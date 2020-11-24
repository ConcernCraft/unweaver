package com.leocth.unweaver.v0.mixin;

import com.leocth.unweaver.v0.api.callbacks.ConsumeItemCallback;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import com.leocth.unweaver.v0.impl.Opener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "spawnConsumptionEffects", cancellable = true)
    protected void spawnConsumptionEffects(ItemStack stack, int particleCount, CallbackInfo ci) {
        UseAction useAction = Opener.open(stack).getUseAction();
        if (useAction.isCustom()) {
            ConsumeItemCallback callback = useAction.getConsumptionCallback();
            if (callback != null) {
                callback.call((LivingEntity)(Object)this, stack, particleCount);
                ci.cancel();
            }
        }
    }
}
