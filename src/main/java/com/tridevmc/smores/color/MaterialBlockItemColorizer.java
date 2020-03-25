package com.tridevmc.smores.color;

import com.tridevmc.smores.block.MaterialBlock;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class MaterialBlockItemColorizer implements IItemColor {
    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if(stack.getItem() instanceof BlockItem) {
            BlockItem i = ((BlockItem)stack.getItem());
            if(i.getBlock() instanceof MaterialBlock) {
                MaterialBlock b = ((MaterialBlock)i.getBlock());
                if(tintIndex == 1) {
                    return b.materialProperties.getColour();
                } else {
                    return -1;
                }
            }
        }

        return -1;
    }
}
