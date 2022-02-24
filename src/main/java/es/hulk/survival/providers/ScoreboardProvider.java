package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.config.ScoreboardConfig;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements ScoreboardAdapter {

    @Override
    public String getTitle(Player player) {
        return Utils.color(ScoreboardConfig.TITLE);
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        lines.add("");
        for (Player online : Bukkit.getOnlinePlayers()) {
            lines.add(ScoreboardConfig.MAIN_COLOR + online.getName() + "&7: " + ScoreboardConfig.SECONDARY_COLOR + PlayerUtils.getDeaths(online));
        }
        lines.add("");
        lines.add(ScoreboardConfig.MAIN_COLOR + "TPS&7: " + ScoreboardConfig.SECONDARY_COLOR + (int) Survival.get().getTpsUtil().getRoundedTPS());
        lines.add("");
        lines.add(ScoreboardConfig.FOOTER);

        return Utils.translate(lines);
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
