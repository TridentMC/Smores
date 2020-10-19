package com.tridevmc.smores.color;

import com.tridevmc.smores.item.MaterialItem;
import com.tridevmc.smores.item.MoltenBucketItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class MoltenBucketItemColorizer implements IItemColor {
    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if(stack.getItem() instanceof MoltenBucketItem) {
            MoltenBucketItem i = ((MoltenBucketItem)stack.getItem());
            if(tintIndex == 1) {
                return i.materialProperties.getColour();
            } else {
                return -1;
            }
        }

        return -1;
    }
}
