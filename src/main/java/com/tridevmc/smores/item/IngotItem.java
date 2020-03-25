package com.tridevmc.smores.item;

import com.tridevmc.smores.material.BaseMaterial;
import com.tridevmc.smores.material.MaterialProperties;

public class IngotItem extends MaterialItem {
    public IngotItem(BaseMaterial material) {
        super(material, getSuffix(material));
    }

    public static String getSuffix(BaseMaterial material) {
        MaterialProperties props = material.getProperties();
        switch(props.getIngotType()) {
            case INGOT:
                return "_ingot";
            case GEM:
                return "_gem";
            case GLOB:
                return "_glob";
            default:
                return "_invalid";
        }
    }
}
