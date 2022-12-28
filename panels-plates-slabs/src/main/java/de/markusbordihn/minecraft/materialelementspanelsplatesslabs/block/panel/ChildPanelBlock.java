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

package de.markusbordihn.minecraft.materialelementspanelsplatesslabs.block.panel;

import net.minecraft.util.StringRepresentable;

public enum ChildPanelBlock implements StringRepresentable {
  // @formatter:off
  NONE("none"),
  LANTERN("lantern"),
  LANTERN_HANGING("lantern_hanging"),
  TORCH("torch"),
  TORCH_NORTH("torch_north"),
  TORCH_EAST("torch_east"),
  TORCH_SOUTH("torch_south"),
  TORCH_WEST("torch_west"),
  SOUL_LANTERN("soul_lantern"),
  SOUL_LANTERN_HANGING("soul_lantern_hanging"),
  SOUL_TORCH("soul_torch"),
  SOUL_TORCH_NORTH("soul_torch_north"),
  SOUL_TORCH_EAST("soul_torch_east"),
  SOUL_TORCH_SOUTH("soul_torch_south"),
  SOUL_TORCH_WEST("soul_torch_west");
  // @formatter:on

  private final String name;

  private ChildPanelBlock(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.getSerializedName();
  }

  public String getSerializedName() {
    return this.name;
  }

}
