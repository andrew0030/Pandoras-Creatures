package andrews.pandoras_creatures.util;

import java.nio.charset.CharsetEncoder;

import com.google.common.base.Charsets;

import andrews.pandoras_creatures.config.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.Type;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public final class RehostedJarHandler
{    
    private static final String STOP_MOD_REPOSTS_URL = "http://stopmodreposts.org/";
    
    private static boolean validJar = false;
    
    private static long lastMessagePost = 0;
    private static long messagePostRate = 1000 * 30;
    
    /**
     * The constructor of this class, it performs a jar check upon getting called
     * @param jarFile - The Mod jar file
     * @param originalName - The proper name of the Mods jar file
     */
    public RehostedJarHandler(ModFile jarFile, String originalName)
    {
        checkIfJarIsValid(jarFile, originalName);
    }
    
    /**
     * Checks if the given file is valid
     * @param jarFile - The Mod jar file
     * @param originalName - The proper name of the Mods jar file
     */
    private void checkIfJarIsValid(ModFile jarFile, String originalName)
    {
        if(jarFile == null)
        {
            return;
        }
        
        if(jarFile.getFileName().equals(originalName))
        {
            //Names match.
            validJar = true;
            return;
        }
        
        CharsetEncoder asciiEncoder = Charsets.US_ASCII.newEncoder();
        if(!asciiEncoder.canEncode(jarFile.getFileName()))
        {
            //Most likely posted on a local language site.
            validJar = true;
            return;
        }
    }
    
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {	
        if(validJar)
        {
            return;
        }
        if(!Config.CLIENT.shouldShowInvalidJarMessage.get())
        {
        	return;
        }
        if(event.side != LogicalSide.CLIENT)
        {
            return;
        }
        if(event.type != Type.PLAYER)
        {
            return;
        }
        if(event.phase != Phase.END)
        {
            return;
        }
        if(lastMessagePost + messagePostRate > System.currentTimeMillis())
        {
            return;
        }
        lastMessagePost = System.currentTimeMillis();
        PlayerEntity player = event.player;
        
        TranslationTextComponent downloadLink = new TranslationTextComponent("chat.pandoras_creatures.invalidJarDownload", (Object)null);
        downloadLink.getStyle().setUnderlined(true);
        downloadLink.getStyle().setColor(TextFormatting.BLUE);
        downloadLink.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("chat.pandoras_creatures.invalidJarDownloadTooltip", (Object)null)));
        downloadLink.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.curseforge.com/minecraft/mc-mods/pandoras-creatures/files"));
        
        TranslationTextComponent stopModRepostsLink = new TranslationTextComponent("chat.pandoras_creatures.invalidJarStopModReposts", (Object)null);
        stopModRepostsLink.getStyle().setUnderlined(true);
        stopModRepostsLink.getStyle().setColor(TextFormatting.BLUE);
        stopModRepostsLink.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("chat.pandoras_creatures.invalidJarStopModRepostsTooltip", (Object)null)));
        stopModRepostsLink.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, STOP_MOD_REPOSTS_URL));
        
        TranslationTextComponent updateMessage = new TranslationTextComponent("chat.pandoras_creatures.invalidJar", downloadLink, stopModRepostsLink);
        updateMessage.getStyle().setColor(TextFormatting.RED);
        player.sendMessage(updateMessage);
    }
}