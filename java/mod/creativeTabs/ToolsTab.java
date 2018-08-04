package isaac.mod.creativeTabs;

import isaac.mod.init.ArmorInit;
import isaac.mod.init.ItemInit;
import isaac.mod.init.ToolsInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ToolsTab extends CreativeTabs {
	
	public ToolsTab(String label) {
		super("toolstab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ToolsInit.PICKAXE_BRONZE);
	}

}
