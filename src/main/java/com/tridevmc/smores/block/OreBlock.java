package com.tridevmc.smores.block;

import com.tridevmc.smores.material.BaseMaterial;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.DiggingParticle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class OreBlock extends MaterialBlock {
    public OreBlock(BaseMaterial material) {
        super(material, "_ore", generateProperties(material.getProperties().getOreType()));
    }

    private static Block.Properties generateProperties(MaterialProperties.BlockProperties<MaterialProperties.OreType> properties) {
        return Block.Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(properties.hardness, properties.resistance)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(properties.blockType == MaterialProperties.OreType.DEFAULT ? 1 : 2);
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        if(this.materialProperties.getOreType() != null) {
            int exp =
                    this.materialProperties.getOreType().blockType == MaterialProperties.OreType.DUST ?
                        MathHelper.nextInt(RANDOM, 2, 5) :
                    this.materialProperties.getOreType().blockType == MaterialProperties.OreType.GEM ?
                        MathHelper.nextInt(RANDOM, 3, 7) : 0;
            return silktouch == 0 ? exp : 0;
        }
        return 0;
    }
}
