package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.config.MessagesConfig;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.location.BedLocation;
import org.bukkit.entity.Player;

public class CamaCoordCommand extends BaseCommand {

    @Command(name = "camacoords")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (String stringList : MessagesConfig.CAMA_COORDS) {
            player.sendMessage(stringList
                    .replaceAll("<bed-x-coord>", String.valueOf(BedLocation.bedCoordinateX(player)))
                    .replaceAll("<bed-y-coord>", String.valueOf(BedLocation.bedCoordinateY(player)))
                    .replaceAll("<bed-z-coord>", String.valueOf(BedLocation.bedCoordinateZ(player)))
                    .replaceAll("<bed-world>", BedLocation.getBedWorld(player)));
        }
        Survival.get().setCounter(9);
    }
}
