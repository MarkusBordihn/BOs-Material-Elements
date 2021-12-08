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

package de.markusbordihn.materialelements.item.testtube;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.NonNullList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import de.markusbordihn.materialelements.item.ModItems;

public class TestTubeFilledItem extends PotionItem {

  public TestTubeFilledItem(Item.Properties properties) {
    super(properties);
  }

  @Override
  public ItemStack finishUsingItem(ItemStack itemStack, World world, LivingEntity livingEntity) {
    PlayerEntity player = livingEntity instanceof PlayerEntity ? (PlayerEntity) livingEntity : null;
    if (player instanceof ServerPlayerEntity) {
      CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) player, itemStack);
    }

    if (!world.isClientSide) {
      for (EffectInstance effectInstance : PotionUtils.getMobEffects(itemStack)) {
        if (effectInstance.getEffect().isInstantenous()) {
          effectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity,
              effectInstance.getAmplifier(), 1.0D);
        } else {
          livingEntity.addEffect(new EffectInstance(effectInstance));
        }
      }
    }

    if (player != null) {
      player.awardStat(Stats.ITEM_USED.get(this));
      if (!player.abilities.instabuild) {
        itemStack.shrink(1);
      }
    }

    if (player == null || !player.abilities.instabuild) {
      if (itemStack.isEmpty()) {
        return new ItemStack(ModItems.TEST_TUBE.get());
      }

      if (player != null) {
        player.inventory.add(new ItemStack(ModItems.TEST_TUBE.get()));
      }
    }

    return itemStack;
  }

  @Override
  public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> itemStack) {
    if (this.allowdedIn(tab)) {
      for (Potion potion : Registry.POTION) {
        // Filter out water potion, because we want to have this as separate item.
        if (potion != Potions.EMPTY && potion != Potions.WATER) {
          itemStack.add(PotionUtils.setPotion(new ItemStack(this), potion));
        }
      }
    }
  }

}
