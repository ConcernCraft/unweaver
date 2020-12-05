package io.github.concerncraft.unweaver.test.useactions.v0;

import io.github.concerncraft.unweaver.util.Ids;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class UseActionsTest {

    public static final UseActionsTestItem TEST_ITEM = new UseActionsTestItem(new Item.Settings());

    public static void init() {
        Registry.register(Registry.ITEM, Ids.unweaver("useactions_test_item"), TEST_ITEM);
    }
}
