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

package de.markusbordihn.materialelements.block.rod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class RodTee extends RodBlock {

  // Shapes for the different faces like NORTH, EAST, SOUTH and WEST
  // Shapes are automatically optimized by the VoxelShapes.or functions.
  protected static final VoxelShape UP_AABB = VoxelShapes
      .or(Block.box(6.0, 0.0, 6.0, 10.0, 8.0, 10.0), Block.box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0));
  protected static final VoxelShape UP_EAST_WEST_AABB = VoxelShapes
      .or(Block.box(6.0, 0.0, 6.0, 10.0, 8.0, 10.0), Block.box(6.0, 6.0, 0.0, 10.0, 10.0, 16.0));
  protected static final VoxelShape DOWN_AABB = VoxelShapes
      .or(Block.box(6.0, 10.0, 6.0, 10.0, 16.0, 10.0), Block.box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0));
  protected static final VoxelShape DOWN_EAST_WEST_AABB = VoxelShapes
      .or(Block.box(6.0, 10.0, 6.0, 10.0, 16.0, 10.0), Block.box(6.0, 6.0, 0.0, 10.0, 10.0, 16.0));
  protected static final VoxelShape NORTH_AABB = VoxelShapes
      .or(Block.box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0), Block.box(6.0, 6.0, 8.0, 10.0, 10.0, 16.0));
  protected static final VoxelShape EAST_AABB = VoxelShapes
      .or(Block.box(6.0, 6.0, 0.0, 10.0, 10.0, 16.0), Block.box(0.0, 6.0, 6.0, 8.0, 10.0, 10.0));
  protected static final VoxelShape SOUTH_AABB = VoxelShapes
      .or(Block.box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0), Block.box(6.0, 6.0, 0.0, 10.0, 10.0, 8.0));
  protected static final VoxelShape WEST_AABB = VoxelShapes
      .or(Block.box(6.0, 6.0, 0.0, 10.0, 10.0, 16.0), Block.box(8.0, 6.0, 6.0, 16.0, 10.0, 10.0));

  public RodTee(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, IBlockReader worldIn, BlockPos blockPos,
      ISelectionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(RodBlock.ATTACH_FACE);
    Direction facing = blockState.getValue(RodBlock.FACING);

    // Handle floor and ceiling placement
    if (attachFace == AttachFace.FLOOR) {
      return (facing == Direction.EAST || facing == Direction.WEST) ? UP_EAST_WEST_AABB : UP_AABB;
    } else if (attachFace == AttachFace.CEILING) {
      return (facing == Direction.EAST || facing == Direction.WEST) ? DOWN_EAST_WEST_AABB
          : DOWN_AABB;
    }

    // Handle wall placements
    switch (facing) {
      case NORTH:
        return NORTH_AABB;
      case EAST:
        return EAST_AABB;
      case SOUTH:
        return SOUTH_AABB;
      case WEST:
        return WEST_AABB;
      default:
        return UP_AABB;
    }
  }

}
