package dev.sdkssh.gameapi.api.properties;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public class Property<T> {
    @Getter
    @Setter
    private T value;

    public Property(@NotNull T value){
        this.value = value;
    }
}
