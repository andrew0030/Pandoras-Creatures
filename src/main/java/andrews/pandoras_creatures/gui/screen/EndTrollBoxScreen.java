package andrews.pandoras_creatures.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import andrews.pandoras_creatures.container.EndTrollBoxContainer;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EndTrollBoxScreen extends ContainerScreen<EndTrollBoxContainer>
{
	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/containers/end_troll_box.png");
	
	public EndTrollBoxScreen(EndTrollBoxContainer endTrollContainer, PlayerInventory playerInv, ITextComponent text)
	{
		super(endTrollContainer, playerInv, text);
		this.xSize = 176;
		this.ySize = 220;
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 93), 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.blit(i, j, 0, 0, this.xSize, this.ySize);
	}
}