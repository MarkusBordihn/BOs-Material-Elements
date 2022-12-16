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

package de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.item.ItemStack;

import net.minecraftforge.items.wrapper.InvWrapper;

import de.markusbordihn.minecraft.materialelementsdecorative.Constants;
import de.markusbordihn.minecraft.materialelementsdecorative.block.framedhopper.entity.FramedHopperBlockEntity;

public class FramedHopperItemHandler extends InvWrapper {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  private final FramedHopperBlockEntity hopper;

  public FramedHopperItemHandler(FramedHopperBlockEntity hopper) {
    super(hopper);
    this.hopper = hopper;
  }

  @Override
  @NotNull
  public ItemStack insertItem(int slot, @NotNull ItemStack itemStack, boolean simulate) {
    if (simulate) {
      return super.insertItem(slot, itemStack, simulate);
    } else {
      boolean wasEmpty = getInv().isEmpty();
      int originalStackSize = itemStack.getCount();
      itemStack = super.insertItem(slot, itemStack, simulate);
      if (wasEmpty && originalStackSize > itemStack.getCount() && !hopper.isOnCustomCooldown()) {
        hopper.setCooldown(8);
      }
      return itemStack;
    }
  }

}
