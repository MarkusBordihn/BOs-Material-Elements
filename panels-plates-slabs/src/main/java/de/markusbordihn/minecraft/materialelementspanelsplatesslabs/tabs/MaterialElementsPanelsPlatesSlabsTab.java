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

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.Constants;
import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.item.ModItems;

public class MaterialElementsPanelsPlatesSlabsTab {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected MaterialElementsPanelsPlatesSlabsTab() {}

  public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

  public static final RegistryObject<CreativeModeTab> TAB_PANEL_PLATES =
      CREATIVE_TABS.register("panel_plates",
          () -> CreativeModeTab.builder().icon(() -> ModItems.OAK_PLATE.get().getDefaultInstance())
              .displayItems(new PanelPlatesItems())
              .title(Component
                  .translatable("itemGroup.material_elements_panels_plates_slabs.panel_plates"))
              .build());

  public static final RegistryObject<CreativeModeTab> TAB_SLABS = CREATIVE_TABS.register("slabs",
      () -> CreativeModeTab.builder().icon(() -> ModItems.WOOL_SLAB_RED.get().getDefaultInstance())
          .displayItems(new SlabsItems())
          .title(Component.translatable("itemGroup.material_elements_panels_plates_slabs.slabs"))
          .build());


}
