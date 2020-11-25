package com.leocth.unweaver.v0.api.enums.blocks.enums;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.api.enums.VanillaFactory;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import com.leocth.unweaver.v0.impl.enums.util.UseActionImpl;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.StringIdentifiable;

public interface Instrument extends ExtendedEnum<net.minecraft.block.enums.Instrument>, StringIdentifiable {

    VanillaFactory<net.minecraft.block.enums.Instrument, Instrument> VANILLA
            = new CachedVanillaFactory<>(InstrumentImpl::new);

    Instrument HARP           = VANILLA.get(net.minecraft.block.enums.Instrument.HARP);
    Instrument BASEDRUM       = VANILLA.get(net.minecraft.block.enums.Instrument.BASEDRUM);
    Instrument SNARE          = VANILLA.get(net.minecraft.block.enums.Instrument.SNARE);
    Instrument HAT            = VANILLA.get(net.minecraft.block.enums.Instrument.HAT);
    Instrument BASS           = VANILLA.get(net.minecraft.block.enums.Instrument.BASS);
    Instrument FLUTE          = VANILLA.get(net.minecraft.block.enums.Instrument.FLUTE);
    Instrument BELL           = VANILLA.get(net.minecraft.block.enums.Instrument.BELL);
    Instrument GUITAR         = VANILLA.get(net.minecraft.block.enums.Instrument.GUITAR);
    Instrument CHIME          = VANILLA.get(net.minecraft.block.enums.Instrument.CHIME);
    Instrument XYLOPHONE      = VANILLA.get(net.minecraft.block.enums.Instrument.XYLOPHONE);
    Instrument IRON_XYLOPHONE = VANILLA.get(net.minecraft.block.enums.Instrument.IRON_XYLOPHONE);
    Instrument COW_BELL       = VANILLA.get(net.minecraft.block.enums.Instrument.COW_BELL);
    Instrument DIDGERIDOO     = VANILLA.get(net.minecraft.block.enums.Instrument.DIDGERIDOO);
    Instrument BIT            = VANILLA.get(net.minecraft.block.enums.Instrument.BIT);
    Instrument BANJO          = VANILLA.get(net.minecraft.block.enums.Instrument.BANJO);
    Instrument PLING          = VANILLA.get(net.minecraft.block.enums.Instrument.PLING);

    SoundEvent getSound();

    static Instrument create(String id, SoundEvent sound) {
        return new InstrumentImpl(id, sound);
    }
}
