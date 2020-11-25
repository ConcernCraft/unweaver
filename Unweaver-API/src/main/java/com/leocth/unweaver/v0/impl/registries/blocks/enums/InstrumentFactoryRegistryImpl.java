package com.leocth.unweaver.v0.impl.registries.blocks.enums;

import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.api.factories.InstrumentFactory;
import com.leocth.unweaver.v0.api.registries.blocks.enums.InstrumentFactoryRegistry;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class InstrumentFactoryRegistryImpl implements InstrumentFactoryRegistry {

    private static final Instrument DEFAULT = Instrument.VANILLA.get(net.minecraft.block.enums.Instrument.HARP);
    private final ObjectArrayList<InstrumentFactory> factories = new ObjectArrayList<>();

    public void register(InstrumentFactory factory) {
        assert factory != null;
        factories.add(factory);
    }

    @Override
    public Optional<Instrument> get(BlockState state, World world, BlockPos pos) {
        // functional pogramming go brrrrrrrrrrrr                           - comments to maintain my sanity
        return factories.stream()                                           // get all the factories
                .map(factory -> factory.get(state, world, pos))             // lazily evaluate/get them in order
                .filter(Optional::isPresent)                                // filter out valid instruments
                .findFirst()                                                // find the first valid one
                .orElseGet(                                                 // if no dice then use the vanilla fallback
                    () -> InstrumentFactory.VANILLA.get(state, world, pos)  // (which may or may not exist)
                );
    }

    @Override
    public Instrument getOrDefault(BlockState state, World world, BlockPos pos) {
        return this.get(state, world, pos).orElse(DEFAULT);
    }
}
