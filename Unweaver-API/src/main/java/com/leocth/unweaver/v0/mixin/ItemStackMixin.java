package com.leocth.unweaver.v0.mixin;

import com.leocth.unweaver.v0.api.enums.util.UseAction;
import com.leocth.unweaver.v0.impl.enums.util.UseActionImpl;
import com.leocth.unweaver.v0.impl.traits.ItemStackTrait;
import com.leocth.unweaver.v0.api.containers.util.UseActionContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemStack.class)
public class ItemStackMixin implements ItemStackTrait {
    @Override
    public UseAction getUseAction() {
        ItemStack dis = ((ItemStack) (Object) this);
        Item item = dis.getItem();

        if (item instanceof UseActionContainer)
            return ((UseActionContainer) item).getCustomUseAction(dis);
        else
            return UseActionImpl.VANILLA.get(dis.getUseAction());
    }
}
