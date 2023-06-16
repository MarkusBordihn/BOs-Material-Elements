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

package de.markusbordihn.minecraft.materialelementsarmortoolsweapons.item;

import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.minecraft.materialelements.item.material.ModArmorMaterials;
import de.markusbordihn.minecraft.materialelements.item.material.ModTiers;
import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.Annotations.TemplateEntryPoint;
import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.Constants;

public class ModItems {

  protected ModItems() {}

  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  @TemplateEntryPoint("Register Items")

  // Copper Weapons
  public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",
      () -> new SwordItem(ModTiers.COPPER, 3, -2.4F, (new Item.Properties())));

  public static final RegistryObject<Item> COPPER_CROSSBOW = ITEMS.register("copper_crossbow",
      () -> new CrossbowItem((new Item.Properties()).stacksTo(1).durability(375)));

  // Copper Tools
  public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
      () -> new ShovelItem(ModTiers.COPPER, 1.5F, -3.0F, (new Item.Properties())));

  public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
      () -> new PickaxeItem(ModTiers.COPPER, 1, -2.8F, (new Item.Properties())));

  public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",
      () -> new AxeItem(ModTiers.COPPER, 6.0F, -3.1F, (new Item.Properties())));

  public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
      () -> new HoeItem(ModTiers.COPPER, -2, -1.0F, (new Item.Properties())));

  public static final RegistryObject<Item> COPPER_SHEARS = ITEMS.register("copper_shears",
      () -> new ShearsItem((new Item.Properties()).durability(330)));

  // Copper Lighter
  public static final RegistryObject<Item> COPPER_LIGHTER = ITEMS.register("copper_lighter",
      () -> new FlintAndSteelItem((new Item.Properties()).durability(84)));

  // Copper Armor
  public static final RegistryObject<Item> COPPER_BOOTS =
      ITEMS.register("copper_boots", () -> new CopperArmorItem(ArmorItem.Type.BOOTS));

  public static final RegistryObject<Item> COPPER_HELMET =
      ITEMS.register("copper_helmet", () -> new CopperArmorItem(ArmorItem.Type.HELMET));

  public static final RegistryObject<Item> COPPER_LEGGINGS =
      ITEMS.register("copper_leggings", () -> new CopperArmorItem(ArmorItem.Type.LEGGINGS));

  public static final RegistryObject<Item> COPPER_CHESTPLATE =
      ITEMS.register("copper_chestplate", () -> new CopperArmorItem(ArmorItem.Type.CHESTPLATE));


  // Steel Weapons
  public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
      () -> new SwordItem(ModTiers.STEEL, 3, -2.4F, (new Item.Properties())));

  public static final RegistryObject<Item> STEEL_CROSSBOW = ITEMS.register("steel_crossbow",
      () -> new CrossbowItem((new Item.Properties()).stacksTo(1).durability(435)));

  // Steel Tools
  public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
      () -> new ShovelItem(ModTiers.STEEL, 1.5F, -3.0F, (new Item.Properties())));

  public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
      () -> new PickaxeItem(ModTiers.STEEL, 1, -2.8F, (new Item.Properties())));

  public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
      () -> new AxeItem(ModTiers.STEEL, 6.0F, -3.1F, (new Item.Properties())));

  public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
      () -> new HoeItem(ModTiers.STEEL, -2, -1.0F, (new Item.Properties())));

  public static final RegistryObject<Item> STEEL_SHEARS =
      ITEMS.register("steel_shears", () -> new ShearsItem((new Item.Properties()).durability(330)));

  // Steel Lighter
  public static final RegistryObject<Item> STEEL_LIGHTER = ITEMS.register("steel_lighter",
      () -> new FlintAndSteelItem((new Item.Properties()).durability(84)));

  // Steel Armor
  public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
      () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, (new Item.Properties())));

  public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
      () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, (new Item.Properties())));

  public static final RegistryObject<Item> STEEL_LEGGINGS =
      ITEMS.register("steel_leggings", () -> new ArmorItem(ModArmorMaterials.STEEL,
          ArmorItem.Type.LEGGINGS, (new Item.Properties())));

  public static final RegistryObject<Item> STEEL_CHESTPLATE =
      ITEMS.register("steel_chestplate", () -> new ArmorItem(ModArmorMaterials.STEEL,
          ArmorItem.Type.CHESTPLATE, (new Item.Properties())));

}
