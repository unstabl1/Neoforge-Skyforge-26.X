package net.notunstabl.skyforge.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.notunstabl.skyforge.Skyforge;
import net.notunstabl.skyforge.item.custom.ColossalExperienceBottleItem;
import net.notunstabl.skyforge.item.custom.EnchantedItem;
import net.notunstabl.skyforge.item.custom.GrandExperienceBottleItem;
import net.notunstabl.skyforge.item.custom.TitanicExperienceBottleItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Skyforge.MOD_ID);

    //public static final DeferredItem<Item> ENCHANTED_REDSTONE = ITEMS.registerSimpleItem("enchanted_redstone",
    //     properties -> properties);


    public static final DeferredItem<Item> ENCHANTED_DIAMOND = ITEMS.registerItem("enchanted_diamond",
            properties -> new EnchantedItem(properties));

    public static final DeferredItem<Item> ENCHANTED_REDSTONE = ITEMS.registerItem("enchanted_redstone",
            properties -> new EnchantedItem(properties));

    public static final DeferredItem<Item> GRAND_EXPERIENCE_BOTTLE = ITEMS.registerItem("grand_experience_bottle",
            properties -> new GrandExperienceBottleItem(properties));

    public static final DeferredItem<Item> TITANIC_EXPERIENCE_BOTTLE = ITEMS.registerItem("titanic_experience_bottle",
            properties -> new TitanicExperienceBottleItem(properties));

public static final DeferredItem<Item> COLOSSAL_EXPERIENCE_BOTTLE = ITEMS.registerItem("colossal_experience_bottle",
            properties -> new ColossalExperienceBottleItem(properties));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
