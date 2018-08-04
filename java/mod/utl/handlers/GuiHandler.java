package isaac.mod.utl.handlers;

import isaac.mod.objects.blocks.machines.alloyfurnace.ContainerAlloyFurnace;
import isaac.mod.objects.blocks.machines.alloyfurnace.GUIAlloyFurnace;
import isaac.mod.objects.blocks.machines.alloyfurnace.TileEntityAlloyFurnace;
import isaac.mod.utl.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_ALLOY_MAKER)return new  ContainerAlloyFurnace(player.inventory, (TileEntityAlloyFurnace)world.getTileEntity(new BlockPos(x, y, z))); 
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_ALLOY_MAKER)return new  GUIAlloyFurnace(player.inventory, (TileEntityAlloyFurnace)world.getTileEntity(new BlockPos(x, y, z))); 
		return null;
	}

}
