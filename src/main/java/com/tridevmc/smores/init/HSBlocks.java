package com.tridevmc.smores.init;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.block.IngotBlock;
import com.tridevmc.smores.block.OreBlock;
import com.tridevmc.smores.color.MaterialBlockColorizer;
import com.tridevmc.smores.color.MaterialBlockItemColorizer;
import com.tridevmc.smores.material.BaseMaterial;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

import java.util.HashMap;
import java.util.Map;

public class HSBlocks {

    public static final MaterialBlockColorizer BLOCK_COLORIZER = new MaterialBlockColorizer();
    public static final MaterialBlockItemColorizer BLOCK_ITEM_COLORIZER = new MaterialBlockItemColorizer();
    public static final Map<BaseMaterial, Block> BLOCKS = new HashMap<>();
    public static final Map<BaseMaterial, Block> ORES = new HashMap<>();
    public static final Map<BaseMaterial, BlockItem> BLOCK_ITEMS = new HashMap<>();
    public static final Map<BaseMaterial, BlockItem> ORE_ITEMS = new HashMap<>();

    public static void registerBlocks(final RegistryEvent.Register<Block> evt) {
        IForgeRegistry<Block> registry = evt.getRegistry();

        IForgeRegistry<BaseMaterial> mats = RegistryManager.ACTIVE.getRegistry(BaseMaterial.class);

        for (BaseMaterial i : mats.getValues()) {
            registerMaterialBlocks(i, registry);
        }
    }

    public static void registerItemBlocks(final RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> registry = evt.getRegistry();

        IForgeRegistry<BaseMaterial> mats = RegistryManager.ACTIVE.getRegistry(BaseMaterial.class);

        for (BaseMaterial i : mats.getValues()) {
            registerMaterialItemBlocks(i, registry);
        }
    }

    private static void registerMaterialBlocks(BaseMaterial mat, IForgeRegistry<Block> registry) {
        MaterialProperties matProp = mat.getProperties();
        MaterialProperties.BlockProperties blockType = matProp.getBlockType();
        if (blockType != null) {
            Block b = new IngotBlock(mat);
            BLOCKS.put(mat, b);
            registry.register(b);
        }
        MaterialProperties.BlockProperties oreType = matProp.getOreType();
        if(oreType != null) {
            Block b = new OreBlock(mat);
            ORES.put(mat, b);
            registry.register(b);
        }
    }

    private static void registerMaterialItemBlocks(BaseMaterial mat, IForgeRegistry<Item> registry) {
        if(BLOCKS.containsKey(mat)) {
            Block b = BLOCKS.get(mat);
            ResourceLocation name = b.getRegistryName();
            BlockItem bi = (BlockItem)new BlockItem(b, new Item.Properties().group(Smores.SMORES_ITEM_GROUP))
                    .setRegistryName(b.getRegistryName());
            BLOCK_ITEMS.put(mat, bi);
            registry.register(bi);
        }

        if(ORES.containsKey(mat)) {
            Block b = ORES.get(mat);
            ResourceLocation name = b.getRegistryName();
            BlockItem bi = (BlockItem)new BlockItem(b, new Item.Properties().group(Smores.SMORES_ITEM_GROUP))
                    .setRegistryName(b.getRegistryName());
            ORE_ITEMS.put(mat, bi);
            registry.register(bi);
        }
    }

    public static void setupBlockColors(BlockColors blockColors) {
        for(Block e : BLOCKS.values()) {
            blockColors.register(BLOCK_COLORIZER, e);
        }
        for(Block e : ORES.values()) {
            blockColors.register(BLOCK_COLORIZER, e);
        }
    }

    public static void setupItemBlockColors(ItemColors itemColors) {
        for(BlockItem e : BLOCK_ITEMS.values()) {
            itemColors.register(BLOCK_ITEM_COLORIZER, e);
        }
        for(BlockItem e : ORE_ITEMS.values()) {
            itemColors.register(BLOCK_ITEM_COLORIZER, e);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void setupRenderLayers() {
        RenderType mipped = RenderType.func_228641_d_();
        for(Block e : ORES.values()) {
            RenderTypeLookup.setRenderLayer(e, mipped);
        }
    }
}
