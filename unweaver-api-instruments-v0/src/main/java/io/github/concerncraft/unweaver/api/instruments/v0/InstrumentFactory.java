package io.github.concerncraft.unweaver.api.instruments.v0;

import io.github.concerncraft.unweaver.impl.instruments.v0.InstrumentImpl;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

/**
 * Factory type that returns a {@link Instrument} with context.
 *
 * @author leocth
 * @since 0.2.0
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
