package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.counter.CounterHelper;
import es.hulk.survival.utils.location.OfflinePlayerLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hulk
 * at 05/03/2022 13:41
 * Project: Survival
 * Class: DeathListener
 */

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        if (player == null) return;
        Location location = player.getLocation();

        if (location.getBlockY() < 1) {
            location.setY(1);
        }

        location.getBlock().setType(Material.CHEST);
        location.getBlock().getRelative(BlockFace.EAST).setType(Material.CHEST);
        location.clone().add(0, 1, 0).getBlock().setType(Material.AIR);
        location.clone().add(0, 1, 0).getBlock().getRelative(BlockFace.EAST).setType(Material.AIR);

        Chest chest = (Chest) location.getBlock().getState();

        for (ItemStack itemStack : event.getDrops()) {
            if (itemStack == null || itemStack.getType() == Material.AIR) continue;
            chest.getInventory().addItem(itemStack);
        }
        event.getDrops().clear();
        player.setExp(event.getNewTotalExp());

        player.sendTitle(Utils.color("&4&lHAS MUERTO"), "", 10, 100, 10);
        player.sendMessage(Utils.color("&aCoordenadas donde has muerto&7: "));
        player.sendMessage(Utils.color("&bMundo&7: &a" + PlayerUtils.getWorld(player)));
        player.sendMessage(Utils.color("&bX&7: &a" + OfflinePlayerLocation.coordinateX(player)));
        player.sendMessage(Utils.color("&bY&7: &a" + OfflinePlayerLocation.coordinateY(player)));
        player.sendMessage(Utils.color("&bZ&7: &a" + OfflinePlayerLocation.coordinateZ(player)));
        player.sendMessage("");

        if (Survival.get().isSpeedRunDeathCounter()) {
            if (Survival.get().getSpeedRunners().contains(player)) {
                CounterHelper.getTimer().setSeconds((int) (CounterHelper.getTimer().getSeconds() + TimeUnit.MINUTES.toSeconds(5)));
            }
        }
    }
}
