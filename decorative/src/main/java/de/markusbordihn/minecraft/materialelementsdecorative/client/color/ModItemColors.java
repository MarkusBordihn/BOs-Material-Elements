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

package de.markusbordihn.minecraft.materialelementsdecorative.client.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.item.ColoredItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.ModItems;
import de.markusbordihn.minecraft.materialelementsdecorative.item.cloth.ClothBlockItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.cloth.ClothSlabItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.cloth.FabricClothItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.lantern.SteelLanternItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModItemColors {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ModItemColors() {}

  @SubscribeEvent
  public static void registerItemColors(ColorHandlerEvent.Item event) {
    ItemColors itemColors = event.getItemColors();

    log.info("{} Item Colors ...", Constants.LOG_REGISTER_PREFIX);

    // Use dye color for fabric cloth.
    itemColors.register(ModItemColors::getColorFromFabricClothBlockItem,
        ModItems.FABRIC_CLOTH_WHITE.get(), ModItems.FABRIC_CLOTH_ORANGE.get(),
        ModItems.FABRIC_CLOTH_MAGENTA.get(), ModItems.FABRIC_CLOTH_LIGHT_BLUE.get(),
        ModItems.FABRIC_CLOTH_YELLOW.get(), ModItems.FABRIC_CLOTH_LIME.get(),
        ModItems.FABRIC_CLOTH_PINK.get(), ModItems.FABRIC_CLOTH_GRAY.get(),
        ModItems.FABRIC_CLOTH_LIGHT_GRAY.get(), ModItems.FABRIC_CLOTH_CYAN.get(),
        ModItems.FABRIC_CLOTH_PURPLE.get(), ModItems.FABRIC_CLOTH_BLUE.get(),
        ModItems.FABRIC_CLOTH_BROWN.get(), ModItems.FABRIC_CLOTH_GREEN.get(),
        ModItems.FABRIC_CLOTH_RED.get(), ModItems.FABRIC_CLOTH_BLACK.get());

    // Use cloth color for cloth block.
    itemColors.register(ModItemColors::getColorFromClothBlockItem, ModItems.CLOTH_BLOCK_WHITE.get(),
        ModItems.CLOTH_BLOCK_ORANGE.get(), ModItems.CLOTH_BLOCK_MAGENTA.get(),
        ModItems.CLOTH_BLOCK_LIGHT_BLUE.get(), ModItems.CLOTH_BLOCK_YELLOW.get(),
        ModItems.CLOTH_BLOCK_LIME.get(), ModItems.CLOTH_BLOCK_PINK.get(),
        ModItems.CLOTH_BLOCK_GRAY.get(), ModItems.CLOTH_BLOCK_LIGHT_GRAY.get(),
        ModItems.CLOTH_BLOCK_CYAN.get(), ModItems.CLOTH_BLOCK_PURPLE.get(),
        ModItems.CLOTH_BLOCK_BLUE.get(), ModItems.CLOTH_BLOCK_BROWN.get(),
        ModItems.CLOTH_BLOCK_GREEN.get(), ModItems.CLOTH_BLOCK_RED.get(),
        ModItems.CLOTH_BLOCK_BLACK.get());

    // Use cloth color for cloth slab.
    itemColors.register(ModItemColors::getColorFromClothSlabItem, ModItems.CLOTH_SLAB_WHITE.get(),
        ModItems.CLOTH_SLAB_ORANGE.get(), ModItems.CLOTH_SLAB_MAGENTA.get(),
        ModItems.CLOTH_SLAB_LIGHT_BLUE.get(), ModItems.CLOTH_SLAB_YELLOW.get(),
        ModItems.CLOTH_SLAB_LIME.get(), ModItems.CLOTH_SLAB_PINK.get(),
        ModItems.CLOTH_SLAB_GRAY.get(), ModItems.CLOTH_SLAB_LIGHT_GRAY.get(),
        ModItems.CLOTH_SLAB_CYAN.get(), ModItems.CLOTH_SLAB_PURPLE.get(),
        ModItems.CLOTH_SLAB_BLUE.get(), ModItems.CLOTH_SLAB_BROWN.get(),
        ModItems.CLOTH_SLAB_GREEN.get(), ModItems.CLOTH_SLAB_RED.get(),
        ModItems.CLOTH_SLAB_BLACK.get());

    // Use dye color for the colored lanterns.
    itemColors.register(ModItemColors::getColorFromSteelLantern, ModItems.STEEL_LANTERN.get(),
        ModItems.STEEL_SOUL_LANTERN.get(), ModItems.STEEL_LANTERN_WHITE.get(),
        ModItems.STEEL_LANTERN_ORANGE.get(), ModItems.STEEL_LANTERN_MAGENTA.get(),
        ModItems.STEEL_LANTERN_LIGHT_BLUE.get(), ModItems.STEEL_LANTERN_YELLOW.get(),
        ModItems.STEEL_LANTERN_LIME.get(), ModItems.STEEL_LANTERN_PINK.get(),
        ModItems.STEEL_LANTERN_GRAY.get(), ModItems.STEEL_LANTERN_LIGHT_GRAY.get(),
        ModItems.STEEL_LANTERN_CYAN.get(), ModItems.STEEL_LANTERN_PURPLE.get(),
        ModItems.STEEL_LANTERN_BLUE.get(), ModItems.STEEL_LANTERN_BROWN.get(),
        ModItems.STEEL_LANTERN_GREEN.get(), ModItems.STEEL_LANTERN_RED.get(),
        ModItems.STEEL_LANTERN_BLACK.get());
  }

  public static int getColorFromColoredItem(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof ColoredItem coloredItem) {
      return coloredItem.getMaterialColor();
    }
    return -1;
  }

  public static int getColorFromFabricClothBlockItem(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof FabricClothItem fabricClothBlockItem) {
      return fabricClothBlockItem.getBlockColor();
    }
    return -1;
  }

  public static int getColorFromClothBlockItem(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof ClothBlockItem clothBlockItem) {
      return clothBlockItem.getBlockColor();
    }
    return -1;
  }

  public static int getColorFromClothSlabItem(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof ClothSlabItem clothSlabItem) {
      return clothSlabItem.getBlockColor();
    }
    return -1;
  }

  public static int getColorFromSteelLantern(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof SteelLanternItem steelLanternItem) {
      return steelLanternItem.getMaterialColor();
    }
    return -1;
  }

}
