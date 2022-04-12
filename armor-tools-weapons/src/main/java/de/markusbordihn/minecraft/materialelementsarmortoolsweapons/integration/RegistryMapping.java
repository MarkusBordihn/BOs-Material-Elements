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

package de.markusbordihn.minecraft.materialelementsarmortoolsweapons.integration;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.Constants;
import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.item.ModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class RegistryMapping {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected RegistryMapping() {

  }

  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void handleMissingItemMappings(RegistryEvent.MissingMappings<Item> event) {
    log.info("Try to migrate missing item mappings from possible former versions ...");
    ImmutableList<Mapping<Item>> items = event.getAllMappings();
    UnmodifiableIterator<Mapping<Item>> itemsIterator = items.iterator();
    while (itemsIterator.hasNext()) {
      Mapping<Item> mapping = itemsIterator.next();

      // Steel Weapons
      if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_sword"))) {
        mapping.remap(ModItems.STEEL_SWORD.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_crossbow"))) {
        mapping.remap(ModItems.STEEL_CROSSBOW.get());
      }

      // Steel Tools
      if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_shovel"))) {
        mapping.remap(ModItems.STEEL_SHOVEL.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_pickaxe"))) {
        mapping.remap(ModItems.STEEL_PICKAXE.get());
      } else if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_axe"))) {
        mapping.remap(ModItems.STEEL_AXE.get());
      } else if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_hoe"))) {
        mapping.remap(ModItems.STEEL_HOE.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_shears"))) {
        mapping.remap(ModItems.STEEL_SHEARS.get());
      }

      // Steel Lighter
      if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_lighter"))) {
        mapping.remap(ModItems.STEEL_LIGHTER.get());
      }

      // Steel Armor
      if (mapping.key.equals(new ResourceLocation("steel_armor_tools_weapons:steel_boots"))) {
        mapping.remap(ModItems.STEEL_BOOTS.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_helmet"))) {
        mapping.remap(ModItems.STEEL_HELMET.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_leggings"))) {
        mapping.remap(ModItems.STEEL_LEGGINGS.get());
      } else if (mapping.key
          .equals(new ResourceLocation("steel_armor_tools_weapons:steel_chestplate"))) {
        mapping.remap(ModItems.STEEL_CHESTPLATE.get());
      }

    }
  }

}
