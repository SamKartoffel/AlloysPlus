package isaac.mod.creativeTabs;

import isaac.mod.init.ArmorInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ArmorTab extends CreativeTabs{

	public ArmorTab(String label) {
		super("armortab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ArmorInit.CHESTPLATE_BRONZE);
	}
}
