package io.github.concerncraft.unweaver.api.instruments.v0;

import io.github.concerncraft.unweaver.api.enums.ExtendedEnum;
import io.github.concerncraft.unweaver.api.enums.VanillaEnumFactory;
import io.github.concerncraft.unweaver.impl.enums.CachedVanillaEnumFactory;
import io.github.concerncraft.unweaver.impl.instruments.v0.InstrumentImpl;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.StringIdentifiable;

/**
 * A custom instrument for note blocks.
 *
 * @see net.minecraft.block.enums.Instrument
 * @see InstrumentFactoryRegistry
 * @author leocth
 * @since 0.2.0
 */
public interface Instrument extends ExtendedEnum<net.minecraft.block.enums.Instrument>, StringIdentifiable {

    VanillaEnumFactory<net.minecraft.block.enums.Instrument, Instrument> VANILLA
            = new CachedVanillaEnumFactory<>(InstrumentImpl::new);

    SoundEvent getSound();

    static Instrument create(String id, SoundEvent sound) {
        return new InstrumentImpl(id, sound);
    }
}
