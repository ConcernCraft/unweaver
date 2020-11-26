package com.leocth.unweaver.v0.api.enums.blocks.enums;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.api.enums.VanillaFactory;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.StringIdentifiable;

/**
 * A custom instrument for note blocks.
 *
 * @see net.minecraft.block.enums.Instrument
 * @see com.leocth.unweaver.v0.api.registries.blocks.enums.InstrumentFactoryRegistry
 * @author leocth
 * @since 0.1.0
 */
public interface Instrument extends ExtendedEnum<net.minecraft.block.enums.Instrument>, StringIdentifiable {

    VanillaFactory<net.minecraft.block.enums.Instrument, Instrument> VANILLA
            = new CachedVanillaFactory<>(InstrumentImpl::new);

    SoundEvent getSound();

    static Instrument create(String id, SoundEvent sound) {
        return new InstrumentImpl(id, sound);
    }
}
