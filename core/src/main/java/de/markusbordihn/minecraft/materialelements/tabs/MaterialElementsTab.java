/**
 * Copyright 2021 Markus Bordihn
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

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import de.markusbordihn.minecraft.materialelements.item.ModItems;

public class MaterialElementsTab {

  protected MaterialElementsTab() {}

  public static final CreativeModeTab TAB_CUBE_FRAMES = new CreativeModeTab("cube_frames") {
    public ItemStack makeIcon() {
      return new ItemStack(ModItems.LIGHT_CUBE_GLASS_FRAME.get());
    }
  };

  public static final CreativeModeTab TAB_RODS = new CreativeModeTab("rods") {
    public ItemStack makeIcon() {
      return new ItemStack(ModItems.IRON_ROD.get());
    }
  };

  public static final CreativeModeTab TAB_TEST_TUBES = new CreativeModeTab("test_tubes") {
    public ItemStack makeIcon() {
      return new ItemStack(ModItems.TEST_TUBE_COLOR_WHITE.get());
    }
  };

  public static final CreativeModeTab TAB_LEATHER = new CreativeModeTab("leather") {
    public ItemStack makeIcon() {
      return new ItemStack(ModItems.LEATHER_SHEET.get());
    }
  };

  public static final CreativeModeTab TAB_CLOTH = new CreativeModeTab("cloth") {
    public ItemStack makeIcon() {
      return new ItemStack(ModItems.CLOTH.get());
    }
  };

}
