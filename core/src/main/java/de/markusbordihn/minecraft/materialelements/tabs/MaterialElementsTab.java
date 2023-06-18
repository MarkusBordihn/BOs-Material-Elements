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

package de.markusbordihn.minecraft.materialelements.tabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;

import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import de.markusbordihn.minecraft.materialelements.Constants;
import de.markusbordihn.minecraft.materialelements.item.ModItems;

public class MaterialElementsTab {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected MaterialElementsTab() {}

  public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

  public static final RegistryObject<CreativeModeTab> TAB_FRAMES = CREATIVE_TABS.register("frames",
      () -> CreativeModeTab.builder()
          .icon(() -> ModItems.LIGHT_CUBE_GLASS_FRAME.get().getDefaultInstance())
          .displayItems(new FramesItems())
          .title(Component.translatable("itemGroup.material_elements.frames")).build());

  public static final RegistryObject<CreativeModeTab> TAB_CONSTRUCTION_FRAMES =
      CREATIVE_TABS.register("construction_frames",
          () -> CreativeModeTab.builder()
              .icon(() -> ModItems.OAK_CONSTRUCTION_CUBE_FRAME.get().getDefaultInstance())
              .displayItems(new ConstructionFramesItems())
              .title(Component.translatable("itemGroup.material_elements.construction_frames"))
              .build());

  public static final RegistryObject<CreativeModeTab> TAB_RODS = CREATIVE_TABS.register("rods",
      () -> CreativeModeTab.builder().icon(() -> ModItems.IRON_ROD.get().getDefaultInstance())
          .displayItems(new RodsItems())
          .title(Component.translatable("itemGroup.material_elements.rods")).build());

  public static final RegistryObject<CreativeModeTab> TAB_TEST_TUBES =
      CREATIVE_TABS.register("test_tubes",
          () -> CreativeModeTab.builder()
              .icon(() -> ModItems.TEST_TUBE_COLOR_WHITE.get().getDefaultInstance())
              .displayItems(new TestTubeItems())
              .title(Component.translatable("itemGroup.material_elements.test_tubes")).build());

  public static final RegistryObject<CreativeModeTab> TAB_LEATHER = CREATIVE_TABS.register(
      "leather",
      () -> CreativeModeTab.builder().icon(() -> ModItems.LEATHER_SHEET.get().getDefaultInstance())
          .displayItems(new LeatherItems())
          .title(Component.translatable("itemGroup.material_elements.leather")).build());

  public static final RegistryObject<CreativeModeTab> TAB_CLOTH = CREATIVE_TABS.register("cloth",
      () -> CreativeModeTab.builder().icon(() -> ModItems.CLOTH.get().getDefaultInstance())
          .displayItems(new ClothItems())
          .title(Component.translatable("itemGroup.material_elements.cloth")).build());

  public static void handleCreativeModeTab(BuildCreativeModeTabContentsEvent event) {
    if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
      // Blocks
      event.accept(ModItems.SILVER_BLOCK.get());
      event.accept(ModItems.STEEL_BLOCK.get());

      // Cokes and Charcoal Block
      event.accept(ModItems.CHARCOAL_BLOCK.get());
      event.accept(ModItems.COKE_BLOCK.get());
    } else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
      // Raw Blocks
      event.accept(ModItems.RAW_SILVER_BLOCK.get());
      event.accept(ModItems.RAW_STEEL_BLOCK.get());

      // Ores
      event.accept(ModItems.SILVER_ORE.get());
      event.accept(ModItems.DEEPSLATE_SILVER_ORE.get());
      event.accept(ModItems.STEEL_ORE.get());
      event.accept(ModItems.DEEPSLATE_STEEL_ORE.get());
    } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
      // Nugget
      event.accept(ModItems.COPPER_NUGGET.get());
      event.accept(ModItems.SILVER_NUGGET.get());
      event.accept(ModItems.STEEL_NUGGET.get());
      event.accept(ModItems.NETHERITE_NUGGET.get());

      // Ingot
      event.accept(ModItems.SILVER_INGOT.get());
      event.accept(ModItems.STEEL_INGOT.get());

      // Raw Material
      event.accept(ModItems.RAW_SILVER.get());
      event.accept(ModItems.RAW_STEEL.get());

      // Other
      event.accept(ModItems.COKE.get());

      // Wooden Sticks
      event.accept(ModItems.OAK_STICK.get());
      event.accept(ModItems.SPRUCE_STICK.get());
      event.accept(ModItems.BIRCH_STICK.get());
      event.accept(ModItems.JUNGLE_STICK.get());
      event.accept(ModItems.ACACIA_STICK.get());
      event.accept(ModItems.DARK_OAK_STICK.get());
      event.accept(ModItems.CRIMSON_STICK.get());
      event.accept(ModItems.WARPED_STICK.get());

      // Wooden Sticks (half-size)
      event.accept(ModItems.OAK_STICK_HALF_SIZE.get());
      event.accept(ModItems.SPRUCE_STICK_HALF_SIZE.get());
      event.accept(ModItems.BIRCH_STICK_HALF_SIZE.get());
      event.accept(ModItems.JUNGLE_STICK_HALF_SIZE.get());
      event.accept(ModItems.ACACIA_STICK_HALF_SIZE.get());
      event.accept(ModItems.DARK_OAK_STICK_HALF_SIZE.get());
      event.accept(ModItems.CRIMSON_STICK_HALF_SIZE.get());
      event.accept(ModItems.WARPED_STICK_HALF_SIZE.get());
    }
  }

}
