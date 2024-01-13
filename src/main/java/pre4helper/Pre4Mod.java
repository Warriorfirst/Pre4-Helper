/**
 * This is a modified version from GoblinMod
 * https://github.com/BabyGetSwekt/GoblinsMod
 * @auther BabyGetSwekt
 * 
 * This only includes the Bonzo Mask timer and the Phoenix pet timer which I made myself (Warriorfirst). 
 * The Base is BabyGetSwekts.
 */



package pre4helper;

import pre4helper.config.Pre4Config;
import pre4helper.commands.Pre4HelperCommands;
import pre4helper.features.*;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod(modid = Pre4Mod.MODID, name = Pre4Mod.NAME, version = Pre4Mod.VERSION)
public class Pre4Mod {
    public static final String MODID = "Pre4Helper", VERSION = "1.0", NAME = "Pre4 Helper";

    @Mod.Instance(MODID)
    public static Pre4Mod instance;

    private Pre4Mod pre4Mod;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        pre4config  = Pre4Config.INSTANCE;




    }



    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        // Features to load
        List<Object> features = Arrays.asList(
                this,
                new BonzoTimer(),
                new PhoenixTimer()
        );
        features.forEach(MinecraftForge.EVENT_BUS::register);


    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        ClientCommandHandler commandHandler = ClientCommandHandler.instance;
        List<ICommand> commands = new ArrayList<>();
        commands.add(new GoblinCommand());

        for (ICommand command : commands) {
            if (!commandHandler.getCommands().containsValue(command)) {
                commandHandler.registerCommand(command);
            }
        }
    }

}