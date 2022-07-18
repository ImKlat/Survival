package es.hulk.survival.command.speedrun.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.speedrun.SpeedRunCommandUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 20:45
 * Project: Survival
 * Class: AddSpeedRunnerCommand
 */

public class AddSpeedRunnerCommand extends BaseCommand {

    @Command(name = "speedrun.add", permission = "survival.speedrun.add")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        Player target = Bukkit.getPlayer(args[0]);
        SpeedRunCommandUtils.addRemoveSpeedRunner(player, args);
        Survival.get().getSpeedRunners().add(target.getName());
        player.sendMessage("§aAdded §7" + target.getName() + " §ato the speedrun");
    }
}
