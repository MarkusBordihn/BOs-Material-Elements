package de.markusbordihn.materialelements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.network.FMLNetworkConstants;

import de.markusbordihn.materialelements.block.ModBlocks;
import de.markusbordihn.materialelements.item.ModItems;

@Mod(Constants.MOD_ID)
public class MaterialElements {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  public MaterialElements() {
    // Make sure the mod being absent on the other network side does not cause the
    // client to display the server as incompatible
    ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
        () -> new IExtensionPoint.DisplayTest(() -> FMLNetworkConstants.IGNORESERVERONLY,
            (a, b) -> true));

    log.info("Register Items ...");
    ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    log.info("Register Blocks ...");
    ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
  }
}
