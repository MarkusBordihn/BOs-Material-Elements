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

import net.minecraft.block.BlockState;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class RodCross extends RodBlock {

  // Shapes for floor and ceiling positions
  protected static final VoxelShape FLOOR_CEILING_NORTH_SOUTH_AABB = VoxelShapes
      .or(Rod.FLOOR_CEILING_AABB, Rod.WALL_EAST_WEST_AABB);
  protected static final VoxelShape FLOOR_CEILING_EAST_WEST_AABB = VoxelShapes
      .or(Rod.FLOOR_CEILING_AABB, Rod.WALL_NORTH_SOUTH_AABB);

  // Shape for wall position
  protected static final VoxelShape WALL_AABB = VoxelShapes
      .or(Rod.WALL_NORTH_SOUTH_AABB, Rod.WALL_EAST_WEST_AABB);

  public RodCross(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, IBlockReader worldIn, BlockPos blockPos,
      ISelectionContext collisionContext) {

    // Handle wall placement
    if (blockState.getValue(RodBlock.ATTACH_FACE) == AttachFace.WALL) {
      return WALL_AABB;
    }

    // Handle floor and ceiling placements
    switch (blockState.getValue(RodBlock.FACING)) {
      case NORTH:
      case SOUTH:
        return FLOOR_CEILING_NORTH_SOUTH_AABB;
      case EAST:
      case WEST:
        return FLOOR_CEILING_EAST_WEST_AABB;
      default:
        return WALL_AABB;
    }
  }

}
