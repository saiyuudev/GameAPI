package dev.sdkssh.exemple.game.player;

import dev.sdkssh.gameapi.api.templates.player.GamePlayerTemplate;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamePlayer extends GamePlayerTemplate {
    public GamePlayer(@NotNull Player player) {
        super(player);
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
