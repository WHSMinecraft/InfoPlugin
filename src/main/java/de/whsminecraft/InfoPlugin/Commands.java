package de.whsminecraft.InfoPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Commands implements CommandExecutor, TabCompleter {
    private Plugin plugin;

    public Commands(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1 && "reload".equals(strings[0])) {
            plugin.reloadConfig();
            commandSender.sendMessage((commandSender instanceof Player ? ChatColor.GREEN : "") + "Successfully reloaded config");
            return true;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> subCommands = new ArrayList<>();
        if (strings.length == 1 && "infoplugin".equalsIgnoreCase(command.getName())) {
            subCommands.add("reload");
        }
        return subCommands;
    }
}
