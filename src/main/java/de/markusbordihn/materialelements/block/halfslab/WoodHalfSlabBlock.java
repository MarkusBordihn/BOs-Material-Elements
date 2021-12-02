package de.markusbordihn.materialelements.block.halfslab;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class WoodHalfSlabBlock extends HalfSlabBlock {

  public WoodHalfSlabBlock(MaterialColor materialColor) {
    super(BlockBehaviour.Properties.of(Material.WOOD, materialColor).strength(1.5F, 3.0F)
        .sound(SoundType.WOOD));
  }

  @Override
  // Called when fire is updating, checks if a block face can catch fire.
  public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
    return true;
  }

  @Override
  // Chance that fire will spread and consume this block. 300 being a 100% chance
  public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
    return 100;
  }

}
