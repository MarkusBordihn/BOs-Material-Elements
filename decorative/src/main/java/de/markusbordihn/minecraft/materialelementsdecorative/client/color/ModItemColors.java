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
import de.markusbordihn.minecraft.materialelementsdecorative.item.lantern.SteelLanternItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModItemColors {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ModItemColors() {}

  @SubscribeEvent
  public static void registerItemColors(ColorHandlerEvent.Item event) {
    ItemColors itemColors = event.getItemColors();

    log.info("{} Item Colors ...", Constants.LOG_REGISTER_PREFIX);

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

  public static int getColorFromSteelLantern(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof SteelLanternItem steelLanternItem) {
      return steelLanternItem.getColor().getMaterialColor().col;
    }
    return -1;
  }

}
