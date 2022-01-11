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

package de.markusbordihn.materialelements.client.renderer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import de.markusbordihn.materialelements.Constants;
import de.markusbordihn.materialelements.block.ModBlocks;

public class ClientRenderer {
  private static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ClientRenderer() {}

  public static void registerRenderLayers(final FMLClientSetupEvent event) {
    log.info("{} Render Layers ...", Constants.LOG_REGISTER_PREFIX);

    event.enqueueWork(() -> {
      // @TemplateEntryPoint("Register Render Layers")
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_CUBE_GLASS_FRAME.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_CUBE_GLASS_FRAME.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.GOLD_CUBE_GLASS_FRAME.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.SILVER_CUBE_GLASS_FRAME.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.IRON_CUBE_GLASS_FRAME.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_CUBE_GLASS_FRAME.get(),
          RenderType.cutoutMipped());
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERITE_CUBE_GLASS_FRAME.get(),
          RenderType.cutoutMipped());
    });
  }
}
