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

package de.markusbordihn.minecraft.materialelementsdecorative.item.cloth;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import de.markusbordihn.minecraft.materialelements.color.ClothColor;
import de.markusbordihn.minecraft.materialelements.tabs.MaterialElementsTab;

import de.markusbordihn.minecraft.materialelementsdecorative.block.cloth.FabricClothBlock;

public class FabricClothItem extends BlockItem implements ClothColoredItem {

  private int blockColor = ClothColor.YELLOW.getBlockColor();

  public FabricClothItem(Block block, Item.Properties properties) {
    super(block, properties);
  }

  public FabricClothItem(Block block) {
    super(block, new Item.Properties().tab(MaterialElementsTab.TAB_CLOTH));
    if (block instanceof FabricClothBlock fabricClothBlock) {
      this.blockColor = fabricClothBlock.getBlockColor();
    }
  }

  public int getBlockColor() {
    return this.blockColor;
  }
}
