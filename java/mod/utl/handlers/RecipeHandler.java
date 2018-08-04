package isaac.mod.utl.handlers;

import java.util.ArrayList;
import java.util.List;

import isaac.mod.init.IngotInit;
import isaac.mod.init.ItemInit;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	
	public static void registerSmelting() {
		GameRegistry.addSmelting(ItemInit.FRAGMENT_OBSIDIAN, new ItemStack(IngotInit.INGOT_OBSIDIAN), 15.0F);
		GameRegistry.addSmelting(ItemInit.CHUNK_CADMIUM, new ItemStack(IngotInit.INGOT_CADMIUM), 15.0F);
		GameRegistry.addSmelting(ItemInit.CHUNK_CARBON, new ItemStack(IngotInit.INGOT_CARBON), 15.0F);
		GameRegistry.addSmelting(Items.IRON_INGOT, new ItemStack(IngotInit.INGOT_HEATED_IRON), 15.0F);

	
	}

}
