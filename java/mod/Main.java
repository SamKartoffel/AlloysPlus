package isaac.mod;

import com.google.common.graph.Network;

import isaac.mod.creativeTabs.ArmorTab;
import isaac.mod.creativeTabs.BlockTab;
import isaac.mod.creativeTabs.IngotTab;
import isaac.mod.creativeTabs.MiscTab;
import isaac.mod.creativeTabs.ToolsTab;
import isaac.mod.proxy.CommonProxy;
import isaac.mod.utl.Reference;
import isaac.mod.utl.handlers.GuiHandler;
import isaac.mod.utl.handlers.RecipeHandler;
import isaac.mod.utl.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	

	public static final CreativeTabs armortab = new ArmorTab("armortab");
	public static final CreativeTabs blocktab = new BlockTab("blocktab");
	public static final CreativeTabs ingottab = new IngotTab("ingottab");
	public static final CreativeTabs toolstab = new ToolsTab("toolstab");
	public static final CreativeTabs misctab = new MiscTab("misctab");

	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
			RegistryHandler.otherRegistries();
	}
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
		RecipeHandler.registerSmelting();
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
			
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
	
	}
	
}
