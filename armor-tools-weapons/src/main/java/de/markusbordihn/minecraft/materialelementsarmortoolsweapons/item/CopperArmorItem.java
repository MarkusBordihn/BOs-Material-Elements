/**
 * Copyright 2022 Markus Bordihn
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import de.markusbordihn.minecraft.materialelements.item.material.ModArmorMaterials;
import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.Constants;

public class CopperArmorItem extends ArmorItem {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  private static int MATERIAL_CHECK_TICK = 35;

  private int ticker = 0;
  private ArmorMaterial armorMaterial = ModArmorMaterials.COPPER;

  public CopperArmorItem(EquipmentSlot equipmentSlot) {
    super(ModArmorMaterials.COPPER, equipmentSlot,
        (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT));
  }

  @Override
  public void onArmorTick(ItemStack itemStack, Level level, Player player) {
    if (ticker++ >= MATERIAL_CHECK_TICK) {
      int damageValue = itemStack.getDamageValue();
      if (damageValue >= 150) {
        this.armorMaterial = ModArmorMaterials.COPPER_OXIDIZED;
      } else if (damageValue >= 100) {
        this.armorMaterial = ModArmorMaterials.COPPER_WEATHERED;
      } else if (damageValue >= 50) {
        this.armorMaterial = ModArmorMaterials.COPPER_EXPOSED;
      } else {
        this.armorMaterial = ModArmorMaterials.COPPER;
      }
      ticker = 0;
    }
    super.onArmorTick(itemStack, level, player);
  }

  @Override
  public int getEnchantmentValue() {
    return this.armorMaterial.getEnchantmentValue();
  }

  @Override
  public ArmorMaterial getMaterial() {
    return this.armorMaterial;
  }

  @Override
  public boolean isValidRepairItem(ItemStack itemStack, ItemStack repairItemStack) {
    return this.armorMaterial.getRepairIngredient().test(repairItemStack)
        || super.isValidRepairItem(itemStack, repairItemStack);
  }

}
