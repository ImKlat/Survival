package es.hulk.survival;

import es.hulk.survival.command.stats.StatsCommand;
import es.hulk.survival.command.teleport.TeleportAllCommand;
import es.hulk.survival.command.teleport.TeleportCommand;
import es.hulk.survival.command.teleport.TeleportCoordsCommand;
import es.hulk.survival.command.teleport.TeleportHereCommand;
import es.hulk.survival.listeners.ChatListener;
import es.hulk.survival.listeners.PlayerListener;
import es.hulk.survival.providers.ScoreboardProvider;
import es.hulk.survival.utils.TPSUtil;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.CommandManager;
import es.hulk.survival.utils.scoreboard.Scoreboard;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Survival extends JavaPlugin {
    private Scoreboard scoreboard;
    private CommandManager commandManager;
    private TPSUtil tpsUtil;

    private int counter = 0;
    private boolean isPlaceholderAPI;

    private boolean isCounterEnabled;
    private boolean isSpeedRun;
    private boolean speedRunDeathCounter;
    private List<String> speedRunners = new ArrayList<>();

    @Override
    public void onEnable() {
        this.loadManagers();
        this.scoreboardCounter();

        this.setGamerules();

        if (Bukkit.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            isPlaceholderAPI = true;
        }

        Utils.sendConsole(Utils.getLINE());
        Utils.sendConsole("");
        Utils.sendConsole("&aSurvival &e- &f" + getDescription().getVersion());
        Utils.sendConsole("");
        Utils.sendConsole("&aAuthor&7: &f" + getDescription().getAuthors());
        Utils.sendConsole("&aVersion&7: &f1.19");
        Utils.sendConsole("");
        this.loadProviders();
        Utils.sendConsole(Utils.getLINE());
        this.loadListeners();
        this.loadCommands();
    }

    @Override
    public void onDisable() {
        this.scoreboard.cleanup();
        this.scoreboard.getBoards().clear();
    }

    public void loadManagers() {
        this.commandManager = new CommandManager(this);
        this.tpsUtil = new TPSUtil(this);
        Utils.sendConsole("&8[&aSurvival&8] &eManagers loaded");
    }

    public void loadProviders() {
        this.scoreboard = new Scoreboard(this, new ScoreboardProvider());
        scoreboard.setTicks(2);
    }

    public void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new PlayerListener(), this);
        Utils.sendConsole("&8[&aSurvival&8] &eListeners Registered");
    }

    public void loadCommands() {
        new TeleportCommand();
        new TeleportHereCommand();
        new TeleportAllCommand();
        new TeleportCoordsCommand();
        new StatsCommand();
        Utils.sendConsole("&8[&aSurvival&8] &eLoaded &a37 &ecommands");
    }

    public void setGamerules() {
        for (World world : Bukkit.getWorlds()) {
            world.setDifficulty(Difficulty.HARD);
        }
        Utils.sendConsole("&8[&aSurvival&8] &eGamerule Updated");
    }

    private void scoreboardCounter() {
        this.isCounterEnabled = false;
        this.isSpeedRun = false;
    }

    public static Survival get() {
        return getPlugin(Survival.class);
    }
}
