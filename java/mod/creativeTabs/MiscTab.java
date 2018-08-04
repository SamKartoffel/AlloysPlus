package isaac.mod.creativeTabs;

import isaac.mod.init.ArmorInit;
import isaac.mod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MiscTab extends CreativeTabs{

	public MiscTab(String label) {
		super("misctab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.WIRE_NITINOL);
	}
}
