package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MessageKey {
    //Not found.
    ENTITY_NOT_FOUND("entity-not-found"),
    ENTITY_SAVE("entity_save"),
    ENTITY_UPDATE("entity_update");





    public final String key;

    public String getKey(){
        return this.key;
    }
}
