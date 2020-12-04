package io.github.concerncraft.unweaver.impl.instruments.v0;

import io.github.concerncraft.unweaver.api.instruments.v0.Instrument;
import io.github.concerncraft.unweaver.api.instruments.v0.InstrumentFactory;
import io.github.concerncraft.unweaver.api.instruments.v0.InstrumentFactoryRegistry;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class InstrumentFactoryRegistryImpl implements InstrumentFactoryRegistry {

    private static final Instrument DEFAULT = Instrument.VANILLA.get(net.minecraft.block.enums.Instrument.HARP);
    private final ReferenceArrayList<InstrumentFactory> factories = new ReferenceArrayList<>();

    public void register(@NotNull InstrumentFactory factory) {
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
