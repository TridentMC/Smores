package com.tridevmc.smores.block;

import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraftforge.common.ToolType;

public class IngotBlock extends MaterialBlock {
    public IngotBlock(Material material) {
        super(material, "_block", generateProperties(material.getProperties().getBlockType()));
    }

    private static Block.Properties generateProperties(MaterialProperties.BlockProperties<MaterialProperties.BlockType> properties) {
        return Block.Properties.create(net.minecraft.block.material.Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(properties.hardness, properties.resistance)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(properties.blockType.getToolLevel());
    }
}
