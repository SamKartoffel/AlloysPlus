package isaac.mod.utl.handlers;
import isaac.mod.init.ArmorInit;
import isaac.mod.init.BlockInit;
import isaac.mod.init.IngotInit;
import isaac.mod.init.ItemInit;
import isaac.mod.init.ToolsInit;
import isaac.mod.utl.interfaces.IHasModel;
import isaac.mod.world.gen.WorldGenCustomOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {
	
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item [0]));
	}
	
	@SubscribeEvent
	public static void onRecipeRegister(RegistryEvent.Register<Item> event) {
				
	}	
	@SubscribeEvent
	public static void onArmorRegister(RegistryEvent.Register<Item> event) {
		
		event.getRegistry().registerAll(ArmorInit.ARMOR.toArray(new Item [0]));
	}
	
	@SubscribeEvent
	public static void onToolRegister(RegistryEvent.Register<Item> event) {
		
		event.getRegistry().registerAll(ToolsInit.TOOLS.toArray(new Item [0]));
	}
	
	@SubscribeEvent
	public static void onIngotRegister(RegistryEvent.Register<Item> event) {
		
		event.getRegistry().registerAll(IngotInit.INGOTS.toArray(new Item [0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block [0]));
		TileEntityHandler.registerTileEntities();
	}
	
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		
		for(Item item :ItemInit.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for(Item item :ArmorInit.ARMOR) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		for(Item item :ToolsInit.TOOLS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		for(Item item :IngotInit.INGOTS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block :BlockInit.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
		
	}
	
	public static void otherRegistries() {
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
	}
	
}
