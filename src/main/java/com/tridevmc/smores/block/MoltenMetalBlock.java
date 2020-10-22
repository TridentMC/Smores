package com.tridevmc.smores.block;

import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

import static net.minecraft.block.material.Material.LAVA;

public class MoltenMetalBlock extends FlowingFluidBlock {
    public final MaterialProperties materialProperties;

    public MoltenMetalBlock(Material material, Supplier<? extends FlowingFluid> supplier) {
        super(supplier, AbstractBlock.Properties.create(LAVA).doesNotBlockMovement().tickRandomly().hardnessAndResistance(100.0F).setLightLevel((state) -> 15).noDrops());
        this.setRegistryName(material.getRegistryName().getNamespace(), material.getRegistryName().getPath() + "_molten");
        this.materialProperties = material.getProperties();
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}
