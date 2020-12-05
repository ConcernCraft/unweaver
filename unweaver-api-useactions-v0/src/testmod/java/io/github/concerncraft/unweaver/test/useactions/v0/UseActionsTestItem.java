package io.github.concerncraft.unweaver.test.useactions.v0;

import io.github.concerncraft.unweaver.api.useactions.v0.ArmPose;
import io.github.concerncraft.unweaver.api.useactions.v0.ArmPoseFactory;
import io.github.concerncraft.unweaver.api.useactions.v0.ConsumptionEffectSpawner;
import io.github.concerncraft.unweaver.api.useactions.v0.UseActionContainer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;

public class UseActionsTestItem extends Item implements UseActionContainer {

    public static final ArmPose USE_ARMPOSE
            = ArmPose.Builder.create()
                .leftArmAngles(UseActionsTestItem::setLeftArmAngles)
                .rightArmAngles(UseActionsTestItem::setRightArmAngles)
                .build();

    public UseActionsTestItem(Settings settings) {
        super(settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public @Nullable ArmPoseFactory getArmPoseFactory() {
        return ArmPoseFactory.fixed(USE_ARMPOSE);
    }

    @Override
    public @Nullable ConsumptionEffectSpawner getConsumptionEffectSpawner() {
        return null;
    }

    private static <T extends LivingEntity> void setLeftArmAngles(BipedEntityModel<T> model, T entity) {
        model.leftArm.pitch = 2.9f;
    }

    private static <T extends LivingEntity> void setRightArmAngles(BipedEntityModel<T> model, T entity) {
        model.rightArm.pitch = 2.9f;
    }
}
