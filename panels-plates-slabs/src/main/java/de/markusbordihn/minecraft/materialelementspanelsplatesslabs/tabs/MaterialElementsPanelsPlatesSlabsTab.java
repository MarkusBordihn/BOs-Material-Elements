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

package de.markusbordihn.minecraft.materialelementspanelsplatesslabs.tabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.event.CreativeModeTabEvent;

import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.Constants;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.item.ModItems;

public class MaterialElementsPanelsPlatesSlabsTab {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected MaterialElementsPanelsPlatesSlabsTab() {}

  protected static CreativeModeTab TAB_PANEL_PLATES;

  protected static CreativeModeTab TAB_SLABS;

  public static void handleCreativeModeTabRegister(CreativeModeTabEvent.Register event) {

    log.info("{} creative mod tabs ...", Constants.LOG_REGISTER_PREFIX);

    TAB_PANEL_PLATES = event.registerCreativeModeTab(
        new ResourceLocation(Constants.MOD_ID, "panel_plates"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.OAK_PLATE.get()))
              .displayItems(MaterialElementsPanelsPlatesSlabsTab::addPanelPlatesTabItems)
              .title(Component
                  .translatable("itemGroup.material_elements_panels_plates_slabs.panel_plates"))
              .build();
        });

    TAB_SLABS =
        event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "slabs"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.WOOL_SLAB_RED.get()))
              .displayItems(MaterialElementsPanelsPlatesSlabsTab::addSlabsTabItems)
              .title(
                  Component.translatable("itemGroup.material_elements_panels_plates_slabs.slabs"))
              .build();
        });
  }

  private static void addPanelPlatesTabItems(FeatureFlagSet featureFlagSet, Output outputTab,
      boolean hasPermissions) {
    // Acacia
    outputTab.accept(ModItems.ACACIA_PANEL.get());
    outputTab.accept(ModItems.ACACIA_PLATE.get());
    outputTab.accept(ModItems.ACACIA_HALF_SLAB.get());

    // Andesite
    outputTab.accept(ModItems.ANDESITE_PANEL.get());
    outputTab.accept(ModItems.ANDESITE_PLATE.get());
    outputTab.accept(ModItems.ANDESITE_HALF_SLAB.get());

    // Polished Andesite
    outputTab.accept(ModItems.POLISHED_ANDESITE_PANEL.get());
    outputTab.accept(ModItems.POLISHED_ANDESITE_PLATE.get());
    outputTab.accept(ModItems.POLISHED_ANDESITE_HALF_SLAB.get());

    // Birch
    outputTab.accept(ModItems.BIRCH_PANEL.get());
    outputTab.accept(ModItems.BIRCH_PLATE.get());
    outputTab.accept(ModItems.BIRCH_HALF_SLAB.get());

    // Brick
    outputTab.accept(ModItems.BRICK_PANEL.get());
    outputTab.accept(ModItems.BRICKS_PLATE.get());
    outputTab.accept(ModItems.BRICKS_HALF_SLAB.get());

    // Crimson
    outputTab.accept(ModItems.CRIMSON_PANEL.get());
    outputTab.accept(ModItems.CRIMSON_PLATE.get());
    outputTab.accept(ModItems.CRIMSON_HALF_SLAB.get());

    // Granite
    outputTab.accept(ModItems.GRANITE_PANEL.get());
    outputTab.accept(ModItems.GRANITE_PLATE.get());
    outputTab.accept(ModItems.GRANITE_HALF_SLAB.get());

    // Polished Granite
    outputTab.accept(ModItems.POLISHED_GRANITE_PANEL.get());
    outputTab.accept(ModItems.POLISHED_GRANITE_PLATE.get());
    outputTab.accept(ModItems.POLISHED_GRANITE_HALF_SLAB.get());

    // Jungle
    outputTab.accept(ModItems.JUNGLE_PLATE.get());
    outputTab.accept(ModItems.JUNGLE_PANEL.get());
    outputTab.accept(ModItems.JUNGLE_HALF_SLAB.get());

    // Oak
    outputTab.accept(ModItems.OAK_PANEL.get());
    outputTab.accept(ModItems.OAK_PLATE.get());
    outputTab.accept(ModItems.OAK_HALF_SLAB.get());

    // Dark Oak
    outputTab.accept(ModItems.DARK_OAK_PANEL.get());
    outputTab.accept(ModItems.DARK_OAK_PLATE.get());
    outputTab.accept(ModItems.DARK_OAK_HALF_SLAB.get());

    // Spruce
    outputTab.accept(ModItems.SPRUCE_PANEL.get());
    outputTab.accept(ModItems.SPRUCE_PLATE.get());
    outputTab.accept(ModItems.SPRUCE_HALF_SLAB.get());

    // Stone Bricks
    outputTab.accept(ModItems.STONE_BRICK_PANEL.get());
    outputTab.accept(ModItems.STONE_BRICKS_PLATE.get());
    outputTab.accept(ModItems.STONE_BRICKS_HALF_SLAB.get());

    // Warped
    outputTab.accept(ModItems.WARPED_PANEL.get());
    outputTab.accept(ModItems.WARPED_PLATE.get());
    outputTab.accept(ModItems.WARPED_HALF_SLAB.get());

    // Quartz
    outputTab.accept(ModItems.QUARTZ_PANEL.get());
    outputTab.accept(ModItems.QUARTZ_PLATE.get());
    outputTab.accept(ModItems.QUARTZ_HALF_SLAB.get());

    // Quartz Smooth
    outputTab.accept(ModItems.SMOOTH_QUARTZ_PANEL.get());
    outputTab.accept(ModItems.SMOOTH_QUARTZ_PLATE.get());
    outputTab.accept(ModItems.SMOOTH_QUARTZ_HALF_SLAB.get());
  }

  private static void addSlabsTabItems(FeatureFlagSet featureFlagSet, Output outputTab,
      boolean hasPermissions) {
    // Glass
    outputTab.accept(ModItems.GLASS_SLAB.get());

    // Wool Slabs
    outputTab.accept(ModItems.WOOL_SLAB_WHITE.get());
    outputTab.accept(ModItems.WOOL_SLAB_ORANGE.get());
    outputTab.accept(ModItems.WOOL_SLAB_MAGENTA.get());
    outputTab.accept(ModItems.WOOL_SLAB_LIGHT_BLUE.get());
    outputTab.accept(ModItems.WOOL_SLAB_YELLOW.get());
    outputTab.accept(ModItems.WOOL_SLAB_LIME.get());
    outputTab.accept(ModItems.WOOL_SLAB_PINK.get());
    outputTab.accept(ModItems.WOOL_SLAB_GRAY.get());
    outputTab.accept(ModItems.WOOL_SLAB_LIGHT_GRAY.get());
    outputTab.accept(ModItems.WOOL_SLAB_CYAN.get());
    outputTab.accept(ModItems.WOOL_SLAB_PURPLE.get());
    outputTab.accept(ModItems.WOOL_SLAB_BLUE.get());
    outputTab.accept(ModItems.WOOL_SLAB_BROWN.get());
    outputTab.accept(ModItems.WOOL_SLAB_GREEN.get());
    outputTab.accept(ModItems.WOOL_SLAB_RED.get());
    outputTab.accept(ModItems.WOOL_SLAB_BLACK.get());
  }

}
