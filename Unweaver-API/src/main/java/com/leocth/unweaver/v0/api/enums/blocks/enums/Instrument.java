package com.leocth.unweaver.v0.api.enums.blocks.enums;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.StringIdentifiable;

public interface Instrument extends ExtendedEnum<net.minecraft.block.enums.Instrument>, StringIdentifiable {

    Instrument HARP           = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.HARP);
    Instrument BASEDRUM       = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.BASEDRUM);
    Instrument SNARE          = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.SNARE);
    Instrument HAT            = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.HAT);
    Instrument BASS           = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.BASS);
    Instrument FLUTE          = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.FLUTE);
    Instrument BELL           = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.BELL);
    Instrument GUITAR         = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.GUITAR);
    Instrument CHIME          = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.CHIME);
    Instrument XYLOPHONE      = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.XYLOPHONE);
    Instrument IRON_XYLOPHONE = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.IRON_XYLOPHONE);
    Instrument COW_BELL       = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.COW_BELL);
    Instrument DIDGERIDOO     = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.DIDGERIDOO);
    Instrument BIT            = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.BIT);
    Instrument BANJO          = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.BANJO);
    Instrument PLING          = InstrumentImpl.VANILLA.get(net.minecraft.block.enums.Instrument.PLING);

    SoundEvent getSound();

    static Instrument create(String id, SoundEvent sound) {
        return new InstrumentImpl(id, sound);
    }
}
