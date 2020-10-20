package com.tridevmc.smores.fluid;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.init.BlocksInit;
import com.tridevmc.smores.init.FluidsInit;
import com.tridevmc.smores.init.ItemsInit;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.IWorldReader;
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
                .levelDecreasePerBlock(1);
    }

    @Override
    public int getTickRate(IWorldReader world) {
        return world.getDimensionType().isUltrawarm() ? 10 : 30;
    }

    protected MoltenMetalFluid(Properties properties) {
        super(properties);
    }

    @Override
    protected int getSlopeFindDistance(IWorldReader worldIn) {
        return worldIn.getDimensionType().isUltrawarm() ? 4 : 2;
    }

    @Override
    protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
        return worldIn.getDimensionType().isUltrawarm() ? 1 : 2;
    }

    public static class Flowing extends MoltenMetalFluid
    {
        public Flowing(Material mat)
        {
            super(getFluidProperties(mat));
            setDefaultState(getStateContainer().getBaseState().with(LEVEL_1_8, 7));
        }

        @Override
        protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL_1_8);
        }
    }

    public static class Source extends MoltenMetalFluid
    {
        public Source(Material mat)
        {
            super(getFluidProperties(mat));
        }

        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
