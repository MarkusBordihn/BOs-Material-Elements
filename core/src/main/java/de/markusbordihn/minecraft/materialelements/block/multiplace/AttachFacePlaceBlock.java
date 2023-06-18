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

package de.markusbordihn.minecraft.materialelements.block.multiplace;

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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.minecraft.materialelements.Constants;

public class AttachFacePlaceBlock extends Block {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  public static final EnumProperty<AttachFace> ATTACH_FACE = BlockStateProperties.ATTACH_FACE;

  protected static final VoxelShape CEILING_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape FLOOR_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape WALL_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);

  public AttachFacePlaceBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(ATTACH_FACE, AttachFace.FLOOR));
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    switch (blockState.getValue(ATTACH_FACE)) {
      case CEILING:
        return CEILING_AABB;
      case WALL:
        return WALL_AABB;
      case FLOOR:
      default:
        return FLOOR_AABB;
    }
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    Direction faceDirection = context.getClickedFace();
    AttachFace attachFace = AttachFace.FLOOR;
    if (faceDirection == Direction.DOWN) {
      attachFace = AttachFace.CEILING;
    } else if (faceDirection != Direction.UP) {
      attachFace = AttachFace.WALL;
    }

    return this.defaultBlockState().setValue(ATTACH_FACE, attachFace);
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockState) {
    blockState.add(ATTACH_FACE);
  }

}
