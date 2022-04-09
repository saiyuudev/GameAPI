package dev.sdkssh.exemple;

import dev.sdkssh.exemple.game.ExempleGame;
import dev.sdkssh.gameapi.register.GameRegister;
import org.bukkit.plugin.java.JavaPlugin;

public class ExemplePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        GameRegister.registerGame(new ExempleGame());
        super.onEnable();
    }
}
