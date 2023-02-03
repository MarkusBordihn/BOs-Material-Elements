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

package de.markusbordihn.minecraft.materialelements.item.testtube;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import de.markusbordihn.minecraft.materialelements.item.ModItems;

public class TestTubeFilledItem extends PotionItem {

  public TestTubeFilledItem(Item.Properties properties) {
    super(properties);
  }

  public TestTubeFilledItem() {
    super(new Item.Properties());
  }

  @Override
  public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
    Player player = livingEntity instanceof Player ? (Player) livingEntity : null;
    if (player instanceof ServerPlayer serverPlayer) {
      CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
    }

    if (!level.isClientSide) {
      for (MobEffectInstance mobEffectInstance : PotionUtils.getMobEffects(itemStack)) {
        if (mobEffectInstance.getEffect().isInstantenous()) {
          mobEffectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity,
              mobEffectInstance.getAmplifier(), 1.0D);
        } else {
          livingEntity.addEffect(new MobEffectInstance(mobEffectInstance));
        }
      }
    }

    if (player != null) {
      player.awardStat(Stats.ITEM_USED.get(this));
      if (!player.getAbilities().instabuild) {
        itemStack.shrink(1);
      }
    }

    if (player == null || !player.getAbilities().instabuild) {
      if (itemStack.isEmpty()) {
        return new ItemStack(ModItems.TEST_TUBE.get());
      }

      if (player != null) {
        player.getInventory().add(new ItemStack(ModItems.TEST_TUBE.get()));
      }
    }

    livingEntity.gameEvent(GameEvent.DRINK);
    return itemStack;
  }

}
