package com.leocth.unweaver.v0.impl.enums.world;

import com.leocth.unweaver.v0.api.Ids;
import com.leocth.unweaver.v0.api.enums.world.Difficulty;
import com.leocth.unweaver.v0.impl.enums.AbstractExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.OptionalInt;

public class DifficultyImpl extends AbstractExtendedEnum<net.minecraft.world.Difficulty> implements Difficulty {

    private final Identifier id;
    private final int numericId;

    public DifficultyImpl(Builder builder) {
        super(null);
        this.id = builder.id;
        this.numericId = builder.numericId;
    }

    public DifficultyImpl(net.minecraft.world.Difficulty vanilla) {
        super(vanilla);
        this.id = Ids.vanilla(vanilla.getName());
        this.numericId = vanilla.getId();
    }

    @Override
    public @NotNull Identifier getId() {
        return id;
    }

    @Override
    public int getNumericId() {
        return numericId;
    }

    public static class Builder implements Difficulty.Builder {
        private final Identifier id;
        private int numericId;

        public Builder(Identifier id) {
            this.id = id;
        }

        public Difficulty build() {
            return new DifficultyImpl(this);
        }

        @Override
        public Difficulty.Builder numericId(int numericId) {
            this.numericId = numericId;
            return this;
        }
    }

}
