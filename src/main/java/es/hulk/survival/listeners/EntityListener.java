package es.hulk.survival.listeners;

import es.hulk.survival.config.MainConfig;
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

    @EventHandler
    public void onEntityDie(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        Random random = new Random();

        if (!MainConfig.POPPY_DROP) {
            if (event.getEntity().getType() == EntityType.IRON_GOLEM) {
                event.getDrops().removeIf(is -> is.getType() == Material.POPPY);
            }
        }

        if (MainConfig.GUNPOWDER_BOOST) {
            if (event.getEntity().getType() == EntityType.CREEPER) {
                event.getDrops().add(new ItemStack(Material.GUNPOWDER, random.nextInt(30)));

                if (event.getEntity() instanceof Player) {
                    if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                        event.getDrops().add(new ItemStack(Material.TNT));
                    }
                }
            }
        }

        if (MainConfig.GHAST_THEAR_BOOST) {
            if (event.getEntity().getType() == EntityType.GHAST) {

                event.getDrops().add(new ItemStack(Material.GHAST_TEAR, random.nextInt(20)));

                if (event.getEntity() instanceof Player) {
                    if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                        event.getDrops().add(new ItemStack(Material.NETHER_STAR, random.nextInt(2)));
                    }
                }
            }

            if (MainConfig.CAT_BOOST) {
                if (event.getEntity().getType() == EntityType.CAT) {
                    event.getDrops().add(new ItemStack(Material.MUTTON, random.nextInt(6)));
                    event.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(6)));
                }
            }

            if (MainConfig.BEE_BOOST) {
                if (event.getEntity().getType() == EntityType.BEE) {
                    event.getDrops().add(new ItemStack(Material.MUTTON, random.nextInt(6)));
                    event.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(6)));

                    if (event.getEntity() instanceof Player) {
                        if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                            event.getDrops().add(new ItemStack(Material.HONEY_BLOCK));
                        }
                    }
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
        event.setCancelled(false);
    }
}
