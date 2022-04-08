package dev.sdkssh.gameapi.api.templates.game;

import dev.sdkssh.gameapi.api.states.GameSTATE;
import dev.sdkssh.gameapi.api.templates.player.GamePlayerTemplate;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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

    public abstract void onWin(@NotNull Player p);

    public void win(@NotNull Player p){
        setState(GameSTATE.WIN);
        onWin(p);
    }

    public void addPlayer(@NotNull Player player){
        T gameplayer = getNewPlayer(player);
        gameplayer.onJoin();
        players.add(gameplayer);
    }

    public Optional<T> getPlayer(@NotNull String uuid){
        return players.stream().filter(p -> p.getPlayerUUID().equalsIgnoreCase(uuid)).findFirst();
    }

    public abstract T getNewPlayer(@NotNull Player player);

    public void removePlayer(@NotNull String uuid){
        getPlayer(uuid).ifPresent(p -> {
            p.onQuit();
            players.remove(p);
        });
    }
}
