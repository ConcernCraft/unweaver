package com.leocth.unweaver.v0.test;

import com.leocth.unweaver.v0.api.callbacks.ConsumingItemCallback;
import com.leocth.unweaver.v0.api.containers.util.UseActionContainer;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;

public class TestItem extends Item implements UseActionContainer {

    public static final UseAction MY_CUSTOM_USEACTION = new UseAction.Builder()
            .armPose((player, hand, stack) -> BipedEntityModel.ArmPose.BOW_AND_ARROW)
            .consumptionEffectSpawner(ConsumingItemCallback.whenUsing(
                    (entity, stack, particleCount) ->
                            entity.playSound(SoundEvents.ENTITY_PLAYER_SPLASH, 0.5F, entity.world.random.nextFloat() * 0.1F + 0.9F)
            ))
            .build();

    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getCustomUseAction(ItemStack stack) {
        return MY_CUSTOM_USEACTION;
    }
}
