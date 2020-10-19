package com.tridevmc.smores.init;

import com.tridevmc.smores.block.IngotBlock;
import com.tridevmc.smores.block.MoltenMetalBlock;
import com.tridevmc.smores.block.OreBlock;
import com.tridevmc.smores.fluid.MoltenMetalFluid;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

import java.util.HashMap;
import java.util.Map;

public class FluidsInit {
    public static final Map<Material, Fluid> MOLTEN_STILL = new HashMap<>();
    public static final Map<Material, Fluid> MOLTEN_FLOWING = new HashMap<>();

    public static void registerFluids(final RegistryEvent.Register<Fluid> evt) {
        IForgeRegistry<Fluid> registry = evt.getRegistry();

        IForgeRegistry<Material> mats = RegistryManager.ACTIVE.getRegistry(Material.class);

        for (Material i : mats.getValues()) {
            registerMaterialFluids(i, registry);
        }
    }

    private static void registerMaterialFluids(Material mat, IForgeRegistry<Fluid> registry) {
        boolean molten = mat.getProperties().hasFluid();
        if(molten) {
            Fluid still = new MoltenMetalFluid.Source(mat).setRegistryName(mat.getRegistryName().getNamespace(), mat.getRegistryName().getPath() + "_molten_still");
            MOLTEN_STILL.put(mat, still);
            registry.register(still);
            Fluid flowing = new MoltenMetalFluid.Flowing(mat).setRegistryName(mat.getRegistryName().getNamespace(), mat.getRegistryName().getPath() + "_molten_flowing");
            MOLTEN_FLOWING.put(mat, flowing);
            registry.register(flowing);
        }
    }


}
