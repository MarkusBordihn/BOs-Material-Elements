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
import net.minecraft.world.World;

public class RodElbow extends RodBlock {

  protected static final VoxelShape NORTH_SOUTH_AABB = VoxelShapes
      .or(Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0), Block.box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0));

  protected static final VoxelShape FLOOR_BASE_AABB = Block.box(7.0, 0.0, 7.0, 9.0, 9.0, 9.0);
  protected static final VoxelShape FLOOR_NORTH_AABB =
      VoxelShapes.or(FLOOR_BASE_AABB, Block.box(7.0, 7.0, 7.0, 16.0, 9.0, 9.0));
  protected static final VoxelShape FLOOR_EAST_AABB =
      VoxelShapes.or(FLOOR_BASE_AABB, Block.box(7.0, 7.0, 7.0, 9.0, 9.0, 16.0));
  protected static final VoxelShape FLOOR_SOUTH_AABB =
      VoxelShapes.or(FLOOR_BASE_AABB, Block.box(0.0, 7.0, 7.0, 9.0, 9.0, 9.0));
  protected static final VoxelShape FLOOR_WEST_AABB =
      VoxelShapes.or(FLOOR_BASE_AABB, Block.box(7.0, 7.0, 0.0, 9.0, 9.0, 9.0));

  protected static final VoxelShape WALL_NORTH_AABB =
      VoxelShapes.or(Block.box(7.0, 7.0, 7.0, 16.0, 9.0, 9.0), Block.box(7.0, 7.0, 7.0, 9.0, 9.0, 16.0));
  protected static final VoxelShape WALL_EAST_AABB =
      VoxelShapes.or(Block.box(7.0, 7.0, 7.0, 9.0, 9.0, 16.0), Block.box(0.0, 7.0, 7.0, 9.0, 9.0, 9.0));
  protected static final VoxelShape WALL_SOUTH_AABB =
      VoxelShapes.or(Block.box(0.0, 7.0, 7.0, 9.0, 9.0, 9.0), Block.box(7.0, 7.0, 0.0, 9.0, 9.0, 9.0));
  protected static final VoxelShape WALL_WEST_AABB =
      VoxelShapes.or(Block.box(7.0, 7.0, 0.0, 9.0, 9.0, 9.0), Block.box(7.0, 7.0, 7.0, 16.0, 9.0, 9.0));

  protected static final VoxelShape CEILING_BASE_AABB = Block.box(7.0, 7.0, 7.0, 9.0, 16.0, 9.0);
  protected static final VoxelShape CEILING_NORTH_AABB =
      VoxelShapes.or(CEILING_BASE_AABB, Block.box(7.0, 7.0, 7.0, 16.0, 9.0, 9.0));
  protected static final VoxelShape CEILING_EAST_AABB =
      VoxelShapes.or(CEILING_BASE_AABB, Block.box(7.0, 7.0, 7.0, 9.0, 9.0, 16.0));
  protected static final VoxelShape CEILING_SOUTH_AABB =
      VoxelShapes.or(CEILING_BASE_AABB, Block.box(0.0, 7.0, 7.0, 9.0, 9.0, 9.0));
  protected static final VoxelShape CEILING_WEST_AABB =
      VoxelShapes.or(CEILING_BASE_AABB, Block.box(7.0, 7.0, 0.0, 9.0, 9.0, 9.0));

  public RodElbow(Properties properties) {
    super(properties);
  }

  public static boolean hasUnwantedBuilds(World world, BlockPos blockPos) {
    // Get surrounding positions and blocks.
    BlockPos blockPosNorth = blockPos.north();
    BlockPos blockPosEast = blockPos.east();
    BlockPos blockPosSouth = blockPos.south();
    BlockPos blockPosWest = blockPos.west();
    BlockState blockStateNorth = world.getBlockState(blockPosNorth);
    BlockState blockStateEast = world.getBlockState(blockPosEast);
    BlockState blockStateSouth = world.getBlockState(blockPosSouth);
    BlockState blockStateWest = world.getBlockState(blockPosWest);

    // We will only check elbow blocks
    if (!(blockStateNorth.getBlock() instanceof RodElbow)
        || !(blockStateEast.getBlock() instanceof RodElbow)
        || !(blockStateSouth.getBlock() instanceof RodElbow)
        || !(blockStateWest.getBlock() instanceof RodElbow)) {
      return false;
    }

    // Perform basic check and destroy unwanted builds with the elbow block.
    return (blockStateNorth.getValue(RodBlock.FACING) == Direction.NORTH
        && blockStateEast.getValue(RodBlock.FACING) == Direction.EAST
        && blockStateSouth.getValue(RodBlock.FACING) == Direction.SOUTH
        && blockStateWest.getValue(RodBlock.FACING) == Direction.WEST)
        || (blockStateNorth.getValue(RodBlock.FACING) == Direction.EAST
            && blockStateEast.getValue(RodBlock.FACING) == Direction.SOUTH
            && blockStateSouth.getValue(RodBlock.FACING) == Direction.WEST
            && blockStateWest.getValue(RodBlock.FACING) == Direction.NORTH)
        || (blockStateNorth.getValue(RodBlock.FACING) == Direction.SOUTH
            && blockStateEast.getValue(RodBlock.FACING) == Direction.WEST
            && blockStateSouth.getValue(RodBlock.FACING) == Direction.NORTH
            && blockStateWest.getValue(RodBlock.FACING) == Direction.EAST)
        || (blockStateNorth.getValue(RodBlock.FACING) == Direction.WEST
            && blockStateEast.getValue(RodBlock.FACING) == Direction.NORTH
            && blockStateSouth.getValue(RodBlock.FACING) == Direction.EAST
            && blockStateWest.getValue(RodBlock.FACING) == Direction.SOUTH);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, IBlockReader worldIn, BlockPos blockPos,
      ISelectionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(RodBlock.ATTACH_FACE);
    Direction facing = blockState.getValue(RodBlock.FACING);

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

    return super.getShape(blockState, worldIn, blockPos, collisionContext);
  }

  @Override
  public void onPlace(BlockState blockState, World world, BlockPos blockPos, BlockState blockState2,
      boolean status) {
    // Ignore all blocks which are not attached to a wall.
    if (blockState.getValue(RodBlock.ATTACH_FACE) != AttachFace.WALL) {
      return;
    }

    // Make sure we check for unwanted builds in each direction.
    if (hasUnwantedBuilds(world, blockPos.north()) || hasUnwantedBuilds(world, blockPos.east())
        || hasUnwantedBuilds(world, blockPos.south())
        || hasUnwantedBuilds(world, blockPos.west())) {
      world.destroyBlock(blockPos, true);
      log.warn("Found unwanted builds at {} which was destroyed", blockPos);
    }
  }

}
