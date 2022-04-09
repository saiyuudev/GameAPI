package dev.sdkssh.exemple.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    private HashMap<Enchantment, Integer> enchantments;
    @Getter
    private List<ItemFlag> flags;
    @Getter
    @Setter
    private short durability;
    @Getter
    @Setter
    private boolean unbreakable;

    public ItemBuilder(@NotNull Material material, int amount){
        this.material = material;
        this.amount = amount;
        this.lores = new ArrayList<>();
        this.enchantments = new HashMap<>();
        this.flags = new ArrayList<>();
        this.unbreakable = false;
        this.durability = 0;
        this.displayName = null;
    }

    public ItemBuilder(@NotNull Material material){
        this(material, 1);
    }

    public ItemBuilder(@NotNull ItemStack it){
        this.material = it.getType();
        ItemMeta itm = it.getItemMeta();
        this.durability = it.getDurability();
        this.unbreakable = itm.spigot().isUnbreakable();
        this.enchantments = (HashMap<Enchantment, Integer>) itm.getEnchants();
        this.lores = itm.getLore();
        this.flags = (List<ItemFlag>) itm.getItemFlags();
        this.displayName = itm.getDisplayName();
        this.amount = it.getAmount();
    }

    public ItemBuilder addLine(@NotNull String... lines){
        lores.addAll(Arrays.asList(lines));
        return this;
    }

    public ItemBuilder addEnchantment(@NotNull Enchantment enchantment, int level){
        enchantments.put(enchantment, level);
        return this;
    }

    public ItemStack build(){
        ItemStack it = new ItemStack(material, amount, durability);
        ItemMeta itemMeta = it.getItemMeta();
        if(!displayName.isEmpty()){
            itemMeta.setDisplayName(displayName);
        }
        if(!lores.isEmpty()){
            itemMeta.setLore(lores);
        }
        if(!enchantments.isEmpty()){
            enchantments.entrySet().forEach(v -> {
                itemMeta.addEnchant(v.getKey(), v.getValue(), true);
            });
        }
        if(!flags.isEmpty()){
            itemMeta.addItemFlags(flags.toArray(new ItemFlag[]{}));
        }
        if(isUnbreakable()){
            itemMeta.spigot().setUnbreakable(unbreakable);
        }
        it.setItemMeta(itemMeta);
        return it;
    }


}