package isaac.mod.objects.tools;

import java.util.Set;

import com.google.common.collect.Sets;

import isaac.mod.Main;
import isaac.mod.init.ToolsInit;
import isaac.mod.utl.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.PotionEffect;

public class ToolAxe extends ItemTool implements IHasModel {
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);

	private PotionEffect effect;
	
	public ToolAxe(String name, ToolMaterial material, CreativeTabs tab, PotionEffect potion) {
		super(material, EFFECTIVE_ON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		this.effect = potion;
		
		ToolsInit.TOOLS.add(this);
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker){
        stack.damageItem(1, attacker);
        
        if(target instanceof EntityLivingBase && target.getHealth() > 0.0F) {
	        target.addPotionEffect(effect);
        }
        return true;
    }

    public float getStrVsBlock(ItemStack stack, IBlockState state){
    	
    	
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency;    }

    @Override
	public void registerModels() {
    	
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
