package dev.sdkssh.gameapi.api.templates.player;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
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

    public abstract void onJoin(PlayerJoinEvent event);

    public abstract void onQuit(PlayerQuitEvent event);

    public abstract void onQuitInGame();
}