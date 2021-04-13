package de.whsminecraft.InfoPlugin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Plugin was successfully enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin was successfully disabled.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().spigot().sendMessage(getWelcomeMessage());
        getLogger().info("Sent welcome screen to " + e.getPlayer().getDisplayName());
    }

    private BaseComponent getWelcomeMessage() {
        BaseComponent message = new TextComponent("");
        TextComponent ln = new TextComponent("\n");
        TextComponent s = new TextComponent(" ");

        // Max width of chat console
        TextComponent divider = new TextComponent("-----------------------------------------------------");
        divider.setColor(ChatColor.DARK_AQUA);

        TextComponent welcome = new TextComponent("Willkommen auf dem ");
        TextComponent server = new TextComponent("WHS Minecraft Server");
        server.setColor(ChatColor.GREEN);
        welcome.addExtra(server);
        welcome.addExtra("!");

        TextComponent linkHeader = new TextComponent("Willst du mehr über den Server herausfinden? Klicke hier:");

        TextComponent links = new TextComponent("");

        TextComponent website = new TextComponent("Website");
        website.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://whsminecraft.de"));
        website.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Homepage des Servers")));
        website.setColor(ChatColor.GOLD);

        TextComponent map = new TextComponent("Karte");
        map.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://whsminecraft.de/map"));
        map.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Interaktive Weltkarte")));
        map.setColor(ChatColor.GOLD);

        TextComponent news = new TextComponent("News");
        news.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://whsminecraft.de/news"));
        news.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Events & Ankündigungen")));
        news.setColor(ChatColor.GOLD);

        TextComponent faq = new TextComponent("FAQ");
        faq.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://whsminecraft.de/about"));
        faq.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Fragen & Antworten")));
        faq.setColor(ChatColor.GOLD);

        links.addExtra(website);
        links.addExtra("    ");
        links.addExtra(map);
        links.addExtra("    ");
        links.addExtra(news);
        links.addExtra("    ");
        links.addExtra(faq);

        TextComponent help = new TextComponent("Brauchst du Hilfe? Schreibe den Admins:");

        TextComponent trollesch = new TextComponent("Trollesch");
        trollesch.setColor(ChatColor.GOLD);
        trollesch.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell Trollesch "));

        TextComponent dreampac = new TextComponent("DReamPac");
        dreampac.setColor(ChatColor.GOLD);
        dreampac.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell DReamPac "));

        TextComponent admins = new TextComponent("");

        admins.addExtra(trollesch);
        admins.addExtra("    ");
        admins.addExtra(dreampac);


        message.addExtra(divider);
        message.addExtra("\n");
        message.addExtra(welcome);
        message.addExtra("\n");
        message.addExtra("\n");
        message.addExtra(linkHeader);
        message.addExtra("\n");
        message.addExtra(links);
        message.addExtra("\n");
        message.addExtra("\n");
        message.addExtra(help);
        message.addExtra("\n");
        message.addExtra(admins);
        message.addExtra("\n");
        message.addExtra(divider);

        return message;
    }
}
