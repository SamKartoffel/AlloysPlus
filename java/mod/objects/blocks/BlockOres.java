package isaac.mod.objects.blocks;

import java.util.Random;

import isaac.mod.Main;
import isaac.mod.init.BlockInit;
import isaac.mod.init.ItemInit;
import isaac.mod.objects.blocks.item.ItemBlockVariants;
import isaac.mod.utl.interfaces.IHasModel;
import isaac.mod.utl.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockOres extends Block implements IHasModel{
	
	private Item drop;
	public BlockOres(String name, Material material, float hardness, float res,
			int harvLevel, Item dropped) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.blocktab);
		this.setHardness(hardness);
		this.setResistance(res);
		this.setHarvestLevel("pickaxe", harvLevel);
		drop = dropped;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(drop == null)
		drop = super.getItemDropped(state, rand, fortune);
		return drop;
	}
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");	
	}


}
