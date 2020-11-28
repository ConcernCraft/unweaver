package com.leocth.unweaver.v0.impl;

import com.leocth.unweaver.v0.impl.traits.BipedEntityModelTrait;
import net.minecraft.client.render.entity.model.BipedEntityModel;

/**
 * The can opener that makes all cans that it opened contain worms.
 */
// potentially dangerous shit going on here
//@SuppressWarnings("ConstantConditions")
public class Opener {
    public static BipedEntityModelTrait open(BipedEntityModel<?> model) {
        return (BipedEntityModelTrait) model;
    }
}
