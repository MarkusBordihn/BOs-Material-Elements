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

public class RodCross extends RodBlock {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Shapes for Y and Y inverted axis
  protected static final VoxelShape Y_AXIS_AABB =
      Shapes.or(Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D),
          Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D));
  protected static final VoxelShape Y_AXIS_INVERTED_AABB =
      Shapes.or(Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D),
          Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D));

  // Shape for X and Z axis
  protected static final VoxelShape X_Z_AXIS_AABB =
      Shapes.or(Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D),
          Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D));

  // Defines if we need to rotate the Object based on the player view.
  public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;

  public RodCross(Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP)
        .setValue(INVERTED, Boolean.valueOf(false)));
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    switch (blockState.getValue(FACING).getAxis()) {
      case X, Z:
        return X_Z_AXIS_AABB;
      case Y:
      default:
        return Boolean.TRUE.equals(blockState.getValue(INVERTED)) ? Y_AXIS_INVERTED_AABB
            : Y_AXIS_AABB;
    }
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    Direction direction = context.getClickedFace();
    BlockState blockState =
        context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
    Direction faceDirection =
        blockState.is(this) && blockState.getValue(FACING) == direction ? direction.getOpposite()
            : direction;
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
