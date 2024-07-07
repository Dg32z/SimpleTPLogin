package org.network.dg32z.logintp.util.server;

import org.bukkit.Bukkit;

public class ServerUtil {
    String version;

    public ServerUtil() {
        this.version = Bukkit.getVersion().split("MC: ")[1].replace(")", "");
    }

    public boolean is1_16orAbove() {
        return this.version.startsWith("1.16") || this.version.startsWith("1.17") || this.version.startsWith("1.18") || this.version.startsWith("1.19") || this.version.startsWith("1.20");
    }
}

