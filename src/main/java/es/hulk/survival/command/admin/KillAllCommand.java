package es.hulk.survival.command.admin;

import es.hulk.survival.Survival;
import es.hulk.survival.config.MessagesConfig;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KillAllCommand extends BaseCommand {

    @Command(name = "killall", permission = "survival.command.killall")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.setHealth(0.0D);
        }
        Bukkit.broadcastMessage(Utils.color(MessagesConfig.KILL_COMMAND_ALL));
        Survival.get().setCounter(5);
    }
}
