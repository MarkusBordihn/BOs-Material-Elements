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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Rod extends RodBlock {

  protected static final VoxelShape UP_DOWN_AABB = Block.box(7.0, 0.0, 7.0, 9.0, 16.0, 9.0);
  protected static final VoxelShape NORTH_SOUTH_AABB = Block.box(7.0, 7.0, 0.0, 9.0, 9.0, 16.0);
  protected static final VoxelShape EAST_WEST_AABB = Block.box(0.0, 7.0, 7.0, 16.0, 9.0, 9.0);

  public Rod(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, IBlockReader worldIn, BlockPos blockPos,
      ISelectionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(RodBlock.ATTACH_FACE);
    if (attachFace == AttachFace.WALL) {
      switch (blockState.getValue(RodBlock.FACING)) {
        case NORTH:
        case SOUTH:
          return NORTH_SOUTH_AABB;
        case EAST:
        case WEST:
          return EAST_WEST_AABB;
      }
    }
    return UP_DOWN_AABB;
  }

}
