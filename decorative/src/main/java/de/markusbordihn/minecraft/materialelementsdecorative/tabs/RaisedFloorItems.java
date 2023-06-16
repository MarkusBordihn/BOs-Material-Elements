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

public class RaisedFloorItems implements DisplayItemsGenerator {
  protected RaisedFloorItems() {}

  @Override
  public void accept(ItemDisplayParameters itemDisplayParameters, Output output) {
    // Raised Floor
    output.accept(ModItems.RAISED_FLOOR_BASE.get());
    output.accept(ModItems.RAISED_FLOOR_BASIC.get());
    output.accept(ModItems.RAISED_FLOOR_FLOW_PANEL_TYPE_A.get());
    output.accept(ModItems.RAISED_FLOOR_FLOW_PANEL_TYPE_B.get());
    output.accept(ModItems.RAISED_FLOOR_FLOW_PANEL_TYPE_C.get());
    output.accept(ModItems.RAISED_FLOOR_FLOW_PANEL_TYPE_D.get());
    output.accept(ModItems.RAISED_FLOOR_FLOW_PANEL_TYPE_E.get());
    output.accept(ModItems.RAISED_FLOOR_FLOW_PANEL_TYPE_F.get());

    // Raised Floor Light
    output.accept(ModItems.RAISED_FLOOR_LIGHT_CORNER_LIGHT_BLUE.get());
    output.accept(ModItems.RAISED_FLOOR_LIGHT_CORNER_FLIPPED_LIGHT_BLUE.get());
    output.accept(ModItems.RAISED_FLOOR_LIGHT_LIGHT_BLUE.get());
    output.accept(ModItems.RAISED_FLOOR_LIGHT_MIDDLE_HALF_LIGHT_BLUE.get());
    output.accept(ModItems.RAISED_FLOOR_LIGHT_MIDDLE_LIGHT_BLUE.get());
    output.accept(ModItems.RAISED_FLOOR_LIGHT_SIDE_HALF_LIGHT_BLUE.get());
    output.accept(ModItems.RAISED_FLOOR_LIGHT_SIDE_HALF_FLIPPED_LIGHT_BLUE.get());
    output.accept(ModItems.RAISED_FLOOR_LIGHT_SIDE_LIGHT_BLUE.get());
  }
}
