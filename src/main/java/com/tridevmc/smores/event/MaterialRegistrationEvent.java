package com.tridevmc.smores.event;

import com.tridevmc.smores.material.BaseMaterial;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.event.lifecycle.IModBusEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class MaterialRegistrationEvent extends Event implements IModBusEvent {
    public final IForgeRegistry<BaseMaterial> registry;

    public MaterialRegistrationEvent(IForgeRegistry<BaseMaterial> registry) {
        this.registry = registry;
    }

}
