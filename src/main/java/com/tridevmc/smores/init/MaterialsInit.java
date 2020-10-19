package com.tridevmc.smores.init;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.event.MaterialRegistrationEvent;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class MaterialsInit {
    public static final Material COPPER = new Material(
            new ResourceLocation(Smores.MODID, "copper"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    8940, 1357, 0xFFFC8E00)
    );
    public static final Material TIN = new Material(
            new ResourceLocation(Smores.MODID, "tin"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    7280,505, 0xFFb5bee6)
    );
    public static final Material LEAD = new Material(
            new ResourceLocation(Smores.MODID, "lead"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    11340, 600, 0xFF55557B)
    );
    public static final Material SILVER = new Material(
            new ResourceLocation(Smores.MODID, "silver"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_PRECIOUS,
                    MaterialProperties.OreType.PRECIOUS,
                    10490, 1234, 0xFFd9e9ff)
    );
    public static final Material NICKEL = new Material(
            new ResourceLocation(Smores.MODID, "nickel"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    8908, 1728, 0xFFcfc4b2)
    );
    public static final Material PLATINUM = new Material(
            new ResourceLocation(Smores.MODID, "platinum"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_PRECIOUS,
                    MaterialProperties.OreType.PRECIOUS,
                    21400, 2041, 0xFFadd8ff)
    );
    public static final Material MITHRIL = new Material(
            new ResourceLocation(Smores.MODID, "mithril"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_PRECIOUS,
                    MaterialProperties.OreType.PRECIOUS,
                    4110, 1941, 0xFFBE94B2)
    );
    public static final Material ZINC = new Material(
            new ResourceLocation(Smores.MODID, "zinc"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    7135, 692, 0xFFC5D098)
    );

    public static final Material ALUMINUM = new Material(
            new ResourceLocation(Smores.MODID, "aluminum"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    2712, 692, 0xFFebebeb)
    );
    public static final Material URANIUM = new Material(
            new ResourceLocation(Smores.MODID, "uranium"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    17300, 1405, 0xFF95FF4F)
    );
    public static final Material PLUTONIUM = new Material(
            new ResourceLocation(Smores.MODID, "plutonium"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    19816, 913, 0xFF6849DB)
    );
    public static final Material IRON = new Material(
            new ResourceLocation(Smores.MODID, "iron"),
            MaterialProperties.defaultVanillaMetal(6980, 1811, 0xFFd1d1d1)
    );
    public static final Material GOLD = new Material(
            new ResourceLocation(Smores.MODID, "gold"),
            MaterialProperties.defaultVanillaMetal(17310, 1337, 0xFFfad348)
    );
    public static final Material ELECTRUM = new Material(
            new ResourceLocation(Smores.MODID, "electrum"),
            MaterialProperties.defaultAlloyMetal(13750, 1336, 0xFFfeff87)
    );
    public static final Material INVAR = new Material(
            new ResourceLocation(Smores.MODID, "invar"),
            MaterialProperties.defaultAlloyMetal(8055, 1700, 0xFFa8aeba)
    );
    public static final Material STEEL = new Material(
            new ResourceLocation(Smores.MODID, "steel"),
            MaterialProperties.defaultAlloyMetal(7800, 1644, 0xFF969696)
    );
    public static final Material BRONZE = new Material(
            new ResourceLocation(Smores.MODID, "bronze"),
            MaterialProperties.defaultAlloyMetal(8800, 1186, 0xFFfaa350)
    );
    public static final Material BRASS = new Material(
            new ResourceLocation(Smores.MODID, "brass"),
            MaterialProperties.defaultAlloyMetal(8520, 1200, 0xFFFCC400)
    );
    public static final Material RUBY = new Material(
            new ResourceLocation(Smores.MODID, "ruby"),
            MaterialProperties.defaultGem(0xFFFF1C1C)
    );
    public static final Material SAPPHIRE = new Material(
            new ResourceLocation(Smores.MODID, "sapphire"),
            MaterialProperties.defaultGem(0xFF194FFF)
    );
    public static final Material PERIDOT = new Material(
            new ResourceLocation(Smores.MODID, "peridot"),
            MaterialProperties.defaultGem(0xFF5EAE1E)
    );

    public static final Material SULFUR = new Material(
            new ResourceLocation(Smores.MODID, "sulfur"),
            MaterialProperties.defaultDust(0xFFf5e027)
    );
    public static final Material NITRE = new Material(
            new ResourceLocation(Smores.MODID, "nitre"),
            MaterialProperties.defaultDust(0xFFe8ba23)
    );
    public static final Material MERCURY = new Material(
            new ResourceLocation(Smores.MODID, "mercury"),
            new MaterialProperties(MaterialProperties.MaterialType.ELEMENT, MaterialProperties.IngotType.GLOB)
                .colour(0xFFc9c9c9)
    );
    public static final Material LAPIS = new Material(
            new ResourceLocation(Smores.MODID, "lapis"),
            new MaterialProperties(MaterialProperties.MaterialType.DUST, MaterialProperties.IngotType.NONE)
                .colour(0xFF3030EF)
                .generateDust()
    );

    public static void registerMaterials(final MaterialRegistrationEvent evt){
        IForgeRegistry<Material> registry = evt.registry;

        registry.registerAll(
                COPPER,
                TIN,
                LEAD,
                SILVER,
                NICKEL,
                PLATINUM,
                MITHRIL,
                ZINC,
                ALUMINUM,
                URANIUM,
                PLUTONIUM,
                IRON,
                GOLD,
                ELECTRUM,
                INVAR,
                STEEL,
                BRONZE,
                BRASS,
                RUBY,
                SAPPHIRE,
                PERIDOT,
                SULFUR,
                NITRE,
                MERCURY,
                LAPIS
        );
    }

}
