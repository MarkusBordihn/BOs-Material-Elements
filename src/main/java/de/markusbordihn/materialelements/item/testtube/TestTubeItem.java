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

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import de.markusbordihn.materialelements.item.ModItems;

public class TestTubeItem extends GlassBottleItem {

  public TestTubeItem(Item.Properties properties) {
    super(properties);
  }

  @Override
  public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
    List<AreaEffectCloudEntity> list = world.getEntitiesOfClass(AreaEffectCloudEntity.class,
        player.getBoundingBox().inflate(2.0D), (areaEffectCloud) -> {
          return areaEffectCloud != null && areaEffectCloud.isAlive()
              && areaEffectCloud.getOwner() instanceof EnderDragonEntity;
        });
    ItemStack itemStack = player.getItemInHand(hand);
    if (!list.isEmpty()) {
      AreaEffectCloudEntity areaEffectCloud = list.get(0);
      areaEffectCloud.setRadius(areaEffectCloud.getRadius() - 0.5F);
      world.playSound((PlayerEntity) null, player.getX(), player.getY(), player.getZ(),
          SoundEvents.BOTTLE_FILL_DRAGONBREATH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
      return ActionResult.sidedSuccess(
          this.turnBottleIntoItem(itemStack, player, new ItemStack(Items.DRAGON_BREATH)),
          world.isClientSide());
    } else {
      RayTraceResult hitResult = getPlayerPOVHitResult(world, player,
          RayTraceContext.FluidMode.SOURCE_ONLY);
      if (hitResult.getType() == RayTraceResult.Type.MISS) {
        return ActionResult.pass(itemStack);
      } else {
        if (hitResult.getType() == RayTraceResult.Type.BLOCK) {
          BlockPos blockPos = ((BlockRayTraceResult) hitResult).getBlockPos();
          if (!world.mayInteract(player, blockPos)) {
            return ActionResult.pass(itemStack);
          }
          if (world.getFluidState(blockPos).is(FluidTags.WATER)) {
            world.playSound(player, player.getX(), player.getY(), player.getZ(),
                SoundEvents.BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            return ActionResult.sidedSuccess(
                this.turnBottleIntoItem(itemStack, player, PotionUtils
                    .setPotion(new ItemStack(ModItems.TEST_TUBE_WATER.get()), Potions.WATER)),
                world.isClientSide());
          }
        }
        return ActionResult.pass(itemStack);
      }
    }
  }

}
