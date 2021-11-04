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
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.materialelements.Constants;

public class RodTee extends RodBlock {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Shapes for the different faces like UP, DOWN, NORTH, EAST, SOUTH and WEST
  // Shapes are automatically optimized by the Shapes.or functions.
  protected static final VoxelShape UP_AABB =
      Shapes.or(Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D),
          Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D));
  protected static final VoxelShape UP_INVERTED_AABB =
      Shapes.or(Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D),
          Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D));
  protected static final VoxelShape DOWN_AABB =
      Shapes.or(Block.box(6.0D, 10.0D, 6.0D, 10.0D, 16.0D, 10.0D),
          Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D));
  protected static final VoxelShape DOWN_INVERTED_AABB =
      Shapes.or(Block.box(6.0D, 10.0D, 6.0D, 10.0D, 16.0D, 10.0D),
          Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D));
  protected static final VoxelShape NORTH_AABB =
      Shapes.or(Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D),
          Block.box(6.0D, 6.0D, 8.0D, 10.0D, 10.0D, 16.0D));
  protected static final VoxelShape EAST_AABB =
      Shapes.or(Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D),
          Block.box(0.0D, 6.0D, 6.0D, 8.0D, 10.0D, 10.0D));
  protected static final VoxelShape SOUTH_AABB =
      Shapes.or(Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D),
          Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 8.0D));
  protected static final VoxelShape WEST_AABB =
      Shapes.or(Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D),
          Block.box(8.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D));

  // Defines if we need to rotate the Object based on the player view.
  public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;

  public RodTee(Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP)
        .setValue(INVERTED, Boolean.valueOf(false)));
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    switch (blockState.getValue(FACING)) {
      case NORTH:
        return NORTH_AABB;
      case EAST:
        return EAST_AABB;
      case SOUTH:
        return SOUTH_AABB;
      case WEST:
        return WEST_AABB;
      case DOWN:
        return Boolean.TRUE.equals(blockState.getValue(INVERTED)) ? DOWN_INVERTED_AABB : DOWN_AABB;
      case UP:
      default:
        return Boolean.TRUE.equals(blockState.getValue(INVERTED)) ? UP_INVERTED_AABB : UP_AABB;
    }
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    Direction direction = context.getClickedFace();
    BlockState blockState =
        context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
    Direction lookingDirection = context.getNearestLookingDirection().getOpposite();
    Direction faceDirection =
        blockState.is(this) && blockState.getValue(FACING) == direction ? direction.getOpposite()
            : direction;
    // Fixing Model direction for placing the block on itself.
    if ((faceDirection == Direction.DOWN && lookingDirection == Direction.UP)
        || (faceDirection == Direction.UP && lookingDirection == Direction.DOWN)) {
      faceDirection = lookingDirection;
    }
    return this.defaultBlockState().setValue(FACING, faceDirection).setValue(INVERTED,
        context.getHorizontalDirection() == Direction.EAST
            || context.getHorizontalDirection() == Direction.WEST);
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockState) {
    blockState.add(FACING, INVERTED);
  }

  @Override
  public PushReaction getPistonPushReaction(BlockState blockState) {
    return PushReaction.NORMAL;
  }

}
