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

public class TestTubeItems implements DisplayItemsGenerator {
  protected TestTubeItems() {}

  @Override
  public void accept(ItemDisplayParameters itemDisplayParameters, Output output) {
    // Test Tube Color (DyeColor)
    output.accept(ModItems.TEST_TUBE_COLOR_WHITE.get());
    output.accept(ModItems.TEST_TUBE_COLOR_ORANGE.get());
    output.accept(ModItems.TEST_TUBE_COLOR_MAGENTA.get());
    output.accept(ModItems.TEST_TUBE_COLOR_LIGHT_BLUE.get());
    output.accept(ModItems.TEST_TUBE_COLOR_YELLOW.get());
    output.accept(ModItems.TEST_TUBE_COLOR_LIME.get());
    output.accept(ModItems.TEST_TUBE_COLOR_PINK.get());
    output.accept(ModItems.TEST_TUBE_COLOR_GRAY.get());
    output.accept(ModItems.TEST_TUBE_COLOR_LIGHT_GRAY.get());
    output.accept(ModItems.TEST_TUBE_COLOR_CYAN.get());
    output.accept(ModItems.TEST_TUBE_COLOR_PURPLE.get());
    output.accept(ModItems.TEST_TUBE_COLOR_BLUE.get());
    output.accept(ModItems.TEST_TUBE_COLOR_BROWN.get());
    output.accept(ModItems.TEST_TUBE_COLOR_GREEN.get());
    output.accept(ModItems.TEST_TUBE_COLOR_RED.get());
    output.accept(ModItems.TEST_TUBE_COLOR_BLACK.get());

    // Test Tube (custom)
    output.accept(ModItems.TEST_TUBE_WATER.get());
    output.accept(ModItems.TEST_TUBE_GLOW.get());

    // Test Tube
    output.accept(ModItems.TEST_TUBE.get());
    output.accept(ModItems.TEST_TUBE_FILLED.get());
  }
}
