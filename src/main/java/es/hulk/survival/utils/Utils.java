package es.hulk.survival.utils;

import lombok.Getter;
import net.minecraft.server.v1_12_R1.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    @Getter private static String LINE = Utils.color("&7&m----------------------------------------");
    @Getter private static String PREFIX = Utils.color("&7[&aSurvival&7] ");

    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> translate(List<String> in) {
        return in.stream().map(Utils::color).collect(Collectors.toList());
    }

    public static int getPing(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        return entityPlayer.ping;
    }

    public static String formatLongHour(long time) {
        long totalSecs = time / 1000L;

        long seconds = totalSecs % 60L;
        long minutes = totalSecs % 3600L / 60L;
        long hours = totalSecs / 3600L;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
