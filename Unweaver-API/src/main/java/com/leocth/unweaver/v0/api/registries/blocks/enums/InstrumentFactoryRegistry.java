package com.leocth.unweaver.v0.api.registries.blocks.enums;

import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.api.factories.InstrumentFactory;
import com.leocth.unweaver.v0.impl.registries.blocks.enums.InstrumentFactoryRegistryImpl;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public interface InstrumentFactoryRegistry {

    InstrumentFactoryRegistry INSTANCE = new InstrumentFactoryRegistryImpl();

    void register(InstrumentFactory factory);

    Optional<Instrument> get(BlockState state, World world, BlockPos pos);

}
