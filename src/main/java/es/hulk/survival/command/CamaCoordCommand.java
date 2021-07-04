package es.hulk.survival.command;

import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.location.BedLocation;
import es.hulk.survival.utils.location.PlayerLocation;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class CamaCoordCommand extends BaseCommand {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @Command(name = "camacoords")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (String stringList : mainConfig.getStringList("CAMA-COORDS-COMMAND")) {
            player.sendMessage(stringList
                    .replaceAll("<bed-x-coord>", BedLocation.bedCoordinateX(player))
                    .replaceAll("<bed-y-coord>", BedLocation.bedCoordinateY(player))
                    .replaceAll("<bed-z-coord>", BedLocation.bedCoordinateZ(player))
                    .replaceAll("<bed-world>", BedLocation.getBedWorld(player)));
        }
    }
}
