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
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.block.ModBlocks;
import de.markusbordihn.minecraft.materialelementsdecorative.item.ModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class RegistryMapping {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected RegistryMapping() {

  }

  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void handleMissingBlockMappings(RegistryEvent.MissingMappings<Block> event) {
    log.info("Try to migrate missing block mappings from possible former versions ...");
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

      // Steel Chain
      if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_chain"))) {
        mapping.remap(ModBlocks.STEEL_CHAIN.get());
      }

      // Steel Lantern
      if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_soul_lantern"))) {
        mapping.remap(ModBlocks.STEEL_SOUL_LANTERN.get());
      }

      // Steel Lantern (colored)
      if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_white"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_WHITE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_orange"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_ORANGE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_magenta"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_MAGENTA.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_light_blue"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_BLUE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_yellow"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_YELLOW.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_lime"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_LIME.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_pink"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_PINK.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_gray"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_GRAY.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_light_gray"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_LIGHT_GRAY.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_cyan"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_CYAN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_purple"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_PURPLE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_blue"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_BLUE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_brown"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_BROWN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_green"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_GREEN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_red"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_RED.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_black"))) {
        mapping.remap(ModBlocks.STEEL_LANTERN_BLACK.get());
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

      // Wool Half-Slab
      if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_white"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_WHITE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_orange"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_ORANGE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_magenta"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_MAGENTA.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_light_blue"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_BLUE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_yellow"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_YELLOW.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_lime"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_LIME.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_pink"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_PINK.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_gray"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_GRAY.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_light_gray"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_LIGHT_GRAY.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_cyan"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_CYAN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_purple"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_PURPLE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_blue"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_BLUE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_brown"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_BROWN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_green"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_GREEN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_red"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_RED.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:wool_slab_black"))) {
        mapping.remap(ModBlocks.WOOL_SLAB_BLACK.get());
      }

    }
  }

  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void handleMissingItemMappings(RegistryEvent.MissingMappings<Item> event) {
    log.info("Try to migrate missing item mappings from possible former versions ...");
    ImmutableList<Mapping<Item>> items = event.getAllMappings();
    UnmodifiableIterator<Mapping<Item>> itemsIterator = items.iterator();
    while (itemsIterator.hasNext()) {
      Mapping<Item> mapping = itemsIterator.next();

      // Framed Hoppers
      if (mapping.key.equals(new ResourceLocation("material_elements:oak_framed_hopper"))) {
        mapping.remap(ModItems.OAK_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:spruce_framed_hopper"))) {
        mapping.remap(ModItems.SPRUCE_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:birch_framed_hopper"))) {
        mapping.remap(ModItems.BIRCH_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:jungle_framed_hopper"))) {
        mapping.remap(ModItems.JUNGLE_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:acacia_framed_hopper"))) {
        mapping.remap(ModItems.ACACIA_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:dark_oak_framed_hopper"))) {
        mapping.remap(ModItems.DARK_OAK_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:crimson_framed_hopper"))) {
        mapping.remap(ModItems.CRIMSON_FRAMED_HOPPER.get());
      } else if (mapping.key
          .equals(new ResourceLocation("material_elements:warped_framed_hopper"))) {
        mapping.remap(ModItems.WARPED_FRAMED_HOPPER.get());
      }

      // Steel Chain
      if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_chain"))) {
        mapping.remap(ModItems.STEEL_CHAIN.get());
      }

      // Steel Lantern
      if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern"))) {
        mapping.remap(ModItems.STEEL_LANTERN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_soul_lantern"))) {
        mapping.remap(ModItems.STEEL_SOUL_LANTERN.get());
      }

      // Steel Lantern (colored)
      if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_white"))) {
        mapping.remap(ModItems.STEEL_LANTERN_WHITE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_orange"))) {
        mapping.remap(ModItems.STEEL_LANTERN_ORANGE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_magenta"))) {
        mapping.remap(ModItems.STEEL_LANTERN_MAGENTA.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_light_blue"))) {
        mapping.remap(ModItems.STEEL_LANTERN_BLUE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_yellow"))) {
        mapping.remap(ModItems.STEEL_LANTERN_YELLOW.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_lime"))) {
        mapping.remap(ModItems.STEEL_LANTERN_LIME.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_pink"))) {
        mapping.remap(ModItems.STEEL_LANTERN_PINK.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_gray"))) {
        mapping.remap(ModItems.STEEL_LANTERN_GRAY.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_light_gray"))) {
        mapping.remap(ModItems.STEEL_LANTERN_LIGHT_GRAY.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_cyan"))) {
        mapping.remap(ModItems.STEEL_LANTERN_CYAN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_purple"))) {
        mapping.remap(ModItems.STEEL_LANTERN_PURPLE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_blue"))) {
        mapping.remap(ModItems.STEEL_LANTERN_BLUE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_brown"))) {
        mapping.remap(ModItems.STEEL_LANTERN_BROWN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_green"))) {
        mapping.remap(ModItems.STEEL_LANTERN_GREEN.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_red"))) {
        mapping.remap(ModItems.STEEL_LANTERN_RED.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_lantern_black"))) {
        mapping.remap(ModItems.STEEL_LANTERN_BLACK.get());
      }

      // Wooden Panels
      if (mapping.key.equals(new ResourceLocation("material_elements:oak_panel"))) {
        mapping.remap(ModItems.OAK_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:spruce_panel"))) {
        mapping.remap(ModItems.SPRUCE_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:birch_panel"))) {
        mapping.remap(ModItems.BIRCH_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:jungle_panel"))) {
        mapping.remap(ModItems.JUNGLE_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:acacia_panel"))) {
        mapping.remap(ModItems.ACACIA_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:dark_oak_panel"))) {
        mapping.remap(ModItems.DARK_OAK_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:crimson_panel"))) {
        mapping.remap(ModItems.CRIMSON_PANEL.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:warped_panel"))) {
        mapping.remap(ModItems.WARPED_PANEL.get());
      }

      // Wooden Plates
      if (mapping.key.equals(new ResourceLocation("material_elements:oak_plate"))) {
        mapping.remap(ModItems.OAK_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:spruce_plate"))) {
        mapping.remap(ModItems.SPRUCE_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:birch_plate"))) {
        mapping.remap(ModItems.BIRCH_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:jungle_plate"))) {
        mapping.remap(ModItems.JUNGLE_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:acacia_plate"))) {
        mapping.remap(ModItems.ACACIA_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:dark_oak_plate"))) {
        mapping.remap(ModItems.DARK_OAK_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:crimson_plate"))) {
        mapping.remap(ModItems.CRIMSON_PLATE.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:warped_plate"))) {
        mapping.remap(ModItems.WARPED_PLATE.get());
      }

      // Wooden Half-Slab
      if (mapping.key.equals(new ResourceLocation("material_elements:oak_half_slab"))) {
        mapping.remap(ModItems.OAK_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:spruce_half_slab"))) {
        mapping.remap(ModItems.SPRUCE_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:birch_half_slab"))) {
        mapping.remap(ModItems.BIRCH_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:jungle_half_slab"))) {
        mapping.remap(ModItems.JUNGLE_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:acacia_half_slab"))) {
        mapping.remap(ModItems.ACACIA_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:dark_oak_half_slab"))) {
        mapping.remap(ModItems.DARK_OAK_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:crimson_half_slab"))) {
        mapping.remap(ModItems.CRIMSON_HALF_SLAB.get());
      } else if (mapping.key.equals(new ResourceLocation("material_elements:warped_half_slab"))) {
        mapping.remap(ModItems.WARPED_HALF_SLAB.get());
      }

    }
  }

}
