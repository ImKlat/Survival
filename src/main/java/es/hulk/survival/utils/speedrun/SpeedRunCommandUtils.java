package es.hulk.survival.utils.speedrun;

import es.hulk.survival.Survival;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@UtilityClass
public class SpeedRunCommandUtils {

    public void addRemoveSpeedRunner(Player player, String[] args) {
        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage("§cPlayer not found");
            return;
        }

        if (Survival.get().isSpeedRun()) {
            player.sendMessage("§cSpeedrun already started");
        }
    }

}
