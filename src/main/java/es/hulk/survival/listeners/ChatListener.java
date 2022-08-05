package es.hulk.survival.listeners;

import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        TextComponent component = new TextComponent(Utils.color("&e" + player.getDisplayName() + " &8» &r" + event.getMessage()));
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, this.getContent(player, "Hola, buenas tardes.")));

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.spigot().sendMessage(component);
        }
        event.setCancelled(true);
    }

    public Content getContent(Player player, String text) {
        switch (player.getName()) {
            case "ElTitoHulk":
                return new Text("Le hierro bloque");
            case "Itz_Wh1sKy":
                return new Text("The Extreme Bugator Finder");
            case "zRT2005":
                return new Text("El Tonto que no hace nada");
            case "DragoGamer3005":
                return new Text("Netherrack Master");
        }
        return new Text(text);
    }
}
