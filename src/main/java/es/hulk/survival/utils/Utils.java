package es.hulk.survival.utils;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    @Getter private static final String LINE = Utils.color("&7&m----------------------------------------");
    @Getter private static final String PREFIX = Utils.color("&7[&aSurvival&7] ");

    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> translate(List<String> in) {
        return in.stream().map(Utils::color).collect(Collectors.toList());
    }
}
