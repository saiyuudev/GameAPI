package dev.sdkssh.gameapi.api.templates.game;

import dev.sdkssh.gameapi.api.states.GameSTATE;
import dev.sdkssh.gameapi.api.templates.Template;
import lombok.Getter;
import lombok.Setter;

public abstract class GameTemplate extends Template {
    @Getter
    @Setter
    private GameSTATE state;

    public abstract void onStart();
}
