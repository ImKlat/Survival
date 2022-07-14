package es.hulk.survival.managers.recipe.recipes.other;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;


public class CustomExperienceBottle {

    private static final Survival plugin = Survival.get();

    public static void load() {
        ItemStack exp = new ItemStack(Material.EXP_BOTTLE);
        NamespacedKey key = new NamespacedKey(plugin, "exp_bottle_custom");

        ShapedRecipe customExp = new ShapedRecipe(key, exp);
        customExp.shape("LLL", "LEL", "LLL");
        customExp.setIngredient('L', Material.INK_SACK, (byte) 4);
        customExp.setIngredient('E', Material.EMERALD);

        Bukkit.addRecipe(customExp);
    }

}
