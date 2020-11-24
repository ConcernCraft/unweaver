package com.leocth.unweaver.v0.test;

import com.leocth.unweaver.v0.api.callbacks.ConsumeItemCallback;
import com.leocth.unweaver.v0.api.containers.util.UseActionContainer;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;

public class TestItem extends Item implements UseActionContainer {

    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getCustomUseAction(ItemStack stack) {
        return Test.MY_CUSTOM_USEACTION;
    }
}
