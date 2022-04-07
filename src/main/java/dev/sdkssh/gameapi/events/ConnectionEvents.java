package dev.sdkssh.gameapi.events;

import dev.sdkssh.gameapi.register.GameRegister;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionEvents implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(GameRegister.isRegistered()){
            GameRegister.getGame().addPlayer(e.getPlayer());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        if(GameRegister.isRegistered()){
            GameRegister.getGame().removePlayer(e.getPlayer().getUniqueId().toString());
        }
    }
}
