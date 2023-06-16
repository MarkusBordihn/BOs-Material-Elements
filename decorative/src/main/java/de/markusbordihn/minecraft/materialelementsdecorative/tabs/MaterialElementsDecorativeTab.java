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

package de.markusbordihn.minecraft.materialelementsdecorative.tabs;

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
import de.markusbordihn.minecraft.materialelements.tabs.MaterialElementsTab;
import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.item.ModItems;

public class MaterialElementsDecorativeTab {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected MaterialElementsDecorativeTab() {}

  protected static CreativeModeTab TAB_FRAMED_HOPPERS;

  protected static CreativeModeTab TAB_RAISED_FLOOR;

  public static void handleCreativeModeTabRegister(CreativeModeTabEvent.Register event) {

    log.info("{} creative mod tabs ...", Constants.LOG_REGISTER_PREFIX);

    TAB_FRAMED_HOPPERS = event.registerCreativeModeTab(
        new ResourceLocation(Constants.MOD_ID, "framed_hoppers"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.OAK_FRAMED_HOPPER.get()))
              .displayItems(new FramedHopperItems())
              .title(
                  Component.translatable("itemGroup.material_elements_decorative.framed_hoppers"))
              .build();
        });

    TAB_RAISED_FLOOR = event.registerCreativeModeTab(
        new ResourceLocation(Constants.MOD_ID, "raised_floor"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.RAISED_FLOOR_BASIC.get()))
              .displayItems(new RaisedFloorItems())
              .title(Component.translatable("itemGroup.material_elements_decorative.raised_floor"))
              .build();
        });
  }

  public static void handleCreativeModeTab(CreativeModeTabEvent.BuildContents event) {
    if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
      // Steel Chain
      event.accept(ModItems.STEEL_CHAIN.get());

      // Steel Lantern
      event.accept(ModItems.STEEL_LANTERN.get());
      event.accept(ModItems.STEEL_SOUL_LANTERN.get());

      // Steel Lantern (colored)
      event.accept(ModItems.STEEL_LANTERN_WHITE.get());
      event.accept(ModItems.STEEL_LANTERN_ORANGE.get());
      event.accept(ModItems.STEEL_LANTERN_MAGENTA.get());
      event.accept(ModItems.STEEL_LANTERN_LIGHT_BLUE.get());
      event.accept(ModItems.STEEL_LANTERN_YELLOW.get());
      event.accept(ModItems.STEEL_LANTERN_LIME.get());
      event.accept(ModItems.STEEL_LANTERN_PINK.get());
      event.accept(ModItems.STEEL_LANTERN_GRAY.get());
      event.accept(ModItems.STEEL_LANTERN_LIGHT_GRAY.get());
      event.accept(ModItems.STEEL_LANTERN_CYAN.get());
      event.accept(ModItems.STEEL_LANTERN_PURPLE.get());
      event.accept(ModItems.STEEL_LANTERN_BROWN.get());
      event.accept(ModItems.STEEL_LANTERN_BLUE.get());
      event.accept(ModItems.STEEL_LANTERN_GREEN.get());
      event.accept(ModItems.STEEL_LANTERN_RED.get());
      event.accept(ModItems.STEEL_LANTERN_BLACK.get());
    } else if (event.getTab() == MaterialElementsTab.TAB_CLOTH) {
      // Fabric Cloth
      event.accept(ModItems.FABRIC_CLOTH_WHITE.get());
      event.accept(ModItems.FABRIC_CLOTH_ORANGE.get());
      event.accept(ModItems.FABRIC_CLOTH_MAGENTA.get());
      event.accept(ModItems.FABRIC_CLOTH_LIGHT_BLUE.get());
      event.accept(ModItems.FABRIC_CLOTH_YELLOW.get());
      event.accept(ModItems.FABRIC_CLOTH_LIME.get());
      event.accept(ModItems.FABRIC_CLOTH_PINK.get());
      event.accept(ModItems.FABRIC_CLOTH_GRAY.get());
      event.accept(ModItems.FABRIC_CLOTH_LIGHT_GRAY.get());

      event.accept(ModItems.FABRIC_CLOTH_CYAN.get());
      event.accept(ModItems.FABRIC_CLOTH_PURPLE.get());
      event.accept(ModItems.FABRIC_CLOTH_BROWN.get());
      event.accept(ModItems.FABRIC_CLOTH_BLUE.get());
      event.accept(ModItems.FABRIC_CLOTH_GREEN.get());
      event.accept(ModItems.FABRIC_CLOTH_RED.get());
      event.accept(ModItems.FABRIC_CLOTH_BLACK.get());

      // Cloth Blocks
      event.accept(ModItems.CLOTH_BLOCK_WHITE.get());
      event.accept(ModItems.CLOTH_BLOCK_ORANGE.get());
      event.accept(ModItems.CLOTH_BLOCK_MAGENTA.get());
      event.accept(ModItems.CLOTH_BLOCK_LIGHT_BLUE.get());
      event.accept(ModItems.CLOTH_BLOCK_YELLOW.get());
      event.accept(ModItems.CLOTH_BLOCK_LIME.get());
      event.accept(ModItems.CLOTH_BLOCK_PINK.get());
      event.accept(ModItems.CLOTH_BLOCK_GRAY.get());
      event.accept(ModItems.CLOTH_BLOCK_LIGHT_GRAY.get());
      event.accept(ModItems.CLOTH_BLOCK_CYAN.get());
      event.accept(ModItems.CLOTH_BLOCK_PURPLE.get());
      event.accept(ModItems.CLOTH_BLOCK_BROWN.get());
      event.accept(ModItems.CLOTH_BLOCK_BLUE.get());
      event.accept(ModItems.CLOTH_BLOCK_GREEN.get());
      event.accept(ModItems.CLOTH_BLOCK_RED.get());
      event.accept(ModItems.CLOTH_BLOCK_BLACK.get());

      // Cloth Slabs
      event.accept(ModItems.CLOTH_SLAB_WHITE.get());
      event.accept(ModItems.CLOTH_SLAB_ORANGE.get());
      event.accept(ModItems.CLOTH_SLAB_MAGENTA.get());
      event.accept(ModItems.CLOTH_SLAB_LIGHT_BLUE.get());
      event.accept(ModItems.CLOTH_SLAB_YELLOW.get());
      event.accept(ModItems.CLOTH_SLAB_LIME.get());
      event.accept(ModItems.CLOTH_SLAB_PINK.get());
      event.accept(ModItems.CLOTH_SLAB_GRAY.get());
      event.accept(ModItems.CLOTH_SLAB_LIGHT_GRAY.get());
      event.accept(ModItems.CLOTH_SLAB_CYAN.get());
      event.accept(ModItems.CLOTH_SLAB_PURPLE.get());
      event.accept(ModItems.CLOTH_SLAB_BROWN.get());
      event.accept(ModItems.CLOTH_SLAB_BLUE.get());
      event.accept(ModItems.CLOTH_SLAB_GREEN.get());
      event.accept(ModItems.CLOTH_SLAB_RED.get());
      event.accept(ModItems.CLOTH_SLAB_BLACK.get());

      // Cloth Triangular
      event.accept(ModItems.CLOTH_TRIANGULAR_WHITE.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_ORANGE.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_MAGENTA.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_LIGHT_BLUE.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_YELLOW.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_LIME.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_PINK.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_GRAY.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_LIGHT_GRAY.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_CYAN.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_PURPLE.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_BROWN.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_BLUE.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_GREEN.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_RED.get());
      event.accept(ModItems.CLOTH_TRIANGULAR_BLACK.get());
    }
  }

}
