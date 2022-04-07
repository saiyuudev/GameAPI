package dev.sdkssh.gameapi.events;

import dev.sdkssh.gameapi.GameAPI;
import dev.sdkssh.gameapi.api.properties.Properties;
import dev.sdkssh.gameapi.api.templates.game.GameTemplate;
import dev.sdkssh.gameapi.register.GameRegister;
import dev.sdkssh.gameapi.schedulers.TimerTask;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ConnectionEvents implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(GameRegister.isRegistered()){
            GameRegister.getGame().addPlayer(e.getPlayer());
            GameTemplate game = GameRegister.getGame();
            if(Properties.PLAYERS_START.getValue() == game.getPlayers().size() && !TimerTask.isStart()){
                new TimerTask(Properties.START_TIMER.getValue()).runTaskTimer(GameAPI.getPlugin(), 0, 20);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        if(GameRegister.isRegistered()){
            GameRegister.getGame().removePlayer(e.getPlayer().getUniqueId().toString());
        }
    }
}
