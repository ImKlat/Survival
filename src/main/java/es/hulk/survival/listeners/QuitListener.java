package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.config.MessagesConfig;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage(Utils.color(MessagesConfig.QUIT_BROADCAST.replaceAll("<player>", player.getDisplayName())));
    }
}
