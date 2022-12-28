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

package de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.panel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.minecraft.materialelements.Constants;
import de.markusbordihn.minecraft.materialelements.block.multiface.MultiFaceWaterloggedBlock;

public class PanelBlock extends MultiFaceWaterloggedBlock {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Additional Block Stats
  public static final EnumProperty<ChildPanelBlock> CHILD =
      EnumProperty.create("child", ChildPanelBlock.class);

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
  protected static final VoxelShape DOWN_NORTH_WEST_AABB = Shapes.or(DOWN_NORTH_AABB, WEST_AABB);
  protected static final VoxelShape DOWN_EAST_SOUTH_AABB = Shapes.or(DOWN_EAST_AABB, SOUTH_AABB);
  protected static final VoxelShape DOWN_EAST_WEST_AABB = Shapes.or(DOWN_EAST_AABB, WEST_AABB);
  protected static final VoxelShape DOWN_SOUTH_WEST_AABB = Shapes.or(DOWN_SOUTH_AABB, WEST_AABB);
  protected static final VoxelShape NORTH_EAST_SOUTH_AABB = Shapes.or(NORTH_EAST_AABB, SOUTH_AABB);
  protected static final VoxelShape NORTH_EAST_WEST_AABB = Shapes.or(NORTH_EAST_AABB, WEST_AABB);
  protected static final VoxelShape NORTH_SOUTH_WEST_AABB = Shapes.or(NORTH_SOUTH_AABB, WEST_AABB);
  protected static final VoxelShape EAST_SOUTH_WEST_AABB = Shapes.or(EAST_SOUTH_AABB, WEST_AABB);

  // Advanced VoxelShape for four face placements.
  protected static final VoxelShape UP_DOWN_NORTH_EAST_AABB =
      Shapes.or(UP_DOWN_AABB, NORTH_EAST_AABB);
  protected static final VoxelShape UP_DOWN_NORTH_SOUTH_AABB =
      Shapes.or(UP_DOWN_AABB, NORTH_SOUTH_AABB);
  protected static final VoxelShape UP_DOWN_NORTH_WEST_AABB =
      Shapes.or(UP_DOWN_AABB, NORTH_WEST_AABB);
  protected static final VoxelShape UP_DOWN_SOUTH_WEST_AABB =
      Shapes.or(UP_DOWN_AABB, SOUTH_WEST_AABB);
  protected static final VoxelShape UP_DOWN_EAST_SOUTH_AABB =
      Shapes.or(UP_DOWN_AABB, EAST_SOUTH_AABB);
  protected static final VoxelShape UP_DOWN_EAST_WEST_AABB =
      Shapes.or(UP_DOWN_AABB, EAST_WEST_AABB);
  protected static final VoxelShape UP_NORTH_EAST_SOUTH_AABB =
      Shapes.or(UP_NORTH_AABB, EAST_SOUTH_AABB);
  protected static final VoxelShape UP_NORTH_EAST_WEST_AABB =
      Shapes.or(UP_NORTH_AABB, EAST_WEST_AABB);
  protected static final VoxelShape UP_NORTH_SOUTH_WEST_AABB =
      Shapes.or(UP_NORTH_AABB, SOUTH_WEST_AABB);
  protected static final VoxelShape UP_EAST_SOUTH_WEST_AABB =
      Shapes.or(UP_EAST_AABB, SOUTH_WEST_AABB);
  protected static final VoxelShape DOWN_NORTH_EAST_WEST_AABB =
      Shapes.or(DOWN_NORTH_AABB, EAST_WEST_AABB);
  protected static final VoxelShape DOWN_NORTH_SOUTH_WEST_AABB =
      Shapes.or(DOWN_NORTH_AABB, SOUTH_WEST_AABB);
  protected static final VoxelShape DOWN_NORTH_EAST_SOUTH_AABB =
      Shapes.or(DOWN_NORTH_AABB, EAST_SOUTH_AABB);
  protected static final VoxelShape DOWN_EAST_SOUTH_WEST_AABB =
      Shapes.or(DOWN_EAST_AABB, SOUTH_WEST_AABB);
  protected static final VoxelShape NORTH_EAST_SOUTH_WEST_AABB =
      Shapes.or(NORTH_EAST_AABB, SOUTH_WEST_AABB);

  public PanelBlock(Block block) {
    this(BlockBehaviour.Properties.copy(block));
  }

  public PanelBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.defaultBlockState().setValue(CHILD, ChildPanelBlock.NONE));
  }

  public static ChildPanelBlock getChildPanelBlock(ItemStack itemStack, Direction direction) {
    ChildPanelBlock childPanelBlock = ChildPanelBlock.NONE;
    if (itemStack.is(Items.LANTERN)) {
      // Handle Lantern variants
      if (direction == Direction.UP) {
        childPanelBlock = ChildPanelBlock.LANTERN_HANGING;
      } else if (direction == Direction.DOWN) {
        childPanelBlock = ChildPanelBlock.LANTERN;
      }
    } else if (itemStack.is(Items.SOUL_LANTERN)) {
      // Handle Soul Lantern variants
      if (direction == Direction.UP) {
        childPanelBlock = ChildPanelBlock.SOUL_LANTERN_HANGING;
      } else if (direction == Direction.DOWN) {
        childPanelBlock = ChildPanelBlock.SOUL_LANTERN;
      }
    } else if (itemStack.is(Items.TORCH)) {
      // Torch
      if (direction == Direction.DOWN) {
        childPanelBlock = ChildPanelBlock.TORCH;
      } else if (direction == Direction.NORTH) {
        childPanelBlock = ChildPanelBlock.TORCH_NORTH;
      } else if (direction == Direction.EAST) {
        childPanelBlock = ChildPanelBlock.TORCH_EAST;
      } else if (direction == Direction.SOUTH) {
        childPanelBlock = ChildPanelBlock.TORCH_SOUTH;
      } else if (direction == Direction.WEST) {
        childPanelBlock = ChildPanelBlock.TORCH_WEST;
      }
    } else if (itemStack.is(Items.SOUL_TORCH) && direction != Direction.UP) {
      // Soul Torch
      if (direction == Direction.DOWN) {
        childPanelBlock = ChildPanelBlock.SOUL_TORCH;
      } else if (direction == Direction.NORTH) {
        childPanelBlock = ChildPanelBlock.SOUL_TORCH_NORTH;
      } else if (direction == Direction.EAST) {
        childPanelBlock = ChildPanelBlock.SOUL_TORCH_EAST;
      } else if (direction == Direction.SOUTH) {
        childPanelBlock = ChildPanelBlock.SOUL_TORCH_SOUTH;
      } else if (direction == Direction.WEST) {
        childPanelBlock = ChildPanelBlock.SOUL_TORCH_WEST;
      }
    }
    return childPanelBlock;
  }

  @Override
  public int getLightEmission(BlockState blockState, BlockGetter level, BlockPos blockPos) {
    if (blockState.getValue(CHILD) != ChildPanelBlock.NONE) {
      return 15;
    }
    return 0;
  }

  @Override
  protected void createBlockStateDefinition(
      StateDefinition.Builder<Block, BlockState> stateDefinition) {
    super.createBlockStateDefinition(stateDefinition);
    stateDefinition.add(CHILD);
  }

  /** @deprecated */
  @Deprecated
  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    boolean faceUp = blockState.getValue(UP);
    boolean faceDown = blockState.getValue(DOWN);
    boolean faceNorth = blockState.getValue(NORTH);
    boolean faceEast = blockState.getValue(EAST);
    boolean faceSouth = blockState.getValue(SOUTH);
    boolean faceWest = blockState.getValue(WEST);

    // Get number of faces based on current stats and not from stored block state to avoid
    // missing updates block state updates which leads to side effects.
    int numOfFaces = (faceUp ? 1 : 0) + (faceDown ? 1 : 0) + (faceNorth ? 1 : 0)
        + (faceEast ? 1 : 0) + (faceSouth ? 1 : 0) + (faceWest ? 1 : 0);

    // Important: To make sure that the client could render the lightning correctly, it's important
    // to structure the model as accurate as possible.
    // For this reason we will covering all combination with 4 or less faces in individual models.
    // Everything with 5 or more faces will very likely, blocking the light anyways and so we are
    // using a block model instead.

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
      } else if (faceSouth && faceWest) {
        return SOUTH_WEST_AABB;
      } else {
        log.debug("Possible Bug: Uncovered two faces combination: {}", blockState);
      }
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
        return DOWN_NORTH_WEST_AABB;
      } else if (faceDown && faceEast && faceSouth) {
        return DOWN_EAST_SOUTH_AABB;
      } else if (faceDown && faceEast && faceWest) {
        return DOWN_EAST_WEST_AABB;
      } else if (faceDown && faceSouth && faceWest) {
        return DOWN_SOUTH_WEST_AABB;
      } else if (faceNorth && faceEast && faceSouth) {
        return NORTH_EAST_SOUTH_AABB;
      } else if (faceNorth && faceEast && faceWest) {
        return NORTH_EAST_WEST_AABB;
      } else if (faceNorth && faceSouth && faceWest) {
        return NORTH_SOUTH_WEST_AABB;
      } else if (faceEast && faceSouth && faceWest) {
        return EAST_SOUTH_WEST_AABB;
      } else {
        log.debug("Possible Bug: Uncovered three faces combination: {}", blockState);
      }
    }

    // Handle four faces.
    if (numOfFaces == 4) {
      if (faceUp && faceDown && faceNorth && faceEast) {
        return UP_DOWN_NORTH_EAST_AABB;
      } else if (faceUp && faceDown && faceNorth && faceSouth) {
        return UP_DOWN_NORTH_SOUTH_AABB;
      } else if (faceUp && faceDown && faceNorth && faceWest) {
        return UP_DOWN_NORTH_WEST_AABB;
      } else if (faceUp && faceDown && faceSouth && faceWest) {
        return UP_DOWN_SOUTH_WEST_AABB;
      } else if (faceUp && faceDown && faceEast && faceSouth) {
        return UP_DOWN_EAST_SOUTH_AABB;
      } else if (faceUp && faceDown && faceEast && faceWest) {
        return UP_DOWN_EAST_WEST_AABB;
      } else if (faceUp && faceNorth && faceEast && faceSouth) {
        return UP_NORTH_EAST_SOUTH_AABB;
      } else if (faceUp && faceNorth && faceEast && faceWest) {
        return UP_NORTH_EAST_WEST_AABB;
      } else if (faceUp && faceNorth && faceSouth && faceWest) {
        return UP_NORTH_SOUTH_WEST_AABB;
      } else if (faceUp && faceEast && faceSouth && faceWest) {
        return UP_EAST_SOUTH_WEST_AABB;
      } else if (faceDown && faceNorth && faceEast && faceWest) {
        return DOWN_NORTH_EAST_WEST_AABB;
      } else if (faceDown && faceNorth && faceSouth && faceWest) {
        return DOWN_NORTH_SOUTH_WEST_AABB;
      } else if (faceDown && faceNorth && faceEast && faceSouth) {
        return DOWN_NORTH_EAST_SOUTH_AABB;
      } else if (faceDown && faceEast && faceSouth && faceWest) {
        return DOWN_EAST_SOUTH_WEST_AABB;
      } else if (faceNorth && faceEast && faceSouth && faceWest) {
        return NORTH_EAST_SOUTH_WEST_AABB;
      } else {
        log.debug("Possible Bug: Uncovered four faces combination: {}", blockState);
      }
    }

    return super.getShape(blockState, blockGetter, blockPos, collisionContext);
  }

  /** @deprecated */
  @Deprecated
  @Override
  public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
    ItemStack itemStack = blockPlaceContext.getItemInHand();
    Player player = blockPlaceContext.getPlayer();
    if (player == null || player.isCrouching()) {
      return false;
    }

    // Support combination of specific items and faces
    if (!itemStack.is(this.asItem())) {
      BlockPos blockPos = blockPlaceContext.getClickedPos();
      Level level = blockPlaceContext.getLevel();
      ChildPanelBlock child = blockState.getValue(CHILD);
      Direction direction = blockPlaceContext.getClickedFace();

      // Child block support for items like lanterns, torches, ....
      // We only adding a child when there are not already any and if the block position mutable.
      if (child == ChildPanelBlock.NONE && blockPos instanceof MutableBlockPos) {
        ChildPanelBlock childPanelBlock = getChildPanelBlock(itemStack, direction.getOpposite());
        if (childPanelBlock != ChildPanelBlock.NONE) {
          if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
          }
          level.setBlockAndUpdate(blockPos, blockState.setValue(CHILD, childPanelBlock));
        }
      }
      return false;
    }

    // Currently supporting only up to 5 faces.
    if (getNumberOfFaces(blockState) > 5) {
      return false;
    }

    Direction placingDirection = blockPlaceContext.getClickedFace().getOpposite();
    return !hasPlacedDirection(placingDirection, blockState);
  }

}
