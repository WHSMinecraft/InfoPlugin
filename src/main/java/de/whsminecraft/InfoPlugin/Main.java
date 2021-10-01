package de.whsminecraft.InfoPlugin;


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
        List<String> commands = getConfig().getStringList("onPlayerJoin");
        commands.forEach(c -> {
            e.getPlayer().performCommand(c);
        });

        getLogger().info("Sent welcome screen to " + e.getPlayer().getDisplayName());
    }
}
