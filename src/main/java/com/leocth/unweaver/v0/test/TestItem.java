package com.leocth.unweaver.v0.test;

import com.leocth.unweaver.v0.api.containers.util.UseActionContainer;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TestItem extends Item implements UseActionContainer {

    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getCustomUseAction(ItemStack stack) {
        return Test.MY_CUSTOM_USEACTION;
    }
}
