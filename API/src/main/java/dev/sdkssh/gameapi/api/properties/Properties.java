package dev.sdkssh.gameapi.api.properties;

public class Properties {
    public static Property<Integer> PLAYERS = new Property<>(6);
    @Deprecated
    public static Property<Boolean> MULTIARENA = new Property<>(false);
    public static Property<String> NAME = new Property<>("Game");
    public static Property<Boolean> BUNGEE = new Property<>(false);
    public static Property<String> BUNGEE_SERVER = new Property<>("");
    public static Property<Boolean> TEAMS = new Property<>(false);
}
