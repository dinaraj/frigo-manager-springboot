package com.frigo.frigomanager.model;

public enum StatutExpiration {
    EXPIRE("Expiré"),
    URGENT("Urgent"),
    ATTENTION("Attention"),
    OK("OK");

    private final String label;

    StatutExpiration(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
