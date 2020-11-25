package com.leocth.unweaver.v0.api.enums;

/**
 * Factory type that gets or creates an extended enum from a vanilla enum.
 *
 * @param <Vanilla> the vanilla enum type
 * @param <Custom> the extended enum type
 * @author leocth
 * @since 0.1.0
 */
@FunctionalInterface
public interface VanillaFactory<Vanilla extends Enum<Vanilla>, Custom extends ExtendedEnum<Vanilla>> {
    Custom get(Vanilla vanilla);
}
