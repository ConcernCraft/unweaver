package com.leocth.unweaver.v0.api;

import com.leocth.unweaver.v0.impl.util.UseActionImpl;
import org.jetbrains.annotations.Nullable;

/**
 * Trait for "extended" enums. (e.g. {@link UseActionImpl})
 * @param <T> the original enum type
 */
public interface ExtendedEnum<T extends Enum<?>> {
    /**
     * Returns the vanilla representation of the extended value.
     * <em>MIGHT return null if the value does not have a vanilla equivalent!</em>
     * @return the vanilla equivalent
     */
    @Nullable T getVanilla();
}
