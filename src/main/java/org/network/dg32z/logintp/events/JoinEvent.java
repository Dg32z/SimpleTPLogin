package org.network.dg32z.logintp.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    public Location location;

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        location = player.getLocation();

        player.teleport(location);
    }
}