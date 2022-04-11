package dev.sdkssh.exemple;

import dev.sdkssh.exemple.events.GameEvents;
import dev.sdkssh.exemple.game.ExempleGame;
import dev.sdkssh.gameapi.api.properties.Properties;
import dev.sdkssh.gameapi.register.GameRegister;
import org.bukkit.plugin.java.JavaPlugin;

public class ExemplePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        GameRegister.registerGame(new ExempleGame());
        Properties.PLAYERS.setValue(4);
        Properties.PLAYERS_START.setValue(2);
        Properties.PLAYERS_FORCE_START.setValue(4);
        Properties.START_TIMER.setValue(90);
        getServer().getPluginManager().registerEvents(new GameEvents(), this);
        super.onEnable();
    }
}
