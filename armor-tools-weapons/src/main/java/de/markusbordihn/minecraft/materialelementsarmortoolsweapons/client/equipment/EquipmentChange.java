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

package de.markusbordihn.minecraft.materialelementsarmortoolsweapons.client.equipment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.Constants;
import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.item.ModItems;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class EquipmentChange {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected EquipmentChange() {}

  @SubscribeEvent
  public static void handleLivingEquipmentChangeEvent(LivingEquipmentChangeEvent event) {
    Minecraft minecraft = Minecraft.getInstance();
    if (minecraft == null || minecraft.player == null) {
      return;
    }
    ItemStack itemStackTo = event.getTo();

    // Plays sound for select the steel lighter
    if (itemStackTo.is(ModItems.STEEL_LIGHTER.get())) {
      minecraft.player.playSound(SoundEvents.METAL_HIT, 0.5f, 0.5f);
      minecraft.player.playSound(SoundEvents.FIRE_AMBIENT, 1.0f, 1.0f);
    }
  }
}
