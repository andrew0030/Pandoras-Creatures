package andrews.pandoras_creatures.gui.buttons.bufflon_menu;

import java.util.List;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.gui.GuiUtils;

@OnlyIn(Dist.CLIENT)
public class GuiButtonBufflonSit extends Button
{		
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/bufflon_menu_buttons.png");
	
	private static BufflonEntity bufflonEntity;
	
	private static int buttonWidth = 26;
	private static int buttonHeight = 26;
	private int u = 0;
	private int v = 0;
	
	private FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
	private List<ITextComponent> list = Lists.newArrayList();
	private String buttonText = new TranslationTextComponent("gui.button.pandoras_creatures.bufflon.sit").getString();
	
	public GuiButtonBufflonSit(BufflonEntity entityIn, int xPos, int yPos) 
	{
		super(xPos, yPos, buttonWidth, buttonHeight, new StringTextComponent(""), (button) -> { handleButtonPress(); });
		this.list.add(new StringTextComponent(this.buttonText));
		bufflonEntity = entityIn;
	}
	
	@Override
	public void renderButton(MatrixStack matrixStack,int mouseX, int mouseY, float partial)
	{
		if(bufflonEntity.getOwner() != Minecraft.getInstance().player)
		{
			this.active = false;
		}
		else
		{
			this.active = true;
		}
		
		if(mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height || this.isFocused())
		{
			this.isHovered = true;
		}
		else
		{
			this.isHovered = false;
		}
		
		//change the texture pick position so the texture of the button changes
		if(this.active)
		{
			if(bufflonEntity.isSitting()) { u = 26; }else{ u = 0; }
		}
		else
		{
			u = 52;
		}
		
		//Renders the Button
		Minecraft.getInstance().getRenderManager().textureManager.bindTexture(texture);
		matrixStack.push();
		RenderSystem.enableBlend();
		GuiUtils.drawTexturedModalRect(x, y, u, v, width, height, 0);
		RenderSystem.disableBlend();
		matrixStack.pop();
		
		//This is used to render a tooltip next to the button
		if(isHovered)
		{
			Minecraft.getInstance().currentScreen.renderToolTip(matrixStack, this.list, x - (15 + this.fontRenderer.getStringWidth(this.buttonText)), y + 21, this.fontRenderer);
		}
	}
	
	private static void handleButtonPress()
	{
		if(!bufflonEntity.isSitting())
		{
			NetworkUtil.setBufflonSittingMessage(bufflonEntity, true);
		}
		
		if(bufflonEntity.isFollowingOwner())
		{
			NetworkUtil.setBufflonFollowingMessage(bufflonEntity, false);
		}
	}
}