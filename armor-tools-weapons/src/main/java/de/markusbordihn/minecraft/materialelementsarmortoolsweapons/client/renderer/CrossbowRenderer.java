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

package de.markusbordihn.minecraft.materialelementsarmortoolsweapons.client.renderer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.Constants;
import de.markusbordihn.minecraft.materialelementsarmortoolsweapons.item.ModItems;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class CrossbowRenderer {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected CrossbowRenderer() {}

  @SubscribeEvent
  public static void handleRenderHandEvent(RenderHandEvent event) {
    ItemStack itemStack = event.getItemStack();
    Minecraft minecraft = Minecraft.getInstance();
    // Early return for all items which are not a steel crossbow item.
    if (!isValidItemStack(itemStack) || minecraft == null) {
      return;
    }

    // Get needed details from the render event.
    PoseStack poseStack = event.getPoseStack();
    MultiBufferSource buffers = event.getMultiBufferSource();
    InteractionHand interactionHand = event.getHand();
    LocalPlayer localPlayer = minecraft.player;
    ClientLevel clientLevel = minecraft.level;

    // Simple and cheap light value calculation, it's not perfect but works in most cases.
    int lightLevel = ItemRendererHelper.getLightLevel(clientLevel, localPlayer);

    // Only overwrite the event if player is not scoping and not swinging.
    if (!localPlayer.isScoping() && !localPlayer.swinging) {
      poseStack.pushPose();
      HumanoidArm humanoidArm =
          interactionHand == InteractionHand.MAIN_HAND ? localPlayer.getMainArm()
              : localPlayer.getMainArm().getOpposite();
      renderArmWithCrossbow(localPlayer, interactionHand, itemStack, poseStack, buffers,
          humanoidArm, lightLevel);
      poseStack.popPose();
      event.setCanceled(true);
    }
  }

  @SubscribeEvent
  public static void handleRenderPlayerEvent(RenderPlayerEvent.Pre event) {
    Player player = event.getPlayer();
    ItemStack itemStack = player.getMainHandItem();
    // Show correct 3rd person arm pose for charged crossbow.
    if (isValidItemStack(itemStack) && !player.swinging
        && CrossbowItem.isCharged(itemStack)) {
      PlayerRendererHelper.setArmPose(event.getRenderer(), HumanoidModel.ArmPose.CROSSBOW_HOLD);
    }
  }

  private static void renderArmWithCrossbow(LocalPlayer localPlayer,
      InteractionHand interactionHand, ItemStack itemStack, PoseStack poseStack,
      MultiBufferSource buffers, HumanoidArm humanoidArm, int lightValue) {
    boolean isRightArm = humanoidArm == HumanoidArm.RIGHT;
    int flipArmValue = isRightArm ? 1 : -1;
    if (localPlayer.isUsingItem() && localPlayer.getUseItemRemainingTicks() > 0
        && localPlayer.getUsedItemHand() == interactionHand) {
      // Handle the charge animation
      ItemRendererHelper.applyItemArmTransform(poseStack, humanoidArm, 0);
      poseStack.translate(flipArmValue * -0.4785682F, -0.094387F, 0.05731531F);
      poseStack.mulPose(Vector3f.XP.rotationDegrees(-11.935F));
      poseStack.mulPose(Vector3f.YP.rotationDegrees(flipArmValue * 65.3F));
      poseStack.mulPose(Vector3f.ZP.rotationDegrees(flipArmValue * -9.785F));
      float f9 = itemStack.getUseDuration() - (localPlayer.getUseItemRemainingTicks() - 0 + 1.0F);
      float f13 = f9 / CrossbowItem.getChargeDuration(itemStack);
      if (f13 > 1.0F) {
        f13 = 1.0F;
      }
      if (f13 > 0.1F) {
        float f4 = (Mth.sin((f9 - 0.1F) * 1.3F)) * (f13 - 0.1F);
        poseStack.translate(0.0F, f4 * 0.004F, 0.0F);
      }
      poseStack.translate(0.0F, 0.0F, f13 * 0.04F);
      poseStack.scale(1.0F, 1.0F, 1.0F + f13 * 0.2F);
      poseStack.mulPose(Vector3f.YN.rotationDegrees(flipArmValue * 45.0F));
    } else {
      ItemRendererHelper.applyItemArmTransform(poseStack, humanoidArm, 0);
      ItemRendererHelper.applyItemArmAttackTransform(poseStack, humanoidArm, 0);

      // Charged crossbow will be displayed in the middle of the screen.
      if (CrossbowItem.isCharged(itemStack) && 0 < 0.001F
          && interactionHand == InteractionHand.MAIN_HAND) {
        poseStack.translate(flipArmValue * -0.641864F, 0.0D, 0.0D);
        poseStack.mulPose(Vector3f.YP.rotationDegrees(flipArmValue * 10.0F));
      }
    }

    // Render the crossbow with former modifications.
    ItemRendererHelper.renderItem(localPlayer, itemStack,
        isRightArm ? ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND
            : ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND,
        !isRightArm, poseStack, buffers, lightValue);
  }

  private static boolean isValidItemStack(ItemStack itemStack) {
    return itemStack != null && (itemStack.is(ModItems.STEEL_CROSSBOW.get())
        || itemStack.is(ModItems.COPPER_CROSSBOW.get()));
  }

}
