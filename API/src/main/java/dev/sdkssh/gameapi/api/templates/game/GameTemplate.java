package dev.sdkssh.gameapi.api.templates.game;

import dev.sdkssh.gameapi.api.states.GameSTATE;
import dev.sdkssh.gameapi.api.templates.Template;
import dev.sdkssh.gameapi.api.templates.players.GamePlayerTemplate;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

public abstract class GameTemplate<T extends GamePlayerTemplate> extends Template {
    @Getter
    @Setter
    private GameSTATE state;

    public abstract void onStart();

    public abstract void onWin(Player p);


}
