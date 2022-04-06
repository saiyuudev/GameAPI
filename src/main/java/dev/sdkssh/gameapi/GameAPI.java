package dev.sdkssh.gameapi;

import dev.sdkssh.gameapi.events.ConnectionEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class GameAPI extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ConnectionEvents(), this);
    }
}
