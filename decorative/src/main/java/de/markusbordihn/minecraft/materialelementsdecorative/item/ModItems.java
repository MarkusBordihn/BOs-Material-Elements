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

package de.markusbordihn.minecraft.materialelementsdecorative.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.block.ModBlocks;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.AcaciaFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.BirchFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.CrimsonFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.DarkOakFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.JungleFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.OakFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.SpruceFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.WarpedFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.tabs.MaterialElementsTab;
import de.markusbordihn.minecraft.materialelementsdecorative.Annotations.TemplateEntryPoint;

public class ModItems {

  protected ModItems() {

  }

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  @TemplateEntryPoint("Register Items")

  String test = "Test";

  @TemplateEntryPoint("Register Block Items")

  // Wool Slaps
  public static final RegistryObject<Item> WOOL_SLAB_WHITE = ITEMS.register("wool_slab_white",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_WHITE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_ORANGE = ITEMS.register("wool_slab_orange",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_ORANGE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_MAGENTA = ITEMS.register("wool_slab_magenta",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_MAGENTA.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_LIGHT_BLUE = ITEMS
      .register("wool_slab_light_blue", () -> new BlockItem(ModBlocks.WOOL_SLAB_LIGHT_BLUE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_YELLOW = ITEMS.register("wool_slab_yellow",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_YELLOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_LIME = ITEMS.register("wool_slab_lime",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_LIME.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_PINK = ITEMS.register("wool_slab_pink",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_PINK.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_GRAY = ITEMS.register("wool_slab_gray",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_GRAY.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_LIGHT_GRAY = ITEMS
      .register("wool_slab_light_gray", () -> new BlockItem(ModBlocks.WOOL_SLAB_LIGHT_GRAY.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_CYAN = ITEMS.register("wool_slab_cyan",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_CYAN.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_PURPLE = ITEMS.register("wool_slab_purple",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_PURPLE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_BLUE = ITEMS.register("wool_slab_blue",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_BLUE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_BROWN = ITEMS.register("wool_slab_brown",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_BROWN.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_GREEN = ITEMS.register("wool_slab_green",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_GREEN.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_RED = ITEMS.register("wool_slab_red",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_RED.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));
  public static final RegistryObject<Item> WOOL_SLAB_BLACK = ITEMS.register("wool_slab_black",
      () -> new BlockItem(ModBlocks.WOOL_SLAB_BLACK.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_SLABS)));

  // Wooden Panels
  public static final RegistryObject<Item> OAK_PANEL = ITEMS.register("oak_panel",
      () -> new BlockItem(ModBlocks.OAK_PANEL.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> SPRUCE_PANEL = ITEMS.register("spruce_panel",
      () -> new BlockItem(ModBlocks.SPRUCE_PANEL.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> BIRCH_PANEL = ITEMS.register("birch_panel",
      () -> new BlockItem(ModBlocks.BIRCH_PANEL.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> JUNGLE_PANEL = ITEMS.register("jungle_panel",
      () -> new BlockItem(ModBlocks.JUNGLE_PANEL.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> ACACIA_PANEL = ITEMS.register("acacia_panel",
      () -> new BlockItem(ModBlocks.ACACIA_PANEL.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> DARK_OAK_PANEL = ITEMS.register("dark_oak_panel",
      () -> new BlockItem(ModBlocks.DARK_OAK_PANEL.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> CRIMSON_PANEL = ITEMS.register("crimson_panel",
      () -> new BlockItem(ModBlocks.CRIMSON_PANEL.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> WARPED_PANEL = ITEMS.register("warped_panel",
      () -> new BlockItem(ModBlocks.WARPED_PANEL.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));

  // Wooden Plates
  public static final RegistryObject<Item> OAK_PLATE = ITEMS.register("oak_plate",
      () -> new BlockItem(ModBlocks.OAK_PLATE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> SPRUCE_PLATE = ITEMS.register("spruce_plate",
      () -> new BlockItem(ModBlocks.SPRUCE_PLATE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> BIRCH_PLATE = ITEMS.register("birch_plate",
      () -> new BlockItem(ModBlocks.BIRCH_PLATE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> JUNGLE_PLATE = ITEMS.register("jungle_plate",
      () -> new BlockItem(ModBlocks.JUNGLE_PLATE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> ACACIA_PLATE = ITEMS.register("acacia_plate",
      () -> new BlockItem(ModBlocks.ACACIA_PLATE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> DARK_OAK_PLATE = ITEMS.register("dark_oak_plate",
      () -> new BlockItem(ModBlocks.DARK_OAK_PLATE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> CRIMSON_PLATE = ITEMS.register("crimson_plate",
      () -> new BlockItem(ModBlocks.CRIMSON_PLATE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> WARPED_PLATE = ITEMS.register("warped_plate",
      () -> new BlockItem(ModBlocks.WARPED_PLATE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));

  // Wooden Half-Slab
  public static final RegistryObject<Item> OAK_HALF_SLAB = ITEMS.register("oak_half_slab",
      () -> new BlockItem(ModBlocks.OAK_HALF_SLAB.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> SPRUCE_HALF_SLAB = ITEMS.register("spruce_half_slab",
      () -> new BlockItem(ModBlocks.SPRUCE_HALF_SLAB.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> BIRCH_HALF_SLAB = ITEMS.register("birch_half_slab",
      () -> new BlockItem(ModBlocks.BIRCH_HALF_SLAB.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> JUNGLE_HALF_SLAB = ITEMS.register("jungle_half_slab",
      () -> new BlockItem(ModBlocks.JUNGLE_HALF_SLAB.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> ACACIA_HALF_SLAB = ITEMS.register("acacia_half_slab",
      () -> new BlockItem(ModBlocks.ACACIA_HALF_SLAB.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> DARK_OAK_HALF_SLAB = ITEMS.register("dark_oak_half_slab",
      () -> new BlockItem(ModBlocks.DARK_OAK_HALF_SLAB.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> CRIMSON_HALF_SLAB = ITEMS.register("crimson_half_slab",
      () -> new BlockItem(ModBlocks.CRIMSON_HALF_SLAB.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));
  public static final RegistryObject<Item> WARPED_HALF_SLAB = ITEMS.register("warped_half_slab",
      () -> new BlockItem(ModBlocks.WARPED_HALF_SLAB.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_PANEL_PLATES)));

  // Wooden framed Hoppers
  public static final RegistryObject<Item> OAK_FRAMED_HOPPER = ITEMS.register(OakFramedHopper.NAME,
      () -> new BlockItem(ModBlocks.OAK_FRAMED_HOPPER.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_FRAMED_HOPPERS)));
  public static final RegistryObject<Item> SPRUCE_FRAMED_HOPPER = ITEMS
      .register(SpruceFramedHopper.NAME, () -> new BlockItem(ModBlocks.SPRUCE_FRAMED_HOPPER.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_FRAMED_HOPPERS)));
  public static final RegistryObject<Item> BIRCH_FRAMED_HOPPER = ITEMS
      .register(BirchFramedHopper.NAME, () -> new BlockItem(ModBlocks.BIRCH_FRAMED_HOPPER.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_FRAMED_HOPPERS)));
  public static final RegistryObject<Item> JUNGLE_FRAMED_HOPPER = ITEMS
      .register(JungleFramedHopper.NAME, () -> new BlockItem(ModBlocks.JUNGLE_FRAMED_HOPPER.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_FRAMED_HOPPERS)));
  public static final RegistryObject<Item> ACACIA_FRAMED_HOPPER = ITEMS
      .register(AcaciaFramedHopper.NAME, () -> new BlockItem(ModBlocks.ACACIA_FRAMED_HOPPER.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_FRAMED_HOPPERS)));
  public static final RegistryObject<Item> DARK_OAK_FRAMED_HOPPER = ITEMS.register(
      DarkOakFramedHopper.NAME, () -> new BlockItem(ModBlocks.DARK_OAK_FRAMED_HOPPER.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_FRAMED_HOPPERS)));
  public static final RegistryObject<Item> CRIMSON_FRAMED_HOPPER = ITEMS
      .register(CrimsonFramedHopper.NAME, () -> new BlockItem(ModBlocks.CRIMSON_FRAMED_HOPPER.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_FRAMED_HOPPERS)));
  public static final RegistryObject<Item> WARPED_FRAMED_HOPPER = ITEMS
      .register(WarpedFramedHopper.NAME, () -> new BlockItem(ModBlocks.WARPED_FRAMED_HOPPER.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_FRAMED_HOPPERS)));
}
