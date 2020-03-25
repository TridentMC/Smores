package com.tridevmc.smores.color;

import com.tridevmc.smores.item.MaterialItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class MaterialItemColorizer implements IItemColor {

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if(stack.getItem() instanceof MaterialItem) {
            MaterialItem i = ((MaterialItem)stack.getItem());
            if(tintIndex == 0) {
                return i.materialProperties.getColour();
            } else {
                return -1;
            }
        }

        return -1;
    }
}
