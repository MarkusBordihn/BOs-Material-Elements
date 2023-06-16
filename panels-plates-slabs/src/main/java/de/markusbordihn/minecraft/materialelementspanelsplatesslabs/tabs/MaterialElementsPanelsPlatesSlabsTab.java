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
              .displayItems(new PanelPlatesItems())
              .title(Component
                  .translatable("itemGroup.material_elements_panels_plates_slabs.panel_plates"))
              .build();
        });

    TAB_SLABS =
        event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "slabs"), builder -> {
          builder.icon(() -> new ItemStack(ModItems.WOOL_SLAB_RED.get()))
              .displayItems(new SlabsItems())
              .title(
                  Component.translatable("itemGroup.material_elements_panels_plates_slabs.slabs"))
              .build();
        });
  }

}
