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

package de.markusbordihn.minecraft.materialelements.item.material;

import java.util.EnumMap;
import java.util.function.Supplier;

import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import de.markusbordihn.minecraft.materialelements.Constants;
import de.markusbordihn.minecraft.materialelements.item.ModItems;

public enum ModArmorMaterials implements ArmorMaterial {

  COPPER(new ResourceLocation(Constants.MOD_ID, "copper").toString(), 10,
      Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItemType) -> {
        armorItemType.put(ArmorItem.Type.BOOTS, 2);
        armorItemType.put(ArmorItem.Type.LEGGINGS, 4);
        armorItemType.put(ArmorItem.Type.CHESTPLATE, 5);
        armorItemType.put(ArmorItem.Type.HELMET, 2);
      }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(Items.COPPER_INGOT)),

  COPPER_EXPOSED(new ResourceLocation(Constants.MOD_ID, "copper_exposed").toString(), 10,
      Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItemType) -> {
        armorItemType.put(ArmorItem.Type.BOOTS, 2);
        armorItemType.put(ArmorItem.Type.LEGGINGS, 4);
        armorItemType.put(ArmorItem.Type.CHESTPLATE, 5);
        armorItemType.put(ArmorItem.Type.HELMET, 2);
      }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(Items.COPPER_INGOT)),

  COPPER_OXIDIZED(new ResourceLocation(Constants.MOD_ID, "copper_oxidized").toString(), 10,
      Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItemType) -> {
        armorItemType.put(ArmorItem.Type.BOOTS, 2);
        armorItemType.put(ArmorItem.Type.LEGGINGS, 4);
        armorItemType.put(ArmorItem.Type.CHESTPLATE, 5);
        armorItemType.put(ArmorItem.Type.HELMET, 2);
      }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(Items.COPPER_INGOT)),

  COPPER_WEATHERED(new ResourceLocation(Constants.MOD_ID, "copper_weathered").toString(), 10,
      Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItemType) -> {
        armorItemType.put(ArmorItem.Type.BOOTS, 2);
        armorItemType.put(ArmorItem.Type.LEGGINGS, 4);
        armorItemType.put(ArmorItem.Type.CHESTPLATE, 5);
        armorItemType.put(ArmorItem.Type.HELMET, 2);
      }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(Items.COPPER_INGOT)),

  STEEL(new ResourceLocation(Constants.MOD_ID, "steel").toString(), 20,
      Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItemType) -> {
        armorItemType.put(ArmorItem.Type.BOOTS, 2);
        armorItemType.put(ArmorItem.Type.LEGGINGS, 5);
        armorItemType.put(ArmorItem.Type.CHESTPLATE, 7);
        armorItemType.put(ArmorItem.Type.HELMET, 2);
      }), 9, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.5F,
      () -> Ingredient.of(ModItems.STEEL_INGOT.get()));

  private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE =
      Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItemType) -> {
        armorItemType.put(ArmorItem.Type.BOOTS, 13);
        armorItemType.put(ArmorItem.Type.LEGGINGS, 15);
        armorItemType.put(ArmorItem.Type.CHESTPLATE, 16);
        armorItemType.put(ArmorItem.Type.HELMET, 11);
      });
  private final String name;
  private final int durabilityMultiplier;
  private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
  private final int enchantmentValue;
  private final SoundEvent sound;
  private final float toughness;
  private final float knockbackResistance;
  private final LazyLoadedValue<Ingredient> repairIngredient;

  private ModArmorMaterials(String name, int durability,
      EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantmentValue,
      SoundEvent soundEvent, float toughness, float knockbackResistance,
      Supplier<Ingredient> ingredient) {
    this.name = name;
    this.durabilityMultiplier = durability;
    this.protectionFunctionForType = protectionFunctionForType;
    this.enchantmentValue = enchantmentValue;
    this.sound = soundEvent;
    this.toughness = toughness;
    this.knockbackResistance = knockbackResistance;
    this.repairIngredient = new LazyLoadedValue<>(ingredient);
  }

  public int getDurabilityForType(ArmorItem.Type armorItemType) {
    return HEALTH_FUNCTION_FOR_TYPE.get(armorItemType) * this.durabilityMultiplier;
  }

  public int getDefenseForType(ArmorItem.Type armorItemType) {
    return this.protectionFunctionForType.get(armorItemType);
  }

  public int getEnchantmentValue() {
    return this.enchantmentValue;
  }

  public SoundEvent getEquipSound() {
    return this.sound;
  }

  public Ingredient getRepairIngredient() {
    return this.repairIngredient.get();
  }

  public String getName() {
    return this.name;
  }

  public float getToughness() {
    return this.toughness;
  }

  public float getKnockbackResistance() {
    return this.knockbackResistance;
  }

  public String getSerializedName() {
    return this.name;
  }
}
