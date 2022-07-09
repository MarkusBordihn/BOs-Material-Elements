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

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.block.ModBlocks;
import de.markusbordihn.minecraft.materialelementsdecorative.block.cloth.ClothColoredBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.lantern.SteelLanternBlock;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBlockColors {
  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ModBlockColors() {}

  @SubscribeEvent
  public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
    log.info("{} Block Colors ...", Constants.LOG_REGISTER_PREFIX);

    // Fabric cloth
    event.register(ModBlockColors::getColorFromClothColoredBlock,
        ModBlocks.FABRIC_CLOTH_WHITE.get(), ModBlocks.FABRIC_CLOTH_ORANGE.get(),
        ModBlocks.FABRIC_CLOTH_MAGENTA.get(), ModBlocks.FABRIC_CLOTH_LIGHT_BLUE.get(),
        ModBlocks.FABRIC_CLOTH_YELLOW.get(), ModBlocks.FABRIC_CLOTH_LIME.get(),
        ModBlocks.FABRIC_CLOTH_PINK.get(), ModBlocks.FABRIC_CLOTH_GRAY.get(),
        ModBlocks.FABRIC_CLOTH_LIGHT_GRAY.get(), ModBlocks.FABRIC_CLOTH_CYAN.get(),
        ModBlocks.FABRIC_CLOTH_PURPLE.get(), ModBlocks.FABRIC_CLOTH_BLUE.get(),
        ModBlocks.FABRIC_CLOTH_BROWN.get(), ModBlocks.FABRIC_CLOTH_GREEN.get(),
        ModBlocks.FABRIC_CLOTH_RED.get(), ModBlocks.FABRIC_CLOTH_BLACK.get());

    // Cloth block
    event.register(ModBlockColors::getColorFromClothColoredBlock, ModBlocks.CLOTH_BLOCK_WHITE.get(),
        ModBlocks.CLOTH_BLOCK_ORANGE.get(), ModBlocks.CLOTH_BLOCK_MAGENTA.get(),
        ModBlocks.CLOTH_BLOCK_LIGHT_BLUE.get(), ModBlocks.CLOTH_BLOCK_YELLOW.get(),
        ModBlocks.CLOTH_BLOCK_LIME.get(), ModBlocks.CLOTH_BLOCK_PINK.get(),
        ModBlocks.CLOTH_BLOCK_GRAY.get(), ModBlocks.CLOTH_BLOCK_LIGHT_GRAY.get(),
        ModBlocks.CLOTH_BLOCK_CYAN.get(), ModBlocks.CLOTH_BLOCK_PURPLE.get(),
        ModBlocks.CLOTH_BLOCK_BLUE.get(), ModBlocks.CLOTH_BLOCK_BROWN.get(),
        ModBlocks.CLOTH_BLOCK_GREEN.get(), ModBlocks.CLOTH_BLOCK_RED.get(),
        ModBlocks.CLOTH_BLOCK_BLACK.get());

    // Cloth slab
    event.register(ModBlockColors::getColorFromClothColoredBlock, ModBlocks.CLOTH_SLAB_WHITE.get(),
        ModBlocks.CLOTH_SLAB_ORANGE.get(), ModBlocks.CLOTH_SLAB_MAGENTA.get(),
        ModBlocks.CLOTH_SLAB_LIGHT_BLUE.get(), ModBlocks.CLOTH_SLAB_YELLOW.get(),
        ModBlocks.CLOTH_SLAB_LIME.get(), ModBlocks.CLOTH_SLAB_PINK.get(),
        ModBlocks.CLOTH_SLAB_GRAY.get(), ModBlocks.CLOTH_SLAB_LIGHT_GRAY.get(),
        ModBlocks.CLOTH_SLAB_CYAN.get(), ModBlocks.CLOTH_SLAB_PURPLE.get(),
        ModBlocks.CLOTH_SLAB_BLUE.get(), ModBlocks.CLOTH_SLAB_BROWN.get(),
        ModBlocks.CLOTH_SLAB_GREEN.get(), ModBlocks.CLOTH_SLAB_RED.get(),
        ModBlocks.CLOTH_SLAB_BLACK.get());

    // Cloth triangular
    event.register(ModBlockColors::getColorFromClothColoredBlock,
        ModBlocks.CLOTH_TRIANGULAR_WHITE.get(), ModBlocks.CLOTH_TRIANGULAR_ORANGE.get(),
        ModBlocks.CLOTH_TRIANGULAR_MAGENTA.get(), ModBlocks.CLOTH_TRIANGULAR_LIGHT_BLUE.get(),
        ModBlocks.CLOTH_TRIANGULAR_YELLOW.get(), ModBlocks.CLOTH_TRIANGULAR_LIME.get(),
        ModBlocks.CLOTH_TRIANGULAR_PINK.get(), ModBlocks.CLOTH_TRIANGULAR_GRAY.get(),
        ModBlocks.CLOTH_TRIANGULAR_LIGHT_GRAY.get(), ModBlocks.CLOTH_TRIANGULAR_CYAN.get(),
        ModBlocks.CLOTH_TRIANGULAR_PURPLE.get(), ModBlocks.CLOTH_TRIANGULAR_BLUE.get(),
        ModBlocks.CLOTH_TRIANGULAR_BROWN.get(), ModBlocks.CLOTH_TRIANGULAR_GREEN.get(),
        ModBlocks.CLOTH_TRIANGULAR_RED.get(), ModBlocks.CLOTH_TRIANGULAR_BLACK.get());

    // Colored lanterns
    event.register(ModBlockColors::getColorFromSteelLantern, ModBlocks.STEEL_LANTERN.get(),
        ModBlocks.STEEL_SOUL_LANTERN.get(), ModBlocks.STEEL_LANTERN_WHITE.get(),
        ModBlocks.STEEL_LANTERN_ORANGE.get(), ModBlocks.STEEL_LANTERN_MAGENTA.get(),
        ModBlocks.STEEL_LANTERN_LIGHT_BLUE.get(), ModBlocks.STEEL_LANTERN_YELLOW.get(),
        ModBlocks.STEEL_LANTERN_LIME.get(), ModBlocks.STEEL_LANTERN_PINK.get(),
        ModBlocks.STEEL_LANTERN_GRAY.get(), ModBlocks.STEEL_LANTERN_LIGHT_GRAY.get(),
        ModBlocks.STEEL_LANTERN_CYAN.get(), ModBlocks.STEEL_LANTERN_PURPLE.get(),
        ModBlocks.STEEL_LANTERN_BLUE.get(), ModBlocks.STEEL_LANTERN_BROWN.get(),
        ModBlocks.STEEL_LANTERN_GREEN.get(), ModBlocks.STEEL_LANTERN_RED.get(),
        ModBlocks.STEEL_LANTERN_BLACK.get());
  }

  public static int getColorFromClothColoredBlock(BlockState blockState,
      BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, int color) {
    if (color <= 0 && blockState.getBlock() instanceof ClothColoredBlock clothColoredBlock) {
      return clothColoredBlock.getBlockColor();
    }
    return -1;
  }

  public static int getColorFromSteelLantern(BlockState blockState,
      BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, int color) {
    if (color <= 0 && blockState.getBlock() instanceof SteelLanternBlock steelLanternBlock) {
      return steelLanternBlock.getMaterialColor();
    }
    return -1;
  }
}
