package com.frigo.frigomanager.model;

import lombok.Getter;

@Getter
public enum StatutExpiration {
    EXPIRE("Expiré"),
    URGENT("Urgent"),
    ATTENTION("Attention"),
    OK("OK");

    private final String label;

    StatutExpiration(String label) {
        this.label = label;
    }

}
