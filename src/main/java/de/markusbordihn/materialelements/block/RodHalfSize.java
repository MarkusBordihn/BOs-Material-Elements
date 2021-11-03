/**
 * Copyright 2021 Markus Bordihn
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

package de.markusbordihn.materialelements.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RodHalfSize extends RodBlock {

  protected static final VoxelShape Y_AXIS_AABB = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D);
  protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 8.0D);
  protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 6.0D, 6.0D, 8.0D, 10.0D, 10.0D);

  public RodHalfSize(Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP));
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    switch (blockState.getValue(FACING)) {
      case UP, DOWN:
        return Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D);
      case NORTH:
        return Block.box(6.0D, 6.0D, 8.0D, 10.0D, 10.0D, 16.0D);
      case EAST:
        return Block.box(0.0D, 6.0D, 6.0D, 8.0D, 10.0D, 10.0D);
      case SOUTH:
        return Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 8.0D);
      case WEST:
        return Block.box(8.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D);
      default:
        return Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D);
    }
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    Direction direction = context.getClickedFace();
    BlockState blockState =
        context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
    return blockState.is(this) && blockState.getValue(FACING) == direction
        ? this.defaultBlockState().setValue(FACING, direction.getOpposite())
        : this.defaultBlockState().setValue(FACING, direction);
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockState) {
    blockState.add(FACING);
  }

  @Override
  public PushReaction getPistonPushReaction(BlockState blockState) {
    return PushReaction.NORMAL;
  }

}
