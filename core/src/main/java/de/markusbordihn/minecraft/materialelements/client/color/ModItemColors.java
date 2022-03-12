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

package de.markusbordihn.minecraft.materialelements.client.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import de.markusbordihn.minecraft.materialelements.Constants;
import de.markusbordihn.minecraft.materialelements.item.ColoredItem;
import de.markusbordihn.minecraft.materialelements.item.ModItems;
import de.markusbordihn.minecraft.materialelements.item.testtube.TestTubeColorItem;
import de.markusbordihn.minecraft.materialelements.item.testtube.TestTubeCustomItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModItemColors {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ModItemColors() {}

  @SubscribeEvent
  public static void registerItemColors(ColorHandlerEvent.Item event) {

    ItemColors itemColors = event.getItemColors();

    log.info("{} Item Colors ...", Constants.LOG_REGISTER_PREFIX);

    // Use the existing potion color system for the filled test tubes.
    itemColors.register((itemStack, color) -> {
      return color > 0 ? -1 : PotionUtils.getColor(itemStack);
    }, ModItems.TEST_TUBE_FILLED.get());

    // Use dye color for the colored test tubes.
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_WHITE.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_ORANGE.get());
    itemColors.register(ModItemColors::getColorFromTestTube,
        ModItems.TEST_TUBE_COLOR_MAGENTA.get());
    itemColors.register(ModItemColors::getColorFromTestTube,
        ModItems.TEST_TUBE_COLOR_LIGHT_BLUE.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_YELLOW.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_LIME.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_PINK.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_GRAY.get());
    itemColors.register(ModItemColors::getColorFromTestTube,
        ModItems.TEST_TUBE_COLOR_LIGHT_GRAY.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_CYAN.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_PURPLE.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_BLUE.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_BROWN.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_GREEN.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_RED.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_COLOR_BLACK.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_WATER.get());
    itemColors.register(ModItemColors::getColorFromTestTube, ModItems.TEST_TUBE_GLOW.get());
  }

  public static int getColorFromColoredItem(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof ColoredItem coloredItem) {
      return coloredItem.getMaterialColor();
    }
    return -1;
  }

  public static int getColorFromTestTube(ItemStack itemStack, int color) {
    if (color <= 0 && itemStack.getItem() instanceof TestTubeColorItem testTubeColorItem) {
      return testTubeColorItem.getColor().getMaterialColor().col;
    } else if (color <= 0 && itemStack.getItem() instanceof TestTubeCustomItem testTubeCustomItem) {
      return testTubeCustomItem.getColor().getMaterialColor().col;
    }
    return -1;
  }

}
