package com.tridevmc.smores.block;

import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Block;

public abstract class MaterialBlock extends Block {
    public final MaterialProperties materialProperties;

    public MaterialBlock(Material material, String suffix, Properties properties) {
        super(properties);
        this.setRegistryName(material.getRegistryName().getNamespace(), material.getRegistryName().getPath() + suffix);
        this.materialProperties = material.getProperties();
    }

    public int getTintIndexLayer() {
        return 0;
    }
}
