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

package de.markusbordihn.minecraft.materialelementsdecorative.utils;

import java.util.Optional;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;

import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ItemHandlerUtils {

  protected ItemHandlerUtils() {}

  public static boolean isItemHandler(BlockEntity blockEntity, Direction direction) {
    return blockEntity != null && direction != null && blockEntity
        .getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, direction).isPresent();
  }

  public static IItemHandler getItemHandler(BlockEntity blockEntity, Direction direction) {
    if (!isItemHandler(blockEntity, direction)) {
      return null;
    }
    Optional<IItemHandler> capability = blockEntity
        .getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, direction).resolve();
    if (capability.isPresent()) {
      return capability.get();
    }
    return null;
  }

}
