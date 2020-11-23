package com.leocth.unweaver.v0.api.enums;

@FunctionalInterface
public interface VanillaFactory<Vanilla extends Enum<Vanilla>, Custom extends ExtendedEnum<Vanilla>> {

    Custom get(Vanilla vanilla);

}
