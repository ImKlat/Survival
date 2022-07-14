package es.hulk.survival.managers.recipe.recipes.gold;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldPickaxe {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.GOLD_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&6Golden Pickaxe"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 8);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        NamespacedKey key = new NamespacedKey(Survival.get(), "gold_block_pickaxe");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("RRR", " I ", " I ");
        recipe.setIngredient('R', Material.GOLD_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
