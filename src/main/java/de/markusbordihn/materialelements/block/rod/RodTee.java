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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RodTee extends RodComplexBlock {

  // Shapes for the different faces like NORTH, EAST, SOUTH and WEST
  // Shapes are automatically optimized by the VoxelShapes.or functions.
  // Rod Shapes need to be rotated, for this reason we are using the opposite side.
  protected static final VoxelShape FLOOR_AABB =
      Shapes.or(RodHalfSize.FLOOR_AABB, Rod.WALL_EAST_WEST_AABB);
  protected static final VoxelShape FLOOR_EAST_WEST_AABB =
      Shapes.or(RodHalfSize.FLOOR_AABB, Rod.WALL_NORTH_SOUTH_AABB);
  protected static final VoxelShape CEILING_AABB =
      Shapes.or(RodHalfSize.CEILING_AABB, Rod.WALL_EAST_WEST_AABB);
  protected static final VoxelShape CEILING_EAST_WEST_AABB =
      Shapes.or(RodHalfSize.CEILING_AABB, Rod.WALL_NORTH_SOUTH_AABB);
  protected static final VoxelShape WALL_NORTH_AABB =
      Shapes.or(RodHalfSize.WALL_NORTH_AABB, Rod.WALL_EAST_WEST_AABB);
  protected static final VoxelShape WALL_EAST_AABB =
      Shapes.or(RodHalfSize.WALL_EAST_AABB, Rod.WALL_NORTH_SOUTH_AABB);
  protected static final VoxelShape WALL_SOUTH_AABB =
      Shapes.or(RodHalfSize.WALL_SOUTH_AABB, Rod.WALL_EAST_WEST_AABB);
  protected static final VoxelShape WALL_WEST_AABB =
      Shapes.or(RodHalfSize.WALL_WEST_AABB, Rod.WALL_NORTH_SOUTH_AABB);

  public RodTee(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(RodComplexBlock.ATTACH_FACE);
    Direction facing = blockState.getValue(RodComplexBlock.FACING);

    // Handle floor and ceiling placement
    if (attachFace == AttachFace.FLOOR) {
      return (facing == Direction.EAST || facing == Direction.WEST) ? FLOOR_EAST_WEST_AABB
          : FLOOR_AABB;
    }
    if (attachFace == AttachFace.CEILING) {
      return (facing == Direction.EAST || facing == Direction.WEST) ? CEILING_EAST_WEST_AABB
          : CEILING_AABB;
    }

    // Handle wall placements
    switch (facing) {
      case NORTH:
        return WALL_NORTH_AABB;
      case EAST:
        return WALL_EAST_AABB;
      case SOUTH:
        return WALL_SOUTH_AABB;
      case WEST:
        return WALL_WEST_AABB;
      default:
        return FLOOR_AABB;
    }
  }

}
