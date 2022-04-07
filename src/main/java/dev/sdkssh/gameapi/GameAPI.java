package dev.sdkssh.gameapi;

import dev.sdkssh.gameapi.events.ConnectionEvents;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class GameAPI extends JavaPlugin {
    @Getter
    private static GameAPI plugin;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ConnectionEvents(), this);
        plugin = this;
    }
}
