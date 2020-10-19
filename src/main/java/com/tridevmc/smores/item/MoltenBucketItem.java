package com.tridevmc.smores.item;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.fluid.MoltenMetalFluid;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.item.BucketItem;

public class MoltenBucketItem extends BucketItem {
    public final MaterialProperties materialProperties;

    public MoltenBucketItem(Material material) {
        super(() -> new MoltenMetalFluid.Source(material), new Properties().group(Smores.SMORES_ITEM_GROUP));
        this.setRegistryName(material.getRegistryName().getNamespace(), material.getRegistryName().getPath() + "_bucket");
        this.materialProperties = material.getProperties();
    }
}
