package dev.sdkssh.exemple.events;

import dev.sdkssh.exemple.game.player.GamePlayer;
import dev.sdkssh.gameapi.api.events.GameAPIEvent;
import dev.sdkssh.gameapi.register.GameRegister;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class GameEvents extends GameAPIEvent {
    @EventHandler
    public void onDie(PlayerDeathEvent e){
        e.setDeathMessage("");
        e.getDrops().clear();
        Player p = e.getEntity();
        GamePlayer gp = getPlayer(p);
        p.spigot().respawn();
        if(gp.getLife() == 1){
            return;
        }else{
            gp.giveKit();
        }
    }


    public GamePlayer getPlayer(Player p){
        return (GamePlayer) GameRegister.getGame().getPlayer(p.getUniqueId().toString()).get();
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent e){
        e.setCancelled(e.toWeatherState());
    }
}
