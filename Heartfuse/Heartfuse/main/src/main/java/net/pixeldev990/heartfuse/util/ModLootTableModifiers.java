package net.pixeldev990.heartfusesmp.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.pixeldev990.heartfusesmp.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier GRASS_BLOCK_ID
            = new Identifier("minecraft", "blocks/grass");

    private static final Identifier VILLAGE_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/VILLAGE_chest");

    private static final Identifier IGLOO_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/igloo_chest");

    private static final Identifier DESERT_TEMPLE_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/desert_temple_chest");

    private static final Identifier STRONGHOLD_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/stronghold_chest");

    private static final Identifier TREASURE_BASTION_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/treasure_bastion_chest");

    private static final Identifier ENDCITY_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/endcity_chest");

    public static void modifyLootTables() {
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            //check for leaves loot table.
            if(GRASS_BLOCK_ID.equals(id)) {
                // Adds pepper Seeds to the grass loot table.
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.35f)) // Drops 35% of the time
                        .with(ItemEntry.builder(ModItems.heart))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(VILLAGE_STRUCTURE_CHEST_ID.equals(id)) {

                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.HEART))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());

                if(IGLOO_STRUCTURE_CHEST_ID.equals(id)) {

                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(1f))
                            .with(ItemEntry.builder(ModItems.HEART))
                            .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    supplier.withPool(poolBuilder.build());

                    if(DESERT_TEMPLE_STRUCTURE_CHEST_ID.equals(id)) {

                        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(1f))
                                .with(ItemEntry.builder(ModItems.HEART))
                                .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                        supplier.withPool(poolBuilder.build());

                        if(STRONGHOLD_STRUCTURE_CHEST_ID.equals(id)) {

                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                                    .rolls(ConstantLootNumberProvider.create(1))
                                    .conditionally(RandomChanceLootCondition.builder(1f))
                                    .with(ItemEntry.builder(ModItems.HEART))
                                    .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                            supplier.withPool(poolBuilder.build());

                            if(TREASURE_BASTION_STRUCTURE_CHEST_ID.equals(id)) {

                                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                                        .rolls(ConstantLootNumberProvider.create(1))
                                        .conditionally(RandomChanceLootCondition.builder(1f))
                                        .with(ItemEntry.builder(ModItems.HEART))
                                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                                supplier.withPool(poolBuilder.build());

                                if(ENDCITY_STRUCTURE_CHEST_ID.equals(id)) {

                                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                                            .rolls(ConstantLootNumberProvider.create(1))
                                            .conditionally(RandomChanceLootCondition.builder(1f))
                                            .with(ItemEntry.builder(ModItems.HEART))
                                            .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                                    supplier.withPool(poolBuilder.build());
            }
        }));
    }
}