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

package de.markusbordihn.minecraft.materialelements.block.multiplace;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class MultiPlaceWaterloggedBlock extends MultiPlaceBlock implements SimpleWaterloggedBlock {

  // Additional Block Stats
  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

  public MultiPlaceWaterloggedBlock(Block block) {
    this(BlockBehaviour.Properties.copy(block));
  }

  public MultiPlaceWaterloggedBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, false));
  }


  @Override
  protected void createBlockStateDefinition(
      StateDefinition.Builder<Block, BlockState> stateDefinition) {
    super.createBlockStateDefinition(stateDefinition);
    stateDefinition.add(WATERLOGGED);
  }

  @Override
  @Nullable
  public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
    BlockState blockState = super.getStateForPlacement(blockPlaceContext);
    BlockPos blockPos = blockPlaceContext.getClickedPos();
    FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPos);
    return blockState != null
        ? blockState.setValue(WATERLOGGED, Boolean.valueOf(fluidState.getType() == Fluids.WATER))
        : blockState;
  }

  /** @deprecated */
  @Deprecated
  @Override
  public FluidState getFluidState(BlockState blockState) {
    return Boolean.TRUE.equals(blockState.getValue(WATERLOGGED)) ? Fluids.WATER.getSource(false)
        : super.getFluidState(blockState);
  }

  @Override
  public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState,
      FluidState fluidState) {
    return SimpleWaterloggedBlock.super.placeLiquid(levelAccessor, blockPos, blockState,
        fluidState);
  }

  @Override
  public boolean canPlaceLiquid(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState,
      Fluid fluid) {
    return SimpleWaterloggedBlock.super.canPlaceLiquid(blockGetter, blockPos, blockState, fluid);
  }

  /** @deprecated */
  @Deprecated
  @Override
  public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      PathComputationType pathComputationType) {
    switch (pathComputationType) {
      case AIR:
      case LAND:
        return false;
      case WATER:
        return blockGetter.getFluidState(blockPos).is(FluidTags.WATER);
      default:
        return false;
    }
  }

}
