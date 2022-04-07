package dev.sdkssh.gameapi.api.templates.player;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class GamePlayerTemplate {
    @Getter
    private String PlayerUUID;

    public GamePlayerTemplate(@NotNull Player player){
        this.PlayerUUID = player.getUniqueId().toString();
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(UUID.fromString(PlayerUUID));
    }

    public abstract void onPlay();

    public abstract void onJoin();

    public abstract void onQuit();

    public abstract void onQuitInGame();
}