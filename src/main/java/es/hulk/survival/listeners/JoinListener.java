package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.SpawnManager;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.UUIDs;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;

public class JoinListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();
    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();
    private Survival plugin = Survival.get();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Player hulk = Bukkit.getPlayer(UUIDs.hulkUUID());


        if (mainConfig.getBoolean("SEAL-KICK")) {
            if (player.getUniqueId().equals(UUIDs.nadalUUID())) {
                player.kickPlayer(Utils.color(
                        "&cYou are not allowed to join this server! " +
                                "\n " +
                                "\nBecause you are a fucking retarded i dont want u in this server" +
                                "\nHave fun and go cry retard"));
            }
        }

        event.setJoinMessage(Utils.color(messagesConfig.getString("BROADCAST.JOIN").replaceAll("<player>", player.getDisplayName())));

        assert hulk != null;
        hulk.sendMessage(Utils.getLINE());
        hulk.sendMessage(Utils.color("&6Player&7: &a" + player.getName()));
        hulk.sendMessage(Utils.color("&6Rank&7: &a" + Survival.get().getRankManager().getRank().getDisplayName(player)));
        hulk.sendMessage("");
        hulk.sendMessage(Utils.color("&6UUID&7: &a" + player.getUniqueId()));
        hulk.sendMessage(Utils.color("&6IP&7: &a" + player.getAddress().getHostString()));
        hulk.sendMessage(Utils.getLINE());

        if (mainConfig.getBoolean("JOIN-MESSAGE.ENABLE")) {
            for (String lines : mainConfig.getStringList("JOIN-MESSAGE.LINES")) {
                player.sendMessage(lines.replaceAll("<player>", player.getDisplayName()));
            }
        }

        if (!player.hasPlayedBefore()) {
            player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
            player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
            player.getInventory().addItem(new ItemStack(Material.STONE_AXE));
            player.getInventory().addItem(new ItemStack(Material.STONE_SHOVEL));
            player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 20));

            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "recipe give " + player.getName() + " *");
        }
    }

}
