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

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.block.ModBlocks;
import de.markusbordihn.minecraft.materialelementsdecorative.block.cloth.ClothBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.cloth.ClothSlabBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.cloth.FabricClothBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.lantern.SteelLanternBlock;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBlockColors {
  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ModBlockColors() {}

  @SubscribeEvent
  public static void registerBlockColors(ColorHandlerEvent.Block event) {
    BlockColors blockColors = event.getBlockColors();

    log.info("{} Block Colors ...", Constants.LOG_REGISTER_PREFIX);

    // Use cloth color for fabric cloth.
    blockColors.register(ModBlockColors::getColorFromFabricClothBlock,
        ModBlocks.FABRIC_CLOTH_WHITE.get(), ModBlocks.FABRIC_CLOTH_ORANGE.get(),
        ModBlocks.FABRIC_CLOTH_MAGENTA.get(), ModBlocks.FABRIC_CLOTH_LIGHT_BLUE.get(),
        ModBlocks.FABRIC_CLOTH_YELLOW.get(), ModBlocks.FABRIC_CLOTH_LIME.get(),
        ModBlocks.FABRIC_CLOTH_PINK.get(), ModBlocks.FABRIC_CLOTH_GRAY.get(),
        ModBlocks.FABRIC_CLOTH_LIGHT_GRAY.get(), ModBlocks.FABRIC_CLOTH_CYAN.get(),
        ModBlocks.FABRIC_CLOTH_PURPLE.get(), ModBlocks.FABRIC_CLOTH_BLUE.get(),
        ModBlocks.FABRIC_CLOTH_BROWN.get(), ModBlocks.FABRIC_CLOTH_GREEN.get(),
        ModBlocks.FABRIC_CLOTH_RED.get(), ModBlocks.FABRIC_CLOTH_BLACK.get());

    // Use cloth color for cloth block.
    blockColors.register(ModBlockColors::getColorFromClothBlock, ModBlocks.CLOTH_BLOCK_WHITE.get(),
        ModBlocks.CLOTH_BLOCK_ORANGE.get(), ModBlocks.CLOTH_BLOCK_MAGENTA.get(),
        ModBlocks.CLOTH_BLOCK_LIGHT_BLUE.get(), ModBlocks.CLOTH_BLOCK_YELLOW.get(),
        ModBlocks.CLOTH_BLOCK_LIME.get(), ModBlocks.CLOTH_BLOCK_PINK.get(),
        ModBlocks.CLOTH_BLOCK_GRAY.get(), ModBlocks.CLOTH_BLOCK_LIGHT_GRAY.get(),
        ModBlocks.CLOTH_BLOCK_CYAN.get(), ModBlocks.CLOTH_BLOCK_PURPLE.get(),
        ModBlocks.CLOTH_BLOCK_BLUE.get(), ModBlocks.CLOTH_BLOCK_BROWN.get(),
        ModBlocks.CLOTH_BLOCK_GREEN.get(), ModBlocks.CLOTH_BLOCK_RED.get(),
        ModBlocks.CLOTH_BLOCK_BLACK.get());

    // Use cloth color for cloth slab.
    blockColors.register(ModBlockColors::getColorFromClothSlabBlock,
        ModBlocks.CLOTH_SLAB_WHITE.get(), ModBlocks.CLOTH_SLAB_ORANGE.get(),
        ModBlocks.CLOTH_SLAB_MAGENTA.get(), ModBlocks.CLOTH_SLAB_LIGHT_BLUE.get(),
        ModBlocks.CLOTH_SLAB_YELLOW.get(), ModBlocks.CLOTH_SLAB_LIME.get(),
        ModBlocks.CLOTH_SLAB_PINK.get(), ModBlocks.CLOTH_SLAB_GRAY.get(),
        ModBlocks.CLOTH_SLAB_LIGHT_GRAY.get(), ModBlocks.CLOTH_SLAB_CYAN.get(),
        ModBlocks.CLOTH_SLAB_PURPLE.get(), ModBlocks.CLOTH_SLAB_BLUE.get(),
        ModBlocks.CLOTH_SLAB_BROWN.get(), ModBlocks.CLOTH_SLAB_GREEN.get(),
        ModBlocks.CLOTH_SLAB_RED.get(), ModBlocks.CLOTH_SLAB_BLACK.get());

    // Use dye color for the colored lanterns.
    blockColors.register(ModBlockColors::getColorFromSteelLantern, ModBlocks.STEEL_LANTERN.get(),
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

  public static int getColorFromClothBlock(BlockState blockState,
      BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, int color) {
    if (color <= 0 && blockState.getBlock() instanceof ClothBlock clothBlock) {
      return clothBlock.getBlockColor();
    }
    return -1;
  }

  public static int getColorFromClothSlabBlock(BlockState blockState,
      BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, int color) {
    if (color <= 0 && blockState.getBlock() instanceof ClothSlabBlock clothSlabBlock) {
      return clothSlabBlock.getBlockColor();
    }
    return -1;
  }


  public static int getColorFromFabricClothBlock(BlockState blockState,
      BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, int color) {
    if (color <= 0 && blockState.getBlock() instanceof FabricClothBlock fabricClothBlock) {
      return fabricClothBlock.getBlockColor();
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
