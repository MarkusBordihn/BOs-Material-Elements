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

import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.item.ColoredItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.ModItems;
import de.markusbordihn.minecraft.materialelementsdecorative.item.cloth.ClothColoredItem;
import de.markusbordihn.minecraft.materialelementsdecorative.item.lantern.SteelLanternItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModItemColors {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ModItemColors() {}

  @SubscribeEvent
  public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
    log.info("{} Item Colors ...", Constants.LOG_REGISTER_PREFIX);

    // Fabric cloth
    event.register(ModItemColors::getColorFromClothColoredItem,
        ModItems.FABRIC_CLOTH_WHITE.get(), ModItems.FABRIC_CLOTH_ORANGE.get(),
        ModItems.FABRIC_CLOTH_MAGENTA.get(), ModItems.FABRIC_CLOTH_LIGHT_BLUE.get(),
        ModItems.FABRIC_CLOTH_YELLOW.get(), ModItems.FABRIC_CLOTH_LIME.get(),
        ModItems.FABRIC_CLOTH_PINK.get(), ModItems.FABRIC_CLOTH_GRAY.get(),
        ModItems.FABRIC_CLOTH_LIGHT_GRAY.get(), ModItems.FABRIC_CLOTH_CYAN.get(),
        ModItems.FABRIC_CLOTH_PURPLE.get(), ModItems.FABRIC_CLOTH_BLUE.get(),
        ModItems.FABRIC_CLOTH_BROWN.get(), ModItems.FABRIC_CLOTH_GREEN.get(),
        ModItems.FABRIC_CLOTH_RED.get(), ModItems.FABRIC_CLOTH_BLACK.get());

    // Cloth block
    event.register(ModItemColors::getColorFromClothColoredItem, ModItems.CLOTH_BLOCK_WHITE.get(),
        ModItems.CLOTH_BLOCK_ORANGE.get(), ModItems.CLOTH_BLOCK_MAGENTA.get(),
        ModItems.CLOTH_BLOCK_LIGHT_BLUE.get(), ModItems.CLOTH_BLOCK_YELLOW.get(),
        ModItems.CLOTH_BLOCK_LIME.get(), ModItems.CLOTH_BLOCK_PINK.get(),
        ModItems.CLOTH_BLOCK_GRAY.get(), ModItems.CLOTH_BLOCK_LIGHT_GRAY.get(),
        ModItems.CLOTH_BLOCK_CYAN.get(), ModItems.CLOTH_BLOCK_PURPLE.get(),
        ModItems.CLOTH_BLOCK_BLUE.get(), ModItems.CLOTH_BLOCK_BROWN.get(),
        ModItems.CLOTH_BLOCK_GREEN.get(), ModItems.CLOTH_BLOCK_RED.get(),
        ModItems.CLOTH_BLOCK_BLACK.get());

    // Cloth slab
    event.register(ModItemColors::getColorFromClothColoredItem, ModItems.CLOTH_SLAB_WHITE.get(),
        ModItems.CLOTH_SLAB_ORANGE.get(), ModItems.CLOTH_SLAB_MAGENTA.get(),
        ModItems.CLOTH_SLAB_LIGHT_BLUE.get(), ModItems.CLOTH_SLAB_YELLOW.get(),
        ModItems.CLOTH_SLAB_LIME.get(), ModItems.CLOTH_SLAB_PINK.get(),
        ModItems.CLOTH_SLAB_GRAY.get(), ModItems.CLOTH_SLAB_LIGHT_GRAY.get(),
        ModItems.CLOTH_SLAB_CYAN.get(), ModItems.CLOTH_SLAB_PURPLE.get(),
        ModItems.CLOTH_SLAB_BLUE.get(), ModItems.CLOTH_SLAB_BROWN.get(),
        ModItems.CLOTH_SLAB_GREEN.get(), ModItems.CLOTH_SLAB_RED.get(),
        ModItems.CLOTH_SLAB_BLACK.get());

    // Cloth triangular
    event.register(ModItemColors::getColorFromClothColoredItem,
        ModItems.CLOTH_TRIANGULAR_WHITE.get(), ModItems.CLOTH_TRIANGULAR_ORANGE.get(),
        ModItems.CLOTH_TRIANGULAR_MAGENTA.get(), ModItems.CLOTH_TRIANGULAR_LIGHT_BLUE.get(),
        ModItems.CLOTH_TRIANGULAR_YELLOW.get(), ModItems.CLOTH_TRIANGULAR_LIME.get(),
        ModItems.CLOTH_TRIANGULAR_PINK.get(), ModItems.CLOTH_TRIANGULAR_GRAY.get(),
        ModItems.CLOTH_TRIANGULAR_LIGHT_GRAY.get(), ModItems.CLOTH_TRIANGULAR_CYAN.get(),
        ModItems.CLOTH_TRIANGULAR_PURPLE.get(), ModItems.CLOTH_TRIANGULAR_BLUE.get(),
        ModItems.CLOTH_TRIANGULAR_BROWN.get(), ModItems.CLOTH_TRIANGULAR_GREEN.get(),
        ModItems.CLOTH_TRIANGULAR_RED.get(), ModItems.CLOTH_TRIANGULAR_BLACK.get());

    // Colored lanterns
    event.register(ModItemColors::getColorFromSteelLantern, ModItems.STEEL_LANTERN.get(),
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
      return coloredItem.getMapColor();
    }
    return -1;
  }

  public static int getColorFromClothColoredItem(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof ClothColoredItem clothColoredItem) {
      return clothColoredItem.getBlockColor();
    }
    return -1;
  }

  public static int getColorFromSteelLantern(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof SteelLanternItem steelLanternItem) {
      return steelLanternItem.getMapColor();
    }
    return -1;
  }

}
