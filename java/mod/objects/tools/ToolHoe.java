package isaac.mod.objects.tools;

import isaac.mod.Main;
import isaac.mod.init.ToolsInit;
import isaac.mod.utl.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.PotionEffect;

public class ToolHoe extends ItemHoe implements IHasModel {

	private PotionEffect effect;
	
	public ToolHoe(String name, ToolMaterial material, CreativeTabs tab, PotionEffect potion) {
		super(material);
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
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");	
	}

}
