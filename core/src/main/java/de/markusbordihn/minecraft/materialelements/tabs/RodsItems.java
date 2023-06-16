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

public class RodsItems implements DisplayItemsGenerator {
  protected RodsItems() {}

  @Override
  public void accept(ItemDisplayParameters itemDisplayParameters, Output output) {
    // Rods (tee elbow)
    output.accept(ModItems.LIGHT_ROD_TEE_ELBOW.get());
    output.accept(ModItems.COPPER_ROD_TEE_ELBOW.get());
    output.accept(ModItems.GOLD_ROD_TEE_ELBOW.get());
    output.accept(ModItems.SILVER_ROD_TEE_ELBOW.get());
    output.accept(ModItems.IRON_ROD_TEE_ELBOW.get());
    output.accept(ModItems.STEEL_ROD_TEE_ELBOW.get());
    output.accept(ModItems.NETHERITE_ROD_TEE_ELBOW.get());

    // Rods (elbow)
    output.accept(ModItems.LIGHT_ROD_ELBOW.get());
    output.accept(ModItems.COPPER_ROD_ELBOW.get());
    output.accept(ModItems.GOLD_ROD_ELBOW.get());
    output.accept(ModItems.SILVER_ROD_ELBOW.get());
    output.accept(ModItems.IRON_ROD_ELBOW.get());
    output.accept(ModItems.STEEL_ROD_ELBOW.get());
    output.accept(ModItems.NETHERITE_ROD_ELBOW.get());

    // Rods (tee)
    output.accept(ModItems.LIGHT_ROD_TEE.get());
    output.accept(ModItems.COPPER_ROD_TEE.get());
    output.accept(ModItems.GOLD_ROD_TEE.get());
    output.accept(ModItems.SILVER_ROD_TEE.get());
    output.accept(ModItems.IRON_ROD_TEE.get());
    output.accept(ModItems.STEEL_ROD_TEE.get());
    output.accept(ModItems.NETHERITE_ROD_TEE.get());

    // Rods (star)
    output.accept(ModItems.LIGHT_ROD_STAR.get());
    output.accept(ModItems.COPPER_ROD_STAR.get());
    output.accept(ModItems.GOLD_ROD_STAR.get());
    output.accept(ModItems.SILVER_ROD_STAR.get());
    output.accept(ModItems.IRON_ROD_STAR.get());
    output.accept(ModItems.STEEL_ROD_STAR.get());
    output.accept(ModItems.NETHERIRE_ROD_STAR.get());

    // Rods (cross)
    output.accept(ModItems.LIGHT_ROD_CROSS.get());
    output.accept(ModItems.COPPER_ROD_CROSS.get());
    output.accept(ModItems.GOLD_ROD_CROSS.get());
    output.accept(ModItems.SILVER_ROD_CROSS.get());
    output.accept(ModItems.IRON_ROD_CROSS.get());
    output.accept(ModItems.STEEL_ROD_CROSS.get());
    output.accept(ModItems.NETHERITE_ROD_CROSS.get());

    // Rods (half size)
    output.accept(ModItems.LIGHT_ROD_HALF_SIZE.get());
    output.accept(ModItems.COPPER_ROD_HALF_SIZE.get());
    output.accept(ModItems.GOLD_ROD_HALF_SIZE.get());
    output.accept(ModItems.SILVER_ROD_HALF_SIZE.get());
    output.accept(ModItems.IRON_ROD_HALF_SIZE.get());
    output.accept(ModItems.STEEL_ROD_HALF_SIZE.get());
    output.accept(ModItems.NETHERITE_ROD_HALF_SIZE.get());

    // Rods (full-size)
    output.accept(ModItems.LIGHT_ROD.get());
    output.accept(ModItems.COPPER_ROD.get());
    output.accept(ModItems.GOLD_ROD.get());
    output.accept(ModItems.SILVER_ROD.get());
    output.accept(ModItems.IRON_ROD.get());
    output.accept(ModItems.STEEL_ROD.get());
    output.accept(ModItems.NETHERITE_ROD.get());
  }
}
