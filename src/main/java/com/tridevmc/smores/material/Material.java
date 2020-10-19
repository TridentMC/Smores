package com.tridevmc.smores.material;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public class Material implements IForgeRegistryEntry<Material> {

    private ResourceLocation name;
    private MaterialProperties properties;

    public Material(ResourceLocation name, MaterialProperties properties) {
        this.name = name;
        this.properties = properties;
    }

    @Override
    public Material setRegistryName(ResourceLocation name) {
        this.name = name;
        return this;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return name;
    }

    @Override
    public Class<Material> getRegistryType() {
        return Material.class;
    }

    public MaterialProperties getProperties() {
        return properties;
    }
}
