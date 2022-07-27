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

package de.markusbordihn.minecraft.materialelementsdecorative.client.renderer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.block.ModBlocks;

public class ClientRenderer {
  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ClientRenderer() {}

  public static void registerRenderLayers(final FMLClientSetupEvent event) {
    log.info("{} Render Layers ...", Constants.LOG_REGISTER_PREFIX);

    event.enqueueWork(() -> {
      // @TemplateEntryPoint("Register Render Layers")

      // Cloth triangular
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_WHITE.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_ORANGE.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_MAGENTA.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_LIGHT_BLUE.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_YELLOW.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_LIME.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_PINK.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_GRAY.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_LIGHT_GRAY.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_CYAN.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_PURPLE.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_BLUE.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_BROWN.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_GREEN.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_RED.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOTH_TRIANGULAR_BLACK.get(),
          RenderType.cutoutMipped());

      // Steel Chain
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_CHAIN.get(), RenderType.cutoutMipped());

      // Steel and Soul Lantern (default)
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN.get(), RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_SOUL_LANTERN.get(),
          RenderType.cutoutMipped());

      // Steel Lantern (colored)
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_WHITE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_ORANGE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_MAGENTA.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_LIGHT_BLUE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_YELLOW.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_LIME.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_PINK.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_GRAY.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_LIGHT_GRAY.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_CYAN.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_PURPLE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_BLUE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_BROWN.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_GREEN.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_RED.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_LANTERN_BLACK.get(),
          RenderType.translucent());

      // Raised Floor
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_BASE.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_BASIC.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_A.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_B.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_C.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_D.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_E.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_FLOW_PANEL_TYPE_F.get(),
          RenderType.cutoutMipped());

      // Raised Floor Light
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_LIGHT_CORNER_LIGHT_BLUE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(
          ModBlocks.RAISED_FLOOR_LIGHT_CORNER_FLIPPED_LIGHT_BLUE.get(), RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_LIGHT_LIGHT_BLUE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_LIGHT_MIDDLE_HALF_LIGHT_BLUE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_LIGHT_MIDDLE_LIGHT_BLUE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_LIGHT_SIDE_HALF_LIGHT_BLUE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(
          ModBlocks.RAISED_FLOOR_LIGHT_SIDE_HALF_FLIPPED_LIGHT_BLUE.get(),
          RenderType.translucent());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAISED_FLOOR_LIGHT_SIDE_LIGHT_BLUE.get(),
          RenderType.translucent());

      // Misc
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLASS_SLAB.get(), RenderType.translucent());

      // Wooden framed hopper
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.OAK_FRAMED_HOPPER.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_FRAMED_HOPPER.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIRCH_FRAMED_HOPPER.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.JUNGLE_FRAMED_HOPPER.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.ACACIA_FRAMED_HOPPER.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_OAK_FRAMED_HOPPER.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRIMSON_FRAMED_HOPPER.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARPED_FRAMED_HOPPER.get(),
          RenderType.cutoutMipped());
    });
  }
}
