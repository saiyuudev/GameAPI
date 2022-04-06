package dev.sdkssh.gameapi.register;

import dev.sdkssh.gameapi.api.templates.game.GameTemplate;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class GameRegister {
    @Getter
    private static GameTemplate game;

    public static void registerGame(@NotNull GameTemplate gameTemplate){
        game = gameTemplate;
        System.out.println("Game registered successfully !");
    }

    public static boolean isRegistered(){
        return game != null;
    }
}
