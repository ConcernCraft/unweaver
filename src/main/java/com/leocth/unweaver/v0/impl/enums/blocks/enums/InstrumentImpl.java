package com.leocth.unweaver.v0.impl.enums.blocks.enums;

import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.impl.enums.AbstractExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import net.minecraft.sound.SoundEvent;

public class InstrumentImpl extends AbstractExtendedEnum<net.minecraft.block.enums.Instrument> implements Instrument {

    public static final CachedVanillaFactory<net.minecraft.block.enums.Instrument, InstrumentImpl> VANILLA
            = new CachedVanillaFactory<>(InstrumentImpl::new);

    private final String name;
    private final SoundEvent sound;

    public InstrumentImpl(String name, SoundEvent sound) {
        super(null);
        this.name = name;
        this.sound = sound;
    }

    public InstrumentImpl(net.minecraft.block.enums.Instrument vanilla) {
        super(vanilla);
        this.name = vanilla.name();
        this.sound = vanilla.getSound();
    }

    @Override
    public SoundEvent getSound() {
        return sound;
    }

    @Override
    public String asString() {
        return name;
    }
}
