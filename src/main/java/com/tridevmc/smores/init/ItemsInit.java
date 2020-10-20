package com.tridevmc.smores.init;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.color.MaterialItemColorizer;
import com.tridevmc.smores.color.MoltenBucketItemColorizer;
import com.tridevmc.smores.item.*;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

import java.util.HashMap;
import java.util.Map;

public class ItemsInit {

    public static final Map<Material, Item> INGOTS = new HashMap<>();
    public static final Map<Material, Item> GEARS = new HashMap<>();
    public static final Map<Material, Item> DUSTS = new HashMap<>();
    public static final Map<Material, Item> RODS = new HashMap<>();
    public static final Map<Material, Item> PLATES = new HashMap<>();
    public static final Map<Material, Item> NUGGETS = new HashMap<>();
    public static final Map<Material, Item> BUCKETS = new HashMap<>();

    public static final Item SMORE = new SmoreItem().setRegistryName(Smores.MODID, "smore");

    public static void registerItems(final RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> registry = evt.getRegistry();

        IForgeRegistry<Material> mats = RegistryManager.ACTIVE.getRegistry(Material.class);

        registry.register(SMORE);

        for (Material i : mats.getValues()) {
            MaterialProperties matProp = i.getProperties();
            if(matProp.getIngotType() != MaterialProperties.IngotType.NONE) {
                IngotItem ingot = new IngotItem(i);
                INGOTS.put(i, ingot);
                registry.register(ingot);
            }
            if(matProp.hasGear()) {
                GearItem gear = new GearItem(i);
                GEARS.put(i, gear);
                registry.register(gear);
            }
            if(matProp.hasDust()) {
                DustItem dust = new DustItem(i);
                DUSTS.put(i, dust);
                registry.register(dust);
            }
            if(matProp.hasRod()) {
                RodItem rod = new RodItem(i);
                RODS.put(i, rod);
                registry.register(rod);
            }
            if(matProp.hasPlate()) {
                PlateItem plate = new PlateItem(i);
                PLATES.put(i, plate);
                registry.register(plate);
            }
            if(matProp.hasNugget()) {
                NuggetItem nugget = new NuggetItem(i);
                NUGGETS.put(i, nugget);
                registry.register(nugget);
            }
            if(matProp.hasFluid()) {
                MoltenBucketItem bucket = new MoltenBucketItem(i);
                BUCKETS.put(i, bucket);
                registry.register(bucket);
            }
        }
    }
}
