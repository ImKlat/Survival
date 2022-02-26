package es.hulk.survival.config;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class TablistConfig {

    private final FileConfig config = Survival.get().getFileManager().getTablistConfig();

    public boolean ENABLE;
    public List<String> HEADER;
    public List<String> FOOTER;

    public void init() {
        ENABLE = config.getBoolean("TABLIST.ENABLE");
        HEADER = config.getStringList("TABLIST.HEADER");
        FOOTER = config.getStringList("TABLIST.FOOTER");
    }

}
