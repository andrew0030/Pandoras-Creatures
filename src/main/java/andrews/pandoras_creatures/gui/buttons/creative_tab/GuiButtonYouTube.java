package andrews.pandoras_creatures.gui.buttons.creative_tab;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import andrews.pandoras_creatures.config.Config;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.gui.GuiUtils;

@OnlyIn(Dist.CLIENT)
public class GuiButtonYouTube extends Button
{		
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/creative_tab.png");
	private static GuiButtonYouTube youtubeButton;
	private static int buttonWidth = 22;
	private static int buttonHeight = 22;
	private float buttonAlpha;
	private int u = 0;
	private int v = 44;
	
	public GuiButtonYouTube(int xPos, int yPos) 
	{
		super(xPos, yPos, buttonWidth, buttonHeight, new StringTextComponent(""), (button) -> { handleButtonPress(); });
		youtubeButton = this;
		setButtonAlphaToStart();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partial)
	{
		if(visible && Config.CLIENT.shouldButtonsInCreativeTabBeEnabled.get() == true && Minecraft.getInstance().player.getActivePotionEffects().isEmpty())
		{
			this.active = true;
			calculateButtonAlpha();
			
			if(mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height || this.isFocused())
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
			matrixStack.push();
			RenderSystem.enableBlend();
			RenderSystem.color4f(1, 1, 1, (buttonAlpha / 100F));
			GuiUtils.drawTexturedModalRect(x, y, u, v, width, height, 0);
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.disableBlend();
			matrixStack.pop();
			
			//This is used to render a tooltip above the button
			if(isHovered)
			{
//				FontRenderer renderer = Minecraft.getInstance().fontRenderer; TODO figure this out
//				String text = new TranslationTextComponent("gui.button.pandoras_creatures.youtube").getString();
//				List<String> textAsList = Arrays.asList(text);
//				Minecraft.getInstance().currentScreen.renderTooltip(textAsList, x - (15 + renderer.getStringWidth(text)), y + 19, Minecraft.getInstance().fontRenderer);
			}
		}
		else
		{
			this.active = false;
		}
	}
	
	public static GuiButtonYouTube getButton()
	{
		return youtubeButton;
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
		String url = "https://www.youtube.com/channel/UCCwx818CTVQXRLvDjL0GifA/featured";
		Util.getOSType().openURI(url);
		Minecraft.getInstance().player.closeScreen();
	}
}
