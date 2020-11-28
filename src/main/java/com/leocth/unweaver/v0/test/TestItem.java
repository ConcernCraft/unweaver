package com.leocth.unweaver.v0.test;

import com.leocth.unweaver.v0.api.callbacks.ConsumeItemCallback;
import com.leocth.unweaver.v0.api.containers.util.UseActionContainer;
import com.leocth.unweaver.v0.api.enums.client.render.entity.ArmPose;
import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;

public class TestItem extends Item implements UseActionContainer {

    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable ArmPoseFactory getArmPoseFactory() {
        return (player, hand, stack) -> ArmPose.VANILLA.get(BipedEntityModel.ArmPose.BOW_AND_ARROW);
    }

    @Override
    public @Nullable ConsumeItemCallback getConsumeItemCallback() {
        return ConsumeItemCallback.whenUsing(
                (entity, stack, particleCount) ->
                        entity.playSound(SoundEvents.ENTITY_PLAYER_SPLASH, 0.5F, 0.1f)
        );
    }
}
