package isaac.mod.creativeTabs;

import isaac.mod.init.IngotInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class IngotTab extends CreativeTabs{
	
	public IngotTab(String label) {
		super("ingottab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(IngotInit.INGOT_BISMUTH);
	}

}
