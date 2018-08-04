package isaac.mod.world.gen;

import java.util.Random;

import isaac.mod.init.BlockInit;
import isaac.mod.objects.blocks.BlockOres;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator{
	
	private WorldGenerator ore_overworld_bismuth;
	private WorldGenerator ore_overworld_cadmium;
	private WorldGenerator ore_overworld_carbon;
	private WorldGenerator ore_overworld_copper;
	private WorldGenerator ore_overworld_lead;
	private WorldGenerator ore_overworld_nickel;
	private WorldGenerator ore_overworld_nitinol;
	private WorldGenerator ore_overworld_silver;
	private WorldGenerator ore_overworld_tin;
	private WorldGenerator ore_overworld_titanium;
	private WorldGenerator ore_overworld_zinc;

	
	public WorldGenCustomOres() {
		ore_overworld_bismuth = new WorldGenMinable(BlockInit.ORE_BISMUTH.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_cadmium = new WorldGenMinable(BlockInit.ORE_CADMIUM.getDefaultState(), 2, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_carbon = new WorldGenMinable(BlockInit.ORE_CARBON.getDefaultState(), 7, BlockMatcher.forBlock(Blocks.COAL_ORE));
		ore_overworld_copper = new WorldGenMinable(BlockInit.ORE_COPPER.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_lead = new WorldGenMinable(BlockInit.ORE_LEAD.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_nickel = new WorldGenMinable(BlockInit.ORE_NICKEL.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_nitinol = new WorldGenMinable(BlockInit.ORE_NITINOL.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_silver = new WorldGenMinable(BlockInit.ORE_SILVER.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_tin = new WorldGenMinable(BlockInit.ORE_TIN.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_titanium = new WorldGenMinable(BlockInit.ORE_TITANIUM.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_zinc = new WorldGenMinable(BlockInit.ORE_ZINC.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
	}


	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, 
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		if(world.provider.getDimension() == 0) {
			runGenerator(ore_overworld_bismuth, world, random, chunkX, chunkZ, 10, 0, 20);
			runGenerator(ore_overworld_cadmium, world, random, chunkX, chunkZ, 50, 0, 30);
			runGenerator(ore_overworld_carbon, world, random, chunkX, chunkZ, 110, 0, 100);
			runGenerator(ore_overworld_copper, world, random, chunkX, chunkZ, 19, 0, 64);
			runGenerator(ore_overworld_lead, world, random, chunkX, chunkZ, 15, 0, 30);
			runGenerator(ore_overworld_nickel, world, random, chunkX, chunkZ, 20, 0, 40);
			runGenerator(ore_overworld_nitinol, world, random, chunkX, chunkZ, 15, 20, 50);
			runGenerator(ore_overworld_silver, world, random, chunkX, chunkZ, 10, 0, 50);
			runGenerator(ore_overworld_tin, world, random, chunkX, chunkZ, 10, 0, 50);
			runGenerator(ore_overworld_titanium, world, random, chunkX, chunkZ, 60, 0, 30);
			runGenerator(ore_overworld_zinc, world, random, chunkX, chunkZ, 10, 30, 40);
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX,
			int chunkZ, int chance, int minHeight, int maxHeight) {
		
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new 
		IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++) {
			
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
		
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
