package isaac.mod.utl.handlers;

import isaac.mod.objects.blocks.machines.alloyfurnace.TileEntityAlloyFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	public static void registerTileEntities() {
		
		GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, "alloy_furnace");
	}

}
