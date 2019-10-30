package andrews.pandoras_creatures.gui;

import java.util.ArrayList;
import java.util.List;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.config.Config;
import andrews.pandoras_creatures.gui.buttons.GuiButtonCurseForge;
import andrews.pandoras_creatures.gui.buttons.GuiButtonDiscord;
import andrews.pandoras_creatures.gui.buttons.GuiButtonPatreon;
import andrews.pandoras_creatures.gui.buttons.GuiButtonTwitch;
import andrews.pandoras_creatures.gui.buttons.GuiButtonYouTube;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Dist.CLIENT)
public class CreativeTabAdditions
{
	private static final Minecraft mc = Minecraft.getInstance();
	private static GuiButtonDiscord discordButton;
	private static GuiButtonCurseForge curseForgeButton;
	private static GuiButtonYouTube youtubeButton;
	private static GuiButtonTwitch twitchButton;
	private static GuiButtonPatreon patreonButton;
	private static List<Button> buttons = new ArrayList<Button>();
	
	@SubscribeEvent
	public static void onRenderCreativeTab(GuiScreenEvent.DrawScreenEvent.Post event)
	{	
		if(mc.currentScreen != null && mc.currentScreen instanceof CreativeScreen)
		{
			CreativeScreen creativeTab = (CreativeScreen) mc.currentScreen;
			
			if(creativeTab.getSelectedTabIndex() == Main.PANDORAS_CREATURES_GROUP.getIndex())
			{
				int screenWidth = mc.currentScreen.width;
				int screenHeight = mc.currentScreen.height;
				
				showAllButtons();
				createAndStoreAllButtons(creativeTab, screenWidth, screenHeight);
			}
			else
			{
				hideAllButtons();
			}
		}
	}
	
	/**
	 * Calculates the offset and makes sure there aren't any 1 pixel disturbances because of an uneven screen size
	 * @param screenWidth - The screen width
	 * @param offset - The amount of offset that should be applied to the buttons position (in pixel)
	 * @return - The position with applied offset
	 */
	private static int calculateOffsetX(int screenWidth, int offset)
	{
		if((screenWidth % 2) != 0)
		{
			screenWidth++;
		}
		screenWidth = screenWidth / 2;
		return screenWidth += offset;
	}
	
	/**
	 * Calculates the offset and makes sure there aren't any 1 pixel disturbances because of an uneven screen size
	 * @param screenWidth - The screen width
	 * @param offset - The amount of offset that should be applied to the buttons position (in pixel)
	 * @return - The position with applied offset
	 */
	private static int calculateOffsetY(int screenHeight, int offset)
	{
		if((screenHeight % 2) != 0)
		{
			screenHeight++;
		}
		screenHeight = screenHeight / 2;
		return screenHeight += offset;
	}
	
	/**
	 * Used to show all buttons
	 */
	private static void showAllButtons()
	{
		for(Button button : buttons)
		{
			if(button != null && button.visible == false)
			{
				setButtonAlphaToStart(button);
				button.visible = true;
			}
		}
	}
	
	/**
	 * Used to hide all buttons
	 */
	private static void hideAllButtons()
	{
		for(Button button : buttons)
		{
			if(button != null && button.visible == true)
			{
				button.visible = false;
			}
		}
	}
	
	/**
	 * This stores the buttons when called and ensures they don't get stored again if already stored
	 * @param creativeTab - The CreativeScreen
	 * @param screenWidth - The screen width
	 * @param screenHeight - The screen height
	 */
	private static void createAndStoreAllButtons(CreativeScreen creativeTab, int screenWidth, int screenHeight)
	{
		//Discord Button
		if(!creativeTab.buttons.contains(GuiButtonDiscord.getButton()))
		{
			int configOffsetX = Config.CLIENT.buttonDiscordOffsetX.get();
			int configOffsetY = Config.CLIENT.buttonDiscordOffsetY.get();
			creativeTab.addButton(new GuiButtonDiscord(calculateOffsetX(screenWidth, -121 + configOffsetX), calculateOffsetY(screenHeight, -52 + configOffsetY)));
			discordButton = GuiButtonDiscord.getButton();
			buttons.add(discordButton);
		}
		//CurseForge Button
		if(!creativeTab.buttons.contains(GuiButtonCurseForge.getButton()))
		{
			int configOffsetX = Config.CLIENT.buttonCurseForgeOffsetX.get();
			int configOffsetY = Config.CLIENT.buttonCurseForgeOffsetY.get();
			creativeTab.addButton(new GuiButtonCurseForge(calculateOffsetX(screenWidth, -121 + configOffsetX), calculateOffsetY(screenHeight, -29 + configOffsetY)));
			curseForgeButton = GuiButtonCurseForge.getButton();
			buttons.add(curseForgeButton);
		}
		//YouTube Button
		if(!creativeTab.buttons.contains(GuiButtonYouTube.getButton()))
		{
			int configOffsetX = Config.CLIENT.buttonYouTubeOffsetX.get();
			int configOffsetY = Config.CLIENT.buttonYouTubeOffsetY.get();
			creativeTab.addButton(new GuiButtonYouTube(calculateOffsetX(screenWidth, -121 + configOffsetX), calculateOffsetY(screenHeight, -6 + configOffsetY)));
			youtubeButton = GuiButtonYouTube.getButton();
			buttons.add(youtubeButton);
		}
		//Twitch Button
		if(!creativeTab.buttons.contains(GuiButtonTwitch.getButton()))
		{
			int configOffsetX = Config.CLIENT.buttonTwitchOffsetX.get();
			int configOffsetY = Config.CLIENT.buttonTwitchOffsetY.get();
			creativeTab.addButton(new GuiButtonTwitch(calculateOffsetX(screenWidth, -121 + configOffsetX), calculateOffsetY(screenHeight, 17 + configOffsetY)));
			twitchButton = GuiButtonTwitch.getButton();
			buttons.add(twitchButton);
		}
		//Patreon Button
		if(!creativeTab.buttons.contains(GuiButtonPatreon.getButton()))
		{
			int configOffsetX = Config.CLIENT.buttonPatreonOffsetX.get();
			int configOffsetY = Config.CLIENT.buttonPatreonOffsetY.get();
			creativeTab.addButton(new GuiButtonPatreon(calculateOffsetX(screenWidth, -121 + configOffsetX), calculateOffsetY(screenHeight, 40 + configOffsetY)));
			patreonButton = GuiButtonPatreon.getButton();
			buttons.add(patreonButton);
		}
	}
	
	/**
	 * This sets the button alpha back to its start value
	 * @param button - The button that should be modified
	 */
	private static void setButtonAlphaToStart(Button button)
	{
		//Discord Button
		if(button instanceof GuiButtonDiscord)
		{
			((GuiButtonDiscord) button).setButtonAlphaToStart();
		}
		//CurseForge Button
		if(button instanceof GuiButtonCurseForge)
		{
			((GuiButtonCurseForge) button).setButtonAlphaToStart();
		}
		//YouTube Button
		if(button instanceof GuiButtonYouTube)
		{
			((GuiButtonYouTube) button).setButtonAlphaToStart();
		}
		//Twitch Button
		if(button instanceof GuiButtonTwitch)
		{
			((GuiButtonTwitch) button).setButtonAlphaToStart();
		}
		//Patreon Button
		if(button instanceof GuiButtonPatreon)
		{
			((GuiButtonPatreon) button).setButtonAlphaToStart();
		}
	}
}
