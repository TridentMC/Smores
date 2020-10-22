package com.tridevmc.smores.client.color;

import com.tridevmc.smores.block.MaterialBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MaterialBlockColorizer implements IBlockColor {
    @Override
    public int getColor(BlockState state, @Nullable IBlockDisplayReader light, @Nullable BlockPos pos, int tintIndex) {
        Block block = state.getBlock();
        if (block instanceof MaterialBlock) {
            MaterialBlock mat = (MaterialBlock) block;
            if (tintIndex == mat.getTintIndexLayer()) {
                return mat.materialProperties.getColour();
            }
        }
        return -1;
    }
}
