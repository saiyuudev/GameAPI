package dev.sdkssh.exemple.game.player;

import dev.sdkssh.exemple.utils.ChatUtils;
import dev.sdkssh.exemple.utils.ItemBuilder;
import dev.sdkssh.gameapi.api.templates.player.GamePlayerTemplate;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
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
        ChatUtils.sendTitle(getPlayer(), 5, 30, 5, "§eStarting now !", "§6Good luck !");
        giveKit();
    }

    public void giveKit(){
        Player p = getPlayer();
        PlayerInventory inv = p.getInventory();
        ItemStack[] armors = new ItemStack[4];
        armors[0] = new ItemBuilder(Material.IRON_HELMET).build();
        armors[1] = new ItemBuilder(Material.GOLD_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build();
        armors[2] = new ItemBuilder(Material.IRON_LEGGINGS).build();
        armors[3] = new ItemBuilder(Material.IRON_BOOTS).build();
        inv.setArmorContents(armors);
        inv.setItem(0, new ItemBuilder(Material.IRON_SWORD).build());
        inv.setItem(8, new ItemBuilder(Material.GOLDEN_APPLE, 3).build());
        p.updateInventory();
        p.setHealth(20D);
        p.setFoodLevel(20);
        p.teleport(new Location(Bukkit.getWorld("world"), 15, 2, 10));
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
