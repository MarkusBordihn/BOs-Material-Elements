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

package de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.FramedHopperBlockEntity;

public class FramedHopperBlock extends HopperBlock {

  public static final String NAME = "framed_hopper";

  protected static final VoxelShape SHAPE_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);

  public FramedHopperBlock(Properties properties) {
    super(properties);
  }

  public FramedHopperBlock() {
    super(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
        .requiresCorrectToolForDrops().strength(3.0F, 4.8F).sound(SoundType.METAL).noOcclusion());
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
    return null;
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    return SHAPE_AABB;
  }

  @Override
  public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState,
      LivingEntity livingEntity, ItemStack itemStack) {
    if (itemStack.hasCustomHoverName() && level
        .getBlockEntity(blockPos) instanceof FramedHopperBlockEntity framedHopperBlockEntity) {
      framedHopperBlockEntity.setCustomName(itemStack.getHoverName());
    }
  }

  @Override
  public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player,
      InteractionHand hand, BlockHitResult hitResult) {
    if (level.isClientSide) {
      return InteractionResult.SUCCESS;
    } else {
      BlockEntity blockEntity = level.getBlockEntity(blockPos);
      if (blockEntity instanceof FramedHopperBlockEntity framedHopperBlockEntity) {
        player.openMenu(framedHopperBlockEntity);
        player.awardStat(Stats.INSPECT_HOPPER);
      }
      return InteractionResult.CONSUME;
    }
  }

  @Override
  public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
    if (level.getBlockEntity(blockPos) instanceof FramedHopperBlockEntity framedHopperBlockEntity) {
      FramedHopperBlockEntity.entityInside(level, blockPos, blockState, entity,
          framedHopperBlockEntity);
    }
  }

  @Override
  public void onRemove(BlockState blockState, Level level, BlockPos blockPos,
      BlockState targetBlockState, boolean isMoving) {
    if (!blockState.is(targetBlockState.getBlock())) {
      if (level
          .getBlockEntity(blockPos) instanceof FramedHopperBlockEntity framedHopperBlockEntity) {
        Containers.dropContents(level, blockPos, framedHopperBlockEntity);
        level.updateNeighbourForOutputSignal(blockPos, this);
      }
      super.onRemove(blockState, level, blockPos, targetBlockState, isMoving);
    }
  }

  @Override
  @Nullable
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState,
      BlockEntityType<T> blockEntityType) {
    return null;
  }

}
