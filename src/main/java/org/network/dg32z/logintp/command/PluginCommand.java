package org.network.dg32z.logintp.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.network.dg32z.logintp.PluginLoader;
import org.network.dg32z.logintp.util.color.ColorUtil;

public class PluginCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equals("lt")) {
            if (sender instanceof Player) {
                if (args[0].equals("add")) {
                    PluginLoader.INSTANCE.getJoinEvent().location = ((Player) sender).getLocation();
                    sender.sendMessage(ColorUtil.colorMessage(PluginLoader.INSTANCE.getSetDone()));
                    return true;
                }
                sender.sendMessage(ColorUtil.colorMessage(PluginLoader.INSTANCE.getUnknownParameter()));
                return false;
            }
            sender.sendMessage(ColorUtil.colorMessage(PluginLoader.INSTANCE.getNotPlayer()));
            return true;
        }
        return false;
    }
}
