package net.pixeldev990.heartfusesmp.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.Item.Item;
import net.minecraft.item.Itemgroup;
import net.minecraft.util.Identifier;
import net.util.registry.Registry;
import net.pixeldev990.heartfusesmp.HeartFuseSMP;

        public class ModItems {

                public static final Item HEART = registerItem("heart", new Item(new FabricItemSettings()
                        .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.2f).build())
                        .group(ModItemGroup.FUSE)));

                public static final Item BLAZEHEART = registerItem("blazeheart", new Item(new FabricItemSettings().group(ModItemGroups.COURSE)
                        .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                                .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200 , .SLOW_FALL, 200), 1f).build())));

                public static final Item WITHEREHEART = registerItem("witherheart", new Item(new FabricItemSettings().group(ModItemGroups.COURSE)
                        .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                                .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200 , .HASTE, 200, .STRENGTH, 200, .SPEED, 200), 1f).build())));

                public static final Item SLIMEHEART = registerItem("slimeheart", new Item(new FabricItemSettings().group(ModItemGroups.COURSE)
                        .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                                .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200 , .SLOW_FALL, 200), 1f).build())));

                public static final Item PHANTOMHEART = registerItem("phantomheart", new Item(new FabricItemSettings().group(ModItemGroups.COURSE)
                        .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                                .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200 , .SPEED, 200), 1f).build())));

                public static final Item ENDERMANHEART = registerItem("endermanheart", new Item(new FabricItemSettings().group(ModItemGroups.COURSE)
                        .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                                .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200 , .SLOW_FALL, 200), 1f).build())));

                private static Item registerItem(String name, Item item) {
                        return Registry.register(Registry.ITEM, new Identifier(HeartFuseSMP.MOD_ID, name), item);
                }

                public static void registerModItems() {
                        System.out.println("Registering Mod Items for " + HeartFuseSMP.MOD_ID);
                }
        }