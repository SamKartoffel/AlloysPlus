package isaac.mod.creativeTabs;

import isaac.mod.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockTab extends CreativeTabs {
	
	public BlockTab(String label) {
		super("blocktab");
		
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockInit.BLOCK_SILVER);
	}

}
