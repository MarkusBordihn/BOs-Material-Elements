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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.HopperMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;

import net.minecraftforge.items.IItemHandler;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.FramedHopperItemHandler;
import de.markusbordihn.minecraft.materialelementsdecorative.utils.ItemHandlerUtils;

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
      // Handle block entities over the item handler for blocks like Storage Drawers.
      Direction facing = blockState.getValue(HopperBlock.FACING);
      BlockPos targetPos = blockPos.relative(facing);
      BlockState targetBlockState = level.getBlockState(targetPos);
      BlockEntity targetBlockEntity = level.getBlockEntity(targetPos);
      if (targetBlockEntity != null && targetBlockState != null && !targetBlockState.isAir()) {
        IItemHandler itemHandler =
            ItemHandlerUtils.getItemHandler(targetBlockEntity, facing.getOpposite());
        if (itemHandler != null) {
          int numberOfSlots = itemHandler.getSlots();
          for (int slot = 0; slot < numberOfSlots; slot++) {
            for (int i = 0; i < blockEntity.getContainerSize(); ++i) {
              if (!blockEntity.getItem(i).isEmpty()) {
                ItemStack itemStack = blockEntity.getItem(i).copy();
                ItemStack removedItem = blockEntity.removeItem(i, 1);
                if (removedItem != null) {
                  ItemStack itemStackTarget = itemHandler.insertItem(slot, removedItem, false);
                  if (itemStackTarget.isEmpty()) {
                    return true;
                  }
                }
                blockEntity.setItem(i, itemStack);
              }
            }
          }
        }
      }
      return false;
    } else {
      Direction direction = blockState.getValue(HopperBlock.FACING).getOpposite();
      if (isFullContainer(container, direction)) {
        return false;
      } else {
        // Handle containers over their corresponding container implementation.
        for (int i = 0; i < blockEntity.getContainerSize(); ++i) {
          if (!blockEntity.getItem(i).isEmpty()) {
            ItemStack itemStack = blockEntity.getItem(i).copy();
            ItemStack itemStackTarget = HopperBlockEntity.addItem(blockEntity, container,
                blockEntity.removeItem(i, 1), direction);
            if (itemStackTarget.isEmpty()) {
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

  private static IntStream getSlots(Container container, Direction direction) {
    if (container instanceof WorldlyContainer worldlyContainer) {
      return IntStream.of(worldlyContainer.getSlotsForFace(direction));
    }
    return IntStream.range(0, container.getContainerSize());
  }

  protected Component getDefaultName() {
    return Component.translatable("container.hopper");
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

  public static boolean addItem(Container container, ItemEntity itemEntity) {
    boolean flag = false;
    ItemStack itemStack = itemEntity.getItem().copy();
    ItemStack itemStack1 = addItem((Container) null, container, itemStack, (Direction) null);
    if (itemStack1.isEmpty()) {
      flag = true;
      itemEntity.discard();
    } else {
      itemEntity.setItem(itemStack1);
    }
    return flag;
  }

  public static ItemStack addItem(@Nullable Container container, Container containerTarget,
      ItemStack itemStack, @Nullable Direction direction) {
    if (containerTarget instanceof WorldlyContainer && direction != null) {
      WorldlyContainer worldlyContainer = (WorldlyContainer) containerTarget;
      int[] slotsForFace = worldlyContainer.getSlotsForFace(direction);
      for (int slot = 0; slot < slotsForFace.length && !itemStack.isEmpty(); ++slot) {
        itemStack =
            tryMoveInItem(container, containerTarget, itemStack, slotsForFace[slot], direction);
      }
    } else {
      int i = containerTarget.getContainerSize();
      for (int j = 0; j < i && !itemStack.isEmpty(); ++j) {
        itemStack = tryMoveInItem(container, containerTarget, itemStack, j, direction);
      }
    }
    return itemStack;
  }

  public static void entityInside(Level level, BlockPos blockPos, BlockState blockState,
      Entity entity, FramedHopperBlockEntity framedHopperBlockEntity) {
    if (entity instanceof ItemEntity && Shapes.joinIsNotEmpty(
        Shapes.create(
            entity.getBoundingBox().move(-blockPos.getX(), -blockPos.getY(), -blockPos.getZ())),
        framedHopperBlockEntity.getSuckShape(), BooleanOp.AND)) {
      tryMoveItems(level, blockPos, blockState, framedHopperBlockEntity,
          () -> addItem(framedHopperBlockEntity, (ItemEntity) entity));
    }
  }

  private static boolean canPlaceItemInContainer(Container container, ItemStack itemStack, int slot,
      @Nullable Direction direction) {
    if (!container.canPlaceItem(slot, itemStack)) {
      return false;
    } else {
      return !(container instanceof WorldlyContainer)
          || ((WorldlyContainer) container).canPlaceItemThroughFace(slot, itemStack, direction);
    }
  }

  private static boolean canMergeItems(ItemStack itemStack1, ItemStack itemStack2) {
    return itemStack1.getCount() <= itemStack1.getMaxStackSize()
        && ItemStack.isSameItemSameTags(itemStack1, itemStack2);
  }

  private static ItemStack tryMoveInItem(@Nullable Container framedHopperContainer,
      Container container, ItemStack itemStack, int slot, @Nullable Direction direction) {
    ItemStack itemStackTarget = container.getItem(slot);
    if (canPlaceItemInContainer(container, itemStack, slot, direction)) {
      boolean flag = false;
      if (itemStackTarget.isEmpty()) {
        container.setItem(slot, itemStack);
        itemStack = ItemStack.EMPTY;
        flag = true;
      } else if (canMergeItems(itemStackTarget, itemStack)) {
        int i = itemStack.getMaxStackSize() - itemStackTarget.getCount();
        int j = Math.min(itemStack.getCount(), i);
        itemStack.shrink(j);
        itemStackTarget.grow(j);
        flag = j > 0;
      }

      if (flag) {
        if (container.isEmpty()
            && container instanceof FramedHopperBlockEntity framedHopperBlockEntity
            && !framedHopperBlockEntity.isOnCustomCooldown()) {
          int k = 0;
          if (framedHopperContainer instanceof FramedHopperBlockEntity) {
            FramedHopperBlockEntity hopperBlockEntity =
                (FramedHopperBlockEntity) framedHopperContainer;
            if (framedHopperBlockEntity.tickedGameTime >= hopperBlockEntity.tickedGameTime) {
              k = 1;
            }
          }
          framedHopperBlockEntity.setCooldown(8 - k);
        }
        container.setChanged();
      }
    }

    return itemStack;
  }

  @Override
  @Nonnull
  protected AbstractContainerMenu createMenu(int index, Inventory inventory) {
    return new HopperMenu(index, inventory, this);
  }

  @Override
  protected IItemHandler createUnSidedHandler() {
    return new FramedHopperItemHandler(this);
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
