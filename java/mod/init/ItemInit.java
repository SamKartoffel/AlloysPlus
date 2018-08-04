package isaac.mod.init;

import java.util.ArrayList;
import java.util.List;

import isaac.mod.objects.armor.ArmorBase;
import isaac.mod.objects.items.ItemBaseFood;
import isaac.mod.objects.items.ItemBaseIngot;
import isaac.mod.objects.items.ItemBaseItems;
import isaac.mod.objects.tools.ToolAxe;
import isaac.mod.objects.tools.ToolHoe;
import isaac.mod.objects.tools.ToolPickaxe;
import isaac.mod.objects.tools.ToolShovel;
import isaac.mod.objects.tools.ToolSword;
import isaac.mod.utl.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Foods
	public static final Item SLICE_CHEESE = new ItemBaseFood("slice_cheese", 1, false);
	public static final Item SLICE_CAKE = new ItemBaseFood("slice_cake", 2, true, new PotionEffect(Potion.getPotionById(1), 1000, 10, false, false));
	
	
	//Utility Armor components
	public static final Item WIRE_NITINOL = new ItemBaseItems("wire_nitinol");
	
	public static final Item ROBOTIC_LEG = new ItemBaseItems("robotic_leg");
	
	//Ore Fragments and pieces
	public static final Item FRAGMENT_CADMIUM = new ItemBaseItems("fragment_cadmium");
	public static final Item FRAGMENT_OBSIDIAN = new ItemBaseItems("fragment_obsidian");
	public static final Item FRAGMENT_ROBOTIC = new ItemBaseItems("fragment_robotic");
	
	public static final Item CHUNK_CADMIUM = new ItemBaseItems("chunk_cadmium");
	public static final Item CHUNK_CARBON = new ItemBaseItems("chunk_carbon");

	


}
