package io.github.concerncraft.unweaver.impl.sculks.v0;

import io.github.concerncraft.unweaver.api.sculks.v0.SculkFrequencyRegistry;
import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;
import net.minecraft.class_5712;

import java.util.OptionalInt;

public class SculkFrequencyRegistryImpl implements SculkFrequencyRegistry {

    private final Reference2IntOpenHashMap<class_5712> vibrationToFrequency
            = new Reference2IntOpenHashMap<>();

    @Override
    public void register(class_5712 vibrationType, int frequency) {
        vibrationToFrequency.put(vibrationType, frequency);
    }

    @Override
    public OptionalInt getFrequency(class_5712 vibrationType) {
        return vibrationToFrequency.containsKey(vibrationType)
                ? OptionalInt.of(vibrationToFrequency.getInt(vibrationType))
                : OptionalInt.empty();
    }
}
