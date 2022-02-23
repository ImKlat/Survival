package es.hulk.survival.config;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ScoreboardConfig {

    private FileConfig config = Survival.get().getFileManager().getScoreboardConfig();

    public boolean ENABLE;
    public String TITLE;
    public List<String> LINES;

    public void init() {
        ENABLE = config.getBoolean("SCOREBOARD.ENABLE");
        TITLE = config.getString("SCOREBOARD.TITLE");
        LINES = config.getStringList("SCOREBOARD.LINES");
    }

}
