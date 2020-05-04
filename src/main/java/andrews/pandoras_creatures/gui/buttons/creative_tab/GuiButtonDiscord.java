package andrews.pandoras_creatures.gui.buttons.creative_tab;

import java.util.Arrays;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

import andrews.pandoras_creatures.config.Config;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.gui.GuiUtils;

@OnlyIn(Dist.CLIENT)
public class GuiButtonDiscord extends Button
{		
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/creative_tab.png");
	private static GuiButtonDiscord discordButton;
	private static int buttonWidth = 22;
	private static int buttonHeight = 22;
	private float buttonAlpha;
	private int u = 0;
	private int v = 0;
	
	public GuiButtonDiscord(int xPos, int yPos) 
	{
		super(xPos, yPos, buttonWidth, buttonHeight, "", (button) -> { handleButtonPress(); });
		discordButton = this;
		setButtonAlphaToStart();
	}
	
	@Override
	public void renderButton(int mouseX, int mouseY, float partial)
	{
		if(visible && Config.CLIENT.shouldButtonsInCreativeTabBeEnabled.get() == true && Minecraft.getInstance().player.getActivePotionEffects().isEmpty())
		{
			this.active = true;
			calculateButtonAlpha();
			
			if(mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height)
			{
				this.isHovered = true;
			}
			else
			{
				this.isHovered = false;
			}
			
			//change the texture pick position so the texture of the button changes
			if(this.isHovered) { u = 22; }else{ u = 0; }
			
			Minecraft.getInstance().getRenderManager().textureManager.bindTexture(texture);
			RenderSystem.pushMatrix();
			RenderSystem.enableBlend();
			RenderSystem.color4f(1, 1, 1, (buttonAlpha / 100F));
			GuiUtils.drawTexturedModalRect(x, y, u, v, width, height, 0);
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.disableBlend();
			RenderSystem.popMatrix();
			
			//This is used to render a tooltip above the button
			if(isHovered)
			{
				FontRenderer renderer = Minecraft.getInstance().fontRenderer;
				String text = new TranslationTextComponent("gui.button.pandoras_creatures.discord").getString();
				List<String> textAsList = Arrays.asList(text);
				Minecraft.getInstance().currentScreen.renderTooltip(textAsList, x - (15 + renderer.getStringWidth(text)), y + 19, Minecraft.getInstance().fontRenderer);
			}
		}
		else
		{
			this.active = false;
		}
	}

	public static GuiButtonDiscord getButton()
	{
		return discordButton;
	}
	
	//Calculates the Alpha for the Button
	private void calculateButtonAlpha()
	{
		int fadeTime = Config.CLIENT.buttonFadeInTime.get();
		if(fadeTime != 0)
		{
			if(this.buttonAlpha < 100)
			{
				if(this.buttonAlpha + ((20 / fadeTime) / 10F) <= 100)
				{
					this.buttonAlpha += (20 / fadeTime) / 10F;
				}
				else
				{
					this.buttonAlpha = 100;
				}
			}
		}
		else
		{
			this.buttonAlpha = 100;
		}
	}
	
	public void setButtonAlphaToStart()
	{
		this.buttonAlpha = 10;
	}
	
	private static void handleButtonPress()
	{
		String url = "https://discord.gg/ab5zP72";
		Util.getOSType().openURI(url);
		Minecraft.getInstance().player.closeScreen();
//		Minecraft.getInstance().displayGuiScreen(new ConfirmOpenLinkScreen((p_213069_2_) -> {
//			if(p_213069_2_)
//			{
//	        	Util.getOSType().openURI(url);
//	        }
//			Minecraft.getInstance().player.closeScreen();
//		}, url, true));
	}
}
