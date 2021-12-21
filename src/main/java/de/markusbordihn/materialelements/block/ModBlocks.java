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

package de.markusbordihn.materialelements.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.materialelements.Constants;
import de.markusbordihn.materialelements.Annotations.TemplateEntryPoint;
import de.markusbordihn.materialelements.block.halfslab.WoodHalfSlabBlock;
import de.markusbordihn.materialelements.block.panel.WoodPanelBlock;
import de.markusbordihn.materialelements.block.plate.WoodPlateBlock;
import de.markusbordihn.materialelements.block.rod.*;

public class ModBlocks {

  protected ModBlocks() {

  }

  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

  @TemplateEntryPoint("Register Blocks")

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

  // Rods (tee elbow)
  public static final RegistryObject<Block> COPPER_ROD_TEE_ELBOW =
      BLOCKS.register("copper_rod_tee_elbow", () -> new RodTeeElbow(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_ROD_TEE_ELBOW =
      BLOCKS.register("gold_rod_tee_elbow", () -> new RodTeeElbow(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_ROD_TEE_ELBOW =
      BLOCKS.register("silver_rod_tee_elbow", () -> new RodTeeElbow(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_ROD_TEE_ELBOW =
      BLOCKS.register("iron_rod_tee_elbow", () -> new RodTeeElbow(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_ROD_TEE_ELBOW =
      BLOCKS.register("steel_rod_tee_elbow", () -> new RodTeeElbow(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_ROD_TEE_ELBOW =
      BLOCKS.register("netherite_rod_tee_elbow", () -> new RodTeeElbow(BlockType.NETHERITE));

  // Rods (elbow)
  public static final RegistryObject<Block> COPPER_ROD_ELBOW =
      BLOCKS.register("copper_rod_elbow", () -> new RodElbow(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_ROD_ELBOW =
      BLOCKS.register("gold_rod_elbow", () -> new RodElbow(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_ROD_ELBOW =
      BLOCKS.register("silver_rod_elbow", () -> new RodElbow(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_ROD_ELBOW =
      BLOCKS.register("iron_rod_elbow", () -> new RodElbow(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_ROD_ELBOW =
      BLOCKS.register("steel_rod_elbow", () -> new RodElbow(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_ROD_ELBOW =
      BLOCKS.register("netherite_rod_elbow", () -> new RodElbow(BlockType.NETHERITE));

  // Rods (tee)
  public static final RegistryObject<Block> COPPER_ROD_TEE =
      BLOCKS.register("copper_rod_tee", () -> new RodTee(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_ROD_TEE =
      BLOCKS.register("gold_rod_tee", () -> new RodTee(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_ROD_TEE =
      BLOCKS.register("silver_rod_tee", () -> new RodTee(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_ROD_TEE =
      BLOCKS.register("iron_rod_tee", () -> new RodTee(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_ROD_TEE =
      BLOCKS.register("steel_rod_tee", () -> new RodTee(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_ROD_TEE =
      BLOCKS.register("netherite_rod_tee", () -> new RodTee(BlockType.NETHERITE));

  // Rods (star)
  public static final RegistryObject<Block> COPPER_ROD_STAR =
      BLOCKS.register("copper_rod_star", () -> new RodStar(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_ROD_STAR =
      BLOCKS.register("gold_rod_star", () -> new RodStar(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_ROD_STAR =
      BLOCKS.register("silver_rod_star", () -> new RodStar(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_ROD_STAR =
      BLOCKS.register("iron_rod_star", () -> new RodStar(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_ROD_STAR =
      BLOCKS.register("steel_rod_star", () -> new RodStar(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_ROD_STAR =
      BLOCKS.register("netherite_rod_star", () -> new RodStar(BlockType.NETHERITE));

  // Rods (cross)
  public static final RegistryObject<Block> COPPER_ROD_CROSS =
      BLOCKS.register("copper_rod_cross", () -> new RodCross(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_ROD_CROSS =
      BLOCKS.register("gold_rod_cross", () -> new RodCross(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_ROD_CROSS =
      BLOCKS.register("silver_rod_cross", () -> new RodCross(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_ROD_CROSS =
      BLOCKS.register("iron_rod_cross", () -> new RodCross(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_ROD_CROSS =
      BLOCKS.register("steel_rod_cross", () -> new RodCross(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_ROD_CROSS =
      BLOCKS.register("netherite_rod_cross", () -> new RodCross(BlockType.NETHERITE));

  // Rods (half size)
  public static final RegistryObject<Block> COPPER_ROD_HALF_SIZE =
      BLOCKS.register("copper_rod_half_size", () -> new RodHalfSize(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_ROD_HALF_SIZE =
      BLOCKS.register("gold_rod_half_size", () -> new RodHalfSize(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_ROD_HALF_SIZE =
      BLOCKS.register("silver_rod_half_size", () -> new RodHalfSize(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_ROD_HALF_SIZE =
      BLOCKS.register("iron_rod_half_size", () -> new RodHalfSize(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_ROD_HALF_SIZE =
      BLOCKS.register("steel_rod_half_size", () -> new RodHalfSize(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_ROD_HALF_SIZE =
      BLOCKS.register("netherite_rod_half_size", () -> new RodHalfSize(BlockType.NETHERITE));

  // Rods (full-size)
  public static final RegistryObject<Block> COPPER_ROD =
      BLOCKS.register("copper_rod", () -> new Rod(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_ROD =
      BLOCKS.register("gold_rod", () -> new Rod(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_ROD =
      BLOCKS.register("silver_rod", () -> new Rod(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_ROD =
      BLOCKS.register("iron_rod", () -> new Rod(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_ROD =
      BLOCKS.register("steel_rod", () -> new Rod(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_ROD =
      BLOCKS.register("netherite_rod", () -> new Rod(BlockType.NETHERITE));

  // Blocks
  public static final RegistryObject<Block> SILVER_BLOCK =
      BLOCKS.register("silver_block", () -> new Block(BlockType.SILVER));
  public static final RegistryObject<Block> STEEL_BLOCK =
      BLOCKS.register("steel_block", () -> new Block(BlockType.STEEL));

  // Ore
  public static final RegistryObject<Block> SILVER_ORE =
      BLOCKS.register("silver_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
          .requiresCorrectToolForDrops().strength(2.0F, 2.0F)));
  public static final RegistryObject<Block> STEEL_ORE =
      BLOCKS.register("steel_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
          .requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
}
