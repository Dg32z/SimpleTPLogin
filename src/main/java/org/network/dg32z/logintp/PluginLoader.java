package org.network.dg32z.logintp;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.network.dg32z.logintp.command.PluginCommand;
import org.network.dg32z.logintp.events.JoinEvent;
import org.network.dg32z.logintp.util.server.ServerUtil;

import java.util.Objects;
import java.util.logging.Level;

@Getter
public enum PluginLoader {
    INSTANCE;

    private JoinEvent joinEvent;
    private PluginCommand pluginCommand;
    private ServerUtil serverUtil;
    private JavaPlugin plugin;

    private String notPlayer;
    private String setPos;
    private String unknownParameter;
    private String setDone;

    PluginLoader() {
        this.joinEvent = new JoinEvent();
        this.pluginCommand = new PluginCommand();
    }

    public void initialize_start(JavaPlugin plugin) {
        this.plugin = plugin;
        initManagers();
        start();
    }

    public void initialize_stop(JavaPlugin plugin) {
        this.plugin = plugin;
        stop();
    }

    private void initManagers() {
        joinEvent = new JoinEvent();
        serverUtil = new ServerUtil();
        pluginCommand = new PluginCommand();

        notPlayer = plugin.getConfig().getString("languages.notPlayer");
        setPos = plugin.getConfig().getString("languages.setPos");
        unknownParameter = plugin.getConfig().getString("languages.unknownParameter");
        setDone = plugin.getConfig().getString("languages.done");
    }

    private void loadConfigStrings() {
        FileConfiguration config = plugin.getConfig();
        this.notPlayer = config.getString("languages.notPlayer", "");
        this.setPos = config.getString("languages.setPos", "");
        this.unknownParameter = config.getString("languages.unknownParameter", "");
    }

    public void start() {
        Bukkit.getLogger().log(Level.WARNING, "Thanks for using it @QQ1410521748");
        registerEvent();
        registerCommand();
        loadConfigStrings();
        loadSavedLocation();
        plugin.saveDefaultConfig();
    }

    private void loadSavedLocation() {
        FileConfiguration config = plugin.getConfig();
        double x = config.getDouble("Position.x", 0.0);
        double y = config.getDouble("Position.y", 0.0);
        double z = config.getDouble("Position.z", 0.0);

        if (x != 0.0 && y != 0.0 && z != 0.0) {
            joinEvent.location = new Location(plugin.getServer().getWorld("main"), x, y, z);
        }
    }

    public void stop() {
        if (plugin == null) {
            return;
        }

        FileConfiguration config = plugin.getConfig();
        config.set("Position.x", joinEvent.location.getX());
        config.set("Position.y", joinEvent.location.getY());
        config.set("Position.z", joinEvent.location.getZ());
        plugin.saveConfig();
    }
    public void registerEvent() {
        Bukkit.getPluginManager().registerEvents(joinEvent, plugin);
    }
    public void registerCommand() {
        Objects.requireNonNull(Bukkit.getPluginCommand("lt")).setExecutor(this.pluginCommand);
    }

}
