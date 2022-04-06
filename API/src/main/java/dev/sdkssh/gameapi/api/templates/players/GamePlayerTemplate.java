package dev.sdkssh.gameapi.api.templates.players;

import dev.sdkssh.gameapi.api.templates.Template;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class GamePlayerTemplate extends Template {
    @Getter
    private String PlayerUUID;

    public GamePlayerTemplate(@NotNull Player player){
        this.PlayerUUID = player.getUniqueId().toString();
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(UUID.fromString(PlayerUUID));
    }

    @Override
    public void onLoad() {}
    @Override
    public void onUnload() {}

    public abstract void play();
}
