package es.hulk.survival.listeners;

import es.hulk.survival.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

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

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode().equals(GameMode.SPECTATOR)) player.setGameMode(GameMode.SURVIVAL);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.getGameMode().equals(GameMode.SPECTATOR)) player.setGameMode(GameMode.SURVIVAL);
    }
}
