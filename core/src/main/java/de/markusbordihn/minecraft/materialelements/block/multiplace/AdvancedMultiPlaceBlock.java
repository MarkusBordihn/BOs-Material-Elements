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

package de.markusbordihn.minecraft.materialelements.block.multiplace;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;

public class AdvancedMultiPlaceBlock extends MultiPlaceBlock {

  public AdvancedMultiPlaceBlock(Properties properties) {
    super(properties);
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

      // Use calculation for a negative or positive number.
      boolean isPositivePosition = relativeClickLocation >= 0;
      if ((isPositivePosition && relativeClickLocation < 0.3)
          || (!isPositivePosition && relativeClickLocation < -0.7)) {
        attachFace = AttachFace.FLOOR;
      } else if ((isPositivePosition && relativeClickLocation > 0.7)
          || (!isPositivePosition && relativeClickLocation > -0.3)) {
        attachFace = AttachFace.CEILING;
      } else {
        attachFace = AttachFace.WALL;
      }
    }

    return this.defaultBlockState().setValue(ATTACH_FACE, attachFace).setValue(FACING,
        context.getHorizontalDirection().getOpposite());
  }

}
