/**
 * This is a modified version from GoblinMod
 * https://github.com/BabyGetSwekt/GoblinsMod
 * @auther BabyGetSwekt
 * 
 * This only includes the Bonzo Mask timer and the Phoenix pet timer which I made myself (Warriorfirst). 
 * The Base is BabyGetSwekts.
 */


package pre4helper.features;

import pre4helper.config.Pre4Config;
import pre4helper.utils.Utils;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static pre4helper.utils.Utils.drawTitle;

public class BonzoTimer{

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String message = event.message.getUnformattedText();

        if(message.contains("Your ⚚ Bonzo's Mask saved your life!") || message.contains("Your Bonzo's Mask saved your life!")) {
            drawTitle("", null, 20);
            Utils.setTimeout(() -> Minecraft.getMinecraft().ingameGUI.displayTitle("Rod now!", null, 0, 20, 0), Pre4Config.bonzoTimer);
        }

    }
}
