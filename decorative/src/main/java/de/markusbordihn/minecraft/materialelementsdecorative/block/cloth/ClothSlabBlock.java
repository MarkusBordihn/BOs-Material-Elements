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

package de.markusbordihn.minecraft.materialelementsdecorative.block.cloth;

import net.minecraft.world.level.block.SlabBlock;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import de.markusbordihn.minecraft.materialelements.color.ClothColor;

public class ClothSlabBlock extends SlabBlock implements ClothColoredBlock {

  // Store Colors
  private ClothColor color = ClothColor.RED;
  private int blockColor = ClothColor.RED.getBlockColor();

  public ClothSlabBlock(ClothColor color) {
    super(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL));
    this.color = color;
    this.blockColor = color.getBlockColor();
  }

  public ClothColor getColor() {
    return this.color;
  }

  public int getBlockColor() {
    return this.blockColor;
  }

}
