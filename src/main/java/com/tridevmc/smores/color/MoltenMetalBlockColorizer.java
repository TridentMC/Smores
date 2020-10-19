package com.tridevmc.smores.color;

import com.tridevmc.smores.block.MaterialBlock;
import com.tridevmc.smores.block.MoltenMetalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

import javax.annotation.Nullable;

public class MoltenMetalBlockColorizer implements IBlockColor {
    @Override
    public int getColor(BlockState state, @Nullable IBlockDisplayReader light, @Nullable BlockPos pos, int tintIndex) {
        Block block = state.getBlock();
        if (block instanceof MoltenMetalBlock) {
            MoltenMetalBlock mat = (MoltenMetalBlock) block;
            if(tintIndex == 0) {
                return mat.materialProperties.getColour();
            }
        }
        return -1;
    }
}
