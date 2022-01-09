package de.markusbordihn.materialelements.client.renderer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import de.markusbordihn.materialelements.Constants;
import de.markusbordihn.materialelements.block.ModBlocks;

public class ClientRenderer {
  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

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
