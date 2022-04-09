package dev.sdkssh.exemple.game.player;

import dev.sdkssh.gameapi.api.templates.player.GamePlayerTemplate;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

public class GamePlayer extends GamePlayerTemplate {
    @Getter
    @Setter
    private int life;

    public GamePlayer(@NotNull Player player) {
        super(player);
        this.life = 5;
    }

    @Override
    public void onPlay() {

    }

    private void giveKit(Player p){
    }

    @Override
    public void onJoin(PlayerJoinEvent event) {

    }

    @Override
    public void onQuit(PlayerQuitEvent event) {

    }

    @Override
    public void onQuitInGame() {

    }
}
