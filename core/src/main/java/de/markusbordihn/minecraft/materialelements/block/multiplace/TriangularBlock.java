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

package de.markusbordihn.minecraft.materialelements.block.multiplace;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TriangularBlock extends AdvancedMultiPlaceBlock {

  // Shapes Parts
  protected static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
  protected static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape REAR_SOUTH_AABB =
      Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
  protected static final VoxelShape REAR_WEST_AABB =
      Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape REAR_NORTH_AABB =
      Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape REAR_EAST_AABB =
      Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);

  // Combined shapes
  protected static final VoxelShape BOTTOM_NORTH_AABB = Shapes.or(BOTTOM_AABB, REAR_NORTH_AABB);
  protected static final VoxelShape BOTTOM_EAST_AABB = Shapes.or(BOTTOM_AABB, REAR_EAST_AABB);
  protected static final VoxelShape BOTTOM_SOUTH_AABB = Shapes.or(BOTTOM_AABB, REAR_SOUTH_AABB);
  protected static final VoxelShape BOTTOM_WEST_AABB = Shapes.or(BOTTOM_AABB, REAR_WEST_AABB);
  protected static final VoxelShape TOP_NORTH_AABB = Shapes.or(TOP_AABB, REAR_NORTH_AABB);
  protected static final VoxelShape TOP_EAST_AABB = Shapes.or(TOP_AABB, REAR_EAST_AABB);
  protected static final VoxelShape TOP_SOUTH_AABB = Shapes.or(TOP_AABB, REAR_SOUTH_AABB);
  protected static final VoxelShape TOP_WEST_AABB = Shapes.or(TOP_AABB, REAR_WEST_AABB);

  public TriangularBlock(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(ATTACH_FACE);
    if (attachFace == AttachFace.FLOOR || attachFace == AttachFace.WALL) {
      switch (blockState.getValue(FACING)) {
        case EAST:
          return BOTTOM_EAST_AABB;
        case SOUTH:
          return BOTTOM_SOUTH_AABB;
        case WEST:
          return BOTTOM_WEST_AABB;
        case NORTH:
        default:
          return BOTTOM_NORTH_AABB;
      }
    }
    switch (blockState.getValue(FACING)) {
      case EAST:
        return TOP_EAST_AABB;
      case SOUTH:
        return TOP_SOUTH_AABB;
      case WEST:
        return TOP_WEST_AABB;
      case NORTH:
      default:
        return TOP_NORTH_AABB;
    }
  }

}
