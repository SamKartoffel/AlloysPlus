package isaac.mod.objects.blocks.machines.alloyfurnace;

import isaac.mod.utl.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;


public class GUIAlloyFurnace extends GuiContainer{
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/alloy_furnace.png");
	private final InventoryPlayer player;
	private final TileEntityAlloyFurnace tileentity;
	
	
	public GUIAlloyFurnace(InventoryPlayer player, TileEntityAlloyFurnace tileentity) {
		
		super(new ContainerAlloyFurnace(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
		
	}

	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2), 8, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if(TileEntityAlloyFurnace.isBurning(tileentity)) {
			int k = this.getBurnedLeftScales(10);
			this.drawTexturedModalRect(this.guiLeft + 29, this.guiTop + 65  + 12 - k, 176, 12 - k, 40, k + 1);
		}
		
		int l = this.getCookedProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 80, this.guiTop + 34, 176, 10, 15 + 1, 16);
	}
	
	private int getBurnedLeftScales(int pixels) {
		
		int i = this.tileentity.getField(1);
		
		if(i == 0) i = 200;
		return this.tileentity.getField(0) * pixels / i;
	}
	
	private int getCookedProgressScaled(int pixels) {
		int i = this.tileentity.getField(2);
		int j = this.tileentity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}

}
