package com.leocth.unweaver.v0.api.registries.blocks.enums;

import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.api.factories.InstrumentFactory;
import com.leocth.unweaver.v0.impl.registries.blocks.enums.InstrumentFactoryRegistryImpl;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * Registry for {@link InstrumentFactory}s.
 *
 * @author leocth
 * @since 0.1.0
 */
public interface InstrumentFactoryRegistry {

    InstrumentFactoryRegistry INSTANCE = new InstrumentFactoryRegistryImpl();

    /**
     * Registers a {@link InstrumentFactory}.
     */
    void register(@NotNull InstrumentFactory factory);

    /**
     * Gets an optional {@link Instrument} by iterating through the registered factories.
     */
    Optional<Instrument> get(BlockState state, World world, BlockPos pos);

    /**
     * Gets an {@link Instrument} by iterating through the registered factories, then
     * returns a default value ({@code Instrument.HARP}) if no factories return a valid result.
     */
    Instrument getOrDefault(BlockState state, World world, BlockPos pos);
}
