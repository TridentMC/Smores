package com.tridevmc.smores.client;

import com.tridevmc.smores.color.*;
import com.tridevmc.smores.fluid.MoltenMetalFluid;
import com.tridevmc.smores.init.BlocksInit;
import com.tridevmc.smores.init.ItemsInit;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public static final MaterialItemColorizer ITEM_COLORIZER = new MaterialItemColorizer();
    public static final MoltenBucketItemColorizer BUCKET_COLORIZER = new MoltenBucketItemColorizer();
    public static final MaterialBlockColorizer BLOCK_COLORIZER = new MaterialBlockColorizer();
    public static final MoltenMetalBlockColorizer MOLTEN_COLORIZER = new MoltenMetalBlockColorizer();
    public static final MaterialBlockItemColorizer BLOCK_ITEM_COLORIZER = new MaterialBlockItemColorizer();

    @SubscribeEvent
    public void onFogColors(EntityViewRenderEvent.FogColors evt) {
        Fluid fluid = evt.getInfo().getFluidState().getFluid();
        if(fluid instanceof MoltenMetalFluid.Source || fluid instanceof MoltenMetalFluid.Flowing) {
            int color = fluid.getAttributes().getColor();
            evt.setBlue((float) (color & 0xFF) / 0xFF);
            evt.setGreen((float) ((color >> 8) & 0xFF) / 0xFF);
            evt.setRed((float) ((color >> 16) & 0xFF) / 0xFF);
        }
    }

    @SubscribeEvent
    public void onItemColorRegistry(final ColorHandlerEvent.Item evt) {
        ItemColors colors = evt.getItemColors();

        for(Item e : ItemsInit.INGOTS.values()) {
            colors.register(ITEM_COLORIZER, e);
        }
        for(Item e : ItemsInit.GEARS.values()) {
            colors.register(ITEM_COLORIZER, e);
        }
        for(Item e : ItemsInit.DUSTS.values()) {
            colors.register(ITEM_COLORIZER, e);
        }
        for(Item e : ItemsInit.RODS.values()) {
            colors.register(ITEM_COLORIZER, e);
        }
        for(Item e : ItemsInit.PLATES.values()) {
            colors.register(ITEM_COLORIZER, e);
        }
        for(Item e : ItemsInit.NUGGETS.values()) {
            colors.register(ITEM_COLORIZER, e);
        }
        for(Item e : ItemsInit.BUCKETS.values()) {
            colors.register(BUCKET_COLORIZER, e);
        }

        for(BlockItem e : BlocksInit.BLOCK_ITEMS.values()) {
            colors.register(BLOCK_ITEM_COLORIZER, e);
        }
        for(BlockItem e : BlocksInit.ORE_ITEMS.values()) {
            colors.register(BLOCK_ITEM_COLORIZER, e);
        }
    }

    @SubscribeEvent
    public void onBlockColorRegistry(final ColorHandlerEvent.Block evt) {
        BlockColors blockColors = evt.getBlockColors();

        for(Block e : BlocksInit.BLOCKS.values()) {
            blockColors.register(BLOCK_COLORIZER, e);
        }
        for(Block e : BlocksInit.ORES.values()) {
            blockColors.register(BLOCK_COLORIZER, e);
        }
        for(Block e : BlocksInit.MOLTEN.values()) {
            blockColors.register(MOLTEN_COLORIZER, e);
        }
    }

    @Override
    public void setupRenderTypes() {
        RenderType mipped = RenderType.getCutoutMipped();
        for(Block e : BlocksInit.ORES.values()) {
            RenderTypeLookup.setRenderLayer(e, mipped);
        }
    }
}
