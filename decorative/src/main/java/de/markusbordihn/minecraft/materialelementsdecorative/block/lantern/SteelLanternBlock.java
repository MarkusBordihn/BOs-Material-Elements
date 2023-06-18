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

package de.markusbordihn.minecraft.materialelementsdecorative.block.lantern;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class SteelLanternBlock extends LanternBlock {

  private static final BlockBehaviour.Properties DEFAULT_BLOCK_PROPERTIES =
      BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops()
          .strength(4.0F).sound(SoundType.LANTERN).lightLevel(blockState -> 15).noOcclusion();
  private DyeColor color = DyeColor.YELLOW;
  private int materialColor = DyeColor.YELLOW.getMapColor().col;

  public SteelLanternBlock(BlockBehaviour.Properties properties) {
    super(properties);
  }

  public SteelLanternBlock(BlockBehaviour.Properties properties, DyeColor dyeColor) {
    super(properties);
    this.color = dyeColor;
    this.materialColor = dyeColor.getMapColor().col;
  }

  public SteelLanternBlock(DyeColor dyeColor) {
    super(DEFAULT_BLOCK_PROPERTIES);
    this.color = dyeColor;
    this.materialColor = dyeColor.getMapColor().col;
  }

  public DyeColor getColor() {
    return this.color;
  }

  public int getMapColor() {
    return this.materialColor;
  }

}
