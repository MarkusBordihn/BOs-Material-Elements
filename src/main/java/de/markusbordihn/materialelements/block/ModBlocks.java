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
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.materialelements.Constants;
import de.markusbordihn.materialelements.Annotations.TemplateEntryPoint;
import de.markusbordihn.materialelements.block.plate.*;
import de.markusbordihn.materialelements.block.rod.*;

public class ModBlocks {

  protected ModBlocks() {

  }

  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

  @TemplateEntryPoint("Register Blocks")

  // Plates
  public static final RegistryObject<Block> OAK_PLATE =
      BLOCKS
          .register("oak_plate",
              () -> new WoodPlateBlock(BlockBehaviour.Properties
                  .of(Material.WOOD, Blocks.OAK_PLANKS.defaultMaterialColor()).strength(1.5F, 3.0F)
                  .sound(SoundType.WOOD)));

  // Rods (tee)
  public static final RegistryObject<Block> COPPER_ROD_TEE = BLOCKS.register("copper_rod_tee",
      () -> new RodTee(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
  public static final RegistryObject<Block> GOLD_ROD_TEE = BLOCKS.register("gold_rod_tee",
      () -> new RodTee(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> IRON_ROD_TEE = BLOCKS.register("iron_rod_tee",
      () -> new RodTee(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> STEEL_ROD_TEE = BLOCKS.register("steel_rod_tee",
      () -> new RodTee(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> NETHERITE_ROD_TEE = BLOCKS.register("netherite_rod_tee",
      () -> new RodTee(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
          .requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));

  // Rods (star)
  public static final RegistryObject<Block> COPPER_ROD_STAR = BLOCKS.register("copper_rod_star",
      () -> new RodStar(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
  public static final RegistryObject<Block> GOLD_ROD_STAR = BLOCKS.register("gold_rod_star",
      () -> new RodStar(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> IRON_ROD_STAR = BLOCKS.register("iron_rod_star",
      () -> new RodStar(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> STEEL_ROD_STAR = BLOCKS.register("steel_rod_star",
      () -> new RodStar(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> NETHERITE_ROD_STAR =
      BLOCKS.register("netherite_rod_star",
          () -> new RodStar(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
              .requiresCorrectToolForDrops().strength(50.0F, 1200.0F)
              .sound(SoundType.NETHERITE_BLOCK)));

  // Rods (cross)
  public static final RegistryObject<Block> COPPER_ROD_CROSS = BLOCKS.register("copper_rod_cross",
      () -> new RodCross(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
  public static final RegistryObject<Block> GOLD_ROD_CROSS = BLOCKS.register("gold_rod_cross",
      () -> new RodCross(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> IRON_ROD_CROSS = BLOCKS.register("iron_rod_cross",
      () -> new RodCross(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> STEEL_ROD_CROSS = BLOCKS.register("steel_rod_cross",
      () -> new RodCross(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> NETHERITE_ROD_CROSS =
      BLOCKS.register("netherite_rod_cross",
          () -> new RodCross(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
              .requiresCorrectToolForDrops().strength(50.0F, 1200.0F)
              .sound(SoundType.NETHERITE_BLOCK)));

  // Rods (half size)
  public static final RegistryObject<Block> COPPER_ROD_HALF_SIZE = BLOCKS.register(
      "copper_rod_half_size",
      () -> new RodHalfSize(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
  public static final RegistryObject<Block> GOLD_ROD_HALF_SIZE =
      BLOCKS.register("gold_rod_half_size",
          () -> new RodHalfSize(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD)
              .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> IRON_ROD_HALF_SIZE =
      BLOCKS.register("iron_rod_half_size",
          () -> new RodHalfSize(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
              .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> STEEL_ROD_HALF_SIZE =
      BLOCKS.register("steel_rod_half_size",
          () -> new RodHalfSize(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
              .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> NETHERITE_ROD_HALF_SIZE =
      BLOCKS.register("netherite_rod_half_size",
          () -> new RodHalfSize(BlockBehaviour.Properties
              .of(Material.METAL, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops()
              .strength(50.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK)));

  // Rods (full-size)
  public static final RegistryObject<Block> COPPER_ROD = BLOCKS.register("copper_rod",
      () -> new Rod(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
  public static final RegistryObject<Block> GOLD_ROD = BLOCKS.register("gold_rod",
      () -> new Rod(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD)
          .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> IRON_ROD = BLOCKS.register("iron_rod",
      () -> new Rod(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> STEEL_ROD = BLOCKS.register("steel_rod",
      () -> new Rod(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> NETHERITE_ROD = BLOCKS.register("netherite_rod",
      () -> new Rod(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
          .requiresCorrectToolForDrops().strength(50.0F, 1200.0F)
          .sound(SoundType.NETHERITE_BLOCK)));

  // Blocks
  public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block",
      () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
          .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));

  // Ore
  public static final RegistryObject<Block> STEEL_ORE =
      BLOCKS.register("steel_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
          .requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
}
