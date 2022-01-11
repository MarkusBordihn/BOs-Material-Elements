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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.materialelements.Constants;

public class RodElbow extends RodComplexBlock {

  private static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Center block to fix gap between vertical and horizontal rod.
  protected static final VoxelShape CENTER_AABB = Block.box(7.0, 7.0, 7.0, 9.0, 9.0, 9.0);

  protected static final VoxelShape FLOOR_NORTH_AABB =
      Shapes.or(RodHalfSize.FLOOR_AABB, RodHalfSize.WALL_WEST_AABB, RodElbow.CENTER_AABB);
  protected static final VoxelShape FLOOR_EAST_AABB =
      Shapes.or(RodHalfSize.FLOOR_AABB, RodHalfSize.WALL_NORTH_AABB, RodElbow.CENTER_AABB);
  protected static final VoxelShape FLOOR_SOUTH_AABB =
      Shapes.or(RodHalfSize.FLOOR_AABB, RodHalfSize.WALL_EAST_AABB, RodElbow.CENTER_AABB);
  protected static final VoxelShape FLOOR_WEST_AABB =
      Shapes.or(RodHalfSize.FLOOR_AABB, RodHalfSize.WALL_SOUTH_AABB, RodElbow.CENTER_AABB);

  protected static final VoxelShape WALL_NORTH_AABB = Shapes.or(RodHalfSize.WALL_WEST_AABB,
      RodHalfSize.WALL_NORTH_AABB, RodElbow.CENTER_AABB);
  protected static final VoxelShape WALL_EAST_AABB = Shapes.or(RodHalfSize.WALL_NORTH_AABB,
      RodHalfSize.WALL_EAST_AABB, RodElbow.CENTER_AABB);
  protected static final VoxelShape WALL_SOUTH_AABB = Shapes.or(RodHalfSize.WALL_EAST_AABB,
      RodHalfSize.WALL_SOUTH_AABB, RodElbow.CENTER_AABB);
  protected static final VoxelShape WALL_WEST_AABB = Shapes.or(RodHalfSize.WALL_SOUTH_AABB,
      RodHalfSize.WALL_WEST_AABB, RodElbow.CENTER_AABB);

  protected static final VoxelShape CEILING_NORTH_AABB =
      Shapes.or(RodHalfSize.CEILING_AABB, RodHalfSize.WALL_WEST_AABB, RodElbow.CENTER_AABB);
  protected static final VoxelShape CEILING_EAST_AABB =
      Shapes.or(RodHalfSize.CEILING_AABB, RodHalfSize.WALL_NORTH_AABB, RodElbow.CENTER_AABB);
  protected static final VoxelShape CEILING_SOUTH_AABB =
      Shapes.or(RodHalfSize.CEILING_AABB, RodHalfSize.WALL_EAST_AABB, RodElbow.CENTER_AABB);
  protected static final VoxelShape CEILING_WEST_AABB =
      Shapes.or(RodHalfSize.CEILING_AABB, RodHalfSize.WALL_SOUTH_AABB, RodElbow.CENTER_AABB);

  public RodElbow(Properties properties) {
    super(properties);
  }

  public static boolean hasUnwantedBuilds(Level level, BlockPos blockPos) {
    // Get surrounding positions and blocks.
    BlockPos blockPosNorth = blockPos.north();
    BlockPos blockPosEast = blockPos.east();
    BlockPos blockPosSouth = blockPos.south();
    BlockPos blockPosWest = blockPos.west();
    BlockState blockStateNorth = level.getBlockState(blockPosNorth);
    BlockState blockStateEast = level.getBlockState(blockPosEast);
    BlockState blockStateSouth = level.getBlockState(blockPosSouth);
    BlockState blockStateWest = level.getBlockState(blockPosWest);

    // We will only check elbow blocks
    if (!(blockStateNorth.getBlock() instanceof RodElbow)
        || !(blockStateEast.getBlock() instanceof RodElbow)
        || !(blockStateSouth.getBlock() instanceof RodElbow)
        || !(blockStateWest.getBlock() instanceof RodElbow)) {
      return false;
    }

    // Perform basic check and destroy unwanted builds with the elbow block.
    return (blockStateNorth.getValue(RodComplexBlock.FACING) == Direction.NORTH
        && blockStateEast.getValue(RodComplexBlock.FACING) == Direction.EAST
        && blockStateSouth.getValue(RodComplexBlock.FACING) == Direction.SOUTH
        && blockStateWest.getValue(RodComplexBlock.FACING) == Direction.WEST)
        || (blockStateNorth.getValue(RodComplexBlock.FACING) == Direction.EAST
            && blockStateEast.getValue(RodComplexBlock.FACING) == Direction.SOUTH
            && blockStateSouth.getValue(RodComplexBlock.FACING) == Direction.WEST
            && blockStateWest.getValue(RodComplexBlock.FACING) == Direction.NORTH)
        || (blockStateNorth.getValue(RodComplexBlock.FACING) == Direction.SOUTH
            && blockStateEast.getValue(RodComplexBlock.FACING) == Direction.WEST
            && blockStateSouth.getValue(RodComplexBlock.FACING) == Direction.NORTH
            && blockStateWest.getValue(RodComplexBlock.FACING) == Direction.EAST)
        || (blockStateNorth.getValue(RodComplexBlock.FACING) == Direction.WEST
            && blockStateEast.getValue(RodComplexBlock.FACING) == Direction.NORTH
            && blockStateSouth.getValue(RodComplexBlock.FACING) == Direction.EAST
            && blockStateWest.getValue(RodComplexBlock.FACING) == Direction.SOUTH);
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

  @Override
  public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2,
      boolean status) {
    // Ignore all blocks which are not attached to a wall.
    if (blockState.getValue(RodComplexBlock.ATTACH_FACE) != AttachFace.WALL) {
      return;
    }

    // Make sure we check for unwanted builds in each direction.
    if (hasUnwantedBuilds(level, blockPos.north()) || hasUnwantedBuilds(level, blockPos.east())
        || hasUnwantedBuilds(level, blockPos.south())
        || hasUnwantedBuilds(level, blockPos.west())) {
      level.destroyBlock(blockPos, true);
      log.warn("Found unwanted builds at {} which was destroyed", blockPos);
    }
  }

}
