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

package de.markusbordihn.materialelements.block.plate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
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

public class PlateBlock extends Block {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // We need a VoxelShape for each side to cover all faces and possibilities
  protected static final VoxelShape FLOOR_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
  protected static final VoxelShape CEILING_AABB = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape FACING_EAST_AABB = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
  protected static final VoxelShape FACING_SOUTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
  protected static final VoxelShape FACING_NORTH_AABB = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape FACING_WEST_AABB = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

  // Defines if we need to rotate the Object based on the click position and player pov
  public static final DirectionProperty FACING = BlockStateProperties.FACING;
  public static final EnumProperty<AttachFace> ATTACH_FACE = BlockStateProperties.ATTACH_FACE;

  public PlateBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(ATTACH_FACE, AttachFace.FLOOR)
        .setValue(FACING, Direction.UP));
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    AttachFace attachFace = blockState.getValue(ATTACH_FACE);
    // Early return for simple face like ceiling and floor
    if (attachFace == AttachFace.CEILING) {
      return CEILING_AABB;
    } else if ( attachFace == AttachFace.FLOOR) {
      return FLOOR_AABB;
    }

    // Handle the Wall faces for each direction
    switch (blockState.getValue(FACING)) {
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

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    Direction direction = context.getClickedFace();
    BlockState blockState =
        context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
    Direction faceDirection =
        blockState.is(this) && blockState.getValue(FACING) == direction ? direction.getOpposite()
            : direction;

    // Calculate attach face based on clicked face and relative click location.
    AttachFace attachFace = AttachFace.FLOOR;
    if (faceDirection == Direction.DOWN) {
      attachFace = AttachFace.CEILING;
    } else if (faceDirection != Direction.UP) {
      // Get the relative click position like 0.1..0.9
      Double relativeClickLocation = context.getClickLocation().y % 1;
      if (relativeClickLocation < 0.3) {
        attachFace = AttachFace.FLOOR;
      } else if (relativeClickLocation > 0.7) {
        attachFace = AttachFace.CEILING;
      } else {
        attachFace = AttachFace.WALL;
      }
    }

    return this.defaultBlockState().setValue(FACING, faceDirection).setValue(ATTACH_FACE,
        attachFace);
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockState) {
    blockState.add(ATTACH_FACE, FACING);
  }

  @Override
  public PushReaction getPistonPushReaction(BlockState blockState) {
    return PushReaction.DESTROY;
  }

}
