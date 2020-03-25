package com.tridevmc.smores.material;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public class BaseMaterial implements IForgeRegistryEntry<BaseMaterial> {

    private ResourceLocation name;
    private MaterialProperties properties;

    public BaseMaterial(ResourceLocation name, MaterialProperties properties) {
        this.name = name;
        this.properties = properties;
    }

    @Override
    public BaseMaterial setRegistryName(ResourceLocation name) {
        this.name = name;
        return this;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return name;
    }

    @Override
    public Class<BaseMaterial> getRegistryType() {
        return BaseMaterial.class;
    }

    public MaterialProperties getProperties() {
        return properties;
    }
}
