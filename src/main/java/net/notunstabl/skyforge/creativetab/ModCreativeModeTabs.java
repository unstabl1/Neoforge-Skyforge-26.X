package net.notunstabl.skyforge.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.notunstabl.skyforge.Skyforge;
import net.notunstabl.skyforge.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Skyforge.MOD_ID);

    public static final Supplier<CreativeModeTab> SKYBLOCK_RESOURCES_TAB = CREATIVE_MODE_TABS.register("skyblock_resources_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ENCHANTED_DIAMOND.get()))
                    .title(Component.translatable("creativetab.skyforce.skyblock_resources"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ENCHANTED_DIAMOND);
                        output.accept(ModItems.ENCHANTED_REDSTONE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> SKYBLOCK_CONSUMABLES_TAB = CREATIVE_MODE_TABS.register("skyblock_consumables_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.GRAND_EXPERIENCE_BOTTLE.get()))
                    .title(Component.translatable("creativetab.skyforce.skyblock_consumables"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GRAND_EXPERIENCE_BOTTLE);
                        output.accept(ModItems.TITANIC_EXPERIENCE_BOTTLE);
                        output.accept(ModItems.COLOSSAL_EXPERIENCE_BOTTLE);
                    })
                    .build());



    public static void register(IEventBus eventBus) {CREATIVE_MODE_TABS.register(eventBus);
    }
}
