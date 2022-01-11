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
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.materialelements.Constants;

public class Rod extends RodComplexBlock {

  private static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected static final VoxelShape FLOOR_CEILING_AABB = Block.box(7.0, 0.0, 7.0, 9.0, 16.0, 9.0);
  protected static final VoxelShape WALL_NORTH_SOUTH_AABB =
      Block.box(7.0, 7.0, 0.0, 9.0, 9.0, 16.0);
  protected static final VoxelShape WALL_EAST_WEST_AABB = Block.box(0.0, 7.0, 7.0, 16.0, 9.0, 9.0);

  public Rod(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    // Handle floor and ceiling placement
    AttachFace attachFace = blockState.getValue(RodComplexBlock.ATTACH_FACE);
    if (attachFace == AttachFace.FLOOR || attachFace == AttachFace.CEILING) {
      return FLOOR_CEILING_AABB;
    }

    // Handle wall placements
    switch (blockState.getValue(RodComplexBlock.FACING)) {
      case NORTH, SOUTH:
        return WALL_NORTH_SOUTH_AABB;
      case EAST, WEST:
        return WALL_EAST_WEST_AABB;
      default:
        return FLOOR_CEILING_AABB;
    }
  }

  @Override
  public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2,
      boolean status) {

    // Connected Texture
    AttachFace attachFace = blockState.getValue(RodComplexBlock.ATTACH_FACE);
    Direction facingDirection = blockState.getValue(RodComplexBlock.FACING);

    // Handle wall placements
    if (attachFace == AttachFace.WALL) {

      // Check north and south
      if (facingDirection == Direction.NORTH || facingDirection == Direction.SOUTH) {
        BlockState blockStateNorth = level.getBlockState(blockPos.north());
        BlockState blockStateSouth = level.getBlockState(blockPos.south());
        if (blockStateNorth.getBlock() instanceof RodComplexBlock) {
          level.setBlockAndUpdate(blockPos, blockState.setValue(RodComplexBlock.CONNECTED, true));
          level.setBlockAndUpdate(blockPos.north(),
              blockStateNorth.setValue(RodComplexBlock.CONNECTED, true));
        }
        if (blockStateSouth.getBlock() instanceof RodComplexBlock) {
          level.setBlockAndUpdate(blockPos, blockState.setValue(RodComplexBlock.CONNECTED, true));
          level.setBlockAndUpdate(blockPos.south(),
              blockStateSouth.setValue(RodComplexBlock.CONNECTED, true));
        }
      }

      // Check east and west
      if (facingDirection == Direction.EAST || facingDirection == Direction.WEST) {
        BlockState blockStateEast = level.getBlockState(blockPos.east());
        BlockState blockStateWest = level.getBlockState(blockPos.west());
        if (blockStateEast.getBlock() instanceof RodComplexBlock) {
          level.setBlockAndUpdate(blockPos, blockState.setValue(RodComplexBlock.CONNECTED, true));
          level.setBlockAndUpdate(blockPos.east(),
              blockStateEast.setValue(RodComplexBlock.CONNECTED, true));
        }
        if (blockStateWest.getBlock() instanceof RodComplexBlock) {
          level.setBlockAndUpdate(blockPos, blockState.setValue(RodComplexBlock.CONNECTED, true));
          level.setBlockAndUpdate(blockPos.west(),
              blockStateWest.setValue(RodComplexBlock.CONNECTED, true));
        }
      }
    }

    // Handle floor and ceiling
    if (attachFace == AttachFace.FLOOR || attachFace == AttachFace.CEILING) {
      // Check up and down
      BlockState blockStateUp = level.getBlockState(blockPos.above());
      BlockState blockStateDown = level.getBlockState(blockPos.below());
      if (blockStateUp.getBlock() instanceof RodComplexBlock) {
        level.setBlockAndUpdate(blockPos, blockState.setValue(RodComplexBlock.CONNECTED, true));
        level.setBlockAndUpdate(blockPos.above(),
            blockStateUp.setValue(RodComplexBlock.CONNECTED, true));
      }
      if (blockStateDown.getBlock() instanceof RodComplexBlock) {
        level.setBlockAndUpdate(blockPos, blockState.setValue(RodComplexBlock.CONNECTED, true));
        level.setBlockAndUpdate(blockPos.below(),
            blockStateDown.setValue(RodComplexBlock.CONNECTED, true));
      }
    }

  }
}
