/**
 * This is a modified version from GoblinMod
 * https://github.com/BabyGetSwekt/GoblinsMod
 * @auther BabyGetSwekt
 * 
 * This only includes the Bonzo Mask timer and the Phoenix pet timer which I made myself (Warriorfirst). 
 * The Base is BabyGetSwekts.
 */


package pre4helper.config;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import pre4helper.Pre4Mod;

import java.io.File;

public class Pre4Config extends Vigilant {


    @Property(
            type = PropertyType.SLIDER, name = "Bonzo Timer",
            description = "Change the timer (in ms). Standard is 2600ms",
            category = "Dungeon", subcategory = "Pre4 Helper",
            searchTags = {"helper", "pre4"},
            min = 2500,
            max = 2950
    )
    public static int bonzoTimer = 2600;

    @Property(
            type = PropertyType.SLIDER, name = "Phoenix Timer",
            description = "Change the timer (in ms). Standard is 3600ms",
            category = "Dungeon", subcategory = "Pre4 Helper",
            searchTags = {"helper", "pre4"},
            min = 3500,
            max = 3950
    )
    public static int phoenixTimer = 3600;




    public static Pre4Config INSTANCE = new Pre4Config();



    public Pre4Config() {
        super(new File("./config/pre4mod.toml"), "Pre4Mod (" + Pre4Mod.VERSION + ")");
        initialize();
    }

}
