package com.leocth.unweaver.v0.impl.enums.blocks.enums;

import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class InstrumentImpl implements Instrument {

    private final String name;
    private final SoundEvent sound;

    public InstrumentImpl(String name, SoundEvent sound) {
        this.name = name;
        this.sound = sound;
    }

    @Override
    public SoundEvent getSound() {
        return sound;
    }

    @Override
    public String asString() {
        return name;
    }

    @Nullable
    @Override
    public net.minecraft.block.enums.Instrument getVanilla() { return null; }

    public static class Vanilla implements Instrument {

        private static final Object2ObjectOpenHashMap<net.minecraft.block.enums.Instrument, Vanilla> vanillaCache
                = new Object2ObjectOpenHashMap<>();

        private final net.minecraft.block.enums.Instrument vanilla;

        private Vanilla(net.minecraft.block.enums.Instrument vanilla) {
            this.vanilla = vanilla;
        }

        @Override
        public SoundEvent getSound() { return vanilla.getSound(); }

        @Nullable
        @Override
        public net.minecraft.block.enums.Instrument getVanilla() { return vanilla; }

        @Override
        public String asString() { return vanilla.asString(); }

        public static Vanilla get(net.minecraft.block.enums.Instrument vanilla) {
            if (vanillaCache.containsKey(vanilla))
                return vanillaCache.get(vanilla);
            Vanilla impl = new Vanilla(vanilla);
            vanillaCache.put(vanilla, impl);
            return impl;
        }
    }


}
