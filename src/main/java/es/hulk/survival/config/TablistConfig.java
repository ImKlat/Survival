package es.hulk.survival.config;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TablistConfig {

    private FileConfig config = Survival.get().getFileManager().getTablistConfig();

    public boolean ENABLE;

    public void init() {
        ENABLE = config.getBoolean("TABLIST.ENABLE");
    }

}
