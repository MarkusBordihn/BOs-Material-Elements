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

public class FramesItems implements DisplayItemsGenerator {
  protected FramesItems() {}

  @Override
  public void accept(ItemDisplayParameters itemDisplayParameters, Output output) {
    // Cube Frames
    output.accept(ModItems.LIGHT_CUBE_FRAME.get());
    output.accept(ModItems.COPPER_CUBE_FRAME.get());
    output.accept(ModItems.GOLD_CUBE_FRAME.get());
    output.accept(ModItems.SILVER_CUBE_FRAME.get());
    output.accept(ModItems.IRON_CUBE_FRAME.get());
    output.accept(ModItems.STEEL_CUBE_FRAME.get());
    output.accept(ModItems.NETHERITE_CUBE_FRAME.get());

    // Cube Glass Frames
    output.accept(ModItems.LIGHT_CUBE_GLASS_FRAME.get());
    output.accept(ModItems.COPPER_CUBE_GLASS_FRAME.get());
    output.accept(ModItems.GOLD_CUBE_GLASS_FRAME.get());
    output.accept(ModItems.SILVER_CUBE_GLASS_FRAME.get());
    output.accept(ModItems.IRON_CUBE_GLASS_FRAME.get());
    output.accept(ModItems.STEEL_CUBE_GLASS_FRAME.get());
    output.accept(ModItems.NETHERITE_CUBE_GLASS_FRAME.get());

    // Slab Frames
    output.accept(ModItems.LIGHT_SLAB_FRAME.get());
    output.accept(ModItems.COPPER_SLAB_FRAME.get());
    output.accept(ModItems.GOLD_SLAB_FRAME.get());
    output.accept(ModItems.SILVER_SLAB_FRAME.get());
    output.accept(ModItems.IRON_SLAB_FRAME.get());
    output.accept(ModItems.STEEL_SLAB_FRAME.get());
    output.accept(ModItems.NETHERITE_SLAB_FRAME.get());

    // Skeleton Frames
    output.accept(ModItems.LIGHT_SKELETON_FRAME.get());
    output.accept(ModItems.COPPER_SKELETON_FRAME.get());
    output.accept(ModItems.GOLD_SKELETON_FRAME.get());
    output.accept(ModItems.SILVER_SKELETON_FRAME.get());
    output.accept(ModItems.IRON_SKELETON_FRAME.get());
    output.accept(ModItems.STEEL_SKELETON_FRAME.get());
    output.accept(ModItems.NETHERITE_SKELETON_FRAME.get());

    // Triangular Frames
    output.accept(ModItems.LIGHT_TRIANGULAR_FRAME.get());
    output.accept(ModItems.COPPER_TRIANGULAR_FRAME.get());
    output.accept(ModItems.GOLD_TRIANGULAR_FRAME.get());
    output.accept(ModItems.SILVER_TRIANGULAR_FRAME.get());
    output.accept(ModItems.IRON_TRIANGULAR_FRAME.get());
    output.accept(ModItems.STEEL_TRIANGULAR_FRAME.get());
    output.accept(ModItems.NETHERITE_TRIANGULAR_FRAME.get());
  }
}
