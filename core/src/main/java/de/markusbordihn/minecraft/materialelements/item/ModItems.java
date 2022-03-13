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

package de.markusbordihn.minecraft.materialelements.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.minecraft.materialelements.Constants;
import de.markusbordihn.minecraft.materialelements.Annotations.TemplateEntryPoint;
import de.markusbordihn.minecraft.materialelements.block.ModBlocks;
import de.markusbordihn.minecraft.materialelements.item.testtube.TestTubeColorItem;
import de.markusbordihn.minecraft.materialelements.item.testtube.TestTubeCustomFoilItem;
import de.markusbordihn.minecraft.materialelements.item.testtube.TestTubeCustomItem;
import de.markusbordihn.minecraft.materialelements.item.testtube.TestTubeFilledItem;
import de.markusbordihn.minecraft.materialelements.item.testtube.TestTubeItem;
import de.markusbordihn.minecraft.materialelements.tabs.MaterialElementsTab;

public class ModItems {

  protected ModItems() {

  }

  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  @TemplateEntryPoint("Register Items")

  // Cloth
  public static final RegistryObject<Item> CLOTH =
      ITEMS.register("cloth", () -> new ClothItem(DyeColor.WHITE));
  public static final RegistryObject<Item> CLOTH_WHITE =
      ITEMS.register("cloth_white", () -> new ClothItem(DyeColor.WHITE));
  public static final RegistryObject<Item> CLOTH_ORANGE =
      ITEMS.register("cloth_orange", () -> new ClothItem(DyeColor.ORANGE));
  public static final RegistryObject<Item> CLOTH_MAGENTA =
      ITEMS.register("cloth_magenta", () -> new ClothItem(DyeColor.MAGENTA));
  public static final RegistryObject<Item> CLOTH_LIGHT_BLUE =
      ITEMS.register("cloth_light_blue", () -> new ClothItem(DyeColor.LIGHT_BLUE));
  public static final RegistryObject<Item> CLOTH_LIGHT_GRAY =
      ITEMS.register("cloth_light_gray", () -> new ClothItem(DyeColor.LIGHT_GRAY));
  public static final RegistryObject<Item> CLOTH_YELLOW =
      ITEMS.register("cloth_yellow", () -> new ClothItem(DyeColor.YELLOW));
  public static final RegistryObject<Item> CLOTH_LIME =
      ITEMS.register("cloth_lime", () -> new ClothItem(DyeColor.LIME));
  public static final RegistryObject<Item> CLOTH_PINK =
      ITEMS.register("cloth_pink", () -> new ClothItem(DyeColor.PINK));
  public static final RegistryObject<Item> CLOTH_GRAY =
      ITEMS.register("cloth_gray", () -> new ClothItem(DyeColor.GRAY));
  public static final RegistryObject<Item> CLOTH_CYAN =
      ITEMS.register("cloth_cyan", () -> new ClothItem(DyeColor.CYAN));
  public static final RegistryObject<Item> CLOTH_PURPLE =
      ITEMS.register("cloth_purple", () -> new ClothItem(DyeColor.PURPLE));
  public static final RegistryObject<Item> CLOTH_BLUE =
      ITEMS.register("cloth_blue", () -> new ClothItem(DyeColor.BLUE));
  public static final RegistryObject<Item> CLOTH_BROWN =
      ITEMS.register("cloth_brown", () -> new ClothItem(DyeColor.BROWN));
  public static final RegistryObject<Item> CLOTH_GREEN =
      ITEMS.register("cloth_green", () -> new ClothItem(DyeColor.GREEN));
  public static final RegistryObject<Item> CLOTH_RED =
      ITEMS.register("cloth_red", () -> new ClothItem(DyeColor.RED));
  public static final RegistryObject<Item> CLOTH_BLACK =
      ITEMS.register("cloth_black", () -> new ClothItem(DyeColor.BLACK));

  // Leather
  public static final RegistryObject<Item> LEATHER_SHEET =
      ITEMS.register("leather_sheet", LeatherSheetItem::new);

  // Leather Strips
  public static final RegistryObject<Item> LEATHER_STRIP =
      ITEMS.register("leather_strip", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_WHITE =
      ITEMS.register("leather_strip_white", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_ORANGE =
      ITEMS.register("leather_strip_orange", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_MAGENTA =
      ITEMS.register("leather_strip_magenta", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_LIGHT_BLUE =
      ITEMS.register("leather_strip_light_blue", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_LIGHT_GRAY =
      ITEMS.register("leather_strip_light_gray", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_YELLOW =
      ITEMS.register("leather_strip_yellow", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_LIME =
      ITEMS.register("leather_strip_lime", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_PINK =
      ITEMS.register("leather_strip_pink", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_GRAY =
      ITEMS.register("leather_strip_gray", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_CYAN =
      ITEMS.register("leather_strip_cyan", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_PURPLE =
      ITEMS.register("leather_strip_purple", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_BLUE =
      ITEMS.register("leather_strip_blue", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_BROWN =
      ITEMS.register("leather_strip_brown", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_GREEN =
      ITEMS.register("leather_strip_green", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_RED =
      ITEMS.register("leather_strip_red", LeatherStripItem::new);
  public static final RegistryObject<Item> LEATHER_STRIP_BLACK =
      ITEMS.register("leather_strip_black", LeatherStripItem::new);

  // Nugget
  public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

  // Ingot
  public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

  // Raw Material
  public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> RAW_STEEL = ITEMS.register("raw_steel",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

  // Test Tube Color (DyeColor)
  private static final String TEST_TUBE_PREFIX = "test_tube_color_";
  public static final RegistryObject<Item> TEST_TUBE_COLOR_WHITE =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.WHITE.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.WHITE));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_ORANGE =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.ORANGE.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.ORANGE));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_MAGENTA =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.MAGENTA.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.MAGENTA));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_LIGHT_BLUE =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.LIGHT_BLUE.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.LIGHT_BLUE));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_YELLOW =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.YELLOW.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.YELLOW));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_LIME =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.LIME.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.LIME));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_PINK =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.PINK.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.PINK));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_GRAY =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.GRAY.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.GRAY));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_LIGHT_GRAY =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.LIGHT_GRAY.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.LIGHT_GRAY));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_CYAN =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.CYAN.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.CYAN));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_PURPLE =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.PURPLE.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.PURPLE));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_BLUE =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.BLUE.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.BLUE));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_BROWN =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.BROWN.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.BROWN));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_GREEN =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.GREEN.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.GREEN));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_RED =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.RED.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.RED));
  public static final RegistryObject<Item> TEST_TUBE_COLOR_BLACK =
      ITEMS.register(TEST_TUBE_PREFIX + DyeColor.BLACK.getName(),
          () -> new TestTubeColorItem(new Item.Properties().tab(MaterialElementsTab.TAB_TEST_TUBES),
              DyeColor.BLACK));

  // Test Tube (custom)
  public static final RegistryObject<Item> TEST_TUBE_WATER =
      ITEMS.register("test_tube_water", () -> new TestTubeCustomItem(
          (new Item.Properties()).tab(MaterialElementsTab.TAB_TEST_TUBES)));
  public static final RegistryObject<Item> TEST_TUBE_GLOW =
      ITEMS.register("test_tube_glow", () -> new TestTubeCustomFoilItem(
          (new Item.Properties()).tab(MaterialElementsTab.TAB_TEST_TUBES), DyeColor.CYAN));

  // Test Tube
  public static final RegistryObject<Item> TEST_TUBE = ITEMS.register("test_tube",
      () -> new TestTubeItem((new Item.Properties()).tab(MaterialElementsTab.TAB_TEST_TUBES)));
  public static final RegistryObject<Item> TEST_TUBE_FILLED =
      ITEMS.register("test_tube_filled", () -> new TestTubeFilledItem(
          (new Item.Properties()).tab(MaterialElementsTab.TAB_TEST_TUBES)));

  // Other
  public static final RegistryObject<Item> COKE = ITEMS.register("coke",
      () -> new CokeItem(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

  // Wooden Sticks
  public static final RegistryObject<Item> OAK_STICK = ITEMS.register("oak_stick",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> SPRUCE_STICK = ITEMS.register("spruce_stick",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> BIRCH_STICK = ITEMS.register("birch_stick",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> JUNGLE_STICK = ITEMS.register("jungle_stick",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> ACACIA_STICK = ITEMS.register("acacia_stick",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> DARK_OAK_STICK = ITEMS.register("dark_oak_stick",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> CRIMSON_STICK = ITEMS.register("crimson_stick",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> WARPED_STICK = ITEMS.register("warped_stick",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

  @TemplateEntryPoint("Register Block Items")

  // Cube Frames
  public static final RegistryObject<Item> LIGHT_CUBE_FRAME =
      ITEMS.register("light_cube_frame", () -> new CubeFrameItem(ModBlocks.LIGHT_CUBE_FRAME.get()));
  public static final RegistryObject<Item> COPPER_CUBE_FRAME = ITEMS.register("copper_cube_frame",
      () -> new CubeFrameItem(ModBlocks.COPPER_CUBE_FRAME.get()));
  public static final RegistryObject<Item> GOLD_CUBE_FRAME =
      ITEMS.register("gold_cube_frame", () -> new CubeFrameItem(ModBlocks.GOLD_CUBE_FRAME.get()));
  public static final RegistryObject<Item> SILVER_CUBE_FRAME = ITEMS.register("silver_cube_frame",
      () -> new CubeFrameItem(ModBlocks.SILVER_CUBE_FRAME.get()));
  public static final RegistryObject<Item> IRON_CUBE_FRAME =
      ITEMS.register("iron_cube_frame", () -> new CubeFrameItem(ModBlocks.IRON_CUBE_FRAME.get()));
  public static final RegistryObject<Item> STEEL_CUBE_FRAME =
      ITEMS.register("steel_cube_frame", () -> new CubeFrameItem(ModBlocks.STEEL_CUBE_FRAME.get()));
  public static final RegistryObject<Item> NETHERITE_CUBE_FRAME = ITEMS.register(
      "netherite_cube_frame", () -> new CubeFrameItem(ModBlocks.NETHERITE_CUBE_FRAME.get()));

  // Cube Glass Frames
  public static final RegistryObject<Item> LIGHT_CUBE_GLASS_FRAME =
      ITEMS.register("light_cube_glass_frame",
          () -> new CubeGlassFrameItem(ModBlocks.LIGHT_CUBE_GLASS_FRAME.get()));
  public static final RegistryObject<Item> COPPER_CUBE_GLASS_FRAME =
      ITEMS.register("copper_cube_glass_frame",
          () -> new CubeGlassFrameItem(ModBlocks.COPPER_CUBE_GLASS_FRAME.get()));
  public static final RegistryObject<Item> GOLD_CUBE_GLASS_FRAME = ITEMS.register(
      "gold_cube_glass_frame", () -> new CubeGlassFrameItem(ModBlocks.GOLD_CUBE_GLASS_FRAME.get()));
  public static final RegistryObject<Item> SILVER_CUBE_GLASS_FRAME =
      ITEMS.register("silver_cube_glass_frame",
          () -> new CubeGlassFrameItem(ModBlocks.SILVER_CUBE_GLASS_FRAME.get()));
  public static final RegistryObject<Item> IRON_CUBE_GLASS_FRAME = ITEMS.register(
      "iron_cube_glass_frame", () -> new CubeGlassFrameItem(ModBlocks.IRON_CUBE_GLASS_FRAME.get()));
  public static final RegistryObject<Item> STEEL_CUBE_GLASS_FRAME =
      ITEMS.register("steel_cube_glass_frame",
          () -> new CubeGlassFrameItem(ModBlocks.STEEL_CUBE_GLASS_FRAME.get()));
  public static final RegistryObject<Item> NETHERITE_CUBE_GLASS_FRAME =
      ITEMS.register("netherite_cube_glass_frame",
          () -> new CubeGlassFrameItem(ModBlocks.NETHERITE_CUBE_GLASS_FRAME.get()));

  // Rods (tee elbow)
  public static final RegistryObject<Item> LIGHT_ROD_TEE_ELBOW =
      ITEMS.register("light_rod_tee_elbow", () -> new BlockItem(ModBlocks.LIGHT_ROD_TEE_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> COPPER_ROD_TEE_ELBOW = ITEMS
      .register("copper_rod_tee_elbow", () -> new BlockItem(ModBlocks.COPPER_ROD_TEE_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_TEE_ELBOW =
      ITEMS.register("gold_rod_tee_elbow", () -> new BlockItem(ModBlocks.GOLD_ROD_TEE_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> SILVER_ROD_TEE_ELBOW = ITEMS
      .register("silver_rod_tee_elbow", () -> new BlockItem(ModBlocks.SILVER_ROD_TEE_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> IRON_ROD_TEE_ELBOW =
      ITEMS.register("iron_rod_tee_elbow", () -> new BlockItem(ModBlocks.IRON_ROD_TEE_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> STEEL_ROD_TEE_ELBOW =
      ITEMS.register("steel_rod_tee_elbow", () -> new BlockItem(ModBlocks.STEEL_ROD_TEE_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> NETHERITE_ROD_TEE_ELBOW = ITEMS.register(
      "netherite_rod_tee_elbow", () -> new BlockItem(ModBlocks.NETHERITE_ROD_TEE_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));

  // Rods (elbow)
  public static final RegistryObject<Item> LIGHT_ROD_ELBOW =
      ITEMS.register("light_rod_elbow", () -> new BlockItem(ModBlocks.LIGHT_ROD_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> COPPER_ROD_ELBOW =
      ITEMS.register("copper_rod_elbow", () -> new BlockItem(ModBlocks.COPPER_ROD_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_ELBOW =
      ITEMS.register("gold_rod_elbow", () -> new BlockItem(ModBlocks.GOLD_ROD_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> SILVER_ROD_ELBOW =
      ITEMS.register("silver_rod_elbow", () -> new BlockItem(ModBlocks.SILVER_ROD_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> IRON_ROD_ELBOW =
      ITEMS.register("iron_rod_elbow", () -> new BlockItem(ModBlocks.IRON_ROD_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> STEEL_ROD_ELBOW =
      ITEMS.register("steel_rod_elbow", () -> new BlockItem(ModBlocks.STEEL_ROD_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> NETHERITE_ROD_ELBOW =
      ITEMS.register("netherite_rod_elbow", () -> new BlockItem(ModBlocks.NETHERITE_ROD_ELBOW.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));

  // Rods (tee)
  public static final RegistryObject<Item> LIGHT_ROD_TEE =
      ITEMS.register("light_rod_tee", () -> new BlockItem(ModBlocks.LIGHT_ROD_TEE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> COPPER_ROD_TEE =
      ITEMS.register("copper_rod_tee", () -> new BlockItem(ModBlocks.COPPER_ROD_TEE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_TEE =
      ITEMS.register("gold_rod_tee", () -> new BlockItem(ModBlocks.GOLD_ROD_TEE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> SILVER_ROD_TEE =
      ITEMS.register("silver_rod_tee", () -> new BlockItem(ModBlocks.SILVER_ROD_TEE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> IRON_ROD_TEE =
      ITEMS.register("iron_rod_tee", () -> new BlockItem(ModBlocks.IRON_ROD_TEE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> STEEL_ROD_TEE =
      ITEMS.register("steel_rod_tee", () -> new BlockItem(ModBlocks.STEEL_ROD_TEE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> NETHERITE_ROD_TEE =
      ITEMS.register("netherite_rod_tee", () -> new BlockItem(ModBlocks.NETHERITE_ROD_TEE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));

  // Rods (star)
  public static final RegistryObject<Item> LIGHT_ROD_STAR =
      ITEMS.register("light_rod_star", () -> new BlockItem(ModBlocks.LIGHT_ROD_STAR.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> COPPER_ROD_STAR =
      ITEMS.register("copper_rod_star", () -> new BlockItem(ModBlocks.COPPER_ROD_STAR.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_STAR =
      ITEMS.register("gold_rod_star", () -> new BlockItem(ModBlocks.GOLD_ROD_STAR.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> SILVER_ROD_STAR =
      ITEMS.register("silver_rod_star", () -> new BlockItem(ModBlocks.SILVER_ROD_STAR.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> IRON_ROD_STAR =
      ITEMS.register("iron_rod_star", () -> new BlockItem(ModBlocks.IRON_ROD_STAR.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> STEEL_ROD_STAR =
      ITEMS.register("steel_rod_star", () -> new BlockItem(ModBlocks.STEEL_ROD_STAR.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> NETHERIRE_ROD_STAR =
      ITEMS.register("netherite_rod_star", () -> new BlockItem(ModBlocks.NETHERITE_ROD_STAR.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));

  // Rods (cross)
  public static final RegistryObject<Item> LIGHT_ROD_CROSS =
      ITEMS.register("light_rod_cross", () -> new BlockItem(ModBlocks.LIGHT_ROD_CROSS.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> COPPER_ROD_CROSS =
      ITEMS.register("copper_rod_cross", () -> new BlockItem(ModBlocks.COPPER_ROD_CROSS.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_CROSS =
      ITEMS.register("gold_rod_cross", () -> new BlockItem(ModBlocks.GOLD_ROD_CROSS.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> SILVER_ROD_CROSS =
      ITEMS.register("silver_rod_cross", () -> new BlockItem(ModBlocks.SILVER_ROD_CROSS.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> IRON_ROD_CROSS =
      ITEMS.register("iron_rod_cross", () -> new BlockItem(ModBlocks.IRON_ROD_CROSS.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> STEEL_ROD_CROSS =
      ITEMS.register("steel_rod_cross", () -> new BlockItem(ModBlocks.STEEL_ROD_CROSS.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> NETHERITE_ROD_CROSS =
      ITEMS.register("netherite_rod_cross", () -> new BlockItem(ModBlocks.NETHERITE_ROD_CROSS.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));

  // Rods (half size)
  public static final RegistryObject<Item> LIGHT_ROD_HALF_SIZE =
      ITEMS.register("light_rod_half_size", () -> new BlockItem(ModBlocks.LIGHT_ROD_HALF_SIZE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> COPPER_ROD_HALF_SIZE = ITEMS
      .register("copper_rod_half_size", () -> new BlockItem(ModBlocks.COPPER_ROD_HALF_SIZE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_HALF_SIZE =
      ITEMS.register("gold_rod_half_size", () -> new BlockItem(ModBlocks.GOLD_ROD_HALF_SIZE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> SILVER_ROD_HALF_SIZE = ITEMS
      .register("silver_rod_half_size", () -> new BlockItem(ModBlocks.SILVER_ROD_HALF_SIZE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> IRON_ROD_HALF_SIZE =
      ITEMS.register("iron_rod_half_size", () -> new BlockItem(ModBlocks.IRON_ROD_HALF_SIZE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> STEEL_ROD_HALF_SIZE =
      ITEMS.register("steel_rod_half_size", () -> new BlockItem(ModBlocks.STEEL_ROD_HALF_SIZE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> NETHERITE_ROD_HALF_SIZE = ITEMS.register(
      "netherite_rod_half_size", () -> new BlockItem(ModBlocks.NETHERITE_ROD_HALF_SIZE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));

  // Rods (full-size)
  public static final RegistryObject<Item> LIGHT_ROD =
      ITEMS.register("light_rod", () -> new BlockItem(ModBlocks.LIGHT_ROD.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> COPPER_ROD =
      ITEMS.register("copper_rod", () -> new BlockItem(ModBlocks.COPPER_ROD.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD =
      ITEMS.register("gold_rod", () -> new BlockItem(ModBlocks.GOLD_ROD.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> SILVER_ROD =
      ITEMS.register("silver_rod", () -> new BlockItem(ModBlocks.SILVER_ROD.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> IRON_ROD =
      ITEMS.register("iron_rod", () -> new BlockItem(ModBlocks.IRON_ROD.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> STEEL_ROD =
      ITEMS.register("steel_rod", () -> new BlockItem(ModBlocks.STEEL_ROD.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> NETHERITE_ROD =
      ITEMS.register("netherite_rod", () -> new BlockItem(ModBlocks.NETHERITE_ROD.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));

  // Blocks
  public static final RegistryObject<Item> SILVER_BLOCK =
      ITEMS.register("silver_block", () -> new BlockItem(ModBlocks.SILVER_BLOCK.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> STEEL_BLOCK =
      ITEMS.register("steel_block", () -> new BlockItem(ModBlocks.STEEL_BLOCK.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

  // Raw Blocks
  public static final RegistryObject<Item> RAW_SILVER_BLOCK =
      ITEMS.register("raw_silver_block", () -> new BlockItem(ModBlocks.RAW_SILVER_BLOCK.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> RAW_STEEL_BLOCK =
      ITEMS.register("raw_steel_block", () -> new BlockItem(ModBlocks.RAW_STEEL_BLOCK.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

  // Cokes and Charcoal Block
  public static final RegistryObject<Item> CHARCOAL_BLOCK =
      ITEMS.register("charcoal_block", () -> new CharcoalBlockItem(ModBlocks.CHARCOAL_BLOCK.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> COKE_BLOCK =
      ITEMS.register("coke_block", () -> new CokeBlockItem(ModBlocks.COKE_BLOCK.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

  // Ores
  public static final RegistryObject<Item> SILVER_ORE =
      ITEMS.register("silver_ore", () -> new BlockItem(ModBlocks.SILVER_ORE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> DEEPSLATE_SILVER_ORE = ITEMS
      .register("deepslate_silver_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> STEEL_ORE =
      ITEMS.register("steel_ore", () -> new BlockItem(ModBlocks.STEEL_ORE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> DEEPSLATE_STEEL_ORE =
      ITEMS.register("deepslate_steel_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_STEEL_ORE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

}
