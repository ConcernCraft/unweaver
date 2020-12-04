package io.github.concerncraft.unweaver.impl.instruments.v0;

import io.github.concerncraft.unweaver.api.instruments.v0.Instrument;
import io.github.concerncraft.unweaver.impl.enums.AbstractExtendedEnum;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class InstrumentImpl extends AbstractExtendedEnum<net.minecraft.block.enums.Instrument> implements Instrument {

    private final Identifier id;
    private final SoundEvent sound;

    public InstrumentImpl(Identifier id, SoundEvent sound) {
        super(null);
        this.id = id;
        this.sound = sound;
    }

    public InstrumentImpl(net.minecraft.block.enums.Instrument vanilla) {
        super(vanilla);
        this.id = new Identifier(vanilla.name().toLowerCase());
        this.sound = vanilla.getSound();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public SoundEvent getSound() {
        return sound;
    }
}
