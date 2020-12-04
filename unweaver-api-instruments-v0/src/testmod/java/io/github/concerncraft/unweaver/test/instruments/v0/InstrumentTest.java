package io.github.concerncraft.unweaver.test.instruments.v0;

import com.google.common.collect.ImmutableMap;
import io.github.concerncraft.unweaver.api.instruments.v0.Instrument;
import io.github.concerncraft.unweaver.api.instruments.v0.InstrumentFactory;
import io.github.concerncraft.unweaver.api.instruments.v0.InstrumentFactoryRegistry;
import io.github.concerncraft.unweaver.util.Ids;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundEvents;

public class InstrumentTest {
    public static void init() {
        Instrument bellInstrument = Instrument.create(Ids.unweaver("bell"), SoundEvents.BLOCK_BELL_USE);

        InstrumentFactoryRegistry.INSTANCE.register(
            InstrumentFactory.withBlockUnderneath(
                ImmutableMap.of(Blocks.BELL, bellInstrument)
            )
        );
    }
}
