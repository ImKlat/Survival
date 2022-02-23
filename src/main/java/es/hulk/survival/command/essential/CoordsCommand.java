package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.config.MessagesConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.location.OfflinePlayerLocation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CoordsCommand extends BaseCommand {

    @Command(name = "coords")
    @Override
    public void onCommand(CommandArgs command) {
        String[] args = command.getArgs();
        Player player = command.getPlayer();

        if (args.length == 0) {
            for (String stringList : MessagesConfig.YOUR_COORDS) {
                player.sendMessage(stringList
                        .replaceAll("<x-coord>", String.valueOf(OfflinePlayerLocation.coordinateX(player)))
                        .replaceAll("<y-coord>", String.valueOf(OfflinePlayerLocation.coordinateY(player)))
                        .replaceAll("<z-coord>", String.valueOf(OfflinePlayerLocation.coordinateZ(player)))
                        .replaceAll("<world>", OfflinePlayerLocation.getWorld(player)));
            }
        }
        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(Utils.color("&cPlayer is not online!"));
            return;
        }

        for (String stringList : MessagesConfig.TARGET_COORDS) {
            player.sendMessage(stringList
                    .replaceAll("<player>", String.valueOf(target.getName()))
                    .replaceAll("<x-coord>", String.valueOf(OfflinePlayerLocation.coordinateX(target)))
                    .replaceAll("<y-coord>", String.valueOf(OfflinePlayerLocation.coordinateY(target)))
                    .replaceAll("<z-coord>", String.valueOf(OfflinePlayerLocation.coordinateZ(target)))
                    .replaceAll("<world>", OfflinePlayerLocation.getWorld(target)));
        }
        Survival.get().setCounter(10);
    }
}
