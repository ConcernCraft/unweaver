package com.leocth.unweaver.v0.api.enums.world;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import com.leocth.unweaver.v0.impl.enums.world.DifficultyImpl;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public interface Difficulty extends ExtendedEnum<net.minecraft.world.Difficulty> {

    CachedVanillaFactory<net.minecraft.world.Difficulty, Difficulty> VANILLA
            = new CachedVanillaFactory<>(DifficultyImpl::new);

    Difficulty PEACEFUL = VANILLA.get(net.minecraft.world.Difficulty.PEACEFUL);
    Difficulty EASY     = VANILLA.get(net.minecraft.world.Difficulty.EASY);
    Difficulty NORMAL   = VANILLA.get(net.minecraft.world.Difficulty.NORMAL);
    Difficulty HARD     = VANILLA.get(net.minecraft.world.Difficulty.HARD);

    Identifier getId();

    default Text getTranslatableName() {
        Identifier id = this.getId();
        if (!this.isCustom() || id.getNamespace().equals("minecraft")) {
            // vanilla; preserve backwards compat
            return new TranslatableText(String.format("options.difficulty.%s", id.getPath()));
        }
        return new TranslatableText(String.format("options.difficulty.%s.%s", id.getNamespace(), id.getPath()));
    }

    class Builder {
        public final Identifier id;

        private Builder(Identifier id) {
            this.id = id;
        }

        public static Builder create(Identifier id) {
            return new Builder(id);
        }

        public Difficulty build() {
            return new DifficultyImpl(this);
        }
    }
}
