package com.tridevmc.smores.fluid;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.init.BlocksInit;
import com.tridevmc.smores.init.FluidsInit;
import com.tridevmc.smores.init.ItemsInit;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BucketItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class MoltenMetalFluid extends ForgeFlowingFluid {
    public static Properties getFluidProperties(Material mat) {
        MaterialProperties prop = mat.getProperties();
        return  new Properties(
                ()->FluidsInit.MOLTEN_STILL.get(mat),
                ()->FluidsInit.MOLTEN_FLOWING.get(mat),
                FluidAttributes.builder(
                        new ResourceLocation(Smores.MODID, "blocks/molten_metal_still"),
                        new ResourceLocation(Smores.MODID, "blocks/molten_metal_flow"))
                        .color(prop.getColour())
                        .density(prop.getDensity())
                        .temperature(prop.getMeltingPoint())
                        .luminosity(15)
                        .viscosity(6000)
                        .sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA))
                .block(()-> (FlowingFluidBlock) BlocksInit.MOLTEN.get(mat))
                .bucket(() -> ItemsInit.BUCKETS.get(mat))
                .explosionResistance(100F)
                .slopeFindDistance(4)
                .levelDecreasePerBlock(1);
    }

    protected MoltenMetalFluid(Properties properties) {
        super(properties);
    }

    public static class Flowing extends ForgeFlowingFluid.Flowing
    {
        public Flowing(Material mat)
        {
            super(getFluidProperties(mat));
        }
    }

    public static class Source extends ForgeFlowingFluid.Source
    {
        public Source(Material mat)
        {
            super(getFluidProperties(mat));
        }
    }
}
