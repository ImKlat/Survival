package es.hulk.survival.config;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MessagesConfig {

    private FileConfig config = Survival.get().getFileManager().getMessagesConfig();

    public List<String> CAMA_COORDS;

    public List<String> YOUR_COORDS;
    public List<String> TARGET_COORDS;

    public void init() {
        CAMA_COORDS = config.getStringList("CAMA_COORDS");
    }


}
