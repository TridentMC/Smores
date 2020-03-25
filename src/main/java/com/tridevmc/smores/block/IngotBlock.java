package com.tridevmc.smores.block;

import com.tridevmc.smores.material.BaseMaterial;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class IngotBlock extends MaterialBlock {
    public IngotBlock(BaseMaterial material) {
        super(material, "_block", generateProperties(material.getProperties().getBlockType()));
    }

    private static Block.Properties generateProperties(MaterialProperties.BlockProperties<MaterialProperties.BlockType> properties) {
        return Block.Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(properties.hardness, properties.resistance)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel((properties.blockType == MaterialProperties.BlockType.METAL_PRECIOUS
                                || properties.blockType == MaterialProperties.BlockType.GEM) ? 2 :
                                properties.blockType == MaterialProperties.BlockType.METAL_UTILITY ? 1 : 0);
    }
}
