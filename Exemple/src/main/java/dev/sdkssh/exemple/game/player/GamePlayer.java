package dev.sdkssh.exemple.game.player;

import dev.sdkssh.gameapi.api.templates.player.GamePlayerTemplate;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
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

    @Override
    public void onJoin() {

    }

    @Override
    public void onQuit() {

    }

    @Override
    public void onQuitInGame() {

    }
}
