package dev.sdkssh.gameapi.register;

import dev.sdkssh.gameapi.api.templates.game.GameTemplate;
import lombok.Getter;

public class GameRegister {
    @Getter
    private static GameTemplate game;

    public static void registerGame(GameTemplate gameTemplate){
        game = gameTemplate;
    }
}
