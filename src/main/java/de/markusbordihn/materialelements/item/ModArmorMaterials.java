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

package de.markusbordihn.materialelements.item;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import de.markusbordihn.materialelements.Constants;

public enum ModArmorMaterials implements IArmorMaterial {
  STEEL(new ResourceLocation(Constants.MOD_ID, "steel").toString(), 20, new int[] {2, 5, 7, 2}, 9,
      SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> {
        return Ingredient.of(ModItems.STEEL_INGOT.get());
      });

  private static final int[] HEALTH_PER_SLOT = new int[] {13, 15, 16, 11};
  private final String name;
  private final int durabilityMultiplier;
  private final int[] slotProtections;
  private final int enchantmentValue;
  private final SoundEvent sound;
  private final float toughness;
  private final float knockbackResistance;
  private final LazyValue<Ingredient> repairIngredient;

  private ModArmorMaterials(String name, int maxDamageFactor, int[] damageReductionAmountArray,
      int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance,
      Supplier<Ingredient> repairMaterial) {
    this.name = name;
    this.durabilityMultiplier = maxDamageFactor;
    this.slotProtections = damageReductionAmountArray;
    this.enchantmentValue = enchantability;
    this.sound = soundEvent;
    this.toughness = toughness;
    this.knockbackResistance = knockbackResistance;
    this.repairIngredient = new LazyValue<>(repairMaterial);
  }

  public int getDurabilityForSlot(EquipmentSlotType slotIn) {
    return HEALTH_PER_SLOT[slotIn.getIndex()] * this.durabilityMultiplier;
  }

  public int getDefenseForSlot(EquipmentSlotType slotIn) {
    return this.slotProtections[slotIn.getIndex()];
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

  @OnlyIn(Dist.CLIENT)
  public String getName() {
    return this.name;
  }

  public float getToughness() {
    return this.toughness;
  }

  public float getKnockbackResistance() {
    return this.knockbackResistance;
  }
}
