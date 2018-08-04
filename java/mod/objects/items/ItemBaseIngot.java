package isaac.mod.objects.items;

import isaac.mod.Main;
import isaac.mod.init.IngotInit;
import isaac.mod.utl.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBaseIngot extends Item implements IHasModel{
	
	public ItemBaseIngot(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.ingottab);
		
		IngotInit.INGOTS.add(this);
	}

	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");	
	}

}
