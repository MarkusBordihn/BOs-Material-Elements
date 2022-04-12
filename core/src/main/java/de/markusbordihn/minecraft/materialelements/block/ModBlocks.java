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

package de.markusbordihn.minecraft.materialelements.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.minecraft.materialelements.Constants;
import de.markusbordihn.minecraft.materialelements.Annotations.TemplateEntryPoint;
import de.markusbordihn.minecraft.materialelements.block.multiplace.TriangularBlock;
import de.markusbordihn.minecraft.materialelements.block.rod.Rod;
import de.markusbordihn.minecraft.materialelements.block.rod.RodCross;
import de.markusbordihn.minecraft.materialelements.block.rod.RodElbow;
import de.markusbordihn.minecraft.materialelements.block.rod.RodHalfSize;
import de.markusbordihn.minecraft.materialelements.block.rod.RodStar;
import de.markusbordihn.minecraft.materialelements.block.rod.RodTee;
import de.markusbordihn.minecraft.materialelements.block.rod.RodTeeElbow;

public class ModBlocks {

  protected ModBlocks() {

  }

  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

  public static final DeferredRegister<BlockEntityType<?>> ENTITIES =
      DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Constants.MOD_ID);

  @TemplateEntryPoint("Register Blocks")

  // Cube Frames
  public static final RegistryObject<Block> LIGHT_CUBE_FRAME =
      BLOCKS.register("light_cube_frame", () -> new Block(BlockType.LIGHT));
  public static final RegistryObject<Block> COPPER_CUBE_FRAME =
      BLOCKS.register("copper_cube_frame", () -> new Block(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_CUBE_FRAME =
      BLOCKS.register("gold_cube_frame", () -> new Block(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_CUBE_FRAME =
      BLOCKS.register("silver_cube_frame", () -> new Block(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_CUBE_FRAME =
      BLOCKS.register("iron_cube_frame", () -> new Block(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_CUBE_FRAME =
      BLOCKS.register("steel_cube_frame", () -> new Block(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_CUBE_FRAME =
      BLOCKS.register("netherite_cube_frame", () -> new Block(BlockType.NETHERITE));

  // Cube Glass Frames
  public static final RegistryObject<Block> LIGHT_CUBE_GLASS_FRAME =
      BLOCKS.register("light_cube_glass_frame", () -> new Block(BlockType.LIGHT));
  public static final RegistryObject<Block> COPPER_CUBE_GLASS_FRAME =
      BLOCKS.register("copper_cube_glass_frame", () -> new Block(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_CUBE_GLASS_FRAME =
      BLOCKS.register("gold_cube_glass_frame", () -> new Block(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_CUBE_GLASS_FRAME =
      BLOCKS.register("silver_cube_glass_frame", () -> new Block(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_CUBE_GLASS_FRAME =
      BLOCKS.register("iron_cube_glass_frame", () -> new Block(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_CUBE_GLASS_FRAME =
      BLOCKS.register("steel_cube_glass_frame", () -> new Block(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_CUBE_GLASS_FRAME =
      BLOCKS.register("netherite_cube_glass_frame", () -> new Block(BlockType.NETHERITE));

  // Slab Frames
  public static final RegistryObject<Block> LIGHT_SLAB_FRAME =
      BLOCKS.register("light_slab_frame", () -> new SlabBlock(BlockType.LIGHT));
  public static final RegistryObject<Block> COPPER_SLAB_FRAME =
      BLOCKS.register("copper_slab_frame", () -> new SlabBlock(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_SLAB_FRAME =
      BLOCKS.register("gold_slab_frame", () -> new SlabBlock(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_SLAB_FRAME =
      BLOCKS.register("silver_slab_frame", () -> new SlabBlock(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_SLAB_FRAME =
      BLOCKS.register("iron_slab_frame", () -> new SlabBlock(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_SLAB_FRAME =
      BLOCKS.register("steel_slab_frame", () -> new SlabBlock(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_SLAB_FRAME =
      BLOCKS.register("netherite_slab_frame", () -> new SlabBlock(BlockType.NETHERITE));

  // Triangular Frames
  public static final RegistryObject<Block> LIGHT_TRIANGULAR_FRAME =
      BLOCKS.register("light_triangular_frame", () -> new TriangularBlock(BlockType.LIGHT));
  public static final RegistryObject<Block> COPPER_TRIANGULAR_FRAME =
      BLOCKS.register("copper_triangular_frame", () -> new TriangularBlock(BlockType.COPPER));
  public static final RegistryObject<Block> GOLD_TRIANGULAR_FRAME =
      BLOCKS.register("gold_triangular_frame", () -> new TriangularBlock(BlockType.GOLD));
  public static final RegistryObject<Block> SILVER_TRIANGULAR_FRAME =
      BLOCKS.register("silver_triangular_frame", () -> new TriangularBlock(BlockType.SILVER));
  public static final RegistryObject<Block> IRON_TRIANGULAR_FRAME =
      BLOCKS.register("iron_triangular_frame", () -> new TriangularBlock(BlockType.IRON));
  public static final RegistryObject<Block> STEEL_TRIANGULAR_FRAME =
      BLOCKS.register("steel_triangular_frame", () -> new TriangularBlock(BlockType.STEEL));
  public static final RegistryObject<Block> NETHERITE_TRIANGULAR_FRAME =
      BLOCKS.register("netherite_triangular_frame", () -> new TriangularBlock(BlockType.NETHERITE));

  // Construction Cube Frames
  public static final RegistryObject<Block> OAK_CONSTRUCTION_CUBE_FRAME =
      BLOCKS.register("oak_construction_cube_frame", () -> new Block(BlockType.OAK));
  public static final RegistryObject<Block> SPRUCE_CONSTRUCTION_CUBE_FRAME =
      BLOCKS.register("spruce_construction_cube_frame", () -> new Block(BlockType.SPRUCE));
  public static final RegistryObject<Block> BIRCH_CONSTRUCTION_CUBE_FRAME =
      BLOCKS.register("birch_construction_cube_frame", () -> new Block(BlockType.BIRCH));
  public static final RegistryObject<Block> JUNGLE_CONSTRUCTION_CUBE_FRAME =
      BLOCKS.register("jungle_construction_cube_frame", () -> new Block(BlockType.JUNGLE));
  public static final RegistryObject<Block> ACACIA_CONSTRUCTION_CUBE_FRAME =
      BLOCKS.register("acacia_construction_cube_frame", () -> new Block(BlockType.ACACIA));
  public static final RegistryObject<Block> DARK_OAK_CONSTRUCTION_CUBE_FRAME =
      BLOCKS.register("dark_oak_construction_cube_frame", () -> new Block(BlockType.DARK_OAK));
  public static final RegistryObject<Block> CRIMSON_CONSTRUCTION_CUBE_FRAME =
      BLOCKS.register("crimson_construction_cube_frame", () -> new Block(BlockType.CRIMSON));
  public static final RegistryObject<Block> WARPED_CONSTRUCTION_CUBE_FRAME =
      BLOCKS.register("warped_construction_cube_frame", () -> new Block(BlockType.WARPED));

  // Construction Slab Frames
  public static final RegistryObject<Block> OAK_CONSTRUCTION_SLAB_FRAME =
      BLOCKS.register("oak_construction_slab_frame", () -> new SlabBlock(BlockType.OAK));
  public static final RegistryObject<Block> SPRUCE_CONSTRUCTION_SLAB_FRAME =
      BLOCKS.register("spruce_construction_slab_frame", () -> new SlabBlock(BlockType.SPRUCE));
  public static final RegistryObject<Block> BIRCH_CONSTRUCTION_SLAB_FRAME =
      BLOCKS.register("birch_construction_slab_frame", () -> new SlabBlock(BlockType.BIRCH));
  public static final RegistryObject<Block> JUNGLE_CONSTRUCTION_SLAB_FRAME =
      BLOCKS.register("jungle_construction_slab_frame", () -> new SlabBlock(BlockType.JUNGLE));
  public static final RegistryObject<Block> ACACIA_CONSTRUCTION_SLAB_FRAME =
      BLOCKS.register("acacia_construction_slab_frame", () -> new SlabBlock(BlockType.ACACIA));
  public static final RegistryObject<Block> DARK_OAK_CONSTRUCTION_SLAB_FRAME =
      BLOCKS.register("dark_oak_construction_slab_frame", () -> new SlabBlock(BlockType.DARK_OAK));
  public static final RegistryObject<Block> CRIMSON_CONSTRUCTION_SLAB_FRAME =
      BLOCKS.register("crimson_construction_slab_frame", () -> new SlabBlock(BlockType.CRIMSON));
  public static final RegistryObject<Block> WARPED_CONSTRUCTION_SLAB_FRAME =
      BLOCKS.register("warped_construction_slab_frame", () -> new SlabBlock(BlockType.WARPED));

  // Construction Triangular Frames
  public static final RegistryObject<Block> OAK_CONSTRUCTION_TRIANGULAR_FRAME = BLOCKS
      .register("oak_construction_triangular_frame", () -> new TriangularBlock(BlockType.OAK));
  public static final RegistryObject<Block> SPRUCE_CONSTRUCTION_TRIANGULAR_FRAME = BLOCKS.register(
      "spruce_construction_triangular_frame", () -> new TriangularBlock(BlockType.SPRUCE));
  public static final RegistryObject<Block> BIRCH_CONSTRUCTION_TRIANGULAR_FRAME = BLOCKS
      .register("birch_construction_triangular_frame", () -> new TriangularBlock(BlockType.BIRCH));
  public static final RegistryObject<Block> JUNGLE_CONSTRUCTION_TRIANGULAR_FRAME = BLOCKS.register(
      "jungle_construction_triangular_frame", () -> new TriangularBlock(BlockType.JUNGLE));
  public static final RegistryObject<Block> ACACIA_CONSTRUCTION_TRIANGULAR_FRAME = BLOCKS.register(
      "acacia_construction_triangular_frame", () -> new TriangularBlock(BlockType.ACACIA));
  public static final RegistryObject<Block> DARK_OAK_CONSTRUCTION_TRIANGULAR_FRAME =
      BLOCKS.register("dark_oak_construction_triangular_frame",
          () -> new TriangularBlock(BlockType.DARK_OAK));
  public static final RegistryObject<Block> CRIMSON_CONSTRUCTION_TRIANGULAR_FRAME = BLOCKS.register(
      "crimson_construction_triangular_frame", () -> new TriangularBlock(BlockType.CRIMSON));
  public static final RegistryObject<Block> WARPED_CONSTRUCTION_TRIANGULAR_FRAME = BLOCKS.register(
      "warped_construction_triangular_frame", () -> new TriangularBlock(BlockType.WARPED));

  // Rods (tee elbow)
  public static final RegistryObject<Block> LIGHT_ROD_TEE_ELBOW =
      BLOCKS.register("light_rod_tee_elbow", () -> new RodTeeElbow(BlockType.LIGHT));
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
  public static final RegistryObject<Block> LIGHT_ROD_ELBOW =
      BLOCKS.register("light_rod_elbow", () -> new RodElbow(BlockType.LIGHT));
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
  public static final RegistryObject<Block> LIGHT_ROD_TEE =
      BLOCKS.register("light_rod_tee", () -> new RodTee(BlockType.LIGHT));
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
  public static final RegistryObject<Block> LIGHT_ROD_STAR =
      BLOCKS.register("light_rod_star", () -> new RodStar(BlockType.LIGHT));
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
  public static final RegistryObject<Block> LIGHT_ROD_CROSS =
      BLOCKS.register("light_rod_cross", () -> new RodCross(BlockType.LIGHT));
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
  public static final RegistryObject<Block> LIGHT_ROD_HALF_SIZE =
      BLOCKS.register("light_rod_half_size", () -> new RodHalfSize(BlockType.LIGHT));
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
  public static final RegistryObject<Block> LIGHT_ROD =
      BLOCKS.register("light_rod", () -> new Rod(BlockType.LIGHT));
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

  // Raw Blocks
  public static final RegistryObject<Block> RAW_SILVER_BLOCK =
      BLOCKS.register("raw_silver_block", () -> new Block(BlockType.SILVER));
  public static final RegistryObject<Block> RAW_STEEL_BLOCK =
      BLOCKS.register("raw_steel_block", () -> new Block(BlockType.STEEL));

  // Ore
  public static final RegistryObject<Block> SILVER_ORE =
      BLOCKS.register("silver_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
          .requiresCorrectToolForDrops().strength(2.0F, 2.0F)));
  public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = BLOCKS.register(
      "deepslate_silver_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(SILVER_ORE.get())
          .color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
  public static final RegistryObject<Block> STEEL_ORE =
      BLOCKS.register("steel_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
          .requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
  public static final RegistryObject<Block> DEEPSLATE_STEEL_ORE = BLOCKS.register(
      "deepslate_steel_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(STEEL_ORE.get())
          .color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));

  // Coke and Charcoal Block
  public static final RegistryObject<Block> CHARCOAL_BLOCK = BLOCKS.register("charcoal_block",
      () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
  public static final RegistryObject<Block> COKE_BLOCK = BLOCKS.register("coke_block",
      () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F)));

}
