package com.leocth.unweaver.v0.api.containers.util;

import com.leocth.unweaver.v0.api.callbacks.ConsumeItemCallback;
import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import org.jetbrains.annotations.Nullable;

/**
 * {@link net.minecraft.item.Item}s inheriting from this interface will use override
 * the arm pose and use effects defined and fixed in place in vanilla via {@link net.minecraft.util.UseAction}.
 *
 * @author leocth
 * @since 0.1.0
 */
public interface UseActionContainer {

    @Nullable ArmPoseFactory getArmPoseFactory();

    @Nullable ConsumeItemCallback getConsumeItemCallback();

}
