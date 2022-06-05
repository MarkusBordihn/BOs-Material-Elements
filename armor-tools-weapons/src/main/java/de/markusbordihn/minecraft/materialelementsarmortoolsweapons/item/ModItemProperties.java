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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.Constants;

public class ModItemProperties {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  private static final ResourceLocation DAMAGED_PROPERTY =
      new ResourceLocation(Constants.MOD_ID, "damaged");

  protected ModItemProperties() {}

  public static void registerItemProperties(final FMLClientSetupEvent event) {
    log.info("{} item properties ...", Constants.LOG_REGISTER_PREFIX);
    event.enqueueWork(() -> {

      // Copper Items
      ItemProperties.register(ModItems.COPPER_AXE.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);
      ItemProperties.register(ModItems.COPPER_BOOTS.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);
      ItemProperties.register(ModItems.COPPER_CHESTPLATE.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);
      ItemProperties.register(ModItems.COPPER_HELMET.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);
      ItemProperties.register(ModItems.COPPER_HOE.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);
      ItemProperties.register(ModItems.COPPER_LEGGINGS.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);
      ItemProperties.register(ModItems.COPPER_PICKAXE.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);
      ItemProperties.register(ModItems.COPPER_SHEARS.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);
      ItemProperties.register(ModItems.COPPER_SHOVEL.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);
      ItemProperties.register(ModItems.COPPER_SWORD.get(), DAMAGED_PROPERTY,
          ModItemProperties::getWeatheringCopperState);

      // Copper Crossbow (pull, pulling, charged and firework)
      ItemProperties.register(ModItems.COPPER_CROSSBOW.get(),
          new ResourceLocation(Constants.MOD_ID, "pull"),
          (itemStack, clientLevel, livingEntity,
              id) -> livingEntity == null || CrossbowItem.isCharged(itemStack) ? 0.0F
                  : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks())
                      / (float) CrossbowItem.getChargeDuration(itemStack)

      );
      ItemProperties.register(ModItems.COPPER_CROSSBOW.get(),
          new ResourceLocation(Constants.MOD_ID, "pulling"),
          (itemStack, clientLevel, livingEntity,
              id) -> livingEntity != null && livingEntity.isUsingItem()
                  && livingEntity.getUseItem() == itemStack && !CrossbowItem.isCharged(itemStack)
                      ? 1.0F
                      : 0.0F);
      ItemProperties.register(ModItems.COPPER_CROSSBOW.get(),
          new ResourceLocation(Constants.MOD_ID, "charged"), (itemStack, clientLevel, livingEntity,
              id) -> livingEntity != null && CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F);
      ItemProperties.register(ModItems.COPPER_CROSSBOW.get(),
          new ResourceLocation(Constants.MOD_ID, "firework"),
          (itemStack, clientLevel, livingEntity,
              id) -> livingEntity != null && CrossbowItem.isCharged(itemStack)
                  && CrossbowItem.containsChargedProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F
                      : 0.0F);

      // Copper Lighter (open)
      ItemProperties.register(ModItems.COPPER_LIGHTER.get(),
          new ResourceLocation(Constants.MOD_ID, "open"),
          (itemStack, clientLevel, livingEntity,
              id) -> (livingEntity == null || !itemStack.is(ModItems.COPPER_LIGHTER.get())
                  || livingEntity.getMainHandItem().isEmpty()
                  || itemStack != livingEntity.getMainHandItem()) ? 0.0F : 1.0F);

      // Steel Crossbow (pull, pulling, charged and firework)
      ItemProperties.register(ModItems.STEEL_CROSSBOW.get(),
          new ResourceLocation(Constants.MOD_ID, "pull"),
          (itemStack, clientLevel, livingEntity,
              id) -> livingEntity == null || CrossbowItem.isCharged(itemStack) ? 0.0F
                  : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks())
                      / (float) CrossbowItem.getChargeDuration(itemStack)

      );
      ItemProperties.register(ModItems.STEEL_CROSSBOW.get(),
          new ResourceLocation(Constants.MOD_ID, "pulling"),
          (itemStack, clientLevel, livingEntity,
              id) -> livingEntity != null && livingEntity.isUsingItem()
                  && livingEntity.getUseItem() == itemStack && !CrossbowItem.isCharged(itemStack)
                      ? 1.0F
                      : 0.0F);
      ItemProperties.register(ModItems.STEEL_CROSSBOW.get(),
          new ResourceLocation(Constants.MOD_ID, "charged"), (itemStack, clientLevel, livingEntity,
              id) -> livingEntity != null && CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F);
      ItemProperties.register(ModItems.STEEL_CROSSBOW.get(),
          new ResourceLocation(Constants.MOD_ID, "firework"),
          (itemStack, clientLevel, livingEntity,
              id) -> livingEntity != null && CrossbowItem.isCharged(itemStack)
                  && CrossbowItem.containsChargedProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F
                      : 0.0F);

      // Steel Lighter (open)
      ItemProperties.register(ModItems.STEEL_LIGHTER.get(),
          new ResourceLocation(Constants.MOD_ID, "open"),
          (itemStack, clientLevel, livingEntity,
              id) -> (livingEntity == null || !itemStack.is(ModItems.STEEL_LIGHTER.get())
                  || livingEntity.getMainHandItem().isEmpty()
                  || itemStack != livingEntity.getMainHandItem()) ? 0.0F : 1.0F);

    });
  }

  public static final float getWeatheringCopperState(ItemStack itemStack, ClientLevel clientLevel,
      LivingEntity livingEntity, int id) {
    int damageValue = itemStack.getDamageValue();
    if (damageValue >= 150) {
      return 0.75F;
    } else if (damageValue >= 100) {
      return 0.5F;
    } else if (damageValue >= 50) {
      return 0.25F;
    }
    return 0.0F;
  }

}
