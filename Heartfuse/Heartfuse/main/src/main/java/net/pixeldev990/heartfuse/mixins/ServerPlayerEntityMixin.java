package net.pixeldev990.heartfuse.mixins;


import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.pixeldev990.heartfuse.Config;
import net.pixeldev990.heartfuse.Loader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {
	
	@Inject(method = "onDeath", at = @At("TAIL"))
	public void onDeathLowerMaxHealth(DamageSource source, CallbackInfo callbackInfo) {
		Entity entity = source.getAttacker();
		if (Loader.getConfig().looseHealthOnlyOnPlayerRelatedDeath) {
			if (entity instanceof ServerPlayerEntity) {
				updateValueOf((ServerPlayerEntity)(Object)this, 1);
				updateValueOf((ServerPlayerEntity)entity, -1);
			}
		} else {
			updateValueOf((ServerPlayerEntity)(Object)this, 1);
			if (entity instanceof ServerPlayerEntity) {
				updateValueOf((ServerPlayerEntity)entity, -1);
			}
		}
	}
	
	private void updateValueOf(ServerPlayerEntity of, int by) {
		final Config config = Loader.getConfig();
		Loader.incrementDeathsBy(of.getUuid(), by);
		EntityAttributeInstance health = of.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH); // of.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
		double value = 20D-(config.healthToLooseOnDeath*Loader.getDeathsOf(of.getUuid()));
		if (value<config.minHealth) {
			value = config.minHealth;
		} else if (config.maxHealth>0 && value>=config.maxHealth) {
			value = config.maxHealth;
		}
		health.setBaseValue(value);
	}
	
}
