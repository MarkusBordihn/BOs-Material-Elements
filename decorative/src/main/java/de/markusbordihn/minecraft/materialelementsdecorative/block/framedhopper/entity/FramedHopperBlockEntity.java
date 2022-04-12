/**
 * Copyright 2022 Markus Bordihn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity;

import java.util.function.BooleanSupplier;
import java.util.stream.IntStream;

import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.HopperMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;

public class FramedHopperBlockEntity extends RandomizableContainerBlockEntity implements Hopper {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  private NonNullList<ItemStack> items = NonNullList.withSize(5, ItemStack.EMPTY);
  private int cooldownTime = -1;
  protected long tickedGameTime;

  public FramedHopperBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos,
      BlockState blockState) {
    super(blockEntityType, blockPos, blockState);
  }

  public static void pushItemsTick(Level level, BlockPos blockPos, BlockState blockState,
      FramedHopperBlockEntity blockEntity) {
    --blockEntity.cooldownTime;
    blockEntity.tickedGameTime = level.getGameTime();
    if (!blockEntity.isOnCooldown()) {
      blockEntity.setCooldown(0);
      tryMoveItems(level, blockPos, blockState, blockEntity,
          () -> HopperBlockEntity.suckInItems(level, blockEntity));
    }
  }

  private static boolean tryMoveItems(Level level, BlockPos blockPos, BlockState blockState,
      FramedHopperBlockEntity blockEntity, BooleanSupplier supplier) {
    if (level.isClientSide) {
      return false;
    } else {
      if (!blockEntity.isOnCooldown()
          && Boolean.TRUE.equals(blockState.getValue(HopperBlock.ENABLED))) {
        boolean flag = false;
        if (!blockEntity.isEmpty()) {
          flag = ejectItems(level, blockPos, blockState, blockEntity);
        }
        if (!blockEntity.inventoryFull()) {
          flag |= supplier.getAsBoolean();
        }
        if (flag) {
          blockEntity.setCooldown(8);
          setChanged(level, blockPos, blockState);
          return true;
        }
      }
      return false;
    }
  }

  private static boolean ejectItems(Level level, BlockPos blockPos, BlockState blockState,
      FramedHopperBlockEntity blockEntity) {
    Container container = getAttachedContainer(level, blockPos, blockState);
    if (container == null) {
      return false;
    } else {
      Direction direction = blockState.getValue(HopperBlock.FACING).getOpposite();
      if (isFullContainer(container, direction)) {
        return false;
      } else {
        for (int i = 0; i < blockEntity.getContainerSize(); ++i) {
          if (!blockEntity.getItem(i).isEmpty()) {
            ItemStack itemStack = blockEntity.getItem(i).copy();
            ItemStack itemStack1 = HopperBlockEntity.addItem(blockEntity, container,
                blockEntity.removeItem(i, 1), direction);
            if (itemStack1.isEmpty()) {
              container.setChanged();
              return true;
            }
            blockEntity.setItem(i, itemStack);
          }
        }
        return false;
      }
    }
  }

  protected Component getDefaultName() {
    return new TranslatableComponent("container.hopper");
  }

  public double getLevelX() {
    return this.worldPosition.getX() + 0.5D;
  }

  public double getLevelY() {
    return this.worldPosition.getY() + 0.5D;
  }

  public double getLevelZ() {
    return this.worldPosition.getZ() + 0.5D;
  }

  @Nullable
  private static Container getAttachedContainer(Level level, BlockPos blockPos,
      BlockState blockState) {
    Direction direction = blockState.getValue(HopperBlock.FACING);
    return HopperBlockEntity.getContainerAt(level, blockPos.relative(direction));
  }

  private static IntStream getSlots(Container container, Direction direction) {
    if (container instanceof WorldlyContainer worldlyContainer) {
      return IntStream.of(worldlyContainer.getSlotsForFace(direction));
    }
    return IntStream.range(0, container.getContainerSize());
  }

  public void setCooldown(int coolDown) {
    this.cooldownTime = coolDown;
  }

  private boolean isOnCooldown() {
    return this.cooldownTime > 0;
  }

  public boolean isOnCustomCooldown() {
    return this.cooldownTime > 8;
  }

  private static boolean isFullContainer(Container container, Direction direction) {
    return getSlots(container, direction).allMatch(slot -> {
      ItemStack itemStack = container.getItem(slot);
      return itemStack.getCount() >= itemStack.getMaxStackSize();
    });
  }

  private boolean inventoryFull() {
    for (ItemStack itemStack : this.items) {
      if (itemStack.isEmpty() || itemStack.getCount() != itemStack.getMaxStackSize()) {
        return false;
      }
    }
    return true;
  }

  public int getContainerSize() {
    return this.items.size();
  }

  protected void setItems(NonNullList<ItemStack> itemStack) {
    this.items = itemStack;
  }

  protected NonNullList<ItemStack> getItems() {
    return this.items;
  }

  @Override
  public void setItem(int slot, ItemStack itemStack) {
    this.unpackLootTable((Player) null);
    this.getItems().set(slot, itemStack);
    if (itemStack.getCount() > this.getMaxStackSize()) {
      itemStack.setCount(this.getMaxStackSize());
    }
  }

  protected AbstractContainerMenu createMenu(int index, Inventory inventory) {
    return new HopperMenu(index, inventory, this);
  }

  @Override
  public void load(CompoundTag compoundTag) {
    super.load(compoundTag);
    this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    if (!this.tryLoadLootTable(compoundTag)) {
      ContainerHelper.loadAllItems(compoundTag, this.items);
    }
    this.cooldownTime = compoundTag.getInt("TransferCooldown");
  }

  @Override
  protected void saveAdditional(CompoundTag compoundTag) {
    super.saveAdditional(compoundTag);
    if (!this.trySaveLootTable(compoundTag)) {
      ContainerHelper.saveAllItems(compoundTag, this.items);
    }
    compoundTag.putInt("TransferCooldown", this.cooldownTime);
  }

}
