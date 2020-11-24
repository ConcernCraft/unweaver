package com.leocth.unweaver.v0.test;

import com.leocth.unweaver.v0.api.callbacks.ConsumeItemCallback;
import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import com.leocth.unweaver.v0.api.enums.world.Difficulty;
import com.leocth.unweaver.v0.api.registries.blocks.enums.InstrumentFactoryRegistry;
import com.leocth.unweaver.v0.api.registries.world.DifficultyRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Optional;

public class Test implements ModInitializer {

    public static final String MODID = "unweaver";

    public static final UseAction MY_CUSTOM_USEACTION
            = UseAction.Builder.create()
            .armPose((player, hand, stack) -> BipedEntityModel.ArmPose.BOW_AND_ARROW)
            .onConsumeItem(ConsumeItemCallback.whenUsing(
                    (entity, stack, particleCount) ->
                            entity.playSound(SoundEvents.ENTITY_PLAYER_SPLASH, 0.5F, entity.world.random.nextFloat() * 0.1F + 0.9F)
            ))
            .build();

    public static final Instrument MY_INSTRUMENT = Instrument.create("my_instrument", SoundEvents.BLOCK_BELL_USE);

    // tehc - you want it; i made it (peaceful w/o hunger generation thank shnup)
    public static final Difficulty ASIE
            = Difficulty.Builder.create(id("asie"))

                .build();

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, id("test_item"), new TestItem(new Item.Settings().food(FoodComponents.POTATO)));

        InstrumentFactoryRegistry.INSTANCE.register((state, world, pos) -> {
            // match/when exprs when
            BlockState beneath = world.getBlockState(pos.down());
            if (beneath.getBlock() == Blocks.BELL) {
                return Optional.of(MY_INSTRUMENT);
            }
            return Optional.empty();
        });

        DifficultyRegistry.INSTANCE.register(ASIE);

    }

    public static Identifier id(String path) {
        return new Identifier(MODID, path);
    }
}
