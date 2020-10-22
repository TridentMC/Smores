package com.tridevmc.smores.mixin;

import com.tridevmc.smores.fluid.MoltenMetalFluid;
import com.tridevmc.smores.init.FluidsInit;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class MixinEntity {
    @Shadow
    public abstract boolean isImmuneToFire();

    @Shadow
    public abstract void setFire(int seconds);

    @Shadow
    public abstract boolean attackEntityFrom(DamageSource source, float amount);

    @Shadow
    public abstract double getPosX();

    @Shadow
    public abstract double getPosZ();

    @Shadow
    public abstract double getPosY();

    @Shadow
    public World world;

    @Shadow
    protected boolean firstUpdate;

    protected boolean isInMolten() {
        if (this.firstUpdate) return false;

        double y = this.getPosY();
        BlockPos blockpos = new BlockPos(this.getPosX(), y, this.getPosZ());
        FluidState fluidstate = this.world.getFluidState(blockpos);

        if (fluidstate.isTagged(FluidsInit.MOLTEN_METAL)) {
            double height = (float) blockpos.getY() + fluidstate.getActualHeight(this.world, blockpos);
            return height > y;
        }

        return false;
    }

    @Inject(method = "setOnFireFromLava", at = @At("HEAD"), cancellable = true)
    protected void onSetOnFireFromLava(CallbackInfo ci) {
        if (isInMolten() && !this.isImmuneToFire()) {
            BlockPos blockpos = new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ());
            FluidState fluidstate = this.world.getFluidState(blockpos);
            MoltenMetalFluid f = (MoltenMetalFluid) fluidstate.getFluid();
            this.setFire(15);
            this.attackEntityFrom(FluidsInit.MOLTEN_DAMAGE, (float)f.getAttributes().getTemperature() / 325.0f);
            ci.cancel();
        }
    }
}
