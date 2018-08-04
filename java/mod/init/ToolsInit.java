package isaac.mod.init;

import java.util.ArrayList;
import java.util.List;

import isaac.mod.Main;
import isaac.mod.objects.tools.ToolAxe;
import isaac.mod.objects.tools.ToolHoe;
import isaac.mod.objects.tools.ToolPickaxe;
import isaac.mod.objects.tools.ToolShovel;
import isaac.mod.objects.tools.ToolSword;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ToolsInit {
	
	public static final List<Item> TOOLS = new ArrayList<Item>();
	
	public static final CreativeTabs TAB = Main.toolstab;
	
	//Bronze Tools
	public static ToolMaterial TOOL_BRONZE = EnumHelper.addToolMaterial("tool_bronze", 2, 1200, 5.0F, 1.5F, 8);

	public static final Item AXE_BRONZE = new ToolAxe("axe_bronze", TOOL_BRONZE, TAB, null);
	public static final Item HOE_BRONZE = new ToolHoe("hoe_bronze", TOOL_BRONZE, TAB, null);
	public static final Item PICKAXE_BRONZE = new ToolPickaxe("pickaxe_bronze", TOOL_BRONZE, TAB, null);
	public static final Item SHOVEL_BRONZE = new ToolShovel("shovel_bronze", TOOL_BRONZE, TAB, null);
	public static final Item SWORD_BRONZE = new ToolSword("sword_bronze", TOOL_BRONZE, TAB, null);
	
	//Electrum Tools
	public static ToolMaterial TOOL_ELECTRUM = EnumHelper.addToolMaterial("tool_electrum", 4, 1600, 7.0F, 5.0F, 11);

	public static final Item AXE_ELECTRUM = new ToolAxe("axe_electrum", TOOL_ELECTRUM, TAB, null);
	public static final Item HOE_ELECTRUM = new ToolHoe("hoe_electrum", TOOL_ELECTRUM, TAB, null);
	public static final Item PICKAXE_ELECTRUM = new ToolPickaxe("pickaxe_electrum", TOOL_ELECTRUM, TAB, null);
	public static final Item SHOVEL_ELECTRUM = new ToolShovel("shovel_electrum", TOOL_ELECTRUM, TAB, null);
	public static final Item SWORD_ELECTRUM = new ToolSword("sword_electrum", TOOL_ELECTRUM, TAB, null);

	//Obsidisteel Tools
	public static ToolMaterial TOOL_OBSIDISTEEL = EnumHelper.addToolMaterial("tool_obsidisteel", 4, 2100, 5.5F, 3.0F, 2);

	public static final Item AXE_OBSIDISTEEL = new ToolAxe("axe_obsidisteel", TOOL_OBSIDISTEEL, TAB, null);
	public static final Item HOE_OBSIDISTEEL = new ToolHoe("hoe_obsidisteel", TOOL_OBSIDISTEEL, TAB, null);
	public static final Item PICKAXE_OBSIDISTEEL = new ToolPickaxe("pickaxe_obsidisteel", TOOL_OBSIDISTEEL, TAB, null);
	public static final Item SHOVEL_OBSIDISTEEL = new ToolShovel("shovel_obsidisteel", TOOL_OBSIDISTEEL, TAB, null);
	public static final Item SWORD_OBSIDISTEEL = new ToolSword("sword_obsidisteel", TOOL_OBSIDISTEEL, TAB, null);

	//Steel Tools
	public static ToolMaterial TOOL_STEEL = EnumHelper.addToolMaterial("tool_steel", 3, 750, 7.0F, 4.0F, 10);

	public static final Item AXE_STEEL = new ToolAxe("axe_steel", TOOL_STEEL, TAB, null);
	public static final Item HOE_STEEL = new ToolHoe("hoe_steel", TOOL_STEEL, TAB, null);
	public static final Item PICKAXE_STEEL = new ToolPickaxe("pickaxe_steel", TOOL_STEEL, TAB, null);
	public static final Item SHOVEL_STEEL = new ToolShovel("shovel_steel", TOOL_STEEL, TAB, null);
	public static final Item SWORD_STEEL = new ToolSword("sword_steel", TOOL_STEEL, TAB, null);
	
	//Woods Metal Tools
	
	private static PotionEffect WoodsEffect = new PotionEffect(Potion.getPotionById(19), 1000, 2, false, true);
	public static ToolMaterial TOOL_WOODS = EnumHelper.addToolMaterial("tool_woods", 2, 250, 3.0F, 2.0F, 17);

	public static final Item AXE_WOODS = new ToolAxe("axe_woods", TOOL_WOODS, TAB, WoodsEffect);
	public static final Item HOE_WOODS = new ToolHoe("hoe_woods", TOOL_WOODS, TAB, WoodsEffect);
	public static final Item PICKAXE_WOODS = new ToolPickaxe("pickaxe_woods", TOOL_WOODS, TAB, WoodsEffect);
	public static final Item SHOVEL_WOODS = new ToolShovel("shovel_woods", TOOL_WOODS, TAB, WoodsEffect);
	public static final Item SWORD_WOODS = new ToolSword("sword_woods", TOOL_WOODS, TAB, WoodsEffect);




}
