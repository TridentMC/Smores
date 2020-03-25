package com.tridevmc.smores.block;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.material.BaseMaterial;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MaterialBlock extends Block {
    public final MaterialProperties materialProperties;

    public MaterialBlock(BaseMaterial material, String suffix, Properties properties) {
        super(properties);
        this.setRegistryName(material.getRegistryName().getNamespace(), material.getRegistryName().getPath() + suffix);
        this.materialProperties = material.getProperties();
    }
}
