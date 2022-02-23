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

    public List<String> DISCORD;

    public String KILL_COMMAND_ALL;

    public String SETNAME_COMMAND_RESET;
    public String SETNAME_COMMAND_YOURS;
    public String SETNAME_COMMAND_TARGET;
    public String SETNAME_COMMAND_ERROR;
    public String SETNAME_COMMAND_RESET_OTHER;

    public String HEALTH_YOURS;
    public String HEALTH_TARGET;
    public String HEALTH_ERROR;

    public void init() {
        CAMA_COORDS = config.getStringList("CAMA_COORDS");

        YOUR_COORDS = config.getStringList("COORD.YOURS");
        YOUR_COORDS = config.getStringList("COORD.OTHER_PLAYER");

        DISCORD = config.getStringList("DISCORD_COMMAND");

        KILL_COMMAND_ALL = config.getString("KILL_COMMAND.ALL");

        SETNAME_COMMAND_YOURS = config.getString("SETNAME_COMMAND.YOURS");
        SETNAME_COMMAND_TARGET = config.getString("SETNAME_COMMAND.OTHER");
        SETNAME_COMMAND_ERROR = config.getString("SETNAME_COMMAND.ERROR");
        SETNAME_COMMAND_RESET = config.getString("SETNAME_COMMAND.RESET");
        SETNAME_COMMAND_RESET_OTHER = config.getString("SETNAME_COMMAND.RESET_OTHER");
    }


}
