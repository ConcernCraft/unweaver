package com.leocth.unweaver.v0.impl;

import com.leocth.unweaver.v0.impl.traits.ItemStackTrait;
import net.minecraft.item.ItemStack;

// potentially dangerous shit going on here
@SuppressWarnings("ConstantConditions")
public class Opener {

    public static ItemStackTrait open(ItemStack stack) {
        return (ItemStackTrait) (Object) stack;
    }

}
