package dev.sdkssh.gameapi.schedulers;

import dev.sdkssh.gameapi.api.message.Messages;
import dev.sdkssh.gameapi.api.states.GameSTATE;
import dev.sdkssh.gameapi.api.templates.game.GameTemplate;
import dev.sdkssh.gameapi.api.templates.player.GamePlayerTemplate;
import dev.sdkssh.gameapi.register.GameRegister;
import dev.sdkssh.gameapi.utils.chat.TitleAPI;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerTask extends BukkitRunnable {
    @Getter
    @Setter
    private int timer;
    @Getter
    private static TimerTask task;

    public TimerTask(int timer){
        this.timer = timer;
        this.task = this;
    }

    @Override
    public void run() {
        GameTemplate g = GameRegister.getGame();
        if(timer == 0){
            g.onStart();
            g.getPlayers().forEach(p -> {
                GamePlayerTemplate playerTemplate = (GamePlayerTemplate) p;
                playerTemplate.onPlay();
            });
            g.setState(GameSTATE.INGAME);
            this.cancel();
        }
        g.getPlayers().forEach(p -> {
            GamePlayerTemplate playerTemplate = (GamePlayerTemplate) p;
            TitleAPI.sendTitle(playerTemplate.getPlayer(), 5, 10, 5, Messages.TIMER_TITLE, Messages.TIMER_SUBTITLE.replaceAll("%time%", String.valueOf(timer)));
        });
        timer--;
    }

    public static boolean isStart(){
        return task != null;
    }

    @Override
    public synchronized void cancel() throws IllegalStateException {
        task = null;
        super.cancel();
    }
}
