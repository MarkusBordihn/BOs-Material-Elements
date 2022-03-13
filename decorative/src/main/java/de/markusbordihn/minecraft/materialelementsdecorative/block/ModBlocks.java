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

package de.markusbordihn.minecraft.materialelementsdecorative.block;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.AcaciaFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.BirchFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.CrimsonFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.DarkOakFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.JungleFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.OakFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.SpruceFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.WarpedFramedHopper;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.AcaciaFramedHopperEntity;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.BirchFramedHopperEntity;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.CrimsonFramedHopperEntity;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.DarkOakFramedHopperEntity;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.JungleFramedHopperEntity;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.OakFramedHopperEntity;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.SpruceFramedHopperEntity;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.WarpedFramedHopperEntity;
import de.markusbordihn.minecraft.materialelementsdecorative.block.halfslab.HalfSlabBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.halfslab.WoodHalfSlabBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.lantern.SteelLanternBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.panel.PanelBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.panel.WoodPanelBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.plate.PlateBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.plate.WoodPlateBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.slab.WoolSlabBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.Annotations.TemplateEntryPoint;

public class ModBlocks {

  protected ModBlocks() {

  }

  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

  public static final DeferredRegister<BlockEntityType<?>> ENTITIES =
      DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Constants.MOD_ID);

  @TemplateEntryPoint("Register Blocks")

  // Quartz
  public static final RegistryObject<Block> QUARTZ_PANEL =
      BLOCKS.register("quartz_panel", () -> new PanelBlock(Blocks.QUARTZ_BLOCK));
  public static final RegistryObject<Block> QUARTZ_PLATE =
      BLOCKS.register("quartz_plate", () -> new PlateBlock(Blocks.QUARTZ_BLOCK));
  public static final RegistryObject<Block> QUARTZ_HALF_SLAP =
      BLOCKS.register("quartz_half_slab", () -> new HalfSlabBlock(Blocks.QUARTZ_BLOCK));

  // Steel Chain
  public static final RegistryObject<Block> STEEL_CHAIN = BLOCKS.register("steel_chain",
      () -> new ChainBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.NONE)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN)
          .noOcclusion()));

  // Steel Lantern
  public static final RegistryObject<Block> STEEL_LANTERN =
      BLOCKS.register("steel_lantern", () -> new SteelLanternBlock(DyeColor.YELLOW));
  public static final RegistryObject<Block> STEEL_SOUL_LANTERN =
      BLOCKS.register("steel_soul_lantern",
          () -> new SteelLanternBlock(
              BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops()
                  .strength(3.5F).sound(SoundType.LANTERN).lightLevel((blockState) -> {
                    return 10;
                  }).noOcclusion(),
              DyeColor.LIGHT_BLUE));

  // Steel Lantern (colored)
  public static final RegistryObject<Block> STEEL_LANTERN_WHITE =
      BLOCKS.register("steel_lantern_white", () -> new SteelLanternBlock(DyeColor.WHITE));
  public static final RegistryObject<Block> STEEL_LANTERN_ORANGE =
      BLOCKS.register("steel_lantern_orange", () -> new SteelLanternBlock(DyeColor.ORANGE));
  public static final RegistryObject<Block> STEEL_LANTERN_MAGENTA =
      BLOCKS.register("steel_lantern_magenta", () -> new SteelLanternBlock(DyeColor.MAGENTA));
  public static final RegistryObject<Block> STEEL_LANTERN_LIGHT_BLUE =
      BLOCKS.register("steel_lantern_light_blue", () -> new SteelLanternBlock(DyeColor.LIGHT_BLUE));
  public static final RegistryObject<Block> STEEL_LANTERN_YELLOW =
      BLOCKS.register("steel_lantern_yellow", () -> new SteelLanternBlock(DyeColor.YELLOW));
  public static final RegistryObject<Block> STEEL_LANTERN_LIME =
      BLOCKS.register("steel_lantern_lime", () -> new SteelLanternBlock(DyeColor.LIME));
  public static final RegistryObject<Block> STEEL_LANTERN_PINK =
      BLOCKS.register("steel_lantern_pink", () -> new SteelLanternBlock(DyeColor.PINK));
  public static final RegistryObject<Block> STEEL_LANTERN_GRAY =
      BLOCKS.register("steel_lantern_gray", () -> new SteelLanternBlock(DyeColor.GRAY));
  public static final RegistryObject<Block> STEEL_LANTERN_LIGHT_GRAY =
      BLOCKS.register("steel_lantern_light_gray", () -> new SteelLanternBlock(DyeColor.LIGHT_GRAY));
  public static final RegistryObject<Block> STEEL_LANTERN_CYAN =
      BLOCKS.register("steel_lantern_cyan", () -> new SteelLanternBlock(DyeColor.CYAN));
  public static final RegistryObject<Block> STEEL_LANTERN_PURPLE =
      BLOCKS.register("steel_lantern_purple", () -> new SteelLanternBlock(DyeColor.PURPLE));
  public static final RegistryObject<Block> STEEL_LANTERN_BLUE =
      BLOCKS.register("steel_lantern_blue", () -> new SteelLanternBlock(DyeColor.BLUE));
  public static final RegistryObject<Block> STEEL_LANTERN_BROWN =
      BLOCKS.register("steel_lantern_brown", () -> new SteelLanternBlock(DyeColor.BROWN));
  public static final RegistryObject<Block> STEEL_LANTERN_GREEN =
      BLOCKS.register("steel_lantern_green", () -> new SteelLanternBlock(DyeColor.GREEN));
  public static final RegistryObject<Block> STEEL_LANTERN_RED =
      BLOCKS.register("steel_lantern_red", () -> new SteelLanternBlock(DyeColor.RED));
  public static final RegistryObject<Block> STEEL_LANTERN_BLACK =
      BLOCKS.register("steel_lantern_black", () -> new SteelLanternBlock(DyeColor.BLACK));

  // Wool Slaps
  public static final RegistryObject<Block> WOOL_SLAB_WHITE =
      BLOCKS.register("wool_slab_white", () -> new WoolSlabBlock(MaterialColor.SNOW));
  public static final RegistryObject<Block> WOOL_SLAB_ORANGE =
      BLOCKS.register("wool_slab_orange", () -> new WoolSlabBlock(MaterialColor.COLOR_ORANGE));
  public static final RegistryObject<Block> WOOL_SLAB_MAGENTA =
      BLOCKS.register("wool_slab_magenta", () -> new WoolSlabBlock(MaterialColor.COLOR_MAGENTA));
  public static final RegistryObject<Block> WOOL_SLAB_LIGHT_BLUE = BLOCKS
      .register("wool_slab_light_blue", () -> new WoolSlabBlock(MaterialColor.COLOR_LIGHT_BLUE));
  public static final RegistryObject<Block> WOOL_SLAB_YELLOW =
      BLOCKS.register("wool_slab_yellow", () -> new WoolSlabBlock(MaterialColor.COLOR_YELLOW));
  public static final RegistryObject<Block> WOOL_SLAB_LIME =
      BLOCKS.register("wool_slab_lime", () -> new WoolSlabBlock(MaterialColor.COLOR_LIGHT_GREEN));
  public static final RegistryObject<Block> WOOL_SLAB_PINK =
      BLOCKS.register("wool_slab_pink", () -> new WoolSlabBlock(MaterialColor.COLOR_PINK));
  public static final RegistryObject<Block> WOOL_SLAB_GRAY =
      BLOCKS.register("wool_slab_gray", () -> new WoolSlabBlock(MaterialColor.COLOR_GRAY));
  public static final RegistryObject<Block> WOOL_SLAB_LIGHT_GRAY = BLOCKS
      .register("wool_slab_light_gray", () -> new WoolSlabBlock(MaterialColor.COLOR_LIGHT_GRAY));
  public static final RegistryObject<Block> WOOL_SLAB_CYAN =
      BLOCKS.register("wool_slab_cyan", () -> new WoolSlabBlock(MaterialColor.COLOR_CYAN));
  public static final RegistryObject<Block> WOOL_SLAB_PURPLE =
      BLOCKS.register("wool_slab_purple", () -> new WoolSlabBlock(MaterialColor.COLOR_PURPLE));
  public static final RegistryObject<Block> WOOL_SLAB_BLUE =
      BLOCKS.register("wool_slab_blue", () -> new WoolSlabBlock(MaterialColor.COLOR_BLUE));
  public static final RegistryObject<Block> WOOL_SLAB_BROWN =
      BLOCKS.register("wool_slab_brown", () -> new WoolSlabBlock(MaterialColor.COLOR_BROWN));
  public static final RegistryObject<Block> WOOL_SLAB_GREEN =
      BLOCKS.register("wool_slab_green", () -> new WoolSlabBlock(MaterialColor.COLOR_GREEN));
  public static final RegistryObject<Block> WOOL_SLAB_RED =
      BLOCKS.register("wool_slab_red", () -> new WoolSlabBlock(MaterialColor.COLOR_RED));
  public static final RegistryObject<Block> WOOL_SLAB_BLACK =
      BLOCKS.register("wool_slab_black", () -> new WoolSlabBlock(MaterialColor.COLOR_BLACK));

  // Wooden framed Hoppers
  public static final RegistryObject<Block> OAK_FRAMED_HOPPER =
      BLOCKS.register(OakFramedHopper.NAME, OakFramedHopper::new);
  public static final RegistryObject<Block> SPRUCE_FRAMED_HOPPER =
      BLOCKS.register(SpruceFramedHopper.NAME, SpruceFramedHopper::new);
  public static final RegistryObject<Block> BIRCH_FRAMED_HOPPER =
      BLOCKS.register(BirchFramedHopper.NAME, BirchFramedHopper::new);
  public static final RegistryObject<Block> JUNGLE_FRAMED_HOPPER =
      BLOCKS.register(JungleFramedHopper.NAME, JungleFramedHopper::new);
  public static final RegistryObject<Block> ACACIA_FRAMED_HOPPER =
      BLOCKS.register(AcaciaFramedHopper.NAME, AcaciaFramedHopper::new);
  public static final RegistryObject<Block> DARK_OAK_FRAMED_HOPPER =
      BLOCKS.register(DarkOakFramedHopper.NAME, DarkOakFramedHopper::new);
  public static final RegistryObject<Block> CRIMSON_FRAMED_HOPPER =
      BLOCKS.register(CrimsonFramedHopper.NAME, CrimsonFramedHopper::new);
  public static final RegistryObject<Block> WARPED_FRAMED_HOPPER =
      BLOCKS.register(WarpedFramedHopper.NAME, WarpedFramedHopper::new);

  // Wooden Panels
  public static final RegistryObject<Block> OAK_PANEL = BLOCKS.register("oak_panel",
      () -> new WoodPanelBlock(Blocks.OAK_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> SPRUCE_PANEL = BLOCKS.register("spruce_panel",
      () -> new WoodPanelBlock(Blocks.SPRUCE_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> BIRCH_PANEL = BLOCKS.register("birch_panel",
      () -> new WoodPanelBlock(Blocks.BIRCH_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> JUNGLE_PANEL = BLOCKS.register("jungle_panel",
      () -> new WoodPanelBlock(Blocks.JUNGLE_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> ACACIA_PANEL = BLOCKS.register("acacia_panel",
      () -> new WoodPanelBlock(Blocks.ACACIA_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> DARK_OAK_PANEL = BLOCKS.register("dark_oak_panel",
      () -> new WoodPanelBlock(Blocks.DARK_OAK_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> CRIMSON_PANEL = BLOCKS.register("crimson_panel",
      () -> new WoodPanelBlock(Blocks.CRIMSON_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> WARPED_PANEL = BLOCKS.register("warped_panel",
      () -> new WoodPanelBlock(Blocks.WARPED_PLANKS.defaultMaterialColor()));

  // Wooden Plates
  public static final RegistryObject<Block> OAK_PLATE = BLOCKS.register("oak_plate",
      () -> new WoodPlateBlock(Blocks.OAK_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> SPRUCE_PLATE = BLOCKS.register("spruce_plate",
      () -> new WoodPlateBlock(Blocks.SPRUCE_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> BIRCH_PLATE = BLOCKS.register("birch_plate",
      () -> new WoodPlateBlock(Blocks.BIRCH_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> JUNGLE_PLATE = BLOCKS.register("jungle_plate",
      () -> new WoodPlateBlock(Blocks.JUNGLE_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> ACACIA_PLATE = BLOCKS.register("acacia_plate",
      () -> new WoodPlateBlock(Blocks.ACACIA_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> DARK_OAK_PLATE = BLOCKS.register("dark_oak_plate",
      () -> new WoodPlateBlock(Blocks.DARK_OAK_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> CRIMSON_PLATE = BLOCKS.register("crimson_plate",
      () -> new WoodPlateBlock(Blocks.CRIMSON_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> WARPED_PLATE = BLOCKS.register("warped_plate",
      () -> new WoodPlateBlock(Blocks.WARPED_PLANKS.defaultMaterialColor()));

  // Wooden Half-Slab
  public static final RegistryObject<Block> OAK_HALF_SLAB = BLOCKS.register("oak_half_slab",
      () -> new WoodHalfSlabBlock(Blocks.OAK_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> SPRUCE_HALF_SLAB = BLOCKS.register("spruce_half_slab",
      () -> new WoodHalfSlabBlock(Blocks.SPRUCE_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> BIRCH_HALF_SLAB = BLOCKS.register("birch_half_slab",
      () -> new WoodHalfSlabBlock(Blocks.BIRCH_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> JUNGLE_HALF_SLAB = BLOCKS.register("jungle_half_slab",
      () -> new WoodHalfSlabBlock(Blocks.JUNGLE_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> ACACIA_HALF_SLAB = BLOCKS.register("acacia_half_slab",
      () -> new WoodHalfSlabBlock(Blocks.ACACIA_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> DARK_OAK_HALF_SLAB =
      BLOCKS.register("dark_oak_half_slab",
          () -> new WoodHalfSlabBlock(Blocks.DARK_OAK_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> CRIMSON_HALF_SLAB = BLOCKS.register("crimson_half_slab",
      () -> new WoodHalfSlabBlock(Blocks.CRIMSON_PLANKS.defaultMaterialColor()));
  public static final RegistryObject<Block> WARPED_HALF_SLAB = BLOCKS.register("warped_half_slab",
      () -> new WoodHalfSlabBlock(Blocks.WARPED_PLANKS.defaultMaterialColor()));

  @TemplateEntryPoint("Register Entity")

  // Wooden framed Hoppers
  public static final RegistryObject<BlockEntityType<OakFramedHopperEntity>> OAK_HOPPER_ENTITY =
      ENTITIES.register(OakFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(OakFramedHopperEntity::new, OAK_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<SpruceFramedHopperEntity>> SPRUCE_HOPPER_ENTITY =
      ENTITIES.register(SpruceFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(SpruceFramedHopperEntity::new, SPRUCE_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<BirchFramedHopperEntity>> BIRCH_HOPPER_ENTITY =
      ENTITIES.register(BirchFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(BirchFramedHopperEntity::new, BIRCH_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<JungleFramedHopperEntity>> JUNGLE_HOPPER_ENTITY =
      ENTITIES.register(JungleFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(JungleFramedHopperEntity::new, JUNGLE_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<AcaciaFramedHopperEntity>> ACACIA_HOPPER_ENTITY =
      ENTITIES.register(AcaciaFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(AcaciaFramedHopperEntity::new, ACACIA_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<DarkOakFramedHopperEntity>> DARK_OAK_HOPPER_ENTITY =
      ENTITIES.register(DarkOakFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(DarkOakFramedHopperEntity::new, DARK_OAK_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<CrimsonFramedHopperEntity>> CRIMSON_HOPPER_ENTITY =
      ENTITIES.register(CrimsonFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(CrimsonFramedHopperEntity::new, CRIMSON_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<WarpedFramedHopperEntity>> WARPED_HOPPER_ENTITY =
      ENTITIES.register(WarpedFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(WarpedFramedHopperEntity::new, WARPED_FRAMED_HOPPER.get()).build(null));

}
