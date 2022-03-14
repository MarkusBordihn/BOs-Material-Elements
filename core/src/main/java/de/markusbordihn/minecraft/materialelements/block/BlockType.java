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

package de.markusbordihn.minecraft.materialelements.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockType {

  protected BlockType() {}

  // Cloth
  public static final Properties WHITE_CLOTH = BlockBehaviour.Properties
      .of(Material.CLOTH_DECORATION, MaterialColor.SNOW).strength(0.1F).sound(SoundType.WOOL);
  public static final Properties ORANGE_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_ORANGE)
          .strength(0.1F).sound(SoundType.WOOL);
  public static final Properties MAGENTA_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_MAGENTA)
          .strength(0.1F).sound(SoundType.WOOL);
  public static final Properties LIGHT_BLUE_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_LIGHT_BLUE)
          .strength(0.1F).sound(SoundType.WOOL);
  public static final Properties YELLOW_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_YELLOW)
          .strength(0.1F).sound(SoundType.WOOL);
  public static final Properties LIME_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_LIGHT_GREEN)
          .strength(0.1F).sound(SoundType.WOOL);
  public static final Properties PINK_CLOTH = BlockBehaviour.Properties
      .of(Material.CLOTH_DECORATION, MaterialColor.COLOR_PINK).strength(0.1F).sound(SoundType.WOOL);
  public static final Properties GRAY_CLOTH = BlockBehaviour.Properties
      .of(Material.CLOTH_DECORATION, MaterialColor.COLOR_GRAY).strength(0.1F).sound(SoundType.WOOL);
  public static final Properties LIGHT_GRAY_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_LIGHT_GRAY)
          .strength(0.1F).sound(SoundType.WOOL);
  public static final Properties CYAN_CLOTH = BlockBehaviour.Properties
      .of(Material.CLOTH_DECORATION, MaterialColor.COLOR_CYAN).strength(0.1F).sound(SoundType.WOOL);
  public static final Properties PURPLE_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_PURPLE)
          .strength(0.1F).sound(SoundType.WOOL);
  public static final Properties BLUE_CLOTH = BlockBehaviour.Properties
      .of(Material.CLOTH_DECORATION, MaterialColor.COLOR_BLUE).strength(0.1F).sound(SoundType.WOOL);
  public static final Properties BROWN_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_BROWN)
          .strength(0.1F).sound(SoundType.WOOL);
  public static final Properties GREEN_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_GREEN)
          .strength(0.1F).sound(SoundType.WOOL);
  public static final Properties RED_CLOTH = BlockBehaviour.Properties
      .of(Material.CLOTH_DECORATION, MaterialColor.COLOR_RED).strength(0.1F).sound(SoundType.WOOL);
  public static final Properties BLACK_CLOTH =
      BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_BLACK)
          .strength(0.1F).sound(SoundType.WOOL);

  // Metals
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

  // Wood
  public static final Properties OAK =
      BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F)
          .sound(SoundType.WOOD).noOcclusion();
  public static final Properties SPRUCE =
      BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F, 3.0F)
          .sound(SoundType.WOOD).noOcclusion();
  public static final Properties BIRCH =
      BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0F, 3.0F)
          .sound(SoundType.WOOD).noOcclusion();
  public static final Properties JUNGLE =
      BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).strength(2.0F, 3.0F)
          .sound(SoundType.WOOD).noOcclusion();
  public static final Properties ACACIA =
      BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F)
          .sound(SoundType.WOOD).noOcclusion();
  public static final Properties DARK_OAK =
      BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F, 3.0F)
          .sound(SoundType.WOOD).noOcclusion();
  public static final Properties CRIMSON =
      BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.CRIMSON_STEM)
          .strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion();
  public static final Properties WARPED =
      BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.WARPED_STEM)
          .strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion();
}
