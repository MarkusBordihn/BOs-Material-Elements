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

package de.markusbordihn.minecraft.materialelements.tabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab.Output;

import net.minecraftforge.event.CreativeModeTabEvent;

import de.markusbordihn.minecraft.materialelements.Constants;
import de.markusbordihn.minecraft.materialelements.item.ModItems;

public class MaterialElementsTab {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected MaterialElementsTab() {}

  public static CreativeModeTab TAB_FRAMES;

  public static CreativeModeTab TAB_CONSTRUCTION_FRAMES;

  public static CreativeModeTab TAB_RODS;

  public static CreativeModeTab TAB_TEST_TUBES;

  public static CreativeModeTab TAB_LEATHER;

  public static CreativeModeTab TAB_CLOTH;

  public static void handleCreativeModeTabRegister(CreativeModeTabEvent.Register event) {

    log.info("{} creative mod tabs ...", Constants.LOG_REGISTER_PREFIX);

    TAB_FRAMES =
        event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "frames"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.LIGHT_CUBE_GLASS_FRAME.get()))
              .displayItems(MaterialElementsTab::addFramesTabItems)
              .title(Component.translatable("itemGroup.material_elements.frames")).build();
        });
    TAB_CONSTRUCTION_FRAMES = event.registerCreativeModeTab(
        new ResourceLocation(Constants.MOD_ID, "construction_frames"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.OAK_CONSTRUCTION_CUBE_FRAME.get()))
              .displayItems(MaterialElementsTab::addConstructionFramesTabItems)
              .title(Component.translatable("itemGroup.material_elements.construction_frames"))
              .build();
        });
    TAB_RODS =
        event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "rods"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.IRON_ROD.get()))
              .displayItems(MaterialElementsTab::addRodsTabItems)
              .title(Component.translatable("itemGroup.material_elements.rods")).build();
        });
    TAB_TEST_TUBES = event
        .registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "test_tubes"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.TEST_TUBE_COLOR_WHITE.get()))
              .displayItems(MaterialElementsTab::addTestTubesTabItems)
              .title(Component.translatable("itemGroup.material_elements.test_tubes")).build();
        });
    TAB_LEATHER = event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "leather"),
        builder -> {
          builder.icon(() -> new ItemStack(ModItems.LEATHER_SHEET.get()))
              .displayItems(MaterialElementsTab::addLeatherTabItems)
              .title(Component.translatable("itemGroup.material_elements.leather")).build();
        });
    TAB_CLOTH =
        event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "cloth"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.CLOTH.get()))
              .displayItems(MaterialElementsTab::addClothTabItems)
              .title(Component.translatable("itemGroup.material_elements.cloth")).build();
        });
  }

  public static void handleCreativeModeTab(CreativeModeTabEvent.BuildContents event) {
    if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
      // Blocks
      event.accept(ModItems.SILVER_BLOCK.get());
      event.accept(ModItems.STEEL_BLOCK.get());

      // Cokes and Charcoal Block
      event.accept(ModItems.CHARCOAL_BLOCK.get());
      event.accept(ModItems.COKE_BLOCK.get());
    } else if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
      // Raw Blocks
      event.accept(ModItems.RAW_SILVER_BLOCK.get());
      event.accept(ModItems.RAW_STEEL_BLOCK.get());

      // Ores
      event.accept(ModItems.SILVER_ORE.get());
      event.accept(ModItems.DEEPSLATE_SILVER_ORE.get());
      event.accept(ModItems.STEEL_ORE.get());
      event.accept(ModItems.DEEPSLATE_STEEL_ORE.get());
    } else if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
      // Nugget
      event.accept(ModItems.COPPER_NUGGET.get());
      event.accept(ModItems.SILVER_NUGGET.get());
      event.accept(ModItems.STEEL_NUGGET.get());
      event.accept(ModItems.NETHERITE_NUGGET.get());

      // Ingot
      event.accept(ModItems.SILVER_INGOT.get());
      event.accept(ModItems.STEEL_INGOT.get());

      // Raw Material
      event.accept(ModItems.RAW_SILVER.get());
      event.accept(ModItems.RAW_STEEL.get());

      // Other
      event.accept(ModItems.COKE.get());

      // Wooden Sticks
      event.accept(ModItems.OAK_STICK.get());
      event.accept(ModItems.SPRUCE_STICK.get());
      event.accept(ModItems.BIRCH_STICK.get());
      event.accept(ModItems.JUNGLE_STICK.get());
      event.accept(ModItems.ACACIA_STICK.get());
      event.accept(ModItems.DARK_OAK_STICK.get());
      event.accept(ModItems.CRIMSON_STICK.get());
      event.accept(ModItems.WARPED_STICK.get());

      // Wooden Sticks (half-size)
      event.accept(ModItems.OAK_STICK_HALF_SIZE.get());
      event.accept(ModItems.SPRUCE_STICK_HALF_SIZE.get());
      event.accept(ModItems.BIRCH_STICK_HALF_SIZE.get());
      event.accept(ModItems.JUNGLE_STICK_HALF_SIZE.get());
      event.accept(ModItems.ACACIA_STICK_HALF_SIZE.get());
      event.accept(ModItems.DARK_OAK_STICK_HALF_SIZE.get());
      event.accept(ModItems.CRIMSON_STICK_HALF_SIZE.get());
      event.accept(ModItems.WARPED_STICK_HALF_SIZE.get());
    }
  }

  private static void addFramesTabItems(FeatureFlagSet featureFlagSet, Output outputTab,
      boolean hasPermissions) {
    // Cube Frames
    outputTab.accept(ModItems.LIGHT_CUBE_FRAME.get());
    outputTab.accept(ModItems.COPPER_CUBE_FRAME.get());
    outputTab.accept(ModItems.GOLD_CUBE_FRAME.get());
    outputTab.accept(ModItems.SILVER_CUBE_FRAME.get());
    outputTab.accept(ModItems.IRON_CUBE_FRAME.get());
    outputTab.accept(ModItems.STEEL_CUBE_FRAME.get());
    outputTab.accept(ModItems.NETHERITE_CUBE_FRAME.get());

    // Cube Glass Frames
    outputTab.accept(ModItems.LIGHT_CUBE_GLASS_FRAME.get());
    outputTab.accept(ModItems.COPPER_CUBE_GLASS_FRAME.get());
    outputTab.accept(ModItems.GOLD_CUBE_GLASS_FRAME.get());
    outputTab.accept(ModItems.SILVER_CUBE_GLASS_FRAME.get());
    outputTab.accept(ModItems.IRON_CUBE_GLASS_FRAME.get());
    outputTab.accept(ModItems.STEEL_CUBE_GLASS_FRAME.get());
    outputTab.accept(ModItems.NETHERITE_CUBE_GLASS_FRAME.get());

    // Slab Frames
    outputTab.accept(ModItems.LIGHT_SLAB_FRAME.get());
    outputTab.accept(ModItems.COPPER_SLAB_FRAME.get());
    outputTab.accept(ModItems.GOLD_SLAB_FRAME.get());
    outputTab.accept(ModItems.SILVER_SLAB_FRAME.get());
    outputTab.accept(ModItems.IRON_SLAB_FRAME.get());
    outputTab.accept(ModItems.STEEL_SLAB_FRAME.get());
    outputTab.accept(ModItems.NETHERITE_SLAB_FRAME.get());

    // Skeleton Frames
    outputTab.accept(ModItems.LIGHT_SKELETON_FRAME.get());
    outputTab.accept(ModItems.COPPER_SKELETON_FRAME.get());
    outputTab.accept(ModItems.GOLD_SKELETON_FRAME.get());
    outputTab.accept(ModItems.SILVER_SKELETON_FRAME.get());
    outputTab.accept(ModItems.IRON_SKELETON_FRAME.get());
    outputTab.accept(ModItems.STEEL_SKELETON_FRAME.get());
    outputTab.accept(ModItems.NETHERITE_SKELETON_FRAME.get());

    // Triangular Frames
    outputTab.accept(ModItems.LIGHT_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.COPPER_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.GOLD_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.SILVER_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.IRON_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.STEEL_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.NETHERITE_TRIANGULAR_FRAME.get());
  }

  private static void addConstructionFramesTabItems(FeatureFlagSet featureFlagSet, Output outputTab,
      boolean hasPermissions) {
    // Construction Cube Frames
    outputTab.accept(ModItems.OAK_CONSTRUCTION_CUBE_FRAME.get());
    outputTab.accept(ModItems.SPRUCE_CONSTRUCTION_CUBE_FRAME.get());
    outputTab.accept(ModItems.BIRCH_CONSTRUCTION_CUBE_FRAME.get());
    outputTab.accept(ModItems.JUNGLE_CONSTRUCTION_CUBE_FRAME.get());
    outputTab.accept(ModItems.ACACIA_CONSTRUCTION_CUBE_FRAME.get());
    outputTab.accept(ModItems.DARK_OAK_CONSTRUCTION_CUBE_FRAME.get());
    outputTab.accept(ModItems.CRIMSON_CONSTRUCTION_CUBE_FRAME.get());
    outputTab.accept(ModItems.WARPED_CONSTRUCTION_CUBE_FRAME.get());

    // Construction Slab Frames
    outputTab.accept(ModItems.OAK_CONSTRUCTION_SLAB_FRAME.get());
    outputTab.accept(ModItems.SPRUCE_CONSTRUCTION_SLAB_FRAME.get());
    outputTab.accept(ModItems.BIRCH_CONSTRUCTION_SLAB_FRAME.get());
    outputTab.accept(ModItems.JUNGLE_CONSTRUCTION_SLAB_FRAME.get());
    outputTab.accept(ModItems.ACACIA_CONSTRUCTION_SLAB_FRAME.get());
    outputTab.accept(ModItems.DARK_OAK_CONSTRUCTION_SLAB_FRAME.get());
    outputTab.accept(ModItems.CRIMSON_CONSTRUCTION_SLAB_FRAME.get());
    outputTab.accept(ModItems.WARPED_CONSTRUCTION_SLAB_FRAME.get());

    // Construction Triangular Frames
    outputTab.accept(ModItems.OAK_CONSTRUCTION_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.SPRUCE_CONSTRUCTION_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.BIRCH_CONSTRUCTION_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.JUNGLE_CONSTRUCTION_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.ACACIA_CONSTRUCTION_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.DARK_OAK_CONSTRUCTION_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.CRIMSON_CONSTRUCTION_TRIANGULAR_FRAME.get());
    outputTab.accept(ModItems.WARPED_CONSTRUCTION_TRIANGULAR_FRAME.get());
  }

  private static void addRodsTabItems(FeatureFlagSet featureFlagSet, Output outputTab,
      boolean hasPermissions) {
    // Rods (tee elbow)
    outputTab.accept(ModItems.LIGHT_ROD_TEE_ELBOW.get());
    outputTab.accept(ModItems.COPPER_ROD_TEE_ELBOW.get());
    outputTab.accept(ModItems.GOLD_ROD_TEE_ELBOW.get());
    outputTab.accept(ModItems.SILVER_ROD_TEE_ELBOW.get());
    outputTab.accept(ModItems.IRON_ROD_TEE_ELBOW.get());
    outputTab.accept(ModItems.STEEL_ROD_TEE_ELBOW.get());
    outputTab.accept(ModItems.NETHERITE_ROD_TEE_ELBOW.get());

    // Rods (elbow)
    outputTab.accept(ModItems.LIGHT_ROD_ELBOW.get());
    outputTab.accept(ModItems.COPPER_ROD_ELBOW.get());
    outputTab.accept(ModItems.GOLD_ROD_ELBOW.get());
    outputTab.accept(ModItems.SILVER_ROD_ELBOW.get());
    outputTab.accept(ModItems.IRON_ROD_ELBOW.get());
    outputTab.accept(ModItems.STEEL_ROD_ELBOW.get());
    outputTab.accept(ModItems.NETHERITE_ROD_ELBOW.get());

    // Rods (tee)
    outputTab.accept(ModItems.LIGHT_ROD_TEE.get());
    outputTab.accept(ModItems.COPPER_ROD_TEE.get());
    outputTab.accept(ModItems.GOLD_ROD_TEE.get());
    outputTab.accept(ModItems.SILVER_ROD_TEE.get());
    outputTab.accept(ModItems.IRON_ROD_TEE.get());
    outputTab.accept(ModItems.STEEL_ROD_TEE.get());
    outputTab.accept(ModItems.NETHERITE_ROD_TEE.get());

    // Rods (star)
    outputTab.accept(ModItems.LIGHT_ROD_STAR.get());
    outputTab.accept(ModItems.COPPER_ROD_STAR.get());
    outputTab.accept(ModItems.GOLD_ROD_STAR.get());
    outputTab.accept(ModItems.SILVER_ROD_STAR.get());
    outputTab.accept(ModItems.IRON_ROD_STAR.get());
    outputTab.accept(ModItems.STEEL_ROD_STAR.get());
    outputTab.accept(ModItems.NETHERIRE_ROD_STAR.get());

    // Rods (cross)
    outputTab.accept(ModItems.LIGHT_ROD_CROSS.get());
    outputTab.accept(ModItems.COPPER_ROD_CROSS.get());
    outputTab.accept(ModItems.GOLD_ROD_CROSS.get());
    outputTab.accept(ModItems.SILVER_ROD_CROSS.get());
    outputTab.accept(ModItems.IRON_ROD_CROSS.get());
    outputTab.accept(ModItems.STEEL_ROD_CROSS.get());
    outputTab.accept(ModItems.NETHERITE_ROD_CROSS.get());

    // Rods (half size)
    outputTab.accept(ModItems.LIGHT_ROD_HALF_SIZE.get());
    outputTab.accept(ModItems.COPPER_ROD_HALF_SIZE.get());
    outputTab.accept(ModItems.GOLD_ROD_HALF_SIZE.get());
    outputTab.accept(ModItems.SILVER_ROD_HALF_SIZE.get());
    outputTab.accept(ModItems.IRON_ROD_HALF_SIZE.get());
    outputTab.accept(ModItems.STEEL_ROD_HALF_SIZE.get());
    outputTab.accept(ModItems.NETHERITE_ROD_HALF_SIZE.get());

    // Rods (full-size)
    outputTab.accept(ModItems.LIGHT_ROD.get());
    outputTab.accept(ModItems.COPPER_ROD.get());
    outputTab.accept(ModItems.GOLD_ROD.get());
    outputTab.accept(ModItems.SILVER_ROD.get());
    outputTab.accept(ModItems.IRON_ROD.get());
    outputTab.accept(ModItems.STEEL_ROD.get());
    outputTab.accept(ModItems.NETHERITE_ROD.get());
  }

  private static void addTestTubesTabItems(FeatureFlagSet featureFlagSet, Output outputTab,
      boolean hasPermissions) {
    // Test Tube Color (DyeColor)
    outputTab.accept(ModItems.TEST_TUBE_COLOR_WHITE.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_ORANGE.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_MAGENTA.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_LIGHT_BLUE.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_YELLOW.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_LIME.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_PINK.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_GRAY.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_LIGHT_GRAY.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_CYAN.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_PURPLE.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_BLUE.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_BROWN.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_GREEN.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_RED.get());
    outputTab.accept(ModItems.TEST_TUBE_COLOR_BLACK.get());

    // Test Tube (custom)
    outputTab.accept(ModItems.TEST_TUBE_WATER.get());
    outputTab.accept(ModItems.TEST_TUBE_GLOW.get());

    // Test Tube
    outputTab.accept(ModItems.TEST_TUBE.get());
    outputTab.accept(ModItems.TEST_TUBE_FILLED.get());
  }

  private static void addLeatherTabItems(FeatureFlagSet featureFlagSet, Output outputTab,
      boolean hasPermissions) {
    // Leather
    outputTab.accept(ModItems.LEATHER_SHEET.get());
    outputTab.accept(ModItems.LEATHER_SHEET_WHITE.get());
    outputTab.accept(ModItems.LEATHER_SHEET_ORANGE.get());
    outputTab.accept(ModItems.LEATHER_SHEET_MAGENTA.get());
    outputTab.accept(ModItems.LEATHER_SHEET_LIGHT_BLUE.get());
    outputTab.accept(ModItems.LEATHER_SHEET_LIGHT_GRAY.get());
    outputTab.accept(ModItems.LEATHER_SHEET_YELLOW.get());
    outputTab.accept(ModItems.LEATHER_SHEET_LIME.get());
    outputTab.accept(ModItems.LEATHER_SHEET_PINK.get());
    outputTab.accept(ModItems.LEATHER_SHEET_GRAY.get());
    outputTab.accept(ModItems.LEATHER_SHEET_CYAN.get());
    outputTab.accept(ModItems.LEATHER_SHEET_PURPLE.get());
    outputTab.accept(ModItems.LEATHER_SHEET_BLUE.get());
    outputTab.accept(ModItems.LEATHER_SHEET_BROWN.get());
    outputTab.accept(ModItems.LEATHER_SHEET_GREEN.get());
    outputTab.accept(ModItems.LEATHER_SHEET_RED.get());
    outputTab.accept(ModItems.LEATHER_SHEET_BLACK.get());

    // Leather Strips
    outputTab.accept(ModItems.LEATHER_STRIP.get());
    outputTab.accept(ModItems.LEATHER_STRIP_WHITE.get());
    outputTab.accept(ModItems.LEATHER_STRIP_ORANGE.get());
    outputTab.accept(ModItems.LEATHER_STRIP_MAGENTA.get());
    outputTab.accept(ModItems.LEATHER_STRIP_LIGHT_BLUE.get());
    outputTab.accept(ModItems.LEATHER_STRIP_LIGHT_GRAY.get());
    outputTab.accept(ModItems.LEATHER_STRIP_YELLOW.get());
    outputTab.accept(ModItems.LEATHER_STRIP_LIME.get());
    outputTab.accept(ModItems.LEATHER_STRIP_PINK.get());
    outputTab.accept(ModItems.LEATHER_STRIP_GRAY.get());
    outputTab.accept(ModItems.LEATHER_STRIP_CYAN.get());
    outputTab.accept(ModItems.LEATHER_STRIP_PURPLE.get());
    outputTab.accept(ModItems.LEATHER_STRIP_BLUE.get());
    outputTab.accept(ModItems.LEATHER_STRIP_BROWN.get());
    outputTab.accept(ModItems.LEATHER_STRIP_GREEN.get());
    outputTab.accept(ModItems.LEATHER_STRIP_RED.get());
    outputTab.accept(ModItems.LEATHER_STRIP_BLACK.get());

    // Leather Tools
    outputTab.accept(ModItems.LEATHER_KNIFE.get());
    outputTab.accept(ModItems.LEATHER_SHEARS.get());
  }

  private static void addClothTabItems(FeatureFlagSet featureFlagSet, Output outputTab,
      boolean hasPermissions) {
    // Cloth
    outputTab.accept(ModItems.CLOTH.get());
    outputTab.accept(ModItems.CLOTH_WHITE.get());
    outputTab.accept(ModItems.CLOTH_ORANGE.get());
    outputTab.accept(ModItems.CLOTH_MAGENTA.get());
    outputTab.accept(ModItems.CLOTH_LIGHT_BLUE.get());
    outputTab.accept(ModItems.CLOTH_LIGHT_GRAY.get());
    outputTab.accept(ModItems.CLOTH_YELLOW.get());
    outputTab.accept(ModItems.CLOTH_LIME.get());
    outputTab.accept(ModItems.CLOTH_PINK.get());
    outputTab.accept(ModItems.CLOTH_GRAY.get());
    outputTab.accept(ModItems.CLOTH_CYAN.get());
    outputTab.accept(ModItems.CLOTH_PURPLE.get());
    outputTab.accept(ModItems.CLOTH_BLUE.get());
    outputTab.accept(ModItems.CLOTH_BROWN.get());
    outputTab.accept(ModItems.CLOTH_GREEN.get());
    outputTab.accept(ModItems.CLOTH_RED.get());
    outputTab.accept(ModItems.CLOTH_BLACK.get());
  }

}
