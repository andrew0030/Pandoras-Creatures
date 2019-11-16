package andrews.pandoras_creatures.gui.screen;

import com.mojang.blaze3d.platform.GlStateManager;

import andrews.pandoras_creatures.container.BufflonContainer;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BufflonScreen extends ContainerScreen<BufflonContainer>
{
	private static final ResourceLocation BUFFLON_GUI_TEXTURES = new ResourceLocation(Reference.MODID, "textures/gui/menus/bufflon_menu.png");
	
	private int xSize = 256;
	private int ySize = 226;
	
	private final BufflonEntity bufflonEntity;
	private float mousePosx;
	private float mousePosY;
	
	public BufflonScreen(BufflonContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
	{
		super(screenContainer, inv, titleIn);
		this.bufflonEntity = this.getContainer().getBufflonEntity();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		//The Bufflon Name
		this.font.drawString(this.title.getFormattedText(), -29.0F, -22.0F, 0x000000);
		//The Inventory Display Name
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 126), 0x000000);
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
		
		if(bufflonEntity.hasBackAttachment())
		{
			if(bufflonEntity.getBackAttachmentType() == 2)
			{
				renderBufflonInventorySlots(x, y, 3);
			}
			else if(bufflonEntity.getBackAttachmentType() == 3)
			{
				renderBufflonInventorySlots(x, y, 6);
			}
		}
	    
	    InventoryScreen.drawEntityOnScreen(x + 46, y + 76, 15, (float)(x + 46) - this.mousePosx, (float)(y + 50) - this.mousePosY, this.bufflonEntity);
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		this.renderBackground();
		this.mousePosx = (float)mouseX;
		this.mousePosY = (float)mouseY;
	    super.render(mouseX, mouseY, partialTicks);
	    this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	/**
	 * Renders the Inventory Slots of this Bufflon Entity
	 * @param posX - The x position this is relative to
	 * @param posY - The y position this is relative to
	 * @param rows - The amount of rows that should be rendered
	 */
	private void renderBufflonInventorySlots(int posX, int posY, int rows)
	{
		for(int i = 0; i < rows; i++)
		{
			this.blit(posX + 84, (posY + 19 + (i * 18)), 0, 238, 162, 18);
		}
	}
}