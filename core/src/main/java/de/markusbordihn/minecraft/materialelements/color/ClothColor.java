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

package de.markusbordihn.minecraft.materialelements.color;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.material.MaterialColor;

public enum ClothColor implements StringRepresentable {
  WHITE(0, "white", 16383998, MaterialColor.SNOW),
  ORANGE(1, "orange", 15230983, MaterialColor.COLOR_ORANGE),
  MAGENTA(2, "magenta", 14049488, MaterialColor.COLOR_MAGENTA),
  LIGHT_BLUE(3, "light_blue", 5228520, MaterialColor.COLOR_LIGHT_BLUE),
  YELLOW(4, "yellow", 16767296, MaterialColor.COLOR_YELLOW),
  LIME(5, "lime", 8439583, MaterialColor.COLOR_LIGHT_GREEN),
  PINK(6, "pink", 16101575, MaterialColor.COLOR_PINK),
  GRAY(7, "gray", 4673362, MaterialColor.COLOR_GRAY),
  LIGHT_GRAY(8, "light_gray", 10395288, MaterialColor.COLOR_LIGHT_GRAY),
  CYAN(9, "cyan", 1481884, MaterialColor.COLOR_CYAN),
  PURPLE(10, "purple", 8991416, MaterialColor.COLOR_PURPLE),
  BLUE(11, "blue", 3949738, MaterialColor.COLOR_BLUE),
  BROWN(12, "brown", 8606770, MaterialColor.COLOR_BROWN),
  GREEN(13, "green", 6192150, MaterialColor.COLOR_GREEN),
  RED(14, "red", 11546150, MaterialColor.COLOR_RED),
  BLACK(15, "black", 1908001, MaterialColor.COLOR_BLACK);

  private final int id;
  private final String name;
  private final MaterialColor color;
  private final int blockColor;

  private ClothColor(int id, String name, int color, MaterialColor materialColor) {
    this.id = id;
    this.name = name;
    this.color = materialColor;
    this.blockColor = color;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public int getBlockColor() {
    return this.blockColor;
  }

  public MaterialColor getMaterialColor() {
    return this.color;
  }

  @Override
  public String getSerializedName() {
    return this.name;
  }
}
