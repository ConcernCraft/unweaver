package com.leocth.unweaver.v0.impl.enums;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;

@FunctionalInterface
public interface VanillaFactory<Vanilla extends Enum<Vanilla>, Custom extends ExtendedEnum<Vanilla>> {

    Custom get(Vanilla vanilla);

}
