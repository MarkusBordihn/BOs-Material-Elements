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

package de.markusbordihn.minecraft.materialelementspanelsplatesslabs.tabs;

import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;

import de.markusbordihn.minecraft.materialelementspanelsplatesslabs.item.ModItems;

public class PanelPlatesItems implements DisplayItemsGenerator {
  protected PanelPlatesItems() {}

  @Override
  public void accept(ItemDisplayParameters itemDisplayParameters, Output output) {
    // Acacia
    output.accept(ModItems.ACACIA_PANEL.get());
    output.accept(ModItems.ACACIA_PLATE.get());
    output.accept(ModItems.ACACIA_HALF_SLAB.get());

    // Andesite
    output.accept(ModItems.ANDESITE_PANEL.get());
    output.accept(ModItems.ANDESITE_PLATE.get());
    output.accept(ModItems.ANDESITE_HALF_SLAB.get());

    // Polished Andesite
    output.accept(ModItems.POLISHED_ANDESITE_PANEL.get());
    output.accept(ModItems.POLISHED_ANDESITE_PLATE.get());
    output.accept(ModItems.POLISHED_ANDESITE_HALF_SLAB.get());

    // Birch
    output.accept(ModItems.BIRCH_PANEL.get());
    output.accept(ModItems.BIRCH_PLATE.get());
    output.accept(ModItems.BIRCH_HALF_SLAB.get());

    // Brick
    output.accept(ModItems.BRICK_PANEL.get());
    output.accept(ModItems.BRICKS_PLATE.get());
    output.accept(ModItems.BRICKS_HALF_SLAB.get());

    // Crimson
    output.accept(ModItems.CRIMSON_PANEL.get());
    output.accept(ModItems.CRIMSON_PLATE.get());
    output.accept(ModItems.CRIMSON_HALF_SLAB.get());

    // Granite
    output.accept(ModItems.GRANITE_PANEL.get());
    output.accept(ModItems.GRANITE_PLATE.get());
    output.accept(ModItems.GRANITE_HALF_SLAB.get());

    // Polished Granite
    output.accept(ModItems.POLISHED_GRANITE_PANEL.get());
    output.accept(ModItems.POLISHED_GRANITE_PLATE.get());
    output.accept(ModItems.POLISHED_GRANITE_HALF_SLAB.get());

    // Jungle
    output.accept(ModItems.JUNGLE_PLATE.get());
    output.accept(ModItems.JUNGLE_PANEL.get());
    output.accept(ModItems.JUNGLE_HALF_SLAB.get());

    // Oak
    output.accept(ModItems.OAK_PANEL.get());
    output.accept(ModItems.OAK_PLATE.get());
    output.accept(ModItems.OAK_HALF_SLAB.get());

    // Dark Oak
    output.accept(ModItems.DARK_OAK_PANEL.get());
    output.accept(ModItems.DARK_OAK_PLATE.get());
    output.accept(ModItems.DARK_OAK_HALF_SLAB.get());

    // Spruce
    output.accept(ModItems.SPRUCE_PANEL.get());
    output.accept(ModItems.SPRUCE_PLATE.get());
    output.accept(ModItems.SPRUCE_HALF_SLAB.get());

    // Stone Bricks
    output.accept(ModItems.STONE_BRICK_PANEL.get());
    output.accept(ModItems.STONE_BRICKS_PLATE.get());
    output.accept(ModItems.STONE_BRICKS_HALF_SLAB.get());

    // Warped
    output.accept(ModItems.WARPED_PANEL.get());
    output.accept(ModItems.WARPED_PLATE.get());
    output.accept(ModItems.WARPED_HALF_SLAB.get());

    // Quartz
    output.accept(ModItems.QUARTZ_PANEL.get());
    output.accept(ModItems.QUARTZ_PLATE.get());
    output.accept(ModItems.QUARTZ_HALF_SLAB.get());

    // Quartz Smooth
    output.accept(ModItems.SMOOTH_QUARTZ_PANEL.get());
    output.accept(ModItems.SMOOTH_QUARTZ_PLATE.get());
    output.accept(ModItems.SMOOTH_QUARTZ_HALF_SLAB.get());
  }
}
