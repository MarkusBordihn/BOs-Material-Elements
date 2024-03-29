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
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.block.ModBlocks;
import de.markusbordihn.minecraft.materialelementsdecorative.item.cloth.ClothBlockItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.cloth.ClothSlabItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.cloth.ClothTriangularItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.cloth.FabricClothItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.lantern.SteelLanternItem;
import de.markusbordihn.minecraft.materialelementsdecorative.Annotations.TemplateEntryPoint;

public class ModItems {

  protected ModItems() {

  }

  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  @TemplateEntryPoint("Register Items")

  String test = "Test";

  @TemplateEntryPoint("Register Block Items")

  // Fabric Cloth
  public static final RegistryObject<Item> FABRIC_CLOTH_WHITE = ITEMS.register("fabric_cloth_white",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_WHITE.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_ORANGE = ITEMS.register(
      "fabric_cloth_orange", () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_ORANGE.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_MAGENTA = ITEMS.register(
      "fabric_cloth_magenta", () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_MAGENTA.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_LIGHT_BLUE =
      ITEMS.register("fabric_cloth_light_blue",
          () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_LIGHT_BLUE.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_YELLOW = ITEMS.register(
      "fabric_cloth_yellow", () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_YELLOW.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_LIME = ITEMS.register("fabric_cloth_lime",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_LIME.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_PINK = ITEMS.register("fabric_cloth_pink",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_PINK.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_GRAY = ITEMS.register("fabric_cloth_gray",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_GRAY.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_LIGHT_GRAY =
      ITEMS.register("fabric_cloth_light_gray",
          () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_LIGHT_GRAY.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_CYAN = ITEMS.register("fabric_cloth_cyan",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_CYAN.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_PURPLE = ITEMS.register(
      "fabric_cloth_purple", () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_PURPLE.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_BROWN = ITEMS.register("fabric_cloth_brown",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_BROWN.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_BLUE = ITEMS.register("fabric_cloth_blue",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_BLUE.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_GREEN = ITEMS.register("fabric_cloth_green",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_GREEN.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_RED = ITEMS.register("fabric_cloth_red",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_RED.get()));
  public static final RegistryObject<Item> FABRIC_CLOTH_BLACK = ITEMS.register("fabric_cloth_black",
      () -> new FabricClothItem(ModBlocks.FABRIC_CLOTH_BLACK.get()));


  // Cloth Blocks
  public static final RegistryObject<Item> CLOTH_BLOCK_WHITE = ITEMS.register("cloth_block_white",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_WHITE.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_ORANGE = ITEMS.register("cloth_block_orange",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_ORANGE.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_MAGENTA = ITEMS.register(
      "cloth_block_magenta", () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_MAGENTA.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_LIGHT_BLUE = ITEMS.register(
      "cloth_block_light_blue", () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_LIGHT_BLUE.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_YELLOW = ITEMS.register("cloth_block_yellow",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_YELLOW.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_LIME = ITEMS.register("cloth_block_lime",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_LIME.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_PINK = ITEMS.register("cloth_block_pink",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_PINK.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_GRAY = ITEMS.register("cloth_block_gray",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_GRAY.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_LIGHT_GRAY = ITEMS.register(
      "cloth_block_light_gray", () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_LIGHT_GRAY.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_CYAN = ITEMS.register("cloth_block_cyan",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_CYAN.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_PURPLE = ITEMS.register("cloth_block_purple",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_PURPLE.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_BROWN = ITEMS.register("cloth_block_brown",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_BROWN.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_BLUE = ITEMS.register("cloth_block_blue",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_BLUE.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_GREEN = ITEMS.register("cloth_block_green",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_GREEN.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_RED =
      ITEMS.register("cloth_block_red", () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_RED.get()));
  public static final RegistryObject<Item> CLOTH_BLOCK_BLACK = ITEMS.register("cloth_block_black",
      () -> new ClothBlockItem(ModBlocks.CLOTH_BLOCK_BLACK.get()));

  // Cloth Slabs
  public static final RegistryObject<Item> CLOTH_SLAB_WHITE =
      ITEMS.register("cloth_slab_white", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_WHITE.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_ORANGE = ITEMS.register("cloth_slab_orange",
      () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_ORANGE.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_MAGENTA = ITEMS.register("cloth_slab_magenta",
      () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_MAGENTA.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_LIGHT_BLUE = ITEMS.register(
      "cloth_slab_light_blue", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_LIGHT_BLUE.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_YELLOW = ITEMS.register("cloth_slab_yellow",
      () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_YELLOW.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_LIME =
      ITEMS.register("cloth_slab_lime", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_LIME.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_PINK =
      ITEMS.register("cloth_slab_pink", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_PINK.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_GRAY =
      ITEMS.register("cloth_slab_gray", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_GRAY.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_LIGHT_GRAY = ITEMS.register(
      "cloth_slab_light_gray", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_LIGHT_GRAY.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_CYAN =
      ITEMS.register("cloth_slab_cyan", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_CYAN.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_PURPLE = ITEMS.register("cloth_slab_purple",
      () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_PURPLE.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_BROWN =
      ITEMS.register("cloth_slab_brown", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_BROWN.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_BLUE =
      ITEMS.register("cloth_slab_blue", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_BLUE.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_GREEN =
      ITEMS.register("cloth_slab_green", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_GREEN.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_RED =
      ITEMS.register("cloth_slab_red", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_RED.get()));
  public static final RegistryObject<Item> CLOTH_SLAB_BLACK =
      ITEMS.register("cloth_slab_black", () -> new ClothSlabItem(ModBlocks.CLOTH_SLAB_BLACK.get()));

  // Cloth Triangular
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_WHITE =
      ITEMS.register("cloth_triangular_white",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_WHITE.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_ORANGE =
      ITEMS.register("cloth_triangular_orange",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_ORANGE.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_MAGENTA =
      ITEMS.register("cloth_triangular_magenta",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_MAGENTA.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_LIGHT_BLUE =
      ITEMS.register("cloth_triangular_light_blue",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_LIGHT_BLUE.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_YELLOW =
      ITEMS.register("cloth_triangular_yellow",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_YELLOW.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_LIME =
      ITEMS.register("cloth_triangular_lime",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_LIME.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_PINK =
      ITEMS.register("cloth_triangular_pink",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_PINK.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_GRAY =
      ITEMS.register("cloth_triangular_gray",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_GRAY.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_LIGHT_GRAY =
      ITEMS.register("cloth_triangular_light_gray",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_LIGHT_GRAY.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_CYAN =
      ITEMS.register("cloth_triangular_cyan",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_CYAN.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_PURPLE =
      ITEMS.register("cloth_triangular_purple",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_PURPLE.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_BROWN =
      ITEMS.register("cloth_triangular_brown",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_BROWN.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_BLUE =
      ITEMS.register("cloth_triangular_blue",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_BLUE.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_GREEN =
      ITEMS.register("cloth_triangular_green",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_GREEN.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_RED = ITEMS.register(
      "cloth_triangular_red", () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_RED.get()));
  public static final RegistryObject<Item> CLOTH_TRIANGULAR_BLACK =
      ITEMS.register("cloth_triangular_black",
          () -> new ClothTriangularItem(ModBlocks.CLOTH_TRIANGULAR_BLACK.get()));

  // Raised Floor
  public static final RegistryObject<Item> RAISED_FLOOR_BASE = ITEMS.register("raised_floor_base",
      () -> new BlockItem(ModBlocks.RAISED_FLOOR_BASE.get(), new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_BASIC = ITEMS.register("raised_floor_basic",
      () -> new BlockItem(ModBlocks.RAISED_FLOOR_BASIC.get(), new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_FLOW_PANEL_TYPE_A = ITEMS.register(
      "raised_floor_flow_panel_type_a",
      () -> new BlockItem(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_A.get(), new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_FLOW_PANEL_TYPE_B = ITEMS.register(
      "raised_floor_flow_panel_type_b",
      () -> new BlockItem(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_B.get(), new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_FLOW_PANEL_TYPE_C = ITEMS.register(
      "raised_floor_flow_panel_type_c",
      () -> new BlockItem(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_C.get(), new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_FLOW_PANEL_TYPE_D = ITEMS.register(
      "raised_floor_flow_panel_type_d",
      () -> new BlockItem(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_D.get(), new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_FLOW_PANEL_TYPE_E = ITEMS.register(
      "raised_floor_flow_panel_type_e",
      () -> new BlockItem(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_E.get(), new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_FLOW_PANEL_TYPE_F = ITEMS.register(
      "raised_floor_flow_panel_type_f",
      () -> new BlockItem(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_F.get(), new Item.Properties()));

  // Raised Floor Light
  public static final RegistryObject<Item> RAISED_FLOOR_LIGHT_CORNER_LIGHT_BLUE =
      ITEMS.register("raised_floor_light_corner_light_blue",
          () -> new BlockItem(ModBlocks.RAISED_FLOOR_LIGHT_CORNER_LIGHT_BLUE.get(),
              new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_LIGHT_CORNER_FLIPPED_LIGHT_BLUE =
      ITEMS.register("raised_floor_light_corner_flipped_light_blue",
          () -> new BlockItem(ModBlocks.RAISED_FLOOR_LIGHT_CORNER_FLIPPED_LIGHT_BLUE.get(),
              new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_LIGHT_LIGHT_BLUE = ITEMS.register(
      "raised_floor_light_light_blue",
      () -> new BlockItem(ModBlocks.RAISED_FLOOR_LIGHT_LIGHT_BLUE.get(), new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_LIGHT_MIDDLE_HALF_LIGHT_BLUE =
      ITEMS.register("raised_floor_light_middle_half_light_blue",
          () -> new BlockItem(ModBlocks.RAISED_FLOOR_LIGHT_MIDDLE_HALF_LIGHT_BLUE.get(),
              new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_LIGHT_MIDDLE_LIGHT_BLUE =
      ITEMS.register("raised_floor_light_middle_light_blue",
          () -> new BlockItem(ModBlocks.RAISED_FLOOR_LIGHT_MIDDLE_LIGHT_BLUE.get(),
              new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_LIGHT_SIDE_HALF_LIGHT_BLUE =
      ITEMS.register("raised_floor_light_side_half_light_blue",
          () -> new BlockItem(ModBlocks.RAISED_FLOOR_LIGHT_SIDE_HALF_LIGHT_BLUE.get(),
              new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_LIGHT_SIDE_HALF_FLIPPED_LIGHT_BLUE =
      ITEMS.register("raised_floor_light_side_half_flipped_light_blue",
          () -> new BlockItem(ModBlocks.RAISED_FLOOR_LIGHT_SIDE_HALF_FLIPPED_LIGHT_BLUE.get(),
              new Item.Properties()));
  public static final RegistryObject<Item> RAISED_FLOOR_LIGHT_SIDE_LIGHT_BLUE =
      ITEMS.register("raised_floor_light_side_light_blue",
          () -> new BlockItem(ModBlocks.RAISED_FLOOR_LIGHT_SIDE_LIGHT_BLUE.get(),
              new Item.Properties()));

  // Steel Chain
  public static final RegistryObject<Item> STEEL_CHAIN = ITEMS.register("steel_chain",
      () -> new BlockItem(ModBlocks.STEEL_CHAIN.get(), new Item.Properties()));

  // Steel Lantern
  public static final RegistryObject<Item> STEEL_LANTERN =
      ITEMS.register("steel_lantern", () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN.get()));
  public static final RegistryObject<Item> STEEL_SOUL_LANTERN = ITEMS.register("steel_soul_lantern",
      () -> new SteelLanternItem(ModBlocks.STEEL_SOUL_LANTERN.get()));

  // Steel Lantern (colored)
  public static final RegistryObject<Item> STEEL_LANTERN_WHITE = ITEMS.register(
      "steel_lantern_white", () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_WHITE.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_ORANGE = ITEMS.register(
      "steel_lantern_orange", () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_ORANGE.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_MAGENTA = ITEMS.register(
      "steel_lantern_magenta", () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_MAGENTA.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_LIGHT_BLUE =
      ITEMS.register("steel_lantern_light_blue",
          () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_LIGHT_BLUE.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_YELLOW = ITEMS.register(
      "steel_lantern_yellow", () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_YELLOW.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_LIME = ITEMS.register("steel_lantern_lime",
      () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_LIME.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_PINK = ITEMS.register("steel_lantern_pink",
      () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_PINK.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_GRAY = ITEMS.register("steel_lantern_gray",
      () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_GRAY.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_LIGHT_GRAY =
      ITEMS.register("steel_lantern_light_gray",
          () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_LIGHT_GRAY.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_CYAN = ITEMS.register("steel_lantern_cyan",
      () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_CYAN.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_PURPLE = ITEMS.register(
      "steel_lantern_purple", () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_PURPLE.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_BROWN = ITEMS.register(
      "steel_lantern_brown", () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_BROWN.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_BLUE = ITEMS.register("steel_lantern_blue",
      () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_BLUE.get(), DyeColor.BLUE));
  public static final RegistryObject<Item> STEEL_LANTERN_GREEN =
      ITEMS.register("steel_lantern_green",
          () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_GREEN.get(), DyeColor.GREEN));
  public static final RegistryObject<Item> STEEL_LANTERN_RED = ITEMS.register("steel_lantern_red",
      () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_RED.get()));
  public static final RegistryObject<Item> STEEL_LANTERN_BLACK = ITEMS.register(
      "steel_lantern_black", () -> new SteelLanternItem(ModBlocks.STEEL_LANTERN_BLACK.get()));
}
