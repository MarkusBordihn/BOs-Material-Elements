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

import de.markusbordihn.minecraft.materialelements.block.BlockType;
import de.markusbordihn.minecraft.materialelements.color.ClothColor;

import de.markusbordihn.minecraft.materialelementsdecorative.block.cloth.ClothBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.cloth.ClothSlabBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.cloth.ClothTriangularBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.cloth.FabricClothBlock;
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
import de.markusbordihn.minecraft.materialelementsdecorative.block.raisedfloor.RaisedFloorBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.raisedfloor.RaisedFloorLightBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.slab.SlabBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.block.slab.WoolSlabBlock;
import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.Annotations.TemplateEntryPoint;

public class ModBlocks {

  protected ModBlocks() {

  }

  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
      DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Constants.MOD_ID);

  @TemplateEntryPoint("Register Blocks")

  // Fabric Cloth
  public static final RegistryObject<Block> FABRIC_CLOTH_WHITE =
      BLOCKS.register("fabric_cloth_white", () -> new FabricClothBlock(ClothColor.WHITE));
  public static final RegistryObject<Block> FABRIC_CLOTH_ORANGE =
      BLOCKS.register("fabric_cloth_orange", () -> new FabricClothBlock(ClothColor.ORANGE));
  public static final RegistryObject<Block> FABRIC_CLOTH_MAGENTA =
      BLOCKS.register("fabric_cloth_magenta", () -> new FabricClothBlock(ClothColor.MAGENTA));
  public static final RegistryObject<Block> FABRIC_CLOTH_LIGHT_BLUE =
      BLOCKS.register("fabric_cloth_light_blue", () -> new FabricClothBlock(ClothColor.LIGHT_BLUE));
  public static final RegistryObject<Block> FABRIC_CLOTH_YELLOW =
      BLOCKS.register("fabric_cloth_yellow", () -> new FabricClothBlock(ClothColor.YELLOW));
  public static final RegistryObject<Block> FABRIC_CLOTH_LIME =
      BLOCKS.register("fabric_cloth_lime", () -> new FabricClothBlock(ClothColor.LIME));
  public static final RegistryObject<Block> FABRIC_CLOTH_PINK =
      BLOCKS.register("fabric_cloth_pink", () -> new FabricClothBlock(ClothColor.PINK));
  public static final RegistryObject<Block> FABRIC_CLOTH_GRAY =
      BLOCKS.register("fabric_cloth_gray", () -> new FabricClothBlock(ClothColor.GRAY));
  public static final RegistryObject<Block> FABRIC_CLOTH_LIGHT_GRAY =
      BLOCKS.register("fabric_cloth_light_gray", () -> new FabricClothBlock(ClothColor.LIGHT_GRAY));
  public static final RegistryObject<Block> FABRIC_CLOTH_CYAN =
      BLOCKS.register("fabric_cloth_cyan", () -> new FabricClothBlock(ClothColor.CYAN));
  public static final RegistryObject<Block> FABRIC_CLOTH_PURPLE =
      BLOCKS.register("fabric_cloth_purple", () -> new FabricClothBlock(ClothColor.PURPLE));
  public static final RegistryObject<Block> FABRIC_CLOTH_BLUE =
      BLOCKS.register("fabric_cloth_blue", () -> new FabricClothBlock(ClothColor.BLUE));
  public static final RegistryObject<Block> FABRIC_CLOTH_BROWN =
      BLOCKS.register("fabric_cloth_brown", () -> new FabricClothBlock(ClothColor.BROWN));
  public static final RegistryObject<Block> FABRIC_CLOTH_GREEN =
      BLOCKS.register("fabric_cloth_green", () -> new FabricClothBlock(ClothColor.GREEN));
  public static final RegistryObject<Block> FABRIC_CLOTH_RED =
      BLOCKS.register("fabric_cloth_red", () -> new FabricClothBlock(ClothColor.RED));
  public static final RegistryObject<Block> FABRIC_CLOTH_BLACK =
      BLOCKS.register("fabric_cloth_black", () -> new FabricClothBlock(ClothColor.BLACK));

  // Cloth Blocks
  public static final RegistryObject<Block> CLOTH_BLOCK_WHITE =
      BLOCKS.register("cloth_block_white", () -> new ClothBlock(ClothColor.WHITE));
  public static final RegistryObject<Block> CLOTH_BLOCK_ORANGE =
      BLOCKS.register("cloth_block_orange", () -> new ClothBlock(ClothColor.ORANGE));
  public static final RegistryObject<Block> CLOTH_BLOCK_MAGENTA =
      BLOCKS.register("cloth_block_magenta", () -> new ClothBlock(ClothColor.MAGENTA));
  public static final RegistryObject<Block> CLOTH_BLOCK_LIGHT_BLUE =
      BLOCKS.register("cloth_block_light_blue", () -> new ClothBlock(ClothColor.LIGHT_BLUE));
  public static final RegistryObject<Block> CLOTH_BLOCK_YELLOW =
      BLOCKS.register("cloth_block_yellow", () -> new ClothBlock(ClothColor.YELLOW));
  public static final RegistryObject<Block> CLOTH_BLOCK_LIME =
      BLOCKS.register("cloth_block_lime", () -> new ClothBlock(ClothColor.LIME));
  public static final RegistryObject<Block> CLOTH_BLOCK_PINK =
      BLOCKS.register("cloth_block_pink", () -> new ClothBlock(ClothColor.PINK));
  public static final RegistryObject<Block> CLOTH_BLOCK_GRAY =
      BLOCKS.register("cloth_block_gray", () -> new ClothBlock(ClothColor.GRAY));
  public static final RegistryObject<Block> CLOTH_BLOCK_LIGHT_GRAY =
      BLOCKS.register("cloth_block_light_gray", () -> new ClothBlock(ClothColor.LIGHT_GRAY));
  public static final RegistryObject<Block> CLOTH_BLOCK_CYAN =
      BLOCKS.register("cloth_block_cyan", () -> new ClothBlock(ClothColor.CYAN));
  public static final RegistryObject<Block> CLOTH_BLOCK_PURPLE =
      BLOCKS.register("cloth_block_purple", () -> new ClothBlock(ClothColor.PURPLE));
  public static final RegistryObject<Block> CLOTH_BLOCK_BLUE =
      BLOCKS.register("cloth_block_blue", () -> new ClothBlock(ClothColor.BLUE));
  public static final RegistryObject<Block> CLOTH_BLOCK_BROWN =
      BLOCKS.register("cloth_block_brown", () -> new ClothBlock(ClothColor.BROWN));
  public static final RegistryObject<Block> CLOTH_BLOCK_GREEN =
      BLOCKS.register("cloth_block_green", () -> new ClothBlock(ClothColor.GREEN));
  public static final RegistryObject<Block> CLOTH_BLOCK_RED =
      BLOCKS.register("cloth_block_red", () -> new ClothBlock(ClothColor.RED));
  public static final RegistryObject<Block> CLOTH_BLOCK_BLACK =
      BLOCKS.register("cloth_block_black", () -> new ClothBlock(ClothColor.BLACK));

  // Cloth Slabs
  public static final RegistryObject<Block> CLOTH_SLAB_WHITE =
      BLOCKS.register("cloth_slab_white", () -> new ClothSlabBlock(ClothColor.WHITE));
  public static final RegistryObject<Block> CLOTH_SLAB_ORANGE =
      BLOCKS.register("cloth_slab_orange", () -> new ClothSlabBlock(ClothColor.ORANGE));
  public static final RegistryObject<Block> CLOTH_SLAB_MAGENTA =
      BLOCKS.register("cloth_slab_magenta", () -> new ClothSlabBlock(ClothColor.MAGENTA));
  public static final RegistryObject<Block> CLOTH_SLAB_LIGHT_BLUE =
      BLOCKS.register("cloth_slab_light_blue", () -> new ClothSlabBlock(ClothColor.LIGHT_BLUE));
  public static final RegistryObject<Block> CLOTH_SLAB_YELLOW =
      BLOCKS.register("cloth_slab_yellow", () -> new ClothSlabBlock(ClothColor.YELLOW));
  public static final RegistryObject<Block> CLOTH_SLAB_LIME =
      BLOCKS.register("cloth_slab_lime", () -> new ClothSlabBlock(ClothColor.LIME));
  public static final RegistryObject<Block> CLOTH_SLAB_PINK =
      BLOCKS.register("cloth_slab_pink", () -> new ClothSlabBlock(ClothColor.PINK));
  public static final RegistryObject<Block> CLOTH_SLAB_GRAY =
      BLOCKS.register("cloth_slab_gray", () -> new ClothSlabBlock(ClothColor.GRAY));
  public static final RegistryObject<Block> CLOTH_SLAB_LIGHT_GRAY =
      BLOCKS.register("cloth_slab_light_gray", () -> new ClothSlabBlock(ClothColor.LIGHT_GRAY));
  public static final RegistryObject<Block> CLOTH_SLAB_CYAN =
      BLOCKS.register("cloth_slab_cyan", () -> new ClothSlabBlock(ClothColor.CYAN));
  public static final RegistryObject<Block> CLOTH_SLAB_PURPLE =
      BLOCKS.register("cloth_slab_purple", () -> new ClothSlabBlock(ClothColor.PURPLE));
  public static final RegistryObject<Block> CLOTH_SLAB_BLUE =
      BLOCKS.register("cloth_slab_blue", () -> new ClothSlabBlock(ClothColor.BLUE));
  public static final RegistryObject<Block> CLOTH_SLAB_BROWN =
      BLOCKS.register("cloth_slab_brown", () -> new ClothSlabBlock(ClothColor.BROWN));
  public static final RegistryObject<Block> CLOTH_SLAB_GREEN =
      BLOCKS.register("cloth_slab_green", () -> new ClothSlabBlock(ClothColor.GREEN));
  public static final RegistryObject<Block> CLOTH_SLAB_RED =
      BLOCKS.register("cloth_slab_red", () -> new ClothSlabBlock(ClothColor.RED));
  public static final RegistryObject<Block> CLOTH_SLAB_BLACK =
      BLOCKS.register("cloth_slab_black", () -> new ClothSlabBlock(ClothColor.BLACK));

  // Cloth Triangular
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_WHITE =
      BLOCKS.register("cloth_triangular_white", () -> new ClothTriangularBlock(ClothColor.WHITE));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_ORANGE =
      BLOCKS.register("cloth_triangular_orange", () -> new ClothTriangularBlock(ClothColor.ORANGE));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_MAGENTA = BLOCKS
      .register("cloth_triangular_magenta", () -> new ClothTriangularBlock(ClothColor.MAGENTA));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_LIGHT_BLUE = BLOCKS.register(
      "cloth_triangular_light_blue", () -> new ClothTriangularBlock(ClothColor.LIGHT_BLUE));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_YELLOW =
      BLOCKS.register("cloth_triangular_yellow", () -> new ClothTriangularBlock(ClothColor.YELLOW));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_LIME =
      BLOCKS.register("cloth_triangular_lime", () -> new ClothTriangularBlock(ClothColor.LIME));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_PINK =
      BLOCKS.register("cloth_triangular_pink", () -> new ClothTriangularBlock(ClothColor.PINK));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_GRAY =
      BLOCKS.register("cloth_triangular_gray", () -> new ClothTriangularBlock(ClothColor.GRAY));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_LIGHT_GRAY = BLOCKS.register(
      "cloth_triangular_light_gray", () -> new ClothTriangularBlock(ClothColor.LIGHT_GRAY));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_CYAN =
      BLOCKS.register("cloth_triangular_cyan", () -> new ClothTriangularBlock(ClothColor.CYAN));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_PURPLE =
      BLOCKS.register("cloth_triangular_purple", () -> new ClothTriangularBlock(ClothColor.PURPLE));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_BLUE =
      BLOCKS.register("cloth_triangular_blue", () -> new ClothTriangularBlock(ClothColor.BLUE));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_BROWN =
      BLOCKS.register("cloth_triangular_brown", () -> new ClothTriangularBlock(ClothColor.BROWN));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_GREEN =
      BLOCKS.register("cloth_triangular_green", () -> new ClothTriangularBlock(ClothColor.GREEN));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_RED =
      BLOCKS.register("cloth_triangular_red", () -> new ClothTriangularBlock(ClothColor.RED));
  public static final RegistryObject<Block> CLOTH_TRIANGULAR_BLACK =
      BLOCKS.register("cloth_triangular_black", () -> new ClothTriangularBlock(ClothColor.BLACK));

  // Raised Floor
  public static final RegistryObject<Block> RAISED_FLOOR_BASE =
      BLOCKS.register("raised_floor_base", RaisedFloorBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_BASIC =
      BLOCKS.register("raised_floor_basic", RaisedFloorBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_FLOW_PANEL_TYPE_A =
      BLOCKS.register("raised_floor_flow_panel_type_a", RaisedFloorBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_FLOW_PANEL_TYPE_B =
      BLOCKS.register("raised_floor_flow_panel_type_b", RaisedFloorBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_FLOW_PANEL_TYPE_C =
      BLOCKS.register("raised_floor_flow_panel_type_c", RaisedFloorBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_FLOW_PANEL_TYPE_D =
      BLOCKS.register("raised_floor_flow_panel_type_d", RaisedFloorBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_FLOW_PANEL_TYPE_E =
      BLOCKS.register("raised_floor_flow_panel_type_e", RaisedFloorBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_FLOW_PANEL_TYPE_F =
      BLOCKS.register("raised_floor_flow_panel_type_f", RaisedFloorBlock::new);

  // Raised Floor Light
  public static final RegistryObject<Block> RAISED_FLOOR_LIGHT_CORNER_LIGHT_BLUE =
      BLOCKS.register("raised_floor_light_corner_light_blue", RaisedFloorLightBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_LIGHT_CORNER_FLIPPED_LIGHT_BLUE =
      BLOCKS.register("raised_floor_light_corner_flipped_light_blue", RaisedFloorLightBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_LIGHT_LIGHT_BLUE =
      BLOCKS.register("raised_floor_light_light_blue", RaisedFloorLightBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_LIGHT_MIDDLE_HALF_LIGHT_BLUE =
      BLOCKS.register("raised_floor_light_middle_half_light_blue", RaisedFloorLightBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_LIGHT_MIDDLE_LIGHT_BLUE =
      BLOCKS.register("raised_floor_light_middle_light_blue", RaisedFloorLightBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_LIGHT_SIDE_HALF_LIGHT_BLUE =
      BLOCKS.register("raised_floor_light_side_half_light_blue", RaisedFloorLightBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_LIGHT_SIDE_HALF_FLIPPED_LIGHT_BLUE = BLOCKS
      .register("raised_floor_light_side_half_flipped_light_blue", RaisedFloorLightBlock::new);
  public static final RegistryObject<Block> RAISED_FLOOR_LIGHT_SIDE_LIGHT_BLUE =
      BLOCKS.register("raised_floor_light_side_light_blue", RaisedFloorLightBlock::new);

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
  public static final RegistryObject<Block> STEEL_SOUL_LANTERN = BLOCKS.register(
      "steel_soul_lantern",
      () -> new SteelLanternBlock(
          BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F)
              .sound(SoundType.LANTERN).lightLevel(blockState -> 10).noOcclusion(),
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

  // Misc
  public static final RegistryObject<Block> GLASS_SLAB =
      BLOCKS.register("glass_slab", () -> new SlabBlock(Blocks.GLASS));

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
  public static final RegistryObject<Block> OAK_PANEL =
      BLOCKS.register("oak_panel", () -> new WoodPanelBlock(BlockType.OAK));
  public static final RegistryObject<Block> SPRUCE_PANEL =
      BLOCKS.register("spruce_panel", () -> new WoodPanelBlock(BlockType.SPRUCE));
  public static final RegistryObject<Block> BIRCH_PANEL =
      BLOCKS.register("birch_panel", () -> new WoodPanelBlock(BlockType.BIRCH));
  public static final RegistryObject<Block> JUNGLE_PANEL =
      BLOCKS.register("jungle_panel", () -> new WoodPanelBlock(BlockType.JUNGLE));
  public static final RegistryObject<Block> ACACIA_PANEL =
      BLOCKS.register("acacia_panel", () -> new WoodPanelBlock(BlockType.ACACIA));
  public static final RegistryObject<Block> DARK_OAK_PANEL =
      BLOCKS.register("dark_oak_panel", () -> new WoodPanelBlock(BlockType.DARK_OAK));
  public static final RegistryObject<Block> CRIMSON_PANEL =
      BLOCKS.register("crimson_panel", () -> new WoodPanelBlock(BlockType.CRIMSON));
  public static final RegistryObject<Block> WARPED_PANEL =
      BLOCKS.register("warped_panel", () -> new WoodPanelBlock(BlockType.WARPED));

  // Wooden Plates
  public static final RegistryObject<Block> OAK_PLATE =
      BLOCKS.register("oak_plate", () -> new WoodPlateBlock(BlockType.OAK));
  public static final RegistryObject<Block> SPRUCE_PLATE =
      BLOCKS.register("spruce_plate", () -> new WoodPlateBlock(BlockType.SPRUCE));
  public static final RegistryObject<Block> BIRCH_PLATE =
      BLOCKS.register("birch_plate", () -> new WoodPlateBlock(BlockType.BIRCH));
  public static final RegistryObject<Block> JUNGLE_PLATE =
      BLOCKS.register("jungle_plate", () -> new WoodPlateBlock(BlockType.JUNGLE));
  public static final RegistryObject<Block> ACACIA_PLATE =
      BLOCKS.register("acacia_plate", () -> new WoodPlateBlock(BlockType.ACACIA));
  public static final RegistryObject<Block> DARK_OAK_PLATE =
      BLOCKS.register("dark_oak_plate", () -> new WoodPlateBlock(BlockType.DARK_OAK));
  public static final RegistryObject<Block> CRIMSON_PLATE =
      BLOCKS.register("crimson_plate", () -> new WoodPlateBlock(BlockType.CRIMSON));
  public static final RegistryObject<Block> WARPED_PLATE =
      BLOCKS.register("warped_plate", () -> new WoodPlateBlock(BlockType.WARPED));

  // Wooden Half-Slab
  public static final RegistryObject<Block> OAK_HALF_SLAB =
      BLOCKS.register("oak_half_slab", () -> new WoodHalfSlabBlock(BlockType.OAK));
  public static final RegistryObject<Block> SPRUCE_HALF_SLAB =
      BLOCKS.register("spruce_half_slab", () -> new WoodHalfSlabBlock(BlockType.SPRUCE));
  public static final RegistryObject<Block> BIRCH_HALF_SLAB =
      BLOCKS.register("birch_half_slab", () -> new WoodHalfSlabBlock(BlockType.BIRCH));
  public static final RegistryObject<Block> JUNGLE_HALF_SLAB =
      BLOCKS.register("jungle_half_slab", () -> new WoodHalfSlabBlock(BlockType.JUNGLE));
  public static final RegistryObject<Block> ACACIA_HALF_SLAB =
      BLOCKS.register("acacia_half_slab", () -> new WoodHalfSlabBlock(BlockType.ACACIA));
  public static final RegistryObject<Block> DARK_OAK_HALF_SLAB =
      BLOCKS.register("dark_oak_half_slab", () -> new WoodHalfSlabBlock(BlockType.DARK_OAK));
  public static final RegistryObject<Block> CRIMSON_HALF_SLAB =
      BLOCKS.register("crimson_half_slab", () -> new WoodHalfSlabBlock(BlockType.CRIMSON));
  public static final RegistryObject<Block> WARPED_HALF_SLAB =
      BLOCKS.register("warped_half_slab", () -> new WoodHalfSlabBlock(BlockType.WARPED));

  @TemplateEntryPoint("Register Entity")

  // Wooden framed Hoppers
  public static final RegistryObject<BlockEntityType<OakFramedHopperEntity>> OAK_HOPPER_ENTITY =
      BLOCK_ENTITY_TYPES.register(OakFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(OakFramedHopperEntity::new, OAK_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<SpruceFramedHopperEntity>> SPRUCE_HOPPER_ENTITY =
      BLOCK_ENTITY_TYPES.register(SpruceFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(SpruceFramedHopperEntity::new, SPRUCE_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<BirchFramedHopperEntity>> BIRCH_HOPPER_ENTITY =
      BLOCK_ENTITY_TYPES.register(BirchFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(BirchFramedHopperEntity::new, BIRCH_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<JungleFramedHopperEntity>> JUNGLE_HOPPER_ENTITY =
      BLOCK_ENTITY_TYPES.register(JungleFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(JungleFramedHopperEntity::new, JUNGLE_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<AcaciaFramedHopperEntity>> ACACIA_HOPPER_ENTITY =
      BLOCK_ENTITY_TYPES.register(AcaciaFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(AcaciaFramedHopperEntity::new, ACACIA_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<DarkOakFramedHopperEntity>> DARK_OAK_HOPPER_ENTITY =
      BLOCK_ENTITY_TYPES.register(DarkOakFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(DarkOakFramedHopperEntity::new, DARK_OAK_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<CrimsonFramedHopperEntity>> CRIMSON_HOPPER_ENTITY =
      BLOCK_ENTITY_TYPES.register(CrimsonFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(CrimsonFramedHopperEntity::new, CRIMSON_FRAMED_HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<WarpedFramedHopperEntity>> WARPED_HOPPER_ENTITY =
      BLOCK_ENTITY_TYPES.register(WarpedFramedHopper.NAME, () -> BlockEntityType.Builder
          .of(WarpedFramedHopperEntity::new, WARPED_FRAMED_HOPPER.get()).build(null));

}
