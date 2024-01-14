/**
 * This is a modified version from GoblinMod
 * https://github.com/BabyGetSwekt/GoblinsMod
 * @auther BabyGetSwekt
 */



/**
 * Modified from SkyblockFeatures under GNU Lesser General Public License v3.0
 * https://github.com/MrFast-js/SkyblockFeatures/blob/master/LICENSE
 * @author MrFast-js
 */

package pre4helper.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;

public class Utils {

    private static final Minecraft mc = Minecraft.getMinecraft();



    /**
     * Taken from Danker's Skyblock Mod under GPL 3.0 license
     * https://github.com/bowser0000/SkyblockMod/blob/master/LICENSE
     * @author bowser0000
     */
    public static String[] getListOfPlayerUsernames() {
        final Collection<NetworkPlayerInfo> players = Utils.GetMC().getNetHandler().getPlayerInfoMap();
        final List<String> list = new ArrayList<>();
        for (final NetworkPlayerInfo info : players) {
            if(!info.getGameProfile().getName().contains("!")) list.add(info.getGameProfile().getName());
        }
        return list.toArray(new String[0]);
    }

    public static Minecraft GetMC() {
        return mc;
    }
    public static void setTimeout(Runnable code, int ms) {
        setTimeout(code,ms,false);
    }
    public static void setTimeout(Runnable code, int ms,boolean addToMinecraft) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(addToMinecraft) Utils.GetMC().addScheduledTask(code);
                else code.run();
            }
        }, ms);
    }

    public static void drawTitle(String title, String subtitle, int ticks) {
        Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, ticks, 0);
        Minecraft.getMinecraft().ingameGUI.displayTitle(title, null, -1, -1, -1);
        Minecraft.getMinecraft().ingameGUI.displayTitle(null, subtitle, -1, -1, -1);
    }
}