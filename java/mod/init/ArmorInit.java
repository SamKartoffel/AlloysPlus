package isaac.mod.init;

import java.util.ArrayList;
import java.util.List;
import isaac.mod.utl.Reference;


import isaac.mod.objects.armor.ArmorBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorInit {
	
	public static final List<Item> ARMOR = new ArrayList<Item>();

	//Bronze Armor
	public static ArmorMaterial ARMOR_BRONZE = EnumHelper.addArmorMaterial("armor_bronze", Reference.MODID + ":bronze", 38, new int[]{4, 6, 5, 4}, 6, SoundEvents.BLOCK_ANVIL_LAND, 0.0F);
	
	public static final Item HELMET_BRONZE = new ArmorBase("helmet_bronze", ARMOR_BRONZE, 1, EntityEquipmentSlot.HEAD, null);
	public static final Item CHESTPLATE_BRONZE = new ArmorBase("chestplate_bronze", ARMOR_BRONZE, 1, EntityEquipmentSlot.CHEST, null);
	public static final Item LEGGINGS_BRONZE = new ArmorBase("leggings_bronze", ARMOR_BRONZE, 2, EntityEquipmentSlot.LEGS, null);
	public static final Item BOOTS_BRONZE = new ArmorBase("boots_bronze", ARMOR_BRONZE, 1, EntityEquipmentSlot.FEET, null);
	
	//Electrum Armor
	public static ArmorMaterial ARMOR_ELECTRUM = EnumHelper.addArmorMaterial("armor_electrum", Reference.MODID + ":electrum", 30, new int[]{6, 10, 8, 6}, 6, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.5F);

	public static final Item HELMET_ELECTRUM = new ArmorBase("helmet_electrum", ARMOR_ELECTRUM, 1, EntityEquipmentSlot.HEAD, null);
	public static final Item CHESTPLATE_ELECTRUM = new ArmorBase("chestplate_electrum", ARMOR_ELECTRUM, 1, EntityEquipmentSlot.CHEST, null);
	public static final Item LEGGINGS_ELECTRUM = new ArmorBase("leggings_electrum", ARMOR_ELECTRUM, 2, EntityEquipmentSlot.LEGS, null);
	public static final Item BOOTS_ELECTRUM = new ArmorBase("boots_electrum", ARMOR_ELECTRUM, 1, EntityEquipmentSlot.FEET, null);	
		
	//Obsidisteel Armor
	public static ArmorMaterial ARMOR_OBSIDISTEEL = EnumHelper.addArmorMaterial("armor_obsidisteel", Reference.MODID + ":obsidisteel", 45, new int[]{5, 9, 7, 5}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.5F);

	public static final Item HELMET_OBSIDISTEEL = new ArmorBase("helmet_obsidisteel", ARMOR_OBSIDISTEEL, 1, EntityEquipmentSlot.HEAD, null);
	public static final Item CHESTPLATE_OBSIDISTEEL = new ArmorBase("chestplate_obsidisteel", ARMOR_OBSIDISTEEL, 1, EntityEquipmentSlot.CHEST, null);
	public static final Item LEGGINGS_OBSIDISTEEL = new ArmorBase("leggings_obsidisteel", ARMOR_OBSIDISTEEL, 2, EntityEquipmentSlot.LEGS, null);
	public static final Item BOOTS_OBSIDISTEEL = new ArmorBase("boots_obsidisteel", ARMOR_OBSIDISTEEL, 1, EntityEquipmentSlot.FEET, null);
	
	//Steel Armor
	public static ArmorMaterial ARMOR_STEEL = EnumHelper.addArmorMaterial("armor_woods", Reference.MODID + ":steel", 33, new int[]{4, 8, 5, 4}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final Item HELMET_STEEL = new ArmorBase("helmet_steel", ARMOR_STEEL, 1, EntityEquipmentSlot.HEAD, null);
	public static final Item CHESTPLATE_STEEL = new ArmorBase("chestplate_steel", ARMOR_STEEL, 1, EntityEquipmentSlot.CHEST, null);
	public static final Item LEGGINGS_STEEL = new ArmorBase("leggings_steel", ARMOR_STEEL, 2, EntityEquipmentSlot.LEGS, null);
	public static final Item BOOTS_STEEL = new ArmorBase("boots_steel", ARMOR_STEEL, 1, EntityEquipmentSlot.FEET, null);
	
	//Utility Armor
	public static ArmorMaterial ARMOR_NIGHTVISION = EnumHelper.addArmorMaterial("armor_nightvision", Reference.MODID + ":utility", 15, new int[]{1, 2, 2, 1}, 5, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, 0.0F);
	public static ArmorMaterial ARMOR_CAKE = EnumHelper.addArmorMaterial("armor_cake", Reference.MODID + ":utility", 15, new int[]{1, 2, 1, 1}, 1, SoundEvents.ENTITY_PLAYER_BURP, 0.0F);
	public static ArmorMaterial ARMOR_ROBOLEGS = EnumHelper.addArmorMaterial("armor_robolegs", Reference.MODID + ":utility", 30, new int[]{1, 1, 2, 1}, 6, SoundEvents.BLOCK_PISTON_EXTEND, 0.0F);
	public static ArmorMaterial ARMOR_SPRING = EnumHelper.addArmorMaterial("armor_spring", Reference.MODID + ":utility", 25, new int[]{2, 2, 2, 1}, 8, SoundEvents.ENTITY_SLIME_SQUISH, 0.0F);

	public static final Item HELMET_NIGHTVISION = new ArmorBase("helmet_nightvision", ARMOR_NIGHTVISION, 1, EntityEquipmentSlot.HEAD, new PotionEffect(Potion.getPotionById(16), 250, 0, false, false));
	public static final Item CHESTPLATE_CAKE = new ArmorBase("chestplate_cake", ARMOR_CAKE, 1, EntityEquipmentSlot.CHEST, new PotionEffect(Potion.getPotionById(23), 100, 1, false, false));
	public static final Item LEGGINGS_ROBOLEGS = new ArmorBase("leggings_robolegs", ARMOR_ROBOLEGS, 2, EntityEquipmentSlot.LEGS, new PotionEffect(Potion.getPotionById(1), 100, 4, false, false));
	public static final Item BOOTS_SPRINGS = new ArmorBase("boots_springs", ARMOR_SPRING, 1, EntityEquipmentSlot.FEET, new PotionEffect(Potion.getPotionById(8), 100, 2, false, false));
		
	//Woods Metal Armor
	public static ArmorMaterial ARMOR_WOODS = EnumHelper.addArmorMaterial("armor_woods", Reference.MODID + ":woods", 38, new int[]{5, 8, 6, 5}, 5, SoundEvents.BLOCK_WOOD_FALL, 0.5F);

	public static final Item HELMET_WOODS = new ArmorBase("helmet_woods", ARMOR_WOODS, 1, EntityEquipmentSlot.HEAD, null);
	public static final Item CHESTPLATE_WOODS = new ArmorBase("chestplate_woods", ARMOR_WOODS, 1, EntityEquipmentSlot.CHEST, null);
	public static final Item LEGGINGS_WOODS = new ArmorBase("leggings_woods", ARMOR_WOODS, 2, EntityEquipmentSlot.LEGS, null);
	public static final Item BOOTS_WOODS = new ArmorBase("boots_woods", ARMOR_WOODS, 1, EntityEquipmentSlot.FEET, null);
	

}
