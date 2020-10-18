package com.tridevmc.smores.block;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.material.BaseMaterial;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.particle.DiggingParticle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.item.Item;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.World;

public class MaterialBlock extends Block {
    public final MaterialProperties materialProperties;

    public MaterialBlock(BaseMaterial material, String suffix, Properties properties) {
        super(properties);
        this.setRegistryName(material.getRegistryName().getNamespace(), material.getRegistryName().getPath() + suffix);
        this.materialProperties = material.getProperties();
    }

    public int getTintIndexLayer() {
        return 0;
    }
}
