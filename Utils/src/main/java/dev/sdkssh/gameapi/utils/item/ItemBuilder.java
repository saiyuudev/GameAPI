package dev.sdkssh.gameapi.utils.item;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {
    @Setter
    @Getter
    private Material material;
    @Setter
    @Getter
    private String displayName;
    @Getter
    private List<String> lores;
    @Getter
    @Setter
    private int amount;
    @Getter
    private List<Enchantment> enchantments;
    @Getter
    private List<ItemFlag> flags;
    @Getter
    @Setter
    private short durability;
    @Getter
    @Setter
    private boolean unbreakable;

    public ItemBuilder(Material material, int amount){
        this.material = material;
        this.amount = amount;
        this.lores = new ArrayList<>();
        this.enchantments = new ArrayList<>();
        this.flags = new ArrayList<>();
        this.unbreakable = false;
        this.durability = 0;
        this.displayName = null;
    }

    public void addLine(String... lines){
        lores.addAll(Arrays.asList(lines));
    }

    public void addEnchantment(Enchantment... enchantment){
        enchantments.addAll(Arrays.asList(enchantment));
    }


}
