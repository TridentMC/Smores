package com.tridevmc.smores.init;

import com.tridevmc.smores.Smores;
import com.tridevmc.smores.event.MaterialRegistrationEvent;
import com.tridevmc.smores.material.BaseMaterial;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class HSMaterials {
    public static final BaseMaterial COPPER = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "copper"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    8940, 1357, 0xFFFC8E00)
    );
    public static final BaseMaterial TIN = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "tin"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    7280,505, 0xFFb5bee6)
    );
    public static final BaseMaterial LEAD = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "lead"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    11340, 600, 0xFF55557B)
    );
    public static final BaseMaterial SILVER = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "silver"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_PRECIOUS,
                    MaterialProperties.OreType.PRECIOUS,
                    10490, 1234, 0xFFd9e9ff)
    );
    public static final BaseMaterial NICKEL = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "nickel"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    8908, 1728, 0xFFcfc4b2)
    );
    public static final BaseMaterial PLATINUM = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "platinum"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_PRECIOUS,
                    MaterialProperties.OreType.PRECIOUS,
                    21400, 2041, 0xFFadd8ff)
    );
    public static final BaseMaterial MITHRIL = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "mithril"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_PRECIOUS,
                    MaterialProperties.OreType.PRECIOUS,
                    4110, 1941, 0xFFBE94B2)
    );
    public static final BaseMaterial ZINC = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "zinc"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    7135, 692, 0xFFC5D098)
    );
    // TODO: Aluminium colour
    public static final BaseMaterial ALUMINUM = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "aluminum"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    2712, 692, 0xFFebebeb)
    );
    public static final BaseMaterial URANIUM = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "uranium"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    17300, 1405, 0xFF95FF4F)
    );
    public static final BaseMaterial PLUTONIUM = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "plutonium"),
            MaterialProperties.defaultElementalMetal(MaterialProperties.BlockType.METAL_UTILITY,
                    MaterialProperties.OreType.DEFAULT,
                    19816, 913, 0xFF6849DB)
    );
    public static final BaseMaterial IRON = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "iron"),
            MaterialProperties.defaultVanillaMetal(6980, 1811, 0xFFd1d1d1)
    );
    public static final BaseMaterial GOLD = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "gold"),
            MaterialProperties.defaultVanillaMetal(17310, 1337, 0xFFfad348)
    );
    public static final BaseMaterial ELECTRUM = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "electrum"),
            MaterialProperties.defaultAlloyMetal(13750, 1336, 0xFFfeff87)
    );
    public static final BaseMaterial INVAR = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "invar"),
            MaterialProperties.defaultAlloyMetal(8055, 1700, 0xFFa8aeba)
    );
    public static final BaseMaterial STEEL = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "steel"),
            MaterialProperties.defaultAlloyMetal(7800, 1644, 0xFF969696)
    );
    public static final BaseMaterial BRONZE = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "bronze"),
            MaterialProperties.defaultAlloyMetal(8800, 1186, 0xFFfaa350)
    );
    public static final BaseMaterial BRASS = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "brass"),
            MaterialProperties.defaultAlloyMetal(8520, 1200, 0xFFFCC400)
    );
    public static final BaseMaterial RUBY = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "ruby"),
            MaterialProperties.defaultGem(0xFFFF1C1C)
    );
    public static final BaseMaterial SAPPHIRE = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "sapphire"),
            MaterialProperties.defaultGem(0xFF194FFF)
    );
    public static final BaseMaterial PERIDOT = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "peridot"),
            MaterialProperties.defaultGem(0xFF5EAE1E)
    );
    // TODO: Colours for the below
    public static final BaseMaterial SULFUR = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "sulfur"),
            MaterialProperties.defaultDust(0xFFf5e027)
    );
    public static final BaseMaterial NITRE = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "nitre"),
            MaterialProperties.defaultDust(0xFFe8ba23)
    );
    public static final BaseMaterial MERCURY = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "mercury"),
            new MaterialProperties(MaterialProperties.MaterialType.ELEMENT, MaterialProperties.IngotType.GLOB)
                .colour(0xFFc9c9c9)
    );
    public static final BaseMaterial LAPIS = new BaseMaterial(
            new ResourceLocation(Smores.MODID, "lapis"),
            new MaterialProperties(MaterialProperties.MaterialType.DUST, MaterialProperties.IngotType.NONE)
                .colour(0xFF3030EF)
                .generateDust()
    );

    public static void registerMaterials(final MaterialRegistrationEvent evt){
        IForgeRegistry<BaseMaterial> registry = evt.registry;

        Smores.LOGGER.info("HEY! Registering materials now");
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
