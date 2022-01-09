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

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockType {

  protected BlockType() {}

  public static final Properties LIGHT = BlockBehaviour.Properties
      .of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F)
      .sound(SoundType.METAL).noOcclusion().lightLevel(blockState -> 15);
  public static final Properties COPPER =
      BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion();
  public static final Properties GOLD =
      BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).requiresCorrectToolForDrops()
          .strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion();
  public static final Properties SILVER = BlockBehaviour.Properties
      .of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(4.0F, 6.0F)
      .sound(SoundType.METAL).noOcclusion().lightLevel(blockState -> 2);
  public static final Properties IRON =
      BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion();
  public static final Properties STEEL =
      BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion();
  public static final Properties NETHERITE = BlockBehaviour.Properties
      .of(Material.METAL, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops()
      .strength(50.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK).noOcclusion();
}
