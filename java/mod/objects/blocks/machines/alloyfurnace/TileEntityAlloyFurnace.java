package isaac.mod.objects.blocks.machines.alloyfurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityAlloyFurnace extends TileEntity implements IInventory, ITickable{
	
	private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(7, ItemStack.EMPTY);
	private String customName;
	
	private int burnTime;
	private int burn;
	private int smeltTime;
	private int smelt;
	
	public TileEntityAlloyFurnace() {
		super();
	}
	
	@Override
	public String getName() 
	{
		return this.hasCustomName() ? this.customName : "container.alloy_furnace";
	}

	@Override
	public boolean hasCustomName() 
	{
		return this.customName != null && !this.customName.isEmpty();
	}
	
	public void setCustomName(String customName) 
	{
		this.customName = customName;
	}
	
	@Override
	public ITextComponent getDisplayName() 
	{
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() 
	{
		return this.inventory.size();
	}

	@Override
	public boolean isEmpty() 
	{
		for(ItemStack stack : this.inventory)
		{
			if(!stack.isEmpty()) return false;
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return (ItemStack)this.inventory.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return ItemStackHelper.getAndSplit(this.inventory, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(this.inventory, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		ItemStack currentStack = (ItemStack)this.inventory.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(currentStack) && ItemStack.areItemStackTagsEqual(stack, currentStack);
		this.inventory.set(index, stack);
		
		
		if(stack.getCount() > this.getInventoryStackLimit()) stack.setCount(this.getInventoryStackLimit());
		if(index == 0 && index + 1 == 1 && index + 2 == 2 && !flag)
		{
			ItemStack stack1 = (ItemStack)this.inventory.get(index + 1);
			ItemStack stack2 = (ItemStack)this.inventory.get(index + 2);
			this.smeltTime = this.getSmeltTime(stack, stack1, stack2);
			this.smelt = 0;
			this.markDirty();
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.inventory);
		this.burn = compound.getInteger("burn");
		this.burnTime = getItemBurnTime((ItemStack)this.inventory.get(3));//Fuel slot
		this.smeltTime = compound.getInteger("smelt_time");
		this.smelt = compound.getInteger("smelt");
		
		if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		compound.setInteger("burn", (short)this.burn);
		compound.setInteger("smelt_time", (short)this.smeltTime);
		compound.setInteger("smelt", (short)this.smelt);
		ItemStackHelper.saveAllItems(compound, this.inventory);
		
		if(this.hasCustomName()) compound.setString("CustomName", this.customName);
		return compound;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	public boolean isBurning() 
	{
		return this.burn > 0;
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean isBurning(IInventory inventory) 
	{
		return inventory.getField(0) > 0;
	}
	
	public void update() 
	{
		boolean flag = this.isBurning();
		boolean flag1 = false;
		
		BlockAlloyFurnace.setState(this.isBurning(), this.world, this.pos);
		
		if(flag) --this.burn;
		
		if(!this.world.isRemote) 
		{
			ItemStack fuel = (ItemStack)this.inventory.get(3); //Fuel Stack
			ItemStack slot0 = (ItemStack)this.inventory.get(0);
			ItemStack slot1 = (ItemStack)this.inventory.get(1);
			ItemStack slot2 = (ItemStack)this.inventory.get(2);
			
			if(flag || !fuel.isEmpty() && !(slot0.isEmpty() && slot1.isEmpty() && slot2.isEmpty())) 
			{
				if(!flag && this.canSmelt()) 
				{
					this.burnTime = getItemBurnTime(fuel);
					this.burn = this.burnTime;
					
					flag = this.isBurning();
					if(flag) 
					{
						flag1 = true;
						
						if(!fuel.isEmpty()) 
						{
							Item item = fuel.getItem();
							fuel.shrink(1);
							
							if(fuel.isEmpty()) 
							{
								ItemStack item1 = item.getContainerItem(fuel);
								this.inventory.set(3, item1); //Int = fuel stack
							}
						}
					}
				} 
				if(flag && this.canSmelt()) 
				{
					++this.smelt;
					
					if(this.smelt == this.smeltTime) 
					{
						this.process();
						slot0 = (ItemStack)this.inventory.get(0);
						slot1 = (ItemStack)this.inventory.get(1);
						slot2 = (ItemStack)this.inventory.get(2);
						
						this.smelt = 0;
						this.smeltTime = this.getSmeltTime(slot0, slot1, slot2);
						flag1 = true;
					}
				} 
				
				else this.smelt = 0;
			} 
			
			else if(!flag && this.smeltTime > 0) 
				this.smelt = MathHelper.clamp(this.smelt - 2, 0, this.smeltTime);
			
			if(flag != this.isBurning()) 
			{
				flag1 = true;
				BlockAlloyFurnace.setState(this.isBurning(), this.world, this.pos);
			}
		} 
		if(flag1) this.markDirty();
	}
	
	public int getSmeltTime(ItemStack input0, ItemStack input1, ItemStack input2) 
	{
		return 200;
	}
	
	private boolean canSmelt(){ 
		ItemStack result = AlloyFurnaceRecipes.getInstance().getAlloyResult((ItemStack)this.inventory.get(0), (ItemStack)this.inventory.get(1), (ItemStack)this.inventory.get(2));	

		if(result.isEmpty() || ((ItemStack)this.inventory.get(0)).getCount() < AlloyFurnaceRecipes.getInstance().getItemQuantity(result, (ItemStack)this.inventory.get(0)) || ((ItemStack)this.inventory.get(1)).getCount() < AlloyFurnaceRecipes.getInstance().getItemQuantity(result, (ItemStack)this.inventory.get(1)) || ((ItemStack)this.inventory.get(2)).getCount() < AlloyFurnaceRecipes.getInstance().getItemQuantity(result, (ItemStack)this.inventory.get(2))) return false;
		else 
		{
			ItemStack output = (ItemStack)this.inventory.get(4); // Output slot
			if(output.isEmpty()) return true;
			else if(!output.isItemEqual(result) || ItemStack.areItemsEqual(output, result)) return false;
			
			int res = output.getCount() + result.getCount();
			return res <= getInventoryStackLimit() && res <= output.getMaxStackSize();
			
		}
	}
	
	public void process() {
		if (this.canSmelt()) {
			ItemStack input0 = (ItemStack)this.inventory.get(0);
			ItemStack input1 = (ItemStack)this.inventory.get(1);
			ItemStack input2 = (ItemStack)this.inventory.get(2);
			
			ItemStack result = AlloyFurnaceRecipes.getInstance().getAlloyResult(input0, input1, input2);
			ItemStack output = (ItemStack)this.inventory.get(4);
			
			if (output.isEmpty()) this.inventory.set(4, result.copy());
			else if (output.isItemEqual(result) && ItemStack.areItemStackTagsEqual(output, result)) output.grow(result.getCount());
			
			input0.shrink(AlloyFurnaceRecipes.getInstance().getItemQuantity(result, input0));
			input1.shrink(AlloyFurnaceRecipes.getInstance().getItemQuantity(result, input1));
			input2.shrink(AlloyFurnaceRecipes.getInstance().getItemQuantity(result, input2));
		}
	}

	public static int getItemBurnTime(ItemStack fuel) 
	{
		int time = 0;
		if(fuel.isEmpty()) return 0;
		else 
		{
            int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(fuel);
            if (burnTime >= 0) return burnTime;
            Item item = fuel.getItem();

			if (item == Items.LAVA_BUCKET) time = 20000;
		}
		return time;
	}
		
	public static boolean isItemFuel(ItemStack fuel)
	{
		return getItemBurnTime(fuel) > 0;
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		
		if(index == 4) return false;
		else if(index != 3) return true;
		else return isItemFuel(stack);
		
	}
	
	public String getGuiID() 
	{
		return "ap:alloy_furnace";
	}

	@Override
	public int getField(int id) 
	{
		switch(id) 
		{
		case 0:
			return this.burnTime;
		case 1:
			return this.burn;
		case 2:
			return this.smeltTime;
		case 3:
			return this.smelt;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) 
	{
		switch(id) 
		{
		case 0:
			this.burnTime = value;
			break;
		case 1:
			this.burn = value;
			break;
		case 2:
			this.smeltTime = value;
			break;
		case 3:
			this.smelt = value;
		}
	}

	@Override
	public int getFieldCount() 
	{
		return 4;
	}

	@Override
	public void clear() 
	{
		this.inventory.clear();
	}

}
