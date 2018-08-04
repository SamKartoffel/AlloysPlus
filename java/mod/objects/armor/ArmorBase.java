package isaac.mod.objects.armor;

import com.google.common.eventbus.Subscribe;

import isaac.mod.Main;
import isaac.mod.init.ArmorInit;
import isaac.mod.utl.interfaces.IHasModel;
import it.unimi.dsi.fastutil.Stack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ArmorBase extends ItemArmor implements IHasModel {

	private final PotionEffect potionEffect;
	
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, 
			EntityEquipmentSlot equipmentSlotIn, final PotionEffect potionEffect) {
		
		super(materialIn, renderIndexIn, equipmentSlotIn);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.armortab);
		ArmorInit.ARMOR.add(this);
		this.potionEffect = potionEffect;
		
	}

	@Override
	public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
		if (!player.isPotionActive(potionEffect.getPotion())) { // If the Potion isn't currently active,
			player.addPotionEffect(potionEffect); // Apply a copy of the PotionEffect to the player
		}
	}
	



	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");	
	}

}
