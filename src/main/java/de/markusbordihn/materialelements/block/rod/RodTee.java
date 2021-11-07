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

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RodTee extends RodComplexBlock {

  // Shapes for the different faces like NORTH, EAST, SOUTH and WEST
  // Shapes are automatically optimized by the Shapes.or functions.
  protected static final VoxelShape UP_AABB =
      Shapes.or(Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D),
          Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D));
  protected static final VoxelShape UP_EAST_WEST_AABB =
      Shapes.or(Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D),
          Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D));
  protected static final VoxelShape DOWN_AABB =
      Shapes.or(Block.box(6.0D, 10.0D, 6.0D, 10.0D, 16.0D, 10.0D),
          Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D));
  protected static final VoxelShape DOWN_EAST_WEST_AABB =
      Shapes.or(Block.box(6.0D, 10.0D, 6.0D, 10.0D, 16.0D, 10.0D),
          Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D));
  protected static final VoxelShape NORTH_AABB =
      Shapes.or(Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D),
          Block.box(6.0D, 6.0D, 8.0D, 10.0D, 10.0D, 16.0D));
  protected static final VoxelShape EAST_AABB =
      Shapes.or(Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D),
          Block.box(0.0D, 6.0D, 6.0D, 8.0D, 10.0D, 10.0D));
  protected static final VoxelShape SOUTH_AABB =
      Shapes.or(Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D),
          Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 8.0D));
  protected static final VoxelShape WEST_AABB =
      Shapes.or(Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D),
          Block.box(8.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D));

  public RodTee(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(ATTACH_FACE);
    Direction facing = blockState.getValue(FACING);

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
