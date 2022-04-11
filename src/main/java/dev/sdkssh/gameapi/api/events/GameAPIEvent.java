package dev.sdkssh.gameapi.api.events;

import dev.sdkssh.gameapi.api.states.GameSTATE;
import dev.sdkssh.gameapi.register.GameRegister;
import dev.sdkssh.gameapi.schedulers.TimerTask;
import org.bukkit.event.Listener;

public class GameAPIEvent implements Listener {
    public boolean isInTimer(){
        return TimerTask.isStart();
    }

    public boolean isPlaying(){
        return GameRegister.getGame().getState() == GameSTATE.INGAME;
    }

    public boolean isWaiting(){
        return GameRegister.getGame().getState() == GameSTATE.LOBBY;
    }

    public boolean isFinish(){
        return GameRegister.getGame().getState() == GameSTATE.WIN;
    }
}
