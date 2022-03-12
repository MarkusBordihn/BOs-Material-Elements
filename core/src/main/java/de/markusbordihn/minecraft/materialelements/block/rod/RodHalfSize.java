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

package de.markusbordihn.minecraft.materialelements.block.rod;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RodHalfSize extends RodComplexBlock {

  // Shapes for the different faces like UP, DOWN, NORTH, EAST, SOUTH and WEST
  protected static final VoxelShape FLOOR_AABB = Block.box(7.0, 0.0, 7.0, 9.0, 8.0, 9.0);
  protected static final VoxelShape CEILING_AABB = Block.box(7.0, 8.0, 7.0, 9.0, 16.0, 9.0);
  protected static final VoxelShape WALL_NORTH_AABB = Block.box(7.0, 7.0, 8.0, 9.0, 9.0, 16.0);
  protected static final VoxelShape WALL_EAST_AABB = Block.box(0.0, 7.0, 7.0, 8.0, 9.0, 9.0);
  protected static final VoxelShape WALL_SOUTH_AABB = Block.box(7.0, 7.0, 0.0, 9.0, 9.0, 8.0);
  protected static final VoxelShape WALL_WEST_AABB = Block.box(8.0, 7.0, 7.0, 16.0, 9.0, 9.0);

  public RodHalfSize(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    // Handle floor and ceiling placement
    AttachFace attachFace = blockState.getValue(RodComplexBlock.ATTACH_FACE);
    if (attachFace == AttachFace.FLOOR) {
      return FLOOR_AABB;
    }
    if (attachFace == AttachFace.CEILING) {
      return CEILING_AABB;
    }

    // Handle wall placements
    switch (blockState.getValue(RodComplexBlock.FACING)) {
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
