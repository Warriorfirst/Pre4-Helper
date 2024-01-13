/**
 * This is a modified version from GoblinMod
 * https://github.com/BabyGetSwekt/GoblinsMod
 * @auther BabyGetSwekt
 * 
 * This only includes the Bonzo Mask timer and the Phoenix pet timer which I made myself (Warriorfirst). 
 * The Base is BabyGetSwekts.
 */


package pre4helper.commands;

import pre4helper.config.Pre4Config;
import gg.essential.api.utils.GuiUtil;
import pre4helper.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

import java.util.List;
import java.util.Objects;

public class Pre4HelperCommands extends CommandBase {

    private final Minecraft mc = Minecraft.getMinecraft();

    @Override
    public String getCommandName() {
        return "pre4helper";
    }


    @Override
    public List<String> getCommandAliases() {
        return Lists.newArrayList("pre4","warrior","pre4helper");
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return (args.length >= 1) ? getListOfStringsMatchingLastWord(args, Utils.getListOfPlayerUsernames()) : null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        EntityPlayerSP player = (EntityPlayerSP) sender;
        if (args.length == 0) {
            GuiUtil.open(Objects.requireNonNull(GoblinConfig.INSTANCE.gui()));
        }


    }


    }


