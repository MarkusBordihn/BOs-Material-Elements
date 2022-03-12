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
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RodTeeElbow extends RodComplexBlock {

  // Center block to fix gap between vertical and horizontal rod.
  protected static final VoxelShape CENTER_AABB = Block.box(7.0, 7.0, 7.0, 9.0, 9.0, 9.0);

  protected static final VoxelShape FLOOR_NORTH_AABB = Shapes.or(RodHalfSize.FLOOR_AABB,
      RodHalfSize.WALL_SOUTH_AABB, RodHalfSize.WALL_WEST_AABB, RodTeeElbow.CENTER_AABB);
  protected static final VoxelShape FLOOR_EAST_AABB = Shapes.or(RodHalfSize.FLOOR_AABB,
      RodHalfSize.WALL_WEST_AABB, RodHalfSize.WALL_NORTH_AABB, RodTeeElbow.CENTER_AABB);
  protected static final VoxelShape FLOOR_SOUTH_AABB = Shapes.or(RodHalfSize.FLOOR_AABB,
      RodHalfSize.WALL_NORTH_AABB, RodHalfSize.WALL_EAST_AABB, RodTeeElbow.CENTER_AABB);
  protected static final VoxelShape FLOOR_WEST_AABB = Shapes.or(RodHalfSize.FLOOR_AABB,
      RodHalfSize.WALL_EAST_AABB, RodHalfSize.WALL_SOUTH_AABB, RodTeeElbow.CENTER_AABB);

  protected static final VoxelShape WALL_NORTH_AABB = Shapes.or(RodHalfSize.WALL_WEST_AABB,
      RodHalfSize.WALL_NORTH_AABB, RodHalfSize.CEILING_AABB, RodTeeElbow.CENTER_AABB);
  protected static final VoxelShape WALL_EAST_AABB = Shapes.or(RodHalfSize.WALL_NORTH_AABB,
      RodHalfSize.WALL_EAST_AABB, RodHalfSize.CEILING_AABB, RodTeeElbow.CENTER_AABB);
  protected static final VoxelShape WALL_SOUTH_AABB = Shapes.or(RodHalfSize.WALL_EAST_AABB,
      RodHalfSize.WALL_SOUTH_AABB, RodHalfSize.CEILING_AABB, RodTeeElbow.CENTER_AABB);
  protected static final VoxelShape WALL_WEST_AABB = Shapes.or(RodHalfSize.WALL_SOUTH_AABB,
      RodHalfSize.WALL_WEST_AABB, RodHalfSize.CEILING_AABB, RodTeeElbow.CENTER_AABB);

  protected static final VoxelShape CEILING_NORTH_AABB = Shapes.or(RodHalfSize.CEILING_AABB,
      RodHalfSize.WALL_NORTH_AABB, RodHalfSize.WALL_WEST_AABB, RodTeeElbow.CENTER_AABB);
  protected static final VoxelShape CEILING_EAST_AABB = Shapes.or(RodHalfSize.CEILING_AABB,
      RodHalfSize.WALL_EAST_AABB, RodHalfSize.WALL_NORTH_AABB, RodTeeElbow.CENTER_AABB);
  protected static final VoxelShape CEILING_SOUTH_AABB = Shapes.or(RodHalfSize.CEILING_AABB,
      RodHalfSize.WALL_SOUTH_AABB, RodHalfSize.WALL_EAST_AABB, RodTeeElbow.CENTER_AABB);
  protected static final VoxelShape CEILING_WEST_AABB = Shapes.or(RodHalfSize.CEILING_AABB,
      RodHalfSize.WALL_WEST_AABB, RodHalfSize.WALL_SOUTH_AABB, RodTeeElbow.CENTER_AABB);

  public RodTeeElbow(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(RodComplexBlock.ATTACH_FACE);
    Direction facing = blockState.getValue(RodComplexBlock.FACING);

    if (attachFace == AttachFace.FLOOR) {
      switch (facing) {
        case EAST:
          return FLOOR_EAST_AABB;
        case SOUTH:
          return FLOOR_SOUTH_AABB;
        case WEST:
          return FLOOR_WEST_AABB;
        case NORTH:
        default:
          return FLOOR_NORTH_AABB;
      }
    }

    if (attachFace == AttachFace.WALL) {
      switch (facing) {
        case EAST:
          return WALL_EAST_AABB;
        case SOUTH:
          return WALL_SOUTH_AABB;
        case WEST:
          return WALL_WEST_AABB;
        case NORTH:
        default:
          return WALL_NORTH_AABB;
      }
    }

    if (attachFace == AttachFace.CEILING) {
      switch (facing) {
        case EAST:
          return CEILING_EAST_AABB;
        case SOUTH:
          return CEILING_SOUTH_AABB;
        case WEST:
          return CEILING_WEST_AABB;
        case NORTH:
        default:
          return CEILING_NORTH_AABB;
      }
    }

    return RodComplexBlock.DEFAULT_SHAPE_AABB;
  }

}
