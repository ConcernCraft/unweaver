package com.leocth.unweaver.v0.api.factories;

import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

/**
 * Factory type that returns a {@link Instrument} with context.
 *
 * @author leocth
 * @since 0.1.0
 */
@FunctionalInterface
public interface InstrumentFactory {

    /**
     * A fallback {@link InstrumentFactory} that returns vanilla instruments based on the block beneath the note block.
     */
    InstrumentFactory VANILLA = (state, world, pos) ->
            Optional.ofNullable(
                InstrumentImpl.VANILLA.get(
                    net.minecraft.block.enums.Instrument.fromBlockState(world.getBlockState(pos.down()))
                )
            );

    Optional<Instrument> get(BlockState state, World world, BlockPos pos);
}
