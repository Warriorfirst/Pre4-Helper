package pre4helper.features;

import pre4helper.config.Pre4Config;
import pre4helper.utils.Utils;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static pre4helper.utils.Utils.drawTitle;

public class PhoenixTimer{

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String message = event.message.getUnformattedText();
        
        if(message.contains("Your Phoenix Pet saved you from certain death!")) {
            drawTitle("", null, 20);
            Utils.setTimeout(() -> Minecraft.getMinecraft().ingameGUI.displayTitle("Leap now!", null, 0, 20, 0), Pre4Config.phoenixTimer);
        }

    }
}
