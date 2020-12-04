package io.github.concerncraft.unweaver.api.instruments.v0;

import io.github.concerncraft.unweaver.impl.instruments.v0.InstrumentImpl;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
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
                    net.minecraft.block.enums.Instrument.fromBlockState(
                        getBlockUnderneath(world, pos)
                    )
                )
            );

    Optional<Instrument> get(BlockState state, World world, BlockPos pos);

    static InstrumentFactory withBlockUnderneath(Map<Block, Instrument> stateToInstrument) {
        return (state, world, pos) -> Optional.ofNullable(stateToInstrument.get(getBlockUnderneath(world, pos).getBlock()));
    }

    static BlockState getBlockUnderneath(World world, BlockPos pos) {
        return world.getBlockState(pos.down());
    }
}
