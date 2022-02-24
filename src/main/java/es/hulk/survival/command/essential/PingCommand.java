package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.config.MessagesConfig;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PingCommand extends BaseCommand {

    @Command(name = "ping")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        Survival.get().setCounter(16);

        if (args.length == 0) {
            player.sendMessage(Utils.color(MessagesConfig.PING_COMMAND_YOURS.replaceAll("<ping>", String.valueOf(player.getPing()))));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(Utils.color(MessagesConfig.PING_COMMAND_ERROR.replaceAll("<target>", args[0])));
                return;
            }
            player.sendMessage(Utils.color(MessagesConfig.PING_COMMAND_OTHER.replaceAll("<ping>", String.valueOf(target.getPing())).replaceAll("<target>", target.getDisplayName())));
        }
    }
}
