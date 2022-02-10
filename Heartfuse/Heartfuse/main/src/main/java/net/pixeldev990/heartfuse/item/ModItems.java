package net.pixeldev990.heartfuse.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.pixeldev990.heartfuse.Config;

public class ModItems {

        public static final Item HEART = registerItem("heart", new Item(new FabricItemSettings()
                .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.2f).build()).group(Config.LIFESTEAL)));

                public static final Item BLAZEHEART = registerItem("blazeheart", new Item(new FabricItemSettings().group(Config.LIFESTEAL)
                .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                        .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*3), 1f).build())));

        public static final Item WITHEREHEART = registerItem("witherheart", new Item(new FabricItemSettings().group(Config.LIFESTEAL)
                .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                        .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,20*3), 1f).build())));

        public static final Item SLIMEHEART = registerItem("slimeheart", new Item(new FabricItemSettings().group(Config.LIFESTEAL)
                .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                        .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,20*3), 1f).build())));

                public static final Item PHANTOMHEART = registerItem("phantomheart", new Item(new FabricItemSettings().group(Config.LIFESTEAL)
                .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                        .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,20*3), 1f).build())));

                public static final Item ENDERMANHEART = registerItem("endermanheart", new Item(new FabricItemSettings().group(Config.LIFESTEAL)
                .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                        .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*3), 1f).build())));

        private static Item registerItem(String name, Item item) {
                return Registry.register(Registry.ITEM, new Identifier(Config.MOD_ID, name), item);
        }
        public static void registerModItems() {
                System.out.println("Registering Mod Items for " + Config.MOD_ID);
        }
}