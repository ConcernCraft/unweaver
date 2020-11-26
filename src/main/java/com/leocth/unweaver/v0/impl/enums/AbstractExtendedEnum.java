package com.leocth.unweaver.v0.impl.enums;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractExtendedEnum<T extends Enum<T>> implements ExtendedEnum<T> {

    protected final T vanilla;

    public AbstractExtendedEnum(T vanilla) {
        this.vanilla = vanilla;
    }

    @Nullable
    @Override
    public T getVanilla() {
        return vanilla;
    }
}
