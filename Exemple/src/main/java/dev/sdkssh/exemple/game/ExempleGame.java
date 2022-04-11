package dev.sdkssh.exemple.game;

import dev.sdkssh.exemple.game.player.GamePlayer;
import dev.sdkssh.exemple.utils.ChatUtils;
import dev.sdkssh.gameapi.api.templates.game.GameTemplate;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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
        executeToAllPlayers(p -> {
            Player player = p.getPlayer();
            player.setLevel(time);
            player.playSound(player.getLocation(), Sound.ORB_PICKUP,1F, 0F);
            if(time <= 3 || time == 30 || time == 60 || time == 15 || time == 10 || time == 5){
                ChatUtils.sendTitle(player, 5,10,5, "§eStarting in", "§6"+time+" seconds");
            }
        });
    }

    @Override
    public GamePlayer getNewPlayer(@NotNull Player player) {
        return new GamePlayer(player);
    }
}
