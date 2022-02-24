package es.hulk.survival.managers;

import es.hulk.survival.Survival;
import es.hulk.survival.config.MainConfig;
import es.hulk.survival.config.MessagesConfig;
import es.hulk.survival.config.ScoreboardConfig;
import es.hulk.survival.config.TablistConfig;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileManager {

    private FileConfig mainConfig;
    private FileConfig locationsConfig;
    private FileConfig spawnConfig;
    private FileConfig messagesConfig;
    private FileConfig scoreboardConfig;
    private FileConfig tablistConfig;

    public void loadConfigs() {
        this.locationsConfig = new FileConfig(Survival.get(), "data/locations.yml");
        this.spawnConfig = new FileConfig(Survival.get(), "data/spawn.yml");
        this.mainConfig = new FileConfig(Survival.get(), "settings.yml");
        this.messagesConfig = new FileConfig(Survival.get(), "messages.yml");
        this.scoreboardConfig = new FileConfig(Survival.get(), "provider/scoreboard.yml");
        this.tablistConfig = new FileConfig(Survival.get(), "provider/tablist.yml");
        Utils.sendConsole("&8[&aSurvival&8] &eConfigs loaded");

        this.initConfigs();
    }

    public void initConfigs() {
        MainConfig.init();
        ScoreboardConfig.init();
        TablistConfig.init();
        MessagesConfig.init();
    }

    public void reloadConfigs() {
        this.messagesConfig.reload();
        this.mainConfig.reload();
        this.scoreboardConfig.reload();
        this.tablistConfig.reload();
    }

}
