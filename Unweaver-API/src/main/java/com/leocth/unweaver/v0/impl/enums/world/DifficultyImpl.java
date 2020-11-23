package com.leocth.unweaver.v0.impl.enums.world;

import com.leocth.unweaver.v0.api.Ids;
import com.leocth.unweaver.v0.api.enums.world.Difficulty;
import com.leocth.unweaver.v0.impl.enums.AbstractExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import net.minecraft.util.Identifier;

public class DifficultyImpl extends AbstractExtendedEnum<net.minecraft.world.Difficulty> implements Difficulty {

    public static final CachedVanillaFactory<net.minecraft.world.Difficulty, DifficultyImpl> VANILLA
            = new CachedVanillaFactory<>(DifficultyImpl::new);

    private final Identifier id;

    public DifficultyImpl(Builder builder) {
        super(null);
        this.id = builder.id;
    }

    public DifficultyImpl(net.minecraft.world.Difficulty vanilla) {
        super(vanilla);
        this.id = Ids.vanilla(vanilla.getName());
    }

    @Override
    public Identifier getId() {
        return id;
    }

}
