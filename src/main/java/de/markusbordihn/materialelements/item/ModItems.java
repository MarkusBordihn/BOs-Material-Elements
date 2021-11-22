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

package de.markusbordihn.materialelements.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.materialelements.Constants;
import de.markusbordihn.materialelements.Annotations.TemplateEntryPoint;
import de.markusbordihn.materialelements.block.ModBlocks;
import de.markusbordihn.materialelements.item.testtube.TestTubeFilledItem;
import de.markusbordihn.materialelements.item.testtube.TestTubeItem;
import de.markusbordihn.materialelements.tabs.MaterialElementsTab;

public class ModItems {

  protected ModItems() {

  }

  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  @TemplateEntryPoint("Register Items")

  // Nugget
  public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

  // Ingot
  public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

  // Test Tube
  public static final RegistryObject<Item> TEST_TUBE = ITEMS.register("test_tube",
      () -> new TestTubeItem((new Item.Properties()).tab(MaterialElementsTab.TAB_TEST_TUBES)));
  public static final RegistryObject<Item> TEST_TUBE_FILLED =
      ITEMS.register("test_tube_filled", () -> new TestTubeFilledItem(
          (new Item.Properties()).tab(MaterialElementsTab.TAB_TEST_TUBES)));

  // Other
  public static final RegistryObject<Item> COKE = ITEMS.register("coke",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

  @TemplateEntryPoint("Register Block Items")

  // Plates
  public static final RegistryObject<Item> OAK_PLATE =
      ITEMS.register("oak_plate", () -> new BlockItem(ModBlocks.OAK_PLATE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> SPRUCE_PLATE =
      ITEMS.register("spruce_plate", () -> new BlockItem(ModBlocks.SPRUCE_PLATE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> BIRCH_PLATE =
      ITEMS.register("birch_plate", () -> new BlockItem(ModBlocks.BIRCH_PLATE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> JUNGLE_PLATE =
      ITEMS.register("jungle_plate", () -> new BlockItem(ModBlocks.JUNGLE_PLATE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> ACACIA_PLATE =
      ITEMS.register("acacia_plate", () -> new BlockItem(ModBlocks.ACACIA_PLATE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> DARK_OAK_PLATE =
      ITEMS.register("dark_oak_plate", () -> new BlockItem(ModBlocks.DARK_OAK_PLATE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> CRIMSON_PLATE =
      ITEMS.register("crimson_plate", () -> new BlockItem(ModBlocks.CRIMSON_PLATE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
  public static final RegistryObject<Item> WARPED_PLATE =
      ITEMS.register("warped_plate", () -> new BlockItem(ModBlocks.WARPED_PLATE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

  // Rods (tee)
  public static final RegistryObject<Item> COPPER_ROD_TEE =
      ITEMS.register("copper_rod_tee", () -> new BlockItem(ModBlocks.COPPER_ROD_TEE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_TEE =
      ITEMS.register("gold_rod_tee", () -> new BlockItem(ModBlocks.GOLD_ROD_TEE.get(),
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
  public static final RegistryObject<Item> COPPER_ROD_STAR =
      ITEMS.register("copper_rod_star", () -> new BlockItem(ModBlocks.COPPER_ROD_STAR.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_STAR =
      ITEMS.register("gold_rod_star", () -> new BlockItem(ModBlocks.GOLD_ROD_STAR.get(),
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
  public static final RegistryObject<Item> COPPER_ROD_CROSS =
      ITEMS.register("copper_rod_cross", () -> new BlockItem(ModBlocks.COPPER_ROD_CROSS.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_CROSS =
      ITEMS.register("gold_rod_cross", () -> new BlockItem(ModBlocks.GOLD_ROD_CROSS.get(),
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
  public static final RegistryObject<Item> COPPER_ROD_HALF_SIZE = ITEMS
      .register("copper_rod_half_size", () -> new BlockItem(ModBlocks.COPPER_ROD_HALF_SIZE.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD_HALF_SIZE =
      ITEMS.register("gold_rod_half_size", () -> new BlockItem(ModBlocks.GOLD_ROD_HALF_SIZE.get(),
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
  public static final RegistryObject<Item> COPPER_ROD =
      ITEMS.register("copper_rod", () -> new BlockItem(ModBlocks.COPPER_ROD.get(),
          new Item.Properties().tab(MaterialElementsTab.TAB_RODS)));
  public static final RegistryObject<Item> GOLD_ROD =
      ITEMS.register("gold_rod", () -> new BlockItem(ModBlocks.GOLD_ROD.get(),
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
  public static final RegistryObject<Item> STEEL_BLOCK =
      ITEMS.register("steel_block", () -> new BlockItem(ModBlocks.STEEL_BLOCK.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

  // Ore
  public static final RegistryObject<Item> STEEL_ORE =
      ITEMS.register("steel_ore", () -> new BlockItem(ModBlocks.STEEL_ORE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}
