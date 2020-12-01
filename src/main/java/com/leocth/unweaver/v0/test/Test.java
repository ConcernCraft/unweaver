package com.leocth.unweaver.v0.test;

import com.leocth.unweaver.v0.api.Ids;
import com.leocth.unweaver.v0.api.enums.blocks.enums.Instrument;
import com.leocth.unweaver.v0.api.registries.blocks.enums.InstrumentFactoryRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;

import java.util.Optional;

public class Test implements ModInitializer {


    public static final Instrument MY_INSTRUMENT = Instrument.create("my_instrument", SoundEvents.BLOCK_BELL_USE);

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, Ids.unweaver("test_item"), new TestItem(new Item.Settings().food(FoodComponents.POTATO)));

        InstrumentFactoryRegistry.INSTANCE.register((state, world, pos) -> {
            // match/when exprs when
            BlockState beneath = world.getBlockState(pos.down());
            if (beneath.getBlock() == Blocks.BELL) {
                return Optional.of(MY_INSTRUMENT);
            }
            return Optional.empty();
        });

    }
}
