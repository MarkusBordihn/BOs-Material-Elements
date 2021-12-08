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

package de.markusbordihn.materialelements.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockType {

  protected BlockType() {}

  public static final Properties COPPER =
      AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL);
  public static final Properties GOLD =
      AbstractBlock.Properties.of(Material.METAL, MaterialColor.GOLD).requiresCorrectToolForDrops()
          .strength(3.0F, 6.0F).sound(SoundType.METAL);
  public static final Properties IRON =
      AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL);
  public static final Properties STEEL =
      AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL);
  public static final Properties NETHERITE =
      AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
          .requiresCorrectToolForDrops().strength(50.0F, 1200.0F);
}
