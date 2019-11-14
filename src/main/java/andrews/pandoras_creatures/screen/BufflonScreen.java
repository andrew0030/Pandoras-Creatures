package andrews.pandoras_creatures.screen;

import com.mojang.blaze3d.platform.GlStateManager;

import andrews.pandoras_creatures.container.BufflonContainer;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class BufflonScreen extends ContainerScreen<BufflonContainer>
{
	private static final ResourceLocation BUFFLON_GUI_TEXTURES = new ResourceLocation(Reference.MODID, "textures/gui/menus/bufflon_menu.png");
//	private final BufflonEntity bufflonEntity;
//	private float mousePosx;
//	private float mousePosY;
	
	public BufflonScreen(BufflonContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
	{
		super(screenContainer, inv, titleIn);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		renderBackground();//Renders the dark background
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	  	this.minecraft.getTextureManager().bindTexture(BUFFLON_GUI_TEXTURES);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.blit(x, y, 0, 0, this.xSize, this.ySize);
//	    if(abstractchestedhorseentity.hasChest())
//	    {
//	    	this.blit(i + 79, j + 17, 0, this.ySize, abstractchestedhorseentity.getInventoryColumns() * 18, 54);
//	  	}

//		if(this.bufflonEntity.canBeSaddled())
//		{
//			this.blit(i + 7, j + 35 - 18, 18, this.ySize + 54, 18, 18);
//	    }

//	    if(this.horseEntity.wearsArmor())
//	    {
//	    	if(this.horseEntity instanceof LlamaEntity)
//	    	{
//	    		this.blit(i + 7, j + 35, 36, this.ySize + 54, 18, 18);
//	    	}
//	    	else
//	    	{
//	    		this.blit(i + 7, j + 35, 0, this.ySize + 54, 18, 18);
//	        }
//	    }
	    
//	    InventoryScreen.drawEntityOnScreen(x + 51, y + 60, 17, (float)(x + 51) - this.mousePosx, (float)(y + 75 - 50) - this.mousePosY, this.bufflonEntity);
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		this.renderBackground();
//		this.mousePosx = (float)mouseX;
//		this.mousePosY = (float)mouseY;
	    super.render(mouseX, mouseY, partialTicks);
	    this.renderHoveredToolTip(mouseX, mouseY);
	}
}