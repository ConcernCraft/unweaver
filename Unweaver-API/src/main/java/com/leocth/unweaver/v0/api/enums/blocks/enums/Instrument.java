package com.leocth.unweaver.v0.api.enums.blocks.enums;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl.Vanilla;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.StringIdentifiable;

public interface Instrument extends ExtendedEnum<net.minecraft.block.enums.Instrument>, StringIdentifiable {

    Instrument HARP           = Vanilla.get(net.minecraft.block.enums.Instrument.HARP);
    Instrument BASEDRUM       = Vanilla.get(net.minecraft.block.enums.Instrument.BASEDRUM);
    Instrument SNARE          = Vanilla.get(net.minecraft.block.enums.Instrument.SNARE);
    Instrument HAT            = Vanilla.get(net.minecraft.block.enums.Instrument.HAT);
    Instrument BASS           = Vanilla.get(net.minecraft.block.enums.Instrument.BASS);
    Instrument FLUTE          = Vanilla.get(net.minecraft.block.enums.Instrument.FLUTE);
    Instrument BELL           = Vanilla.get(net.minecraft.block.enums.Instrument.BELL);
    Instrument GUITAR         = Vanilla.get(net.minecraft.block.enums.Instrument.GUITAR);
    Instrument CHIME          = Vanilla.get(net.minecraft.block.enums.Instrument.CHIME);
    Instrument XYLOPHONE      = Vanilla.get(net.minecraft.block.enums.Instrument.XYLOPHONE);
    Instrument IRON_XYLOPHONE = Vanilla.get(net.minecraft.block.enums.Instrument.IRON_XYLOPHONE);
    Instrument COW_BELL       = Vanilla.get(net.minecraft.block.enums.Instrument.COW_BELL);
    Instrument DIDGERIDOO     = Vanilla.get(net.minecraft.block.enums.Instrument.DIDGERIDOO);
    Instrument BIT            = Vanilla.get(net.minecraft.block.enums.Instrument.BIT);
    Instrument BANJO          = Vanilla.get(net.minecraft.block.enums.Instrument.BANJO);
    Instrument PLING          = Vanilla.get(net.minecraft.block.enums.Instrument.PLING);

    SoundEvent getSound();

    static Instrument create(String id, SoundEvent sound) {
        return new InstrumentImpl(id, sound);
    }
}
