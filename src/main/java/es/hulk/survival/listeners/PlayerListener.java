package es.hulk.survival.listeners;

import es.hulk.survival.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(Utils.color("&aEl cabron de &c" + player.getDisplayName() + " &ae entrado a tocar los cojones en el servidor."));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(Utils.color("&cEl cabron de &a" + player.getDisplayName() + " &ca dejado de tocar los cojones."));
    }
}
