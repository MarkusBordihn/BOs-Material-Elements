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

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class ItemRendererHelper {

  protected ItemRendererHelper() {}

  public static void applyItemArmAttackTransform(PoseStack poseStack, HumanoidArm humanoidArm,
      float degree) {
    int flipArmValue = humanoidArm == HumanoidArm.RIGHT ? 1 : -1;

    float f = Mth.sin(degree * degree * (float) Math.PI);
    poseStack.mulPose(Vector3f.YP.rotationDegrees(flipArmValue * (45.0F + f * -20.0F)));

    float f1 = Mth.sin(Mth.sqrt(degree) * (float) Math.PI);
    poseStack.mulPose(Vector3f.ZP.rotationDegrees(flipArmValue * f1 * -20.0F));
    poseStack.mulPose(Vector3f.XP.rotationDegrees(f1 * -80.0F));
    poseStack.mulPose(Vector3f.YP.rotationDegrees(flipArmValue * -45.0F));
  }

  public static void applyItemArmTransform(PoseStack poseStack, HumanoidArm humanoidArm,
      float yPadding) {
    poseStack.translate((humanoidArm == HumanoidArm.RIGHT ? 1 : -1) * 0.56F,
        -0.52F + yPadding * -0.6F, -0.72F);
  }

  public static void renderItem(LivingEntity livingEntity, ItemStack itemStack,
      ItemTransforms.TransformType transformType, boolean flipArm, PoseStack poseStack,
      MultiBufferSource buffers, int lightValue) {
    if (itemStack.isEmpty()) {
      return;
    }
    Minecraft minecraft = Minecraft.getInstance();
    if (minecraft == null) {
      return;
    }
    minecraft.getItemRenderer().renderStatic(livingEntity, itemStack, transformType, flipArm,
        poseStack, buffers, livingEntity.level, lightValue, OverlayTexture.NO_OVERLAY,
        livingEntity.getId() + transformType.ordinal());
  }

  public static int getLightLevel(ClientLevel level, LocalPlayer player) {
    if (level.canSeeSky(player.blockPosition())) {
      return (level.getDayTime()
          % net.minecraft.world.level.Level.TICKS_PER_DAY < net.minecraft.world.level.Level.TICKS_PER_DAY
              / 2) ? 255 : 64;
    }
    return 16 + (int) (player.getBrightness() * 239);
  }

}
