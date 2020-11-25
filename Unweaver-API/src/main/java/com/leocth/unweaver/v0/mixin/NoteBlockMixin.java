package com.leocth.unweaver.v0.mixin;

import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.api.registries.blocks.enums.InstrumentFactoryRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.NoteBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NoteBlock.class)
public class NoteBlockMixin extends Block {
    public NoteBlockMixin(Settings settings) {
        super(settings);
    }

    @Redirect(
            method = "onSyncedBlockEvent",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"),
            require = 0
    )
    private void onSyncedBlockEvent(
            World self, PlayerEntity player, BlockPos pos, SoundEvent soundEvent, SoundCategory category, float volume, float pitch,
            BlockState state
    ) {
        // cant use ModifyArg here cos we need to capture onSyncedBlockEvent's args
        self.playSound(player, pos, InstrumentFactoryRegistry.INSTANCE.getOrDefault(state, self, pos).getSound(), category, volume, pitch);
    }
}
