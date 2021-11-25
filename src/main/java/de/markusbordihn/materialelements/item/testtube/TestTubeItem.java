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

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import de.markusbordihn.materialelements.item.ModItems;

public class TestTubeItem extends BottleItem {

  public TestTubeItem(Item.Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
    List<AreaEffectCloud> list = level.getEntitiesOfClass(AreaEffectCloud.class,
        player.getBoundingBox().inflate(2.0D), (p_40650_) -> {
          return p_40650_ != null && p_40650_.isAlive()
              && p_40650_.getOwner() instanceof EnderDragon;
        });
    ItemStack itemStack = player.getItemInHand(hand);
    if (!list.isEmpty()) {
      AreaEffectCloud areaEffectCloud = list.get(0);
      areaEffectCloud.setRadius(areaEffectCloud.getRadius() - 0.5F);
      level.playSound((Player) null, player.getX(), player.getY(), player.getZ(),
          SoundEvents.BOTTLE_FILL_DRAGONBREATH, SoundSource.NEUTRAL, 1.0F, 1.0F);
      level.gameEvent(player, GameEvent.FLUID_PICKUP, player.blockPosition());
      return InteractionResultHolder.sidedSuccess(
          this.turnBottleIntoItem(itemStack, player, new ItemStack(Items.DRAGON_BREATH)),
          level.isClientSide());
    } else {
      HitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
      if (hitResult.getType() == HitResult.Type.MISS) {
        return InteractionResultHolder.pass(itemStack);
      } else {
        if (hitResult.getType() == HitResult.Type.BLOCK) {
          BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
          if (!level.mayInteract(player, blockPos)) {
            return InteractionResultHolder.pass(itemStack);
          }

          if (level.getFluidState(blockPos).is(FluidTags.WATER)) {
            level.playSound(player, player.getX(), player.getY(), player.getZ(),
                SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
            level.gameEvent(player, GameEvent.FLUID_PICKUP, blockPos);
            return InteractionResultHolder.sidedSuccess(
                this.turnBottleIntoItem(itemStack, player, PotionUtils
                    .setPotion(new ItemStack(ModItems.TEST_TUBE_WATER.get()), Potions.WATER)),
                level.isClientSide());
          }
        }
        return InteractionResultHolder.pass(itemStack);
      }
    }
  }

}
