package isaac.mod.init;

import java.util.ArrayList;
import java.util.List;

import isaac.mod.objects.blocks.BlockBaseAlloys;
import isaac.mod.objects.blocks.BlockOres;
import isaac.mod.objects.blocks.machines.alloyfurnace.BlockAlloyFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	public static final Block BLOCK_BISMUTH = new BlockBaseAlloys("block_bismuth", Material.IRON, 5.0F, 2000.0F, 3);
	public static final Block BLOCK_BRONZE = new BlockBaseAlloys("block_bronze", Material.IRON, 5.0F, 2000.0F, 4);
	public static final Block BLOCK_CADMIUM = new BlockBaseAlloys("block_cadmium", Material.IRON, 5.0F, 2000.0F, 4);
	public static final Block BLOCK_CARBON = new BlockBaseAlloys("block_carbon", Material.IRON, 5.0F, 2000.0F, 2);
	public static final Block BLOCK_COPPER = new BlockBaseAlloys("block_copper", Material.IRON, 2.0F, 7.0F, 2);
	public static final Block BLOCK_ELECTRUM = new BlockBaseAlloys("block_electrum", Material.IRON, 5.0F, 2000.0F, 4);
	public static final Block BLOCK_LEAD = new BlockBaseAlloys("block_lead", Material.IRON, 5.0F, 2000.0F, 3);
	public static final Block BLOCK_NICKEL = new BlockBaseAlloys("block_nickel", Material.IRON, 3.0F, 2000.0F, 2);
	public static final Block BLOCK_NITINOL = new BlockBaseAlloys("block_nitinol", Material.IRON, 3.0F, 2000.0F, 3);
	public static final Block BLOCK_OBSIDISTEEL = new BlockBaseAlloys("block_obsidisteel", Material.IRON, 12.0F, 2000.0F, 3);
	public static final Block BLOCK_SILVER = new BlockBaseAlloys("block_silver", Material.IRON, 5.0F, 7.0F, 2);
	public static final Block BLOCK_STEEL = new BlockBaseAlloys("block_steel", Material.IRON, 4.0F, 6.0F, 3);
	public static final Block BLOCK_TIN = new BlockBaseAlloys("block_tin", Material.IRON, 5.0F, 2000.0F, 2);
	public static final Block BLOCK_TITANIUM = new BlockBaseAlloys("block_titanium", Material.IRON, 5.3F, 2000.0F, 4);
	public static final Block BLOCK_WOODS = new BlockBaseAlloys("block_woods", Material.IRON, 7.0F, 2000.0F, 4);
	public static final Block BLOCK_ZINC = new BlockBaseAlloys("block_zinc", Material.IRON, 5.0F, 2000.0F, 3);
	
	
	//Ores
	public static final Block ORE_BISMUTH = new BlockOres("ore_bismuth", Material.ROCK, 6.0F, 7.0F, 2, null);
	public static final Block ORE_CADMIUM = new BlockOres("ore_cadmium", Material.ROCK, 3.0F, 15.0F, 4, ItemInit.FRAGMENT_CADMIUM);
	public static final Block ORE_CARBON = new BlockOres("ore_carbon", Material.ROCK, 3.0F, 15.0F, 3, ItemInit.CHUNK_CARBON);
	public static final Block ORE_COPPER = new BlockOres("ore_copper", Material.ROCK, 5.0F, 7.0F, 2, null);
	public static final Block ORE_LEAD = new BlockOres("ore_lead", Material.ROCK, 7.0F, 7.0F, 2, null);
	public static final Block ORE_NICKEL = new BlockOres("ore_nickel", Material.ROCK, 5.0F, 2.000F, 2, null);
	public static final Block ORE_NITINOL = new BlockOres("ore_nitinol", Material.ROCK, 4.0F, 6.0F, 3, null);
	public static final Block ORE_SILVER = new BlockOres("ore_silver", Material.ROCK, 5.0F, 7.0F, 2, null);
	public static final Block ORE_TIN = new BlockOres("ore_tin", Material.ROCK, 4.0F, 7.0F, 2, null);
	public static final Block ORE_TITANIUM = new BlockOres("ore_titanium", Material.ROCK, 5.0F, 2000.0F, 4, null);
	public static final Block ORE_ZINC = new BlockOres("ore_zinc", Material.ROCK, 5.0F, 2000.0F, 3, null);


	public static final Block ALLOY_FURNACE = new BlockAlloyFurnace("alloy_furnace");

	

}
