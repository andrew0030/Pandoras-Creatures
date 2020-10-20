package andrews.pandoras_creatures.gui.buttons.creative_tab;

import java.util.Arrays;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import andrews.pandoras_creatures.PandorasCreatures;
import andrews.pandoras_creatures.config.PCConfigs;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.gui.GuiUtils;

@OnlyIn(Dist.CLIENT)
public class GuiButtonTwitch extends Button
{		
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/creative_tab.png");
	private TranslationTextComponent buttonText = new TranslationTextComponent("gui.button.pandoras_creatures.twitch");
	private FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
	private CreativeScreen creativeTab;
	private static int buttonWidth = 22;
	private static int buttonHeight = 22;
	private float buttonAlpha;
	private int u = 0;
	private int v = 66;
	
	public GuiButtonTwitch(CreativeScreen creativeTab, int xPos, int yPos) 
	{
		super(xPos, yPos, buttonWidth, buttonHeight, new StringTextComponent(""), (button) -> { handleButtonPress(); });
		this.creativeTab = creativeTab;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partial)
	{
		if(this.creativeTab.getSelectedTabIndex() == PandorasCreatures.PANDORAS_CREATURES_GROUP.getIndex() && PCConfigs.PCClientConfig.shouldButtonsInCreativeTabBeEnabled.get() == true && Minecraft.getInstance().player.getActivePotionEffects().isEmpty())
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
			GuiUtils.drawTexturedModalRect(matrixStack, x, y, u, v, width, height, 0);
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.disableBlend();
			matrixStack.pop();
			
			//This is used to render a tooltip above the button
			if(isHovered)
			{
				Minecraft.getInstance().currentScreen.renderToolTip(matrixStack, Arrays.asList(this.buttonText.func_241878_f()), x - (15 + this.fontRenderer.getStringWidth(this.buttonText.getString())), y + 19, this.fontRenderer);
			}
		}
		else
		{
			setButtonAlphaToStart();
			this.active = false;
		}
	}
	
	//Calculates the Alpha for the Button
	private void calculateButtonAlpha()
	{
		int fadeTime = PCConfigs.PCClientConfig.buttonFadeInTime.get();
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
		String url = "https://www.twitch.tv/andrew0030";
		Util.getOSType().openURI(url);
		Minecraft.getInstance().player.closeScreen();
	}
}
