package com.leocth.unweaver.v0.impl.enums.util;

import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import com.leocth.unweaver.v0.api.callbacks.ConsumingItemCallback;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.jetbrains.annotations.Nullable;

public class VanillaUseActionImpl implements UseAction {

    private static final Object2ObjectOpenHashMap<net.minecraft.util.UseAction, VanillaUseActionImpl> vanillaCache
            = new Object2ObjectOpenHashMap<>();

    private final net.minecraft.util.UseAction vanilla;

    private VanillaUseActionImpl(net.minecraft.util.UseAction vanilla) {
        this.vanilla = vanilla;
    }

    @Nullable
    @Override
    public net.minecraft.util.UseAction getVanilla() {
        return vanilla;
    }

    @Override
    public ArmPoseFactory getArmPoseFactory() {
        return null;
    }

    @Override
    public ConsumingItemCallback getConsumptionCallback() {
        return null;
    }

    public static VanillaUseActionImpl get(net.minecraft.util.UseAction vanilla) {
        if (vanillaCache.containsKey(vanilla))
            return vanillaCache.get(vanilla);
        VanillaUseActionImpl impl = new VanillaUseActionImpl(vanilla);
        vanillaCache.put(vanilla, impl);
        return impl;
    }
}
