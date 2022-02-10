package net.pixeldev990.heartfuse;


import com.bb1.fabric.bfapi.GameObjects;
import org.jetbrains.annotations.NotNull;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Loader implements ModInitializer {
	
	private static final Config CONFIG = new Config();
	
	public static final @NotNull Config getConfig() { return CONFIG; }
	
	private static final Map<UUID, Integer> DEATH_MAP = new HashMap<UUID, Integer>();
	
	public static final int getDeathsOf(UUID of) { return DEATH_MAP.getOrDefault(of, 0); }
	
	public static final void incrementDeathsBy(UUID of, int amount) { DEATH_MAP.put(of, (DEATH_MAP.getOrDefault(of, 0)+amount)); }
	
	@Override
	public void onInitialize() {
		CONFIG.load();
		CONFIG.save();
		for (Map.Entry<String, JsonElement> entry : CONFIG.storage.entrySet()) {
			try {
				DEATH_MAP.put(UUID.fromString(entry.getKey()), entry.getValue().getAsInt());
			} catch (Throwable t) { }
		}
		GameObjects.GameEvents.SERVER_STOP.addHandler((server)->{
			CONFIG.load();
			JsonObject jsonObject = new JsonObject();
			for (Map.Entry<UUID, Integer> entry : DEATH_MAP.entrySet()) {
				jsonObject.addProperty(entry.getKey().toString(), entry.getValue());
			}
			CONFIG.storage = jsonObject;
			CONFIG.save();
		});
	}

}
