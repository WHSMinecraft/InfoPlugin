package de.whsminecraft.InfoPlugin;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        getLogger().info("Plugin was successfully enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin was successfully disabled.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String[] lines = getConfig().getString("onPlayerJoin").split("\n");
        for (String line : lines) {
            String player = e.getPlayer().getDisplayName();
            String command = "tellraw " + player + " " + line;
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
        };

        getLogger().info("Sent welcome screen to " + e.getPlayer().getDisplayName());
    }
}
