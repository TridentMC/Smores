package com.tridevmc.smores.client.color;

import com.tridevmc.smores.fluid.MoltenMetalFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class FogColorizer {
    @SubscribeEvent
    public void onFogColors(EntityViewRenderEvent.FogColors evt) {
        Fluid fluid = evt.getInfo().getFluidState().getFluid();
        if (fluid instanceof MoltenMetalFluid.Source || fluid instanceof MoltenMetalFluid.Flowing) {
            int color = fluid.getAttributes().getColor();
            evt.setBlue((float) (color & 0xFF) / 0xFF);
            evt.setGreen((float) ((color >> 8) & 0xFF) / 0xFF);
            evt.setRed((float) ((color >> 16) & 0xFF) / 0xFF);
        }
    }
}
