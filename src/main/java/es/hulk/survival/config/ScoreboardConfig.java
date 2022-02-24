package es.hulk.survival.config;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ScoreboardConfig {

    private FileConfig config = Survival.get().getFileManager().getScoreboardConfig();

    public boolean ENABLE;
    public String MAIN_COLOR;
    public String SECONDARY_COLOR;
    public String TITLE;
    public String FOOTER;

    public List<String> LINES;

    public void init() {
        ENABLE = config.getBoolean("SCOREBOARD.ENABLE");
        TITLE = config.getString("SCOREBOARD.TITLE");
        FOOTER = config.getString("SCOREBOARD.FOOTER");

        MAIN_COLOR = config.getString("SCOREBOARD.MAIN_COLOR");
        SECONDARY_COLOR = config.getString("SCOREBOARD.SECONDARY_COLOR");

        LINES = config.getStringList("SCOREBOARD.LINES");
    }

}
