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

package de.markusbordihn.materialelements.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import de.markusbordihn.materialelements.Constants;
import de.markusbordihn.materialelements.block.ModBlocks;
import de.markusbordihn.materialelements.Annotations.TemplateEntryPoint;

public class ModItems {

  protected ModItems() {

  }

  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  @TemplateEntryPoint("Register Items")
  public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
  public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
  public static final RegistryObject<Item> COKE = ITEMS.register("coke",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
      () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

  @TemplateEntryPoint("Register Block Items")
  public static final RegistryObject<Item> STEEL_ORE =
      ITEMS.register("steel_ore", () -> new BlockItem(ModBlocks.STEEL_ORE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}
