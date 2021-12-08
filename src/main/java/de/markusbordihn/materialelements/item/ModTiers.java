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

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ModTiers implements IItemTier {
  STEEL(2, 500, 7.0F, 2.5F, 14, () -> {
    return Ingredient.of(ModItems.STEEL_INGOT.get());
  });

  private final int level;
  private final int uses;
  private final float speed;
  private final float damage;
  private final int enchantmentValue;
  private final LazyValue<Ingredient> repairIngredient;

  private ModTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn,
      int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
    this.level = harvestLevelIn;
    this.uses = maxUsesIn;
    this.speed = efficiencyIn;
    this.damage = attackDamageIn;
    this.enchantmentValue = enchantabilityIn;
    this.repairIngredient = new LazyValue<>(repairMaterialIn);
  }

  public int getUses() {
    return this.uses;
  }

  public float getSpeed() {
    return this.speed;
  }

  public float getAttackDamageBonus() {
    return this.damage;
  }

  public int getLevel() {
    return this.level;
  }

  public int getEnchantmentValue() {
    return this.enchantmentValue;
  }

  public Ingredient getRepairIngredient() {
    return this.repairIngredient.get();
  }
}
