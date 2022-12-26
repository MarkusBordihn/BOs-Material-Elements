/**
 * Copyright 2022 Markus Bordihn
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

package de.markusbordihn.minecraft.materialelements.block.multiface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import de.markusbordihn.minecraft.materialelements.Constants;

public class MultiFaceBlock extends Block {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Block stats
  public static final BooleanProperty UP = BlockStateProperties.UP;
  public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
  public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
  public static final BooleanProperty EAST = BlockStateProperties.EAST;
  public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
  public static final BooleanProperty WEST = BlockStateProperties.WEST;
  public static final IntegerProperty FACES = IntegerProperty.create("faces", 0, 6);

  public MultiFaceBlock(Block block) {
    this(BlockBehaviour.Properties.copy(block));
  }

  public MultiFaceBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(
        this.stateDefinition.any().setValue(UP, false).setValue(DOWN, false).setValue(NORTH, false)
            .setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(FACES, 0));
  }

  @Override
  protected void createBlockStateDefinition(
      StateDefinition.Builder<Block, BlockState> stateDefinition) {
    stateDefinition.add(UP, DOWN, NORTH, EAST, SOUTH, WEST, FACES);
  }

  public int getNumberOfFaces(BlockState blockState) {
    return (Boolean.TRUE.equals(blockState.getValue(UP)) ? 1 : 0)
        + (Boolean.TRUE.equals(blockState.getValue(DOWN)) ? 1 : 0)
        + (Boolean.TRUE.equals(blockState.getValue(NORTH)) ? 1 : 0)
        + (Boolean.TRUE.equals(blockState.getValue(EAST)) ? 1 : 0)
        + (Boolean.TRUE.equals(blockState.getValue(SOUTH)) ? 1 : 0)
        + (Boolean.TRUE.equals(blockState.getValue(WEST)) ? 1 : 0);
  }

  public boolean hasPlacedDirection(Direction direction, BlockState blockState) {
    switch (direction) {
      case UP:
        return blockState.getValue(UP);
      case DOWN:
        return blockState.getValue(DOWN);
      case NORTH:
        return blockState.getValue(NORTH);
      case EAST:
        return blockState.getValue(EAST);
      case SOUTH:
        return blockState.getValue(SOUTH);
      case WEST:
        return blockState.getValue(WEST);
      default:
        return false;
    }
  }

  @Override
  @Nullable
  public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
    BlockPos blockPos = blockPlaceContext.getClickedPos();
    BlockState blockStateAtPosition = blockPlaceContext.getLevel().getBlockState(blockPos);
    Direction direction = blockPlaceContext.getClickedFace();
    Direction faceDirectionOpposite = direction.getOpposite();

    // Possible face directions for the multi-face block.
    boolean isExistingBlock = blockStateAtPosition.is(this);
    boolean faceUp = isExistingBlock && blockStateAtPosition.getValue(UP);
    boolean faceDown = isExistingBlock && blockStateAtPosition.getValue(DOWN);
    boolean faceNorth = isExistingBlock && blockStateAtPosition.getValue(NORTH);
    boolean faceEast = isExistingBlock && blockStateAtPosition.getValue(EAST);
    boolean faceSouth = isExistingBlock && blockStateAtPosition.getValue(SOUTH);
    boolean faceWest = isExistingBlock && blockStateAtPosition.getValue(WEST);

    if (isExistingBlock) {
      // If there are already any panels, we can simplify the checks.
      if (faceDirectionOpposite == Direction.DOWN) {
        faceDown = true;
      } else if (faceDirectionOpposite == Direction.UP) {
        faceUp = true;
      } else if (faceDirectionOpposite == Direction.NORTH) {
        faceNorth = true;
      } else if (faceDirectionOpposite == Direction.EAST) {
        faceEast = true;
      } else if (faceDirectionOpposite == Direction.SOUTH) {
        faceSouth = true;
      } else if (faceDirectionOpposite == Direction.WEST) {
        faceWest = true;
      }
    } else {
      // Calculate attach face based on clicked face and relative click location.
      if (faceDirectionOpposite == Direction.DOWN) {
        faceDown = true;
      } else if (faceDirectionOpposite == Direction.UP) {
        faceUp = true;
      } else {
        // Get the relative click position like 0.1..0.9
        Double relativeClickLocation = blockPlaceContext.getClickLocation().y % 1;

        // Use calculation for a negative or positive number based on position.
        boolean isPositivePosition = relativeClickLocation >= 0;
        if ((isPositivePosition && relativeClickLocation < 0.25)
            || (!isPositivePosition && relativeClickLocation < -0.75)) {
          faceDown = true;
        } else if ((isPositivePosition && relativeClickLocation > 0.75)
            || (!isPositivePosition && relativeClickLocation > -0.25)) {
          faceUp = true;
        } else {
          if (faceDirectionOpposite == Direction.NORTH) {
            faceNorth = true;
          } else if (faceDirectionOpposite == Direction.EAST) {
            faceEast = true;
          } else if (faceDirectionOpposite == Direction.SOUTH) {
            faceSouth = true;
          } else if (faceDirectionOpposite == Direction.WEST) {
            faceWest = true;
          }
        }
      }
    }

    int numOfFaces = (faceUp ? 1 : 0) + (faceDown ? 1 : 0) + (faceNorth ? 1 : 0)
        + (faceEast ? 1 : 0) + (faceSouth ? 1 : 0) + (faceWest ? 1 : 0);
    return this.defaultBlockState().setValue(UP, faceUp).setValue(DOWN, faceDown)
        .setValue(NORTH, faceNorth).setValue(SOUTH, faceSouth).setValue(EAST, faceEast)
        .setValue(WEST, faceWest).setValue(FACES, numOfFaces);
  }

  /** @deprecated */
  @Deprecated
  @Override
  public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
    ItemStack itemStack = blockPlaceContext.getItemInHand();
    Player player = blockPlaceContext.getPlayer();
    if (player == null || player.isCrouching() || !itemStack.is(this.asItem())) {
      return false;
    }
    Direction placingDirection = blockPlaceContext.getClickedFace().getOpposite();
    return !hasPlacedDirection(placingDirection, blockState) && getNumberOfFaces(blockState) <= 5;
  }

}
