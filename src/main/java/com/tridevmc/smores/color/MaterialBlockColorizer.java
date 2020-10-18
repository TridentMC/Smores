package com.tridevmc.smores.color;

import com.tridevmc.smores.block.MaterialBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

import javax.annotation.Nullable;

public class MaterialBlockColorizer implements IBlockColor {
    @Override
    public int getColor(BlockState state, @Nullable IBlockDisplayReader light, @Nullable BlockPos pos, int tintIndex) {
       if(tintIndex == ((MaterialBlock)state.getBlock()).getTintIndexLayer()) {
            Block block = state.getBlock();
            if (block instanceof MaterialBlock) {
                MaterialBlock mat = (MaterialBlock) block;
                return mat.materialProperties.getColour();
            }
        }
        return -1;
    }
}
