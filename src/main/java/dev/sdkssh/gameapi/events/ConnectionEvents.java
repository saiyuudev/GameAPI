package dev.sdkssh.gameapi.events;

import dev.sdkssh.gameapi.GameAPI;
import dev.sdkssh.gameapi.api.message.Messages;
import dev.sdkssh.gameapi.api.properties.Properties;
import dev.sdkssh.gameapi.api.states.GameSTATE;
import dev.sdkssh.gameapi.api.templates.game.GameTemplate;
import dev.sdkssh.gameapi.api.templates.player.GamePlayerTemplate;
import dev.sdkssh.gameapi.register.GameRegister;
import dev.sdkssh.gameapi.schedulers.TimerTask;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionEvents implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        if(GameRegister.isRegistered()) {
            if(GameRegister.getGame().getState() != GameSTATE.LOBBY){
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, Messages.KICK_INGAME);
                return;
            }
            if(Bukkit.getOnlinePlayers().size() > Properties.PLAYERS.getValue()) {
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, Messages.KICK_FULL);
                return;
            }
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(GameRegister.isRegistered()){
            GameTemplate game = GameRegister.getGame();
            GameRegister.getGame().addPlayer(e.getPlayer());
            if(Properties.PLAYERS_START.getValue() == game.getPlayers().size() && !TimerTask.isStart()){
                new TimerTask(Properties.START_TIMER.getValue()).runTaskTimer(GameAPI.getPlugin(), 0, 20);
            }
            if(Properties.PLAYERS_FORCE_START.getValue() == game.getPlayers().size() && TimerTask.isStart()){
                TimerTask.getTask().setTimer(5);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        if(GameRegister.isRegistered()){
            GameTemplate game = GameRegister.getGame();
            if(game.getState() == GameSTATE.INGAME){
                ((GamePlayerTemplate) game.getPlayer(e.getPlayer().getUniqueId().toString()).get()).onQuitInGame();
                game.removePlayer(e.getPlayer().getUniqueId().toString());
                if(game.getPlayers().size() == 1){
                    game.win(((GamePlayerTemplate) game.getPlayers().get(0)).getPlayer());
                }
                return;
            }
            else if(TimerTask.isStart() && game.getState() == GameSTATE.LOBBY){
                if(game.getPlayers().size() < Properties.PLAYERS_START.getValue()){
                    TimerTask.getTask().cancel();
                }
            }
        }
    }
}
