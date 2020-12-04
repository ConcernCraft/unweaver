package io.github.concerncraft.unweaver.impl.enums;

import io.github.concerncraft.unweaver.api.enums.ExtendedEnum;

public abstract class AbstractExtendedEnum<T extends Enum<T>> implements ExtendedEnum<T> {

    protected final T vanilla;

    public AbstractExtendedEnum(T vanilla) {
        this.vanilla = vanilla;
    }

    @Override
    public T getVanilla() {
        return vanilla;
    }
}
