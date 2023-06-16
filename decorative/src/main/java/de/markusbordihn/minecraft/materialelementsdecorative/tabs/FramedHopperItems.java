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

package de.markusbordihn.minecraft.materialelementsdecorative.tabs;

import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;

import de.markusbordihn.minecraft.materialelementsdecorative.item.ModItems;

public class FramedHopperItems implements DisplayItemsGenerator {
  protected FramedHopperItems() {}

  @Override
  public void accept(ItemDisplayParameters itemDisplayParameters, Output output) {
    // Wooden framed Hoppers
    output.accept(ModItems.OAK_FRAMED_HOPPER.get());
    output.accept(ModItems.SPRUCE_FRAMED_HOPPER.get());
    output.accept(ModItems.BIRCH_FRAMED_HOPPER.get());
    output.accept(ModItems.JUNGLE_FRAMED_HOPPER.get());
    output.accept(ModItems.ACACIA_FRAMED_HOPPER.get());
    output.accept(ModItems.DARK_OAK_FRAMED_HOPPER.get());
    output.accept(ModItems.CRIMSON_FRAMED_HOPPER.get());
    output.accept(ModItems.WARPED_FRAMED_HOPPER.get());
  }
}
