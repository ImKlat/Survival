package es.hulk.survival.config;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MessagesConfig {

    private final FileConfig config = Survival.get().getFileManager().getMessagesConfig();

    public List<String> CAMA_COORDS;

    public List<String> YOUR_COORDS;
    public List<String> TARGET_COORDS;

    public List<String> DISCORD;

    public String KILL_COMMAND_ALL;
    public String KILL_COMMAND_BROADCAST;

    public String BED_LISTENER;

    public String PING_COMMAND_YOURS;
    public String PING_COMMAND_OTHER;
    public String PING_COMMAND_ERROR;

    public String JOIN_BROADCAST;
    public String QUIT_BROADCAST;

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
        KILL_COMMAND_BROADCAST = config.getString("KILL_COMMAND.BROADCAST");

        BED_LISTENER = config.getString("BED_LISTENER.MESSAGE");

        SETNAME_COMMAND_YOURS = config.getString("SETNAME_COMMAND.YOURS");
        SETNAME_COMMAND_TARGET = config.getString("SETNAME_COMMAND.OTHER");
        SETNAME_COMMAND_ERROR = config.getString("SETNAME_COMMAND.ERROR");
        SETNAME_COMMAND_RESET = config.getString("SETNAME_COMMAND.RESET");
        SETNAME_COMMAND_RESET_OTHER = config.getString("SETNAME_COMMAND.RESET_OTHER");

        PING_COMMAND_YOURS = config.getString("PING_COMMAND.YOURS");
        PING_COMMAND_OTHER = config.getString("PING_COMMAND.OTHER");
        PING_COMMAND_ERROR = config.getString("PING_COMMAND.ERROR");

        JOIN_BROADCAST = config.getString("BROADCAST.JOIN");
        QUIT_BROADCAST = config.getString("BROADCAST.QUIT");

        HEALTH_YOURS = config.getString("HEALTH_COMMAND.YOURS");
        HEALTH_TARGET = config.getString("HEALTH_COMMAND.OTHER");
        HEALTH_ERROR = config.getString("HEALTH_COMMAND.ERROR");
    }


}
