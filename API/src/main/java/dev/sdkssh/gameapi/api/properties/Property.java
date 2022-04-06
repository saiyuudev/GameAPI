package dev.sdkssh.gameapi.api.properties;

import lombok.Getter;
import lombok.Setter;

public class Property<T> {
    @Getter
    @Setter
    private T value;

    public Property(T value){
        this.value = value;
    }
}
