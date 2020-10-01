package andrews.pandoras_creatures.gui.screen;

import andrews.pandoras_creatures.config.PCConfig;
import andrews.pandoras_creatures.gui.buttons.creative_tab.GuiButtonCurseForge;
import andrews.pandoras_creatures.gui.buttons.creative_tab.GuiButtonDiscord;
import andrews.pandoras_creatures.gui.buttons.creative_tab.GuiButtonPatreon;
import andrews.pandoras_creatures.gui.buttons.creative_tab.GuiButtonTwitch;
import andrews.pandoras_creatures.gui.buttons.creative_tab.GuiButtonYouTube;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Dist.CLIENT)
public class CreativeTabAdditions
{	
	@SubscribeEvent
	public static void onRenderCreativeTab(InitGuiEvent event)
	{	
		if(event.getGui() instanceof CreativeScreen)
		{
			CreativeScreen creativeTab = (CreativeScreen) event.getGui();
			int screenWidth = creativeTab.width;
			int screenHeight = creativeTab.height;
			
			int discordOffsetX = PCConfig.ValuesHolder.getButtonDiscordOffsetX();
			int discordOffsetY = PCConfig.ValuesHolder.getButtonDiscordOffsetY();
			int curseForgeOffsetX = PCConfig.ValuesHolder.getButtonCurseForgeOffsetX();
			int curseForgeOffsetY = PCConfig.ValuesHolder.getButtonCurseForgeOffsetY();
			int youTubeOffsetX = PCConfig.ValuesHolder.getButtonYouTubeOffsetX();
			int youTubeOffsetY = PCConfig.ValuesHolder.getButtonYouTubeOffsetY();
			int twitchOffsetX = PCConfig.ValuesHolder.getButtonTwitchOffsetX();
			int twitchOffsetY = PCConfig.ValuesHolder.getButtonTwitchOffsetY();
			int patreonOffsetX = PCConfig.ValuesHolder.getButtonPatreonOffsetX();
			int patreonOffsetY = PCConfig.ValuesHolder.getButtonPatreonOffsetY();
			
			event.addWidget(new GuiButtonDiscord(creativeTab, calculateOffsetX(screenWidth, -121 + discordOffsetX), calculateOffsetY(screenHeight, -52 + discordOffsetY)));
			event.addWidget(new GuiButtonCurseForge(creativeTab, calculateOffsetX(screenWidth, -121 + curseForgeOffsetX), calculateOffsetY(screenHeight, -29 + curseForgeOffsetY)));
			event.addWidget(new GuiButtonYouTube(creativeTab, calculateOffsetX(screenWidth, -121 + youTubeOffsetX), calculateOffsetY(screenHeight, -6 + youTubeOffsetY)));
			event.addWidget(new GuiButtonTwitch(creativeTab, calculateOffsetX(screenWidth, -121 + twitchOffsetX), calculateOffsetY(screenHeight, 17 + twitchOffsetY)));
			event.addWidget(new GuiButtonPatreon(creativeTab, calculateOffsetX(screenWidth, -121 + patreonOffsetX), calculateOffsetY(screenHeight, 40 + patreonOffsetY)));
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
}
