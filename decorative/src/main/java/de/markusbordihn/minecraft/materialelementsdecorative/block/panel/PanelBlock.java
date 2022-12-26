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

package de.markusbordihn.minecraft.materialelementsdecorative.block.panel;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.minecraft.materialelements.block.multiplace.AdvancedMultiPlaceBlock;
import de.markusbordihn.minecraft.materialelements.block.multiplace.MultiPlaceBlock;

public class PanelBlock extends AdvancedMultiPlaceBlock {

  // Block stats
  public static final BooleanProperty UP = BlockStateProperties.UP;
  public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
  public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
  public static final BooleanProperty EAST = BlockStateProperties.EAST;
  public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
  public static final BooleanProperty WEST = BlockStateProperties.WEST;

  // Basic VoxelShape for single placements.
  protected static final VoxelShape UP_AABB = Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape DOWN_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
  protected static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
  protected static final VoxelShape EAST_AABB = Block.box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape WEST_AABB = Block.box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);

  // Advanced VoxelShape for two face placements.
  protected static final VoxelShape UP_DOWN_AABB = Shapes.or(UP_AABB, DOWN_AABB);
  protected static final VoxelShape UP_NORTH_AABB = Shapes.or(UP_AABB, NORTH_AABB);
  protected static final VoxelShape UP_EAST_AABB = Shapes.or(UP_AABB, EAST_AABB);
  protected static final VoxelShape UP_SOUTH_AABB = Shapes.or(UP_AABB, SOUTH_AABB);
  protected static final VoxelShape UP_WEST_AABB = Shapes.or(UP_AABB, WEST_AABB);
  protected static final VoxelShape DOWN_NORTH_AABB = Shapes.or(DOWN_AABB, NORTH_AABB);
  protected static final VoxelShape DOWN_EAST_AABB = Shapes.or(DOWN_AABB, EAST_AABB);
  protected static final VoxelShape DOWN_SOUTH_AABB = Shapes.or(DOWN_AABB, SOUTH_AABB);
  protected static final VoxelShape DOWN_WEST_AABB = Shapes.or(DOWN_AABB, WEST_AABB);
  protected static final VoxelShape NORTH_EAST_AABB = Shapes.or(NORTH_AABB, EAST_AABB);
  protected static final VoxelShape NORTH_SOUTH_AABB = Shapes.or(NORTH_AABB, SOUTH_AABB);
  protected static final VoxelShape NORTH_WEST_AABB = Shapes.or(NORTH_AABB, WEST_AABB);
  protected static final VoxelShape EAST_SOUTH_AABB = Shapes.or(EAST_AABB, SOUTH_AABB);
  protected static final VoxelShape EAST_WEST_AABB = Shapes.or(EAST_AABB, WEST_AABB);
  protected static final VoxelShape SOUTH_WEST_AABB = Shapes.or(SOUTH_AABB, WEST_AABB);

  // Advanced VoxelShape for three face placements.
  protected static final VoxelShape UP_DOWN_NORTH_AABB = Shapes.or(UP_DOWN_AABB, NORTH_AABB);
  protected static final VoxelShape UP_DOWN_EAST_AABB = Shapes.or(UP_DOWN_AABB, EAST_AABB);
  protected static final VoxelShape UP_DOWN_SOUTH_AABB = Shapes.or(UP_DOWN_AABB, SOUTH_AABB);
  protected static final VoxelShape UP_DOWN_WEST_AABB = Shapes.or(UP_DOWN_AABB, WEST_AABB);
  protected static final VoxelShape UP_NORTH_EAST_AABB = Shapes.or(UP_NORTH_AABB, EAST_AABB);
  protected static final VoxelShape UP_NORTH_SOUTH_AABB = Shapes.or(UP_NORTH_AABB, SOUTH_AABB);
  protected static final VoxelShape UP_NORTH_WEST_AABB = Shapes.or(UP_NORTH_AABB, WEST_AABB);
  protected static final VoxelShape UP_EAST_SOUTH_AABB = Shapes.or(UP_EAST_AABB, SOUTH_AABB);
  protected static final VoxelShape UP_EAST_WEST_AABB = Shapes.or(UP_EAST_AABB, WEST_AABB);
  protected static final VoxelShape UP_SOUTH_WEST_AABB = Shapes.or(UP_SOUTH_AABB, WEST_AABB);
  protected static final VoxelShape DOWN_NORTH_EAST_AABB = Shapes.or(DOWN_NORTH_AABB, EAST_AABB);
  protected static final VoxelShape DOWN_NORTH_SOUTH_AABB = Shapes.or(DOWN_NORTH_AABB, SOUTH_AABB);
  protected static final VoxelShape DOWN_NORTH_WEST = Shapes.or(DOWN_NORTH_AABB, WEST_AABB);
  protected static final VoxelShape NORTH_EAST_SOUTH_AABB = Shapes.or(NORTH_EAST_AABB, SOUTH_AABB);
  protected static final VoxelShape NORTH_EAST_WEST_AABB = Shapes.or(NORTH_EAST_AABB, WEST_AABB);
  protected static final VoxelShape EAST_SOUTH_WEST_AABB = Shapes.or(EAST_SOUTH_AABB, WEST_AABB);

  // We need a VoxelShape for each side to cover all faces and possibilities
  protected static final VoxelShape CEILING_AABB = Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape FLOOR_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
  protected static final VoxelShape FACING_EAST_AABB = Block.box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
  protected static final VoxelShape FACING_SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
  protected static final VoxelShape FACING_NORTH_AABB = Block.box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape FACING_WEST_AABB = Block.box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);

  public PanelBlock(Block block) {
    this(BlockBehaviour.Properties.copy(block));
  }

  public PanelBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(UP, false).setValue(DOWN, false)
        .setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
  }

  @Override
  protected void createBlockStateDefinition(
      StateDefinition.Builder<Block, BlockState> stateDefinition) {
    super.createBlockStateDefinition(stateDefinition);
    stateDefinition.add(UP, DOWN, NORTH, EAST, SOUTH, WEST);
  }

  /** @deprecated */
  @Deprecated
  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(MultiPlaceBlock.ATTACH_FACE);

    boolean faceUp = blockState.getValue(UP);
    boolean faceDown = blockState.getValue(DOWN);
    boolean faceNorth = blockState.getValue(NORTH);
    boolean faceEast = blockState.getValue(EAST);
    boolean faceSouth = blockState.getValue(SOUTH);
    boolean faceWest = blockState.getValue(WEST);
    int numOfFaces = (faceUp ? 1 : 0) + (faceDown ? 1 : 0) + (faceNorth ? 1 : 0)
        + (faceEast ? 1 : 0) + (faceSouth ? 1 : 0) + (faceWest ? 1 : 0);

    // Handle simples faces like one direction.
    if (numOfFaces == 1) {
      if (faceUp) {
        return UP_AABB;
      } else if (faceDown) {
        return DOWN_AABB;
      } else if (faceNorth) {
        return NORTH_AABB;
      } else if (faceEast) {
        return EAST_AABB;
      } else if (faceSouth) {
        return SOUTH_AABB;
      } else {
        return WEST_AABB;
      }
    }

    // Handle two faces.
    if (numOfFaces == 2) {
      if (faceUp && faceDown) {
        return UP_DOWN_AABB;
      } else if (faceUp && faceNorth) {
        return UP_NORTH_AABB;
      } else if (faceUp && faceEast) {
        return UP_EAST_AABB;
      } else if (faceUp && faceSouth) {
        return UP_SOUTH_AABB;
      } else if (faceUp && faceWest) {
        return UP_WEST_AABB;
      } else if (faceDown && faceNorth) {
        return DOWN_NORTH_AABB;
      } else if (faceDown && faceEast) {
        return DOWN_EAST_AABB;
      } else if (faceDown && faceSouth) {
        return DOWN_SOUTH_AABB;
      } else if (faceDown && faceWest) {
        return DOWN_WEST_AABB;
      } else if (faceNorth && faceEast) {
        return NORTH_EAST_AABB;
      } else if (faceNorth && faceSouth) {
        return NORTH_SOUTH_AABB;
      } else if (faceNorth && faceWest) {
        return NORTH_WEST_AABB;
      } else if (faceEast && faceSouth) {
        return EAST_SOUTH_AABB;
      } else if (faceEast && faceWest) {
        return EAST_WEST_AABB;
      } else if (faceSouth && faceWest)
        return SOUTH_WEST_AABB;
    }

    // Handle three faces.
    if (numOfFaces == 3) {
      if (faceUp && faceDown && faceNorth) {
        return UP_DOWN_NORTH_AABB;
      } else if (faceUp && faceDown && faceEast) {
        return UP_DOWN_EAST_AABB;
      } else if (faceUp && faceDown && faceSouth) {
        return UP_DOWN_SOUTH_AABB;
      } else if (faceUp && faceDown && faceWest) {
        return UP_DOWN_WEST_AABB;
      } else if (faceUp && faceNorth && faceEast) {
        return UP_NORTH_EAST_AABB;
      } else if (faceUp && faceNorth && faceSouth) {
        return UP_NORTH_SOUTH_AABB;
      } else if (faceUp && faceNorth && faceWest) {
        return UP_NORTH_WEST_AABB;
      } else if (faceUp && faceEast && faceSouth) {
        return UP_EAST_SOUTH_AABB;
      } else if (faceUp && faceEast && faceWest) {
        return UP_EAST_WEST_AABB;
      } else if (faceUp && faceSouth && faceWest) {
        return UP_SOUTH_WEST_AABB;
      } else if (faceDown && faceNorth && faceEast) {
        return DOWN_NORTH_EAST_AABB;
      } else if (faceDown && faceNorth && faceSouth) {
        return DOWN_NORTH_SOUTH_AABB;
      } else if (faceDown && faceNorth && faceWest) {
        return DOWN_NORTH_WEST;
      } else if (faceNorth && faceEast && faceSouth) {
        return NORTH_EAST_SOUTH_AABB;
      } else if (faceNorth && faceEast && faceWest) {
        return NORTH_EAST_WEST_AABB;
      } else {
        return EAST_SOUTH_WEST_AABB;
      }
    }

    // log.info("{} {} {} {} {} {}", faceUp, faceDown, faceNorth, faceEast, faceSouth, faceWest);

    // Early return for simple face like ceiling and floor
    if (attachFace == AttachFace.CEILING) {
      return CEILING_AABB;
    } else if (attachFace == AttachFace.FLOOR) {
      return FLOOR_AABB;
    }

    // Handle the Wall faces for each direction
    switch (blockState.getValue(MultiPlaceBlock.FACING)) {
      case NORTH:
        return FACING_NORTH_AABB;
      case EAST:
        return FACING_EAST_AABB;
      case SOUTH:
        return FACING_SOUTH_AABB;
      case WEST:
        return FACING_WEST_AABB;
      default:
        return FLOOR_AABB;
    }
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
    Direction direction = blockPlaceContext.getClickedFace();
    BlockPos blockPos = blockPlaceContext.getClickedPos();
    BlockState blockState = blockPlaceContext.getLevel()
        .getBlockState(blockPlaceContext.getClickedPos().relative(direction.getOpposite()));
    BlockState blockStateAtPosition = blockPlaceContext.getLevel().getBlockState(blockPos);
    Direction faceDirection =
        blockState.is(this) && blockState.getValue(FACING) == direction ? direction.getOpposite()
            : direction;

    // Possible face directions for the multi-face block.
    boolean isExistingBlock = blockStateAtPosition.is(this);
    boolean faceUp = isExistingBlock && blockStateAtPosition.getValue(UP);
    boolean faceDown = isExistingBlock && blockStateAtPosition.getValue(DOWN);
    boolean faceNorth = isExistingBlock && blockStateAtPosition.getValue(NORTH);
    boolean faceEast = isExistingBlock && blockStateAtPosition.getValue(EAST);
    boolean faceSouth = isExistingBlock && blockStateAtPosition.getValue(SOUTH);
    boolean faceWest = isExistingBlock && blockStateAtPosition.getValue(WEST);

    if (blockStateAtPosition.is(this)) {
      log.info("Existing Block ... {}", blockStateAtPosition);
    } else {
      log.info("Unknown Block ...");
    }

    AttachFace attachFace = AttachFace.FLOOR;

    faceDirection.getOpposite();

    if (faceDirection.getOpposite() == Direction.DOWN) {
      faceDown = true;
    } else if (faceDirection.getOpposite() == Direction.UP) {
      faceUp = true;
    } else if (faceDirection.getOpposite() == Direction.NORTH) {
      faceNorth = true;
    } else if (faceDirection.getOpposite() == Direction.EAST) {
      faceEast = true;
    } else if (faceDirection.getOpposite() == Direction.SOUTH) {
      faceSouth = true;
    } else if (faceDirection.getOpposite() == Direction.WEST) {
      faceWest = true;
    }

    // Calculate attach face based on clicked face and relative click location.
    if (faceDirection == Direction.DOWN) {
      attachFace = AttachFace.CEILING;
    } else if (faceDirection != Direction.UP) {
      // Get the relative click position like 0.1..0.9
      Double relativeClickLocation = blockPlaceContext.getClickLocation().y % 1;

      // Use calculation for a negative or positive number.
      if (relativeClickLocation > 0) {
        if (relativeClickLocation < 0.3) {
          attachFace = AttachFace.FLOOR;
        } else if (relativeClickLocation > 0.7) {
          attachFace = AttachFace.CEILING;
        } else {
          attachFace = AttachFace.WALL;
        }
      } else {
        if (relativeClickLocation < -0.7) {
          attachFace = AttachFace.FLOOR;
        } else if (relativeClickLocation > -0.3) {
          attachFace = AttachFace.CEILING;
        } else {
          attachFace = AttachFace.WALL;
        }
      }
    }

    return this.defaultBlockState().setValue(ATTACH_FACE, attachFace)
        .setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())
        .setValue(UP, faceUp).setValue(DOWN, faceDown).setValue(NORTH, faceNorth)
        .setValue(SOUTH, faceSouth).setValue(EAST, faceEast).setValue(WEST, faceWest);

    // log.info("getStateForPlacement: {} {} {}", blockPos, blockStateAtPosition, blockState);
    // return blockState;
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
    log.info("placingDirection: {} / {} {} {}", placingDirection,
        blockPlaceContext.getNearestLookingDirection(),
        blockPlaceContext.getNearestLookingVerticalDirection(), blockPlaceContext.getClickedFace());

    log.info("canBeReplaced: {}", !hasPlacedDirection(placingDirection, blockState));

    return !hasPlacedDirection(placingDirection, blockState);
  }

}
