package org.network.dg32z.logintp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.network.dg32z.logintp.PluginLoader;

public class PluginCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equals("lt")) {
            if (sender instanceof Player) {
                if (args[0].equals("add")) {
                    PluginLoader.INSTANCE.getJoinEvent().location = ((Player) sender).getLocation();
                    sender.sendMessage();
                    return true;
                }
                sender.sendMessage(PluginLoader.INSTANCE.unknownParameter);
                return false;
            }
            sender.sendMessage(PluginLoader.INSTANCE.notPlayer);
            return true;
        }
        return false;
    }
}
