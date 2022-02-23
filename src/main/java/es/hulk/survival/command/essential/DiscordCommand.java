package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.config.MessagesConfig;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class DiscordCommand extends BaseCommand {

    @Command(name = "discord")

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        Survival.get().setCounter(11);

        for (String list : MessagesConfig.DISCORD) {
            sender.sendMessage(Utils.color(list));
        }
    }
}
