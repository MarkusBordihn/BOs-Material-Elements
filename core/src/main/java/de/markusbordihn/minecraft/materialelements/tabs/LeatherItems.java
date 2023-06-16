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

package de.markusbordihn.minecraft.materialelements.tabs;

import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;

import de.markusbordihn.minecraft.materialelements.item.ModItems;

public class LeatherItems implements DisplayItemsGenerator {
  protected LeatherItems() {}

  @Override
  public void accept(ItemDisplayParameters itemDisplayParameters, Output output) {
    // Leather
    output.accept(ModItems.LEATHER_SHEET.get());
    output.accept(ModItems.LEATHER_SHEET_WHITE.get());
    output.accept(ModItems.LEATHER_SHEET_ORANGE.get());
    output.accept(ModItems.LEATHER_SHEET_MAGENTA.get());
    output.accept(ModItems.LEATHER_SHEET_LIGHT_BLUE.get());
    output.accept(ModItems.LEATHER_SHEET_LIGHT_GRAY.get());
    output.accept(ModItems.LEATHER_SHEET_YELLOW.get());
    output.accept(ModItems.LEATHER_SHEET_LIME.get());
    output.accept(ModItems.LEATHER_SHEET_PINK.get());
    output.accept(ModItems.LEATHER_SHEET_GRAY.get());
    output.accept(ModItems.LEATHER_SHEET_CYAN.get());
    output.accept(ModItems.LEATHER_SHEET_PURPLE.get());
    output.accept(ModItems.LEATHER_SHEET_BLUE.get());
    output.accept(ModItems.LEATHER_SHEET_BROWN.get());
    output.accept(ModItems.LEATHER_SHEET_GREEN.get());
    output.accept(ModItems.LEATHER_SHEET_RED.get());
    output.accept(ModItems.LEATHER_SHEET_BLACK.get());

    // Leather Strips
    output.accept(ModItems.LEATHER_STRIP.get());
    output.accept(ModItems.LEATHER_STRIP_WHITE.get());
    output.accept(ModItems.LEATHER_STRIP_ORANGE.get());
    output.accept(ModItems.LEATHER_STRIP_MAGENTA.get());
    output.accept(ModItems.LEATHER_STRIP_LIGHT_BLUE.get());
    output.accept(ModItems.LEATHER_STRIP_LIGHT_GRAY.get());
    output.accept(ModItems.LEATHER_STRIP_YELLOW.get());
    output.accept(ModItems.LEATHER_STRIP_LIME.get());
    output.accept(ModItems.LEATHER_STRIP_PINK.get());
    output.accept(ModItems.LEATHER_STRIP_GRAY.get());
    output.accept(ModItems.LEATHER_STRIP_CYAN.get());
    output.accept(ModItems.LEATHER_STRIP_PURPLE.get());
    output.accept(ModItems.LEATHER_STRIP_BLUE.get());
    output.accept(ModItems.LEATHER_STRIP_BROWN.get());
    output.accept(ModItems.LEATHER_STRIP_GREEN.get());
    output.accept(ModItems.LEATHER_STRIP_RED.get());
    output.accept(ModItems.LEATHER_STRIP_BLACK.get());

    // Leather Tools
    output.accept(ModItems.LEATHER_KNIFE.get());
    output.accept(ModItems.LEATHER_SHEARS.get());
  }
}
