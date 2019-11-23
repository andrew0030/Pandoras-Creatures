package andrews.pandoras_creatures.gui.screen;

import com.mojang.blaze3d.platform.GlStateManager;

import andrews.pandoras_creatures.container.BufflonContainer;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.gui.buttons.bufflon_menu.GuiButtonBufflonFightMode;
import andrews.pandoras_creatures.gui.buttons.bufflon_menu.GuiButtonBufflonFollow;
import andrews.pandoras_creatures.gui.buttons.bufflon_menu.GuiButtonBufflonMoveFreely;
import andrews.pandoras_creatures.gui.buttons.bufflon_menu.GuiButtonBufflonPeacefulMode;
import andrews.pandoras_creatures.gui.buttons.bufflon_menu.GuiButtonBufflonSit;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BufflonScreen extends ContainerScreen<BufflonContainer>
{
	private static final ResourceLocation BUFFLON_GUI_TEXTURES = new ResourceLocation(Reference.MODID, "textures/gui/menus/bufflon_menu.png");
	
	private int attachmentToRender = 1;
	
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
	protected void init()
	{
		super.init();
		//Values to calculate the relative position
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		
		this.addButton(new GuiButtonBufflonSit(bufflonEntity, x + 9, y + 138));
		this.addButton(new GuiButtonBufflonFollow(bufflonEntity, x + 9, y + 166));
		this.addButton(new GuiButtonBufflonMoveFreely(bufflonEntity, x + 9, y + 194));
		this.addButton(new GuiButtonBufflonFightMode(bufflonEntity, x + 221, y + 148));
		this.addButton(new GuiButtonBufflonPeacefulMode(bufflonEntity, x + 221, y + 188));
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
	    //The Bufflon Entity inside the Menu
	    InventoryScreen.drawEntityOnScreen(x + 46, y + 76, 15, (float)(x + 46) - this.mousePosx, (float)(y + 50) - this.mousePosY, this.bufflonEntity);
	    //The Saddle slot previews
	    if(!bufflonEntity.isSaddled())
	    {
	    	Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(new ItemStack(PCItems.BUFFLON_SADDLE), x + 23, y + 102);
	    }
	    
	    if(!bufflonEntity.hasBackAttachment())
	    {
		    switch(attachmentToRender) {
			case 1:
				Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(new ItemStack(PCItems.BUFFLON_PLAYER_SEATS), x + 51, y + 102);
				break;
			case 2:
				Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(new ItemStack(PCItems.BUFFLON_SMALL_STORAGE), x + 51, y + 102);
				break;
			case 3:
				Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(new ItemStack(PCItems.BUFFLON_LARGE_STORAGE), x + 51, y + 102);
				break;
			default:
				break;
		    }
		}
	}
	
	@Override
	public void tick()
	{
		super.tick();
		if((bufflonEntity.ticksExisted % 60) == 0)//Updates the attachment type that should be rendered every 60 ticks / 3 seconds
	    {
			if(attachmentToRender < 3)
			{
				attachmentToRender++;
			}
			else
			{
				attachmentToRender = 1;
			}
	    }
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