package isaac.mod.objects.items;

import isaac.mod.Main;
import isaac.mod.init.ItemInit;
import isaac.mod.utl.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBaseFood extends ItemFood implements IHasModel{

	
	private PotionEffect[] effects;
	
	public ItemBaseFood(String name, int amount, boolean isWolfFood, PotionEffect...potionEffects) {
		
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
		this.effects = potionEffects;
		
		
		
		
		ItemInit.ITEMS.add(this);
	}
	
	 protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player){	
		 
	        for(PotionEffect effect : effects) {
	        	player.addPotionEffect(effect);
	        }
	    }
	

	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
