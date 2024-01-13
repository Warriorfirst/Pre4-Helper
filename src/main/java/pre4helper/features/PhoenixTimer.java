package pre4mod.features;

import pre4mod.config.Pre4Config;
import pre4mod.utils.Utils;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



public class PhoenixTimer{

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String message = event.message.getUnformattedText();
        
        if(GoblinConfig.phoenixTimer && message.contains("Your Phoenix Pet saved you from certain death!")) {
            drawTitle("", null, 20);
            Utils.setTimeout(() -> Minecraft.getMinecraft().ingameGUI.displayTitle("Leap now!", null, 0, 20, 0), 3750);
        }

    }
}