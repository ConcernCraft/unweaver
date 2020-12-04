package io.github.concerncraft.unweaver.mixin.useactions.v0;

import io.github.concerncraft.unweaver.api.useactions.v0.ConsumptionEffectSpawner;
import io.github.concerncraft.unweaver.api.useactions.v0.UseActionContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
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
        Item item = stack.getItem();
        if (item instanceof UseActionContainer) {
            ConsumptionEffectSpawner spawner = ((UseActionContainer) item).getConsumptionEffectSpawner();
            if (spawner != null) {
                spawner.spawn((LivingEntity)(Object)this, stack, particleCount);
                ci.cancel();
            }
        }
    }
}
