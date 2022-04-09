package dev.sdkssh.exemple.game;

import dev.sdkssh.exemple.game.player.GamePlayer;
import dev.sdkssh.gameapi.api.templates.game.GameTemplate;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ExempleGame extends GameTemplate<GamePlayer> {
    @Override
    public void onStart() {

    }

    @Override
    public void onWin(@NotNull Player p) {

    }

    @Override
    public void onTimerMove(int time) {

    }

    @Override
    public GamePlayer getNewPlayer(@NotNull Player player) {
        return null;
    }
}
