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
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import de.markusbordihn.materialelements.Constants;

public class RodComplexBlock extends RodBlock {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Default Shape
  protected static final VoxelShape DEFAULT_SHAPE_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);

  // Defines if we need to rotate the Object based on the click position and player pov
  public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
  public static final EnumProperty<AttachFace> ATTACH_FACE = BlockStateProperties.ATTACH_FACE;

  public RodComplexBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(
        this.stateDefinition.any().setValue(RodComplexBlock.ATTACH_FACE, AttachFace.FLOOR)
            .setValue(RodComplexBlock.FACING, Direction.NORTH));
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    return RodComplexBlock.DEFAULT_SHAPE_AABB;
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {

    // Clicked facing direction
    Direction direction = context.getClickedFace();
    BlockState blockState =
        context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
    Direction faceDirection =
        blockState.is(this) && blockState.getValue(RodComplexBlock.FACING) == direction
            ? direction.getOpposite()
            : direction;

    // Calculate attach face based on clicked face
    AttachFace attachFace = AttachFace.FLOOR;
    if (faceDirection == Direction.DOWN) {
      attachFace = AttachFace.CEILING;
    } else if (faceDirection != Direction.UP) {
      attachFace = AttachFace.WALL;
    }

    return this.defaultBlockState().setValue(RodComplexBlock.ATTACH_FACE, attachFace)
        .setValue(RodComplexBlock.FACING, context.getHorizontalDirection().getOpposite());
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockState) {
    blockState.add(RodComplexBlock.ATTACH_FACE, RodComplexBlock.FACING);
  }

  @Override
  public PushReaction getPistonPushReaction(BlockState blockState) {
    return PushReaction.DESTROY;
  }
}
