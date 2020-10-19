package com.tridevmc.smores;

import com.tridevmc.smores.init.ItemsInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SmoresItemGroup extends ItemGroup {
    public SmoresItemGroup() {
        super("smores");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemsInit.SMORE);
    }
}
