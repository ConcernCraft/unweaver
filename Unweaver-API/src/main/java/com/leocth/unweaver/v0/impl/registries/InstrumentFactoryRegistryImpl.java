package com.leocth.unweaver.v0.impl.registries;

import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.api.factories.InstrumentFactory;
import com.leocth.unweaver.v0.api.registries.InstrumentFactoryRegistry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Optional;

public class InstrumentFactoryRegistryImpl implements InstrumentFactoryRegistry {

    private final ObjectArrayList<InstrumentFactory> factories = new ObjectArrayList<>();

    public void register(InstrumentFactory factory) {
        factories.add(factory);
    }

    @Override
    public Optional<Instrument> get(BlockState state, World world, BlockPos pos) {
        Optional<Instrument> maybeInstrument = factories.stream()
                .map(factory -> factory.get(state, world, pos))
                .filter(Objects::nonNull)
                .findFirst();

        // maybe theres a better way to do this. idk
        if (maybeInstrument.isPresent())
            return maybeInstrument;
        else
            return Optional.ofNullable(InstrumentFactory.VANILLA.get(state, world, pos));
    }
}
