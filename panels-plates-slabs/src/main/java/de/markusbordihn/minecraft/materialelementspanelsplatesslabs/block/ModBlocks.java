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

package de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.minecraft.materialelements.block.BlockType;

import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.Annotations.TemplateEntryPoint;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.Constants;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.halfslab.HalfSlabBlock;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.halfslab.WoodHalfSlabBlock;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.panel.PanelBlock;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.panel.WoodPanelBlock;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.plate.PlateBlock;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.plate.WoodPlateBlock;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.slab.SlabBlock;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.slab.WoolSlabBlock;

public class ModBlocks {

  protected ModBlocks() {

  }

  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

  @TemplateEntryPoint("Register Blocks")

  // Quartz (normal and smooth)
  public static final RegistryObject<Block> QUARTZ_PANEL =
      BLOCKS.register("quartz_panel", () -> new PanelBlock(Blocks.QUARTZ_BLOCK));
  public static final RegistryObject<Block> QUARTZ_PLATE =
      BLOCKS.register("quartz_plate", () -> new PlateBlock(Blocks.QUARTZ_BLOCK));
  public static final RegistryObject<Block> QUARTZ_HALF_SLAP =
      BLOCKS.register("quartz_half_slab", () -> new HalfSlabBlock(Blocks.QUARTZ_BLOCK));
  public static final RegistryObject<Block> SMOOTH_QUARTZ_PANEL =
      BLOCKS.register("smooth_quartz_panel", () -> new PanelBlock(Blocks.SMOOTH_QUARTZ));
  public static final RegistryObject<Block> SMOOTH_QUARTZ_PLATE =
      BLOCKS.register("smooth_quartz_plate", () -> new PlateBlock(Blocks.SMOOTH_QUARTZ));
  public static final RegistryObject<Block> SMOOTH_QUARTZ_HALF_SLAP =
      BLOCKS.register("smooth_quartz_half_slab", () -> new HalfSlabBlock(Blocks.SMOOTH_QUARTZ));

  // Glass
  public static final RegistryObject<Block> GLASS_SLAB =
      BLOCKS.register("glass_slab", () -> new SlabBlock(Blocks.GLASS));

  // Wool
  public static final RegistryObject<Block> WOOL_SLAB_WHITE =
      BLOCKS.register("wool_slab_white", () -> new WoolSlabBlock(MaterialColor.SNOW));
  public static final RegistryObject<Block> WOOL_SLAB_ORANGE =
      BLOCKS.register("wool_slab_orange", () -> new WoolSlabBlock(MaterialColor.COLOR_ORANGE));
  public static final RegistryObject<Block> WOOL_SLAB_MAGENTA =
      BLOCKS.register("wool_slab_magenta", () -> new WoolSlabBlock(MaterialColor.COLOR_MAGENTA));
  public static final RegistryObject<Block> WOOL_SLAB_LIGHT_BLUE = BLOCKS
      .register("wool_slab_light_blue", () -> new WoolSlabBlock(MaterialColor.COLOR_LIGHT_BLUE));
  public static final RegistryObject<Block> WOOL_SLAB_YELLOW =
      BLOCKS.register("wool_slab_yellow", () -> new WoolSlabBlock(MaterialColor.COLOR_YELLOW));
  public static final RegistryObject<Block> WOOL_SLAB_LIME =
      BLOCKS.register("wool_slab_lime", () -> new WoolSlabBlock(MaterialColor.COLOR_LIGHT_GREEN));
  public static final RegistryObject<Block> WOOL_SLAB_PINK =
      BLOCKS.register("wool_slab_pink", () -> new WoolSlabBlock(MaterialColor.COLOR_PINK));
  public static final RegistryObject<Block> WOOL_SLAB_GRAY =
      BLOCKS.register("wool_slab_gray", () -> new WoolSlabBlock(MaterialColor.COLOR_GRAY));
  public static final RegistryObject<Block> WOOL_SLAB_LIGHT_GRAY = BLOCKS
      .register("wool_slab_light_gray", () -> new WoolSlabBlock(MaterialColor.COLOR_LIGHT_GRAY));
  public static final RegistryObject<Block> WOOL_SLAB_CYAN =
      BLOCKS.register("wool_slab_cyan", () -> new WoolSlabBlock(MaterialColor.COLOR_CYAN));
  public static final RegistryObject<Block> WOOL_SLAB_PURPLE =
      BLOCKS.register("wool_slab_purple", () -> new WoolSlabBlock(MaterialColor.COLOR_PURPLE));
  public static final RegistryObject<Block> WOOL_SLAB_BLUE =
      BLOCKS.register("wool_slab_blue", () -> new WoolSlabBlock(MaterialColor.COLOR_BLUE));
  public static final RegistryObject<Block> WOOL_SLAB_BROWN =
      BLOCKS.register("wool_slab_brown", () -> new WoolSlabBlock(MaterialColor.COLOR_BROWN));
  public static final RegistryObject<Block> WOOL_SLAB_GREEN =
      BLOCKS.register("wool_slab_green", () -> new WoolSlabBlock(MaterialColor.COLOR_GREEN));
  public static final RegistryObject<Block> WOOL_SLAB_RED =
      BLOCKS.register("wool_slab_red", () -> new WoolSlabBlock(MaterialColor.COLOR_RED));
  public static final RegistryObject<Block> WOOL_SLAB_BLACK =
      BLOCKS.register("wool_slab_black", () -> new WoolSlabBlock(MaterialColor.COLOR_BLACK));

  // Wooden Panels
  public static final RegistryObject<Block> OAK_PANEL =
      BLOCKS.register("oak_panel", () -> new WoodPanelBlock(BlockType.OAK));
  public static final RegistryObject<Block> SPRUCE_PANEL =
      BLOCKS.register("spruce_panel", () -> new WoodPanelBlock(BlockType.SPRUCE));
  public static final RegistryObject<Block> BIRCH_PANEL =
      BLOCKS.register("birch_panel", () -> new WoodPanelBlock(BlockType.BIRCH));
  public static final RegistryObject<Block> JUNGLE_PANEL =
      BLOCKS.register("jungle_panel", () -> new WoodPanelBlock(BlockType.JUNGLE));
  public static final RegistryObject<Block> ACACIA_PANEL =
      BLOCKS.register("acacia_panel", () -> new WoodPanelBlock(BlockType.ACACIA));
  public static final RegistryObject<Block> DARK_OAK_PANEL =
      BLOCKS.register("dark_oak_panel", () -> new WoodPanelBlock(BlockType.DARK_OAK));
  public static final RegistryObject<Block> CRIMSON_PANEL =
      BLOCKS.register("crimson_panel", () -> new WoodPanelBlock(BlockType.CRIMSON));
  public static final RegistryObject<Block> WARPED_PANEL =
      BLOCKS.register("warped_panel", () -> new WoodPanelBlock(BlockType.WARPED));

  // Wooden Plates
  public static final RegistryObject<Block> OAK_PLATE =
      BLOCKS.register("oak_plate", () -> new WoodPlateBlock(BlockType.OAK));
  public static final RegistryObject<Block> SPRUCE_PLATE =
      BLOCKS.register("spruce_plate", () -> new WoodPlateBlock(BlockType.SPRUCE));
  public static final RegistryObject<Block> BIRCH_PLATE =
      BLOCKS.register("birch_plate", () -> new WoodPlateBlock(BlockType.BIRCH));
  public static final RegistryObject<Block> JUNGLE_PLATE =
      BLOCKS.register("jungle_plate", () -> new WoodPlateBlock(BlockType.JUNGLE));
  public static final RegistryObject<Block> ACACIA_PLATE =
      BLOCKS.register("acacia_plate", () -> new WoodPlateBlock(BlockType.ACACIA));
  public static final RegistryObject<Block> DARK_OAK_PLATE =
      BLOCKS.register("dark_oak_plate", () -> new WoodPlateBlock(BlockType.DARK_OAK));
  public static final RegistryObject<Block> CRIMSON_PLATE =
      BLOCKS.register("crimson_plate", () -> new WoodPlateBlock(BlockType.CRIMSON));
  public static final RegistryObject<Block> WARPED_PLATE =
      BLOCKS.register("warped_plate", () -> new WoodPlateBlock(BlockType.WARPED));

  // Wooden Half-Slab
  public static final RegistryObject<Block> OAK_HALF_SLAB =
      BLOCKS.register("oak_half_slab", () -> new WoodHalfSlabBlock(BlockType.OAK));
  public static final RegistryObject<Block> SPRUCE_HALF_SLAB =
      BLOCKS.register("spruce_half_slab", () -> new WoodHalfSlabBlock(BlockType.SPRUCE));
  public static final RegistryObject<Block> BIRCH_HALF_SLAB =
      BLOCKS.register("birch_half_slab", () -> new WoodHalfSlabBlock(BlockType.BIRCH));
  public static final RegistryObject<Block> JUNGLE_HALF_SLAB =
      BLOCKS.register("jungle_half_slab", () -> new WoodHalfSlabBlock(BlockType.JUNGLE));
  public static final RegistryObject<Block> ACACIA_HALF_SLAB =
      BLOCKS.register("acacia_half_slab", () -> new WoodHalfSlabBlock(BlockType.ACACIA));
  public static final RegistryObject<Block> DARK_OAK_HALF_SLAB =
      BLOCKS.register("dark_oak_half_slab", () -> new WoodHalfSlabBlock(BlockType.DARK_OAK));
  public static final RegistryObject<Block> CRIMSON_HALF_SLAB =
      BLOCKS.register("crimson_half_slab", () -> new WoodHalfSlabBlock(BlockType.CRIMSON));
  public static final RegistryObject<Block> WARPED_HALF_SLAB =
      BLOCKS.register("warped_half_slab", () -> new WoodHalfSlabBlock(BlockType.WARPED));
}
