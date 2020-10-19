package com.tridevmc.smores.material;

public class MaterialProperties {
    public enum MaterialType {
        ELEMENT,
        ALLOY,
        GEM,
        DUST
    }

    public enum IngotType {
        NONE,
        INGOT,
        GEM,
        GLOB
    }

    public enum BlockType {
        METAL_UTILITY,
        METAL_PRECIOUS,
        DUST,
        GEM
    }

    public enum OreType {
        DEFAULT,
        PRECIOUS,
        DUST,
        GEM
    }

    public static class BlockProperties<T> {
        public T blockType;
        public float hardness;
        public float resistance;

        public BlockProperties(T type) {
            this.blockType = type;
        }

        public BlockProperties<T> hardness(float hardness) {
            this.hardness = hardness;
            return this;
        }

        public BlockProperties<T> resistance(float resistance) {
            this.resistance = resistance;
            return this;
        }
    }

    private final MaterialType materialType;
    private final IngotType ingotType;
    private BlockProperties<BlockType> blockType = null;
    private BlockProperties<OreType> oreType = null;
    private boolean fluid;
    private boolean dust;
    private boolean nugget;
    private boolean plate;
    private boolean gear;
    private boolean rod;
    private boolean molten;
    private int colour = -1;
    private int density = -1;
    private int meltingPoint = -1;

    public MaterialProperties(MaterialType materialType, IngotType ingotType) {
        this.materialType = materialType;
        this.ingotType = ingotType;
    }

    public MaterialProperties block(BlockProperties<BlockType> properties) {
        this.blockType = properties;
        return this;
    }

    public MaterialProperties oreBlock(BlockProperties<OreType> properties) {
        this.oreType = properties;
        return this;
    }

    public MaterialProperties generateFluid() {
        this.fluid = true;
        return this;
    }

    public MaterialProperties generateDust() {
        this.dust = true;
        return this;
    }

    public MaterialProperties generateNugget() {
        this.nugget = true;
        return this;
    }

    public MaterialProperties generatePlate() {
        this.plate = true;
        return this;
    }

    public MaterialProperties generateGear() {
        this.gear = true;
        return this;
    }

    public MaterialProperties generateRod() {
        this.rod = true;
        return this;
    }

    public MaterialProperties density(int density) {
        this.density = density;
        return this;
    }

    public MaterialProperties meltingPoint(int meltingPoint) {
        this.meltingPoint = meltingPoint;
        return this;
    }

    public MaterialProperties colour(int colour) {
        this.colour = colour;
        return this;
    }

    public static MaterialProperties defaultElementalMetal(BlockType type, OreType oreType, int density, int meltingPoint, int colour) {
        return new MaterialProperties(MaterialType.ELEMENT, IngotType.INGOT)
                .density(density)
                .meltingPoint(meltingPoint)
                .colour(colour)
                .oreBlock(new BlockProperties<>(oreType).hardness(3.0f).resistance(3.0f))
                .block(new BlockProperties<>(type).hardness(5.0f).resistance(6.0f))
                .generateDust()
                .generateGear()
                .generateNugget()
                .generatePlate()
                .generateFluid()
                .generateRod();
    }

    public static MaterialProperties defaultVanillaMetal(int density, int meltingPoint, int colour) {
        return new MaterialProperties(MaterialType.ELEMENT, IngotType.NONE)
                .density(density)
                .meltingPoint(meltingPoint)
                .colour(colour)
                .generateDust()
                .generateGear()
                .generatePlate()
                .generateFluid()
                .generateRod();
    }

    public static MaterialProperties defaultAlloyMetal(int density, int meltingPoint, int colour) {
        return new MaterialProperties(MaterialType.ALLOY, IngotType.INGOT)
                .density(density)
                .meltingPoint(meltingPoint)
                .colour(colour)
                .block(new BlockProperties<>(BlockType.METAL_UTILITY).hardness(5.0f).resistance(6.0f))
                .generateDust()
                .generateGear()
                .generateNugget()
                .generatePlate()
                .generateFluid()
                .generateRod();
    }

    public static MaterialProperties defaultDust(int colour) {
        return new MaterialProperties(MaterialType.DUST, IngotType.NONE)
                .colour(colour)
                .oreBlock(new BlockProperties<>(OreType.DUST).hardness(3.0f).resistance(3.0f))
                .block(new BlockProperties<>(BlockType.DUST).hardness(5.0f).resistance(6.0f))
                .generateDust();
    }

    public static MaterialProperties defaultGem(int colour) {
        return new MaterialProperties(MaterialType.GEM, IngotType.GEM)
                .colour(colour)
                .oreBlock(new BlockProperties<>(OreType.GEM).hardness(3.0f).resistance(3.0f))
                .block(new BlockProperties<>(BlockType.GEM).hardness(5.0f).resistance(6.0f));
    }

    public boolean hasFluid() {
        return fluid;
    }

    public boolean hasDust() {
        return dust;
    }

    public boolean hasNugget() {
        return nugget;
    }

    public boolean hasPlate() {
        return plate;
    }

    public boolean hasGear() {
        return gear;
    }

    public boolean hasRod() {
        return rod;
    }

    public int getColour() {
        return colour;
    }

    public int getDensity() {
        return density;
    }

    public int getMeltingPoint() {
        return meltingPoint;
    }

    public BlockProperties<OreType> getOreType() {
        return oreType;
    }

    public BlockProperties<BlockType> getBlockType() {
        return blockType;
    }

    public IngotType getIngotType() {
        return ingotType;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }
}
