package de.markusbordihn.materialelements.block.halfslab;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class WoodHalfSlabBlock extends HalfSlabBlock {

  public WoodHalfSlabBlock(MaterialColor materialColor) {
    super(AbstractBlock.Properties.of(Material.WOOD, materialColor).strength(1.5F, 3.0F)
        .sound(SoundType.WOOD));
  }
}
