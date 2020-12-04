package io.github.concerncraft.unweaver.api.sculks.v0;

import io.github.concerncraft.unweaver.impl.sculks.v0.SculkFrequencyRegistryImpl;
import net.minecraft.class_5712;

import java.util.OptionalInt;

public interface SculkFrequencyRegistry {

    SculkFrequencyRegistry INSTANCE = new SculkFrequencyRegistryImpl();

    void register(class_5712 vibrationType, int frequency);

    OptionalInt getFrequency(class_5712 vibrationType);

}
