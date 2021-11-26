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

public class RodCross extends RodComplexBlock {

  // Shapes for floor and ceiling
  protected static final VoxelShape NORTH_SOUTH_AABB = Shapes
      .or(Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0), Block.box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0));
  protected static final VoxelShape EAST_WEST_AABB = Shapes
      .or(Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0), Block.box(6.0, 6.0, 0.0, 10.0, 10.0, 16.0));

  // Shape for all wall positions
  protected static final VoxelShape WALL_AABB = Shapes
      .or(Block.box(6.0, 6.0, 0.0, 10.0, 10.0, 16.0), Block.box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0));

  public RodCross(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(RodComplexBlock.ATTACH_FACE);
    if (attachFace == AttachFace.WALL) {
      return WALL_AABB;
    }
    Direction facing = blockState.getValue(RodComplexBlock.FACING);
    if (facing == Direction.EAST || facing == Direction.WEST) {
      return EAST_WEST_AABB;
    }
    return NORTH_SOUTH_AABB;
  }

}
