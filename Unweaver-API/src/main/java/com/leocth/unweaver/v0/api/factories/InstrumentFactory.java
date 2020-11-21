package com.leocth.unweaver.v0.api.factories;

import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface InstrumentFactory {
    InstrumentFactory VANILLA = (state, world, pos) ->
            InstrumentImpl.Vanilla.get(net.minecraft.block.enums.Instrument.fromBlockState(state));

    @Nullable Instrument get(BlockState state, World world, BlockPos pos);
}
