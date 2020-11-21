package com.leocth.unweaver.v0.api.enums;

import org.jetbrains.annotations.Nullable;

/**
 * Trait for "extended" enums. (e.g. {@link com.leocth.unweaver.v0.api.enums.util.UseAction})
 * @param <T> the original enum type
 */
public interface ExtendedEnum<T extends Enum<?>> {
    /**
     * Returns the vanilla representation of the extended value.
     * <em>MIGHT return null if the value does not have a vanilla equivalent!</em>
     * @return the vanilla equivalent
     */
    @Nullable T getVanilla();

    /**
     * @return whether the extended enum is custom (i.e. does not have a vanilla counterpart).
     */
    default boolean isCustom() {
        return getVanilla() == null;
    }
}
