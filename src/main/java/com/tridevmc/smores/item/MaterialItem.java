package com.tridevmc.smores.item;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.material.BaseMaterial;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.item.Item;

public class MaterialItem extends Item {
    public final MaterialProperties materialProperties;

    public MaterialItem(BaseMaterial material, String suffix) {
        super(new Item.Properties().group(Smores.SMORES_ITEM_GROUP));
        this.setRegistryName(material.getRegistryName().getNamespace(), material.getRegistryName().getPath() + suffix);
        this.materialProperties = material.getProperties();
    }
}
