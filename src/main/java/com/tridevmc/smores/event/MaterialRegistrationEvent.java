package com.tridevmc.smores.event;

import com.tridevmc.smores.material.Material;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.event.lifecycle.IModBusEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class MaterialRegistrationEvent extends Event implements IModBusEvent {
    public final IForgeRegistry<Material> registry;

    public MaterialRegistrationEvent(IForgeRegistry<Material> registry) {
        this.registry = registry;
    }
}
