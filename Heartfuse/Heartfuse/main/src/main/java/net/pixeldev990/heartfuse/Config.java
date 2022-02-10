package net.pixeldev990.heartfuse;



import com.bb1.fabric.bfapi.Constants;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.pixeldev990.heartfuse.item.ModItems;


public class Config extends com.bb1.fabric.bfapi.config.Config {

	public Config() {
		super(new Identifier(/*I dont know what to put here */));
	}

	Object self = (Object) this;
	public static final String MOD_ID = "lifesteal";

	//ItemGroup
	public static final ItemGroup LIFESTEAL = FabricItemGroupBuilder.build(
			new Identifier("lifesteal", "general"),
			() -> new ItemStack(ModItems.HEART));
	/** 
	 * The max health a player can have
	 * 
	 * @apiNote if the maxHealth is set to <=0 then this constraint will be ignored
	 */
	public double maxHealth = -1D;
	/** 
	 * The minimum health a player can have in order to lose hearts
	 * 
	 * @apiNote if a player's health is less than or equal to this value the player is unable to lose health
	 */
	public double minHealth = 0D;
	/** When the player looses their last heart they get banned from the server */
	public boolean banWhenHealthReachesZero = true;
	/** The amount of health to lose on death */
	public double healthToLooseOnDeath = 2D;
	/** If players should lose health only if the player's death was caused by another player */
	public boolean looseHealthOnlyOnPlayerRelatedDeath = true;

	public String banReason = "You have been banned due to your health reaching 0!";
	
	public JsonObject storage = new JsonObject();


}
