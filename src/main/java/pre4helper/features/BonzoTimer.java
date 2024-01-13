/**
 * This is a modified version from GoblinMod
 * https://github.com/BabyGetSwekt/GoblinsMod
 * @auther BabyGetSwekt
 * 
 * This only includes the Bonzo Mask timer and the Phoenix pet timer which I made myself (Warriorfirst). 
 * The Base is BabyGetSwekts.
 */


package pre4mod.features;

import pre4mod.config.Pre4Config;
import pre4mod.utils.Utils;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



public class BonzoTimer{

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String message = event.message.getUnformattedText();

        if(GoblinConfig.bonzoTimer && message.contains("Your ⚚ Bonzo's Mask saved your life!") || message.contains("Your Bonzo's Mask saved your life!")) {
            drawTitle("", null, 20);
            Utils.setTimeout(() -> Minecraft.getMinecraft().ingameGUI.displayTitle("Rod now!", null, 0, 20, 0), 2500);
        }

    }
}