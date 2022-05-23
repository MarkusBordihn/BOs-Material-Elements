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

package de.markusbordihn.minecraft.materialelements.block.frame;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.minecraft.materialelements.block.multiplace.AttachFacePlaceBlock;

public class SkeletonFrame extends AttachFacePlaceBlock {

  // Shapes Individual Parts
  protected static final VoxelShape LEG1_AABB = Block.box(15.0, 0.0, 0.0, 16.0, 16.0, 1.0);
  protected static final VoxelShape LEG2_AABB = Block.box(15.0, 0.0, 15.0, 16.0, 16.0, 16.0);
  protected static final VoxelShape LEG3_AABB = Block.box(0.0, 0.0, 15.0, 1.0, 16.0, 16.0);
  protected static final VoxelShape LEG4_AABB = Block.box(0.0, 0.0, 0.0, 1.0, 16.0, 1.0);

  protected static final VoxelShape BASE_BOTTOM = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
  protected static final VoxelShape BASE_TOP = Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);

  // Combination Shapes of Parts
  protected static final VoxelShape CEILING_AABB =
      Shapes.or(LEG1_AABB, LEG2_AABB, LEG3_AABB, LEG4_AABB, BASE_BOTTOM);
  protected static final VoxelShape FLOOR_AABB =
      Shapes.or(LEG1_AABB, LEG2_AABB, LEG3_AABB, LEG4_AABB, BASE_TOP);

  public SkeletonFrame(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    if (blockState.getValue(ATTACH_FACE) == AttachFace.CEILING) {
      return CEILING_AABB;
    }
    return FLOOR_AABB;
  }

}
