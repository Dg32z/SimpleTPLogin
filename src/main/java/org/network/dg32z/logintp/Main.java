package org.network.dg32z.logintp;

import org.bukkit.plugin.java.JavaPlugin;
public final class Main extends JavaPlugin {
    private Main plugin;

    public void onEnable() {
        plugin = this;
        PluginLoader.INSTANCE.initialize_start(this);
    }

    public void onDisable() {
        plugin = null;
        PluginLoader.INSTANCE.initialize_stop(this);
    }
}