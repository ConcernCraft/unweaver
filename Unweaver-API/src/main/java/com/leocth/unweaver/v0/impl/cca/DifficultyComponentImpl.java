package com.leocth.unweaver.v0.impl.cca;

import com.leocth.unweaver.v0.api.cca.DifficultyComponent;
import com.leocth.unweaver.v0.api.enums.world.Difficulty;
import com.leocth.unweaver.v0.api.registries.world.DifficultyRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class DifficultyComponentImpl implements DifficultyComponent {

    @Nullable
    private Difficulty difficulty;

    @Override
    public @Nullable Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public void setDifficulty(@Nullable Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        DifficultyRegistry.INSTANCE.get(new Identifier(tag.getString("UwvrDifficulty")))
                .ifPresent(diff -> this.difficulty = diff);
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        if (difficulty != null)
            tag.putString("UwvrDifficulty", difficulty.getId().toString());
    }

}
