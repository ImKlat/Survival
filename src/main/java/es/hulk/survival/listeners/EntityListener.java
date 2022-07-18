package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();

    @EventHandler
    public void onEntityDie(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        Random random = new Random();

        if (!mainConfig.getBoolean("ENTITIES.POPPY-DROP")) {
            if (event.getEntity().getType() == EntityType.IRON_GOLEM) {
                event.getDrops().removeIf(is -> is.getType() == Material.RED_ROSE);
            }
        }

        if (mainConfig.getBoolean("ENTITIES.GUNPOWDER-BOOST")) {
            if (event.getEntity().getType() == EntityType.CREEPER) {
                event.getDrops().add(new ItemStack(Material.SULPHUR, random.nextInt(30)));

                if (event.getEntity() instanceof Player) {
                    if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                        event.getDrops().add(new ItemStack(Material.TNT));
                    }
                }
            }
        }

        if (mainConfig.getBoolean("ENTITIES.GHAST-THEAR-BOOST")) {
            if (event.getEntity().getType() == EntityType.GHAST) {

                event.getDrops().add(new ItemStack(Material.GHAST_TEAR, random.nextInt(20)));

                if (event.getEntity() instanceof Player) {
                    if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                        event.getDrops().add(new ItemStack(Material.NETHER_STAR, random.nextInt(2)));
                    }
                }
            }

            if (mainConfig.getBoolean("ENTITIES.CAT-BOOST")) {
                if (event.getEntity().getType() == EntityType.OCELOT) {
                    event.getDrops().add(new ItemStack(Material.MUTTON, random.nextInt(6)));
                    event.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(6)));
                }
            }
        }
    }

    @EventHandler
    public void entityExplode(EntityExplodeEvent event) {
        if (event.getEntity().getType() == EntityType.CREEPER) {
            event.setCancelled(true);
            return;
        }

        if (event.getEntity().getType() == EntityType.PRIMED_TNT) {
            event.setCancelled(true);
            return;
        }
        event.setCancelled(false);
    }
}
