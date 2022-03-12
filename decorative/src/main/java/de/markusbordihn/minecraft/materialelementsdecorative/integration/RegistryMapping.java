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

package de.markusbordihn.minecraft.materialelementsdecorative.integration;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.block.ModBlocks;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class RegistryMapping {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected RegistryMapping() {

  }

  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void handleMissingBlockMappings(RegistryEvent.MissingMappings<Block> event) {
    log.info("Try to fix missing mappings from possible former versions ...");
    ImmutableList<Mapping<Block>> blocks = event.getAllMappings();
    UnmodifiableIterator<Mapping<Block>> blocksIterator = blocks.iterator();
    while (blocksIterator.hasNext()) {
      Mapping<Block> mapping = blocksIterator.next();

      // Framed Hoppers
      if (mapping.key.equals(new ResourceLocation("material_elements:oak_framed_hopper"))) {
        mapping.remap(ModBlocks.OAK_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:spruce_framed_hopper"))) {
        mapping.remap(ModBlocks.SPRUCE_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:birch_framed_hopper"))) {
        mapping.remap(ModBlocks.BIRCH_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:jungle_framed_hopper"))) {
        mapping.remap(ModBlocks.JUNGLE_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:acacia_framed_hopper"))) {
        mapping.remap(ModBlocks.ACACIA_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:dark_oak_framed_hopper"))) {
        mapping.remap(ModBlocks.DARK_OAK_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:crimson_framed_hopper"))) {
        mapping.remap(ModBlocks.CRIMSON_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:warped_framed_hopper"))) {
        mapping.remap(ModBlocks.WARPED_FRAMED_HOPPER.get());
      }

      // Wooden Panels
      if (mapping.key.equals(new ResourceLocation("material_elements:oak_panel"))) {
        mapping.remap(ModBlocks.OAK_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:spruce_panel"))) {
        mapping.remap(ModBlocks.SPRUCE_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:birch_panel"))) {
        mapping.remap(ModBlocks.BIRCH_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:jungle_panel"))) {
        mapping.remap(ModBlocks.JUNGLE_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:acacia_panel"))) {
        mapping.remap(ModBlocks.ACACIA_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:dark_oak_panel"))) {
        mapping.remap(ModBlocks.DARK_OAK_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:crimson_panel"))) {
        mapping.remap(ModBlocks.CRIMSON_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:warped_panel"))) {
        mapping.remap(ModBlocks.WARPED_PANEL.get());
      }

      // Wooden Plates
      if (mapping.key.equals(new ResourceLocation("material_elements:oak_plate"))) {
        mapping.remap(ModBlocks.OAK_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:spruce_plate"))) {
        mapping.remap(ModBlocks.SPRUCE_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:birch_plate"))) {
        mapping.remap(ModBlocks.BIRCH_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:jungle_plate"))) {
        mapping.remap(ModBlocks.JUNGLE_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:acacia_plate"))) {
        mapping.remap(ModBlocks.ACACIA_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:dark_oak_plate"))) {
        mapping.remap(ModBlocks.DARK_OAK_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:crimson_plate"))) {
        mapping.remap(ModBlocks.CRIMSON_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:warped_plate"))) {
        mapping.remap(ModBlocks.WARPED_PLATE.get());
      }

      // Wooden Half-Slab
      if (mapping.key.equals(new ResourceLocation("material_elements:oak_half_slab"))) {
        mapping.remap(ModBlocks.OAK_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:spruce_half_slab"))) {
        mapping.remap(ModBlocks.SPRUCE_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:birch_half_slab"))) {
        mapping.remap(ModBlocks.BIRCH_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:jungle_half_slab"))) {
        mapping.remap(ModBlocks.JUNGLE_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:acacia_half_slab"))) {
        mapping.remap(ModBlocks.ACACIA_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:dark_oak_half_slab"))) {
        mapping.remap(ModBlocks.DARK_OAK_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:crimson_half_slab"))) {
        mapping.remap(ModBlocks.CRIMSON_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:warped_half_slab"))) {
        mapping.remap(ModBlocks.WARPED_HALF_SLAB.get());
      }

    }
  }

}
