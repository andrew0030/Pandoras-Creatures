package andrews.pandoras_creatures.gui.buttons.bufflon_menu;

import java.util.Arrays;
import java.util.List;

import com.mojang.blaze3d.platform.GlStateManager;

import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.config.GuiUtils;

@OnlyIn(Dist.CLIENT)
public class GuiButtonBufflonFollow extends Button
{		
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/bufflon_menu_buttons.png");
	
	private static BufflonEntity bufflonEntity;
	
	private static int buttonWidth = 26;
	private static int buttonHeight = 26;
	private int u = 0;
	private int v = 26;
	
	public GuiButtonBufflonFollow(BufflonEntity entityIn, int xPos, int yPos) 
	{
		super(xPos, yPos, buttonWidth, buttonHeight, "", (button) -> { handleButtonPress(); });
		bufflonEntity = entityIn;
	}
	
	@Override
	public void renderButton(int mouseX, int mouseY, float partial)
	{
		if(mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height)
		{
			this.isHovered = true;
		}
		else
		{
			this.isHovered = false;
		}
		
		//change the texture pick position so the texture of the button changes
		if(bufflonEntity.isFollowingOwner()) { u = 26; }else{ u = 0; }
		
		//Renders the Button
		Minecraft.getInstance().getRenderManager().textureManager.bindTexture(texture);
		GlStateManager.pushMatrix();
		GlStateManager.disableLighting();
		GuiUtils.drawTexturedModalRect(x, y, u, v, width, height, 0);
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
		
		//This is used to render a tooltip next to the button
		if(isHovered)
		{
			FontRenderer renderer = Minecraft.getInstance().fontRenderer;
			String text = new TranslationTextComponent("gui.button.pandoras_creatures.bufflon.follow").getString();
			List<String> textAsList = Arrays.asList(text);
			Minecraft.getInstance().currentScreen.renderTooltip(textAsList, x - (15 + renderer.getStringWidth(text)), y + 21, Minecraft.getInstance().fontRenderer);
		}
	}
	
	private static void handleButtonPress()
	{
		if(!bufflonEntity.isFollowingOwner())
		{
			NetworkUtil.setBufflonFollowingMessage(bufflonEntity, true);
		}
		
		if(bufflonEntity.isSitting())
		{
			NetworkUtil.setBufflonSittingMessage(bufflonEntity, false);
		}
	}
}