/**
 * Copyright 2023 Markus Bordihn
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


package de.markusbordihn.minecraft.materialelementsarmortoolsweapons.tabs;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.item.ModItems;

public class MaterialElementsArmorToolsWeaponsTab {

  protected MaterialElementsArmorToolsWeaponsTab() {}

  public static void handleCreativeModeTab(BuildCreativeModeTabContentsEvent event) {
    if (event.getTabKey() == CreativeModeTabs.COMBAT) {
      // Copper Weapons
      event.accept(ModItems.COPPER_SWORD.get());
      event.accept(ModItems.COPPER_CROSSBOW.get());

      // Copper Armor
      event.accept(ModItems.COPPER_BOOTS.get());
      event.accept(ModItems.COPPER_HELMET.get());
      event.accept(ModItems.COPPER_LEGGINGS.get());
      event.accept(ModItems.COPPER_CHESTPLATE.get());

      // Steel Weapons
      event.accept(ModItems.STEEL_SWORD.get());
      event.accept(ModItems.STEEL_CROSSBOW.get());

      // Steel Armor
      event.accept(ModItems.STEEL_BOOTS.get());
      event.accept(ModItems.STEEL_HELMET.get());
      event.accept(ModItems.STEEL_LEGGINGS.get());
      event.accept(ModItems.STEEL_CHESTPLATE.get());
    } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
      // Copper Tools
      event.accept(ModItems.COPPER_AXE.get());
      event.accept(ModItems.COPPER_HOE.get());
      event.accept(ModItems.COPPER_PICKAXE.get());
      event.accept(ModItems.COPPER_SHEARS.get());
      event.accept(ModItems.COPPER_SHOVEL.get());

      // Copper Lighter
      event.accept(ModItems.COPPER_LIGHTER.get());

      // Steel Tools
      event.accept(ModItems.STEEL_AXE.get());
      event.accept(ModItems.STEEL_HOE.get());
      event.accept(ModItems.STEEL_PICKAXE.get());
      event.accept(ModItems.STEEL_SHEARS.get());
      event.accept(ModItems.STEEL_SHOVEL.get());

      // Steel Lighter
      event.accept(ModItems.STEEL_LIGHTER.get());
    }
  }

}
