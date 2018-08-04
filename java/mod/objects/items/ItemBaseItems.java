package isaac.mod.objects.items;

import isaac.mod.Main;
import isaac.mod.init.IngotInit;
import isaac.mod.init.ItemInit;
import isaac.mod.utl.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemBaseItems extends Item implements IHasModel{
	
	public ItemBaseItems(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.misctab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");	
	}

}
