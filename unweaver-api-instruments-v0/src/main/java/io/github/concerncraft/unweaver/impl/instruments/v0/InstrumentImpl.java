package io.github.concerncraft.unweaver.impl.instruments.v0;

import io.github.concerncraft.unweaver.api.instruments.v0.Instrument;
import io.github.concerncraft.unweaver.impl.enums.AbstractExtendedEnum;
import net.minecraft.sound.SoundEvent;

public class InstrumentImpl extends AbstractExtendedEnum<net.minecraft.block.enums.Instrument> implements Instrument {

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
