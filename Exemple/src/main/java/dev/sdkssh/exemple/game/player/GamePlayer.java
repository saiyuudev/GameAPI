package dev.sdkssh.exemple.game.player;

import dev.sdkssh.exemple.utils.ItemBuilder;
import dev.sdkssh.gameapi.api.templates.player.GamePlayerTemplate;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GamePlayer extends GamePlayerTemplate {
    @Getter
    @Setter
    private int life;

    public GamePlayer(@NotNull Player player) {
        super(player);
        this.life = 5;
    }

    @Override
    public void onPlay() {

    }

    public void giveKit(Player p){
        ItemStack[] armors = new ItemStack[4];
        armors[0] = new ItemBuilder(Material.IRON_HELMET).build();
        armors[1] = new ItemBuilder(Material.GOLD_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build();
        armors[2] = new ItemBuilder(Material.IRON_LEGGINGS).build();
        armors[3] = new ItemBuilder(Material.IRON_BOOTS).build();
        p.getInventory().setArmorContents(armors);
    }

    @Override
    public void onJoin(PlayerJoinEvent event) {

    }

    @Override
    public void onQuit(PlayerQuitEvent event) {

    }

    @Override
    public void onQuitInGame() {

    }
}
