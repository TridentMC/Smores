package com.tridevmc.smores;

import com.tridevmc.smores.init.HSItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class SmoresItemGroup extends ItemGroup {
    public SmoresItemGroup() {
        super("smores");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(HSItems.SMORE);
    }
}
