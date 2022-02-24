package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.config.MessagesConfig;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.UUIDs;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KillCommand extends BaseCommand {

    @Command(name = "suicide")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        Survival.get().setCounter(15);

        player.setHealth(0.0D);
        Bukkit.broadcastMessage(Utils.color(MessagesConfig.KILL_COMMAND_BROADCAST).replace("<player>", player.getDisplayName()));
    }
}
