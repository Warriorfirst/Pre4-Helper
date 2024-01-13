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
            type = PropertyType.SWITCH, name = "Bonzo Timer",
            description = "Bonzo Mask timer to help with pre 4 in M7 and F7",
            category = "Dungeon", subcategory = "Miscellaneous",
        searchTags = {"helper", "pre4"}
    )
    public static boolean bonzoTimer = false;

    @Property(
            type = PropertyType.SWITCH, name = "Phoenix Timer",
            description = "Phoenix Pet timer to help with pre 4 in M7 and F7",
            category = "Dungeon", subcategory = "Miscellanous",
            searchTags = {"helper", "pre4"}
    )
    public static boolean phoenixTimer = false;




    public static pre4Config INSTANCE = new Pre4Config();



    public Pre4Config() {
        super(new File("./config/pre4mod.toml"), "Pre4Mod (" + Pre4Mod.VERSION + ")");
        initialize();
    }

}
