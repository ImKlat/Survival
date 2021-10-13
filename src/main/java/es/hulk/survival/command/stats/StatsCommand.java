package es.hulk.survival.command.stats;

import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 13/10/2021 23:35
 * Project: Survival
 * Class: StatsCommand
 */

public class StatsCommand extends BaseCommand {

    @Command(name = "stats")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(Utils.color("&aTus Estadisticas"));
            player.sendMessage();
            player.sendMessage(Utils.color("&bMobs Asesinados&7: &e" + PlayerUtils.getMobKills(player)));
            player.sendMessage(Utils.color("&bJugadores Asesinados&7: &e" + PlayerUtils.getPlayerKills(player)));
            player.sendMessage(Utils.color("&bMuertes&7: &e" + PlayerUtils.getDeaths(player)));
            player.sendMessage(Utils.color("&bTiempo Jugado&7: &e" + PlayerUtils.getPlayTime(player)));
            player.sendMessage(Utils.color("&bVida&7: &e" + (int) player.getHealth()));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(Utils.color("&cJugador " + target + " no esta conectado o no existe"));
                return;
            }

            player.sendMessage(Utils.color("&aEstadisticas del jugador &e" + target.getName()));
            player.sendMessage();
            player.sendMessage(Utils.color("&bMobs Asesinados&7: &e" + PlayerUtils.getMobKills(target)));
            player.sendMessage(Utils.color("&bJugadores Asesinados&7: &e" + PlayerUtils.getPlayerKills(target)));
            player.sendMessage(Utils.color("&bMuertes&7: &e" + PlayerUtils.getDeaths(target)));
            player.sendMessage(Utils.color("&bTiempo Jugado&7: &e" + PlayerUtils.getPlayTime(target)));
            player.sendMessage(Utils.color("&bVida&7: &e" + (int) target.getHealth()));
        }
    }
}
