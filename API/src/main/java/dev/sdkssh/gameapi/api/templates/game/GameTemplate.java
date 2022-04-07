package dev.sdkssh.gameapi.api.templates.game;

import dev.sdkssh.gameapi.api.states.GameSTATE;
import dev.sdkssh.gameapi.api.templates.player.GamePlayerTemplate;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GameTemplate<T extends GamePlayerTemplate> {
    @Getter
    private final List<T> players = new ArrayList<>();
    @Getter
    @Setter
    private GameSTATE state;

    public abstract void onStart();

    public abstract void Win(Player p);

    public void addPlayer(Player player){
        T gameplayer = getNewPlayer(player);
        gameplayer.onJoin();
        players.add(gameplayer);
    }

    public Optional<T> getPlayer(String uuid){
        return players.stream().filter(p -> p.getPlayerUUID().equalsIgnoreCase(uuid)).findFirst();
    }

    public abstract T getNewPlayer(Player player);

    public void removePlayer(String uuid){
        getPlayer(uuid).ifPresent(p -> {
            p.onQuit();
            players.remove(p);
        });
    }
}
