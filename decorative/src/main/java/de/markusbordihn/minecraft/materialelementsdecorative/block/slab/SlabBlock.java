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

package de.markusbordihn.minecraft.materialelementsdecorative.block.slab;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.minecraft.materialelements.block.multiplace.AdvancedMultiPlaceBlock;
import de.markusbordihn.minecraft.materialelements.block.multiplace.MultiPlaceBlock;

public class SlabBlock extends AdvancedMultiPlaceBlock {

  // Block stats
  public static final BooleanProperty STACKED = BooleanProperty.create("stacked");
  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

  // We need a VoxelShape for each side to cover all faces and possibilities
  protected static final VoxelShape FLOOR_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
  protected static final VoxelShape CEILING_AABB = Block.box(0.0, 8.0, 0.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape FACING_EAST_AABB = Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 16.0);
  protected static final VoxelShape FACING_SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 8.0);
  protected static final VoxelShape FACING_NORTH_AABB = Block.box(0.0, 0.0, 8.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape FACING_WEST_AABB = Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 16.0);

  public SlabBlock(Block block) {
    super(BlockBehaviour.Properties.copy(block));
  }

  public SlabBlock(Properties properties) {
    super(properties);
  }

  /** @deprecated */
  @Deprecated
  @Override
  public boolean useShapeForLightOcclusion(BlockState blockState) {
    return !blockState.getValue(STACKED);
  }

  @Override
  protected void createBlockStateDefinition(
      StateDefinition.Builder<Block, BlockState> stateDefinition) {
    super.createBlockStateDefinition(stateDefinition);
    stateDefinition.add(STACKED, WATERLOGGED);
  }

  /** @deprecated */
  @Deprecated
  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {

    // Early return for full blocks.
    if (Boolean.TRUE.equals(blockState.getValue(STACKED))) {
      return Shapes.block();
    }

    // Handle simple face like ceiling and floor
    AttachFace attachFace = blockState.getValue(MultiPlaceBlock.ATTACH_FACE);
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

  @Override
  @Nullable
  public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
    BlockPos blockPos = blockPlaceContext.getClickedPos();
    BlockState blockStateAtPosition = blockPlaceContext.getLevel().getBlockState(blockPos);
    if (blockStateAtPosition.is(this)) {
      return blockStateAtPosition.setValue(STACKED, true).setValue(WATERLOGGED,
          Boolean.valueOf(false));
    } else {
      FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPos);
      BlockState blockState = super.getStateForPlacement(blockPlaceContext);
      return blockState.setValue(STACKED, false).setValue(WATERLOGGED,
          Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }
  }

  /** @deprecated */
  @Deprecated
  @Override
  public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
    ItemStack itemStack = blockPlaceContext.getItemInHand();
    return !blockPlaceContext.getPlayer().isCrouching() && !blockState.getValue(STACKED)
        && itemStack.is(this.asItem()) && blockPlaceContext.replacingClickedOnBlock();
  }

}
