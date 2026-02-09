package com.frigo.frigomanager.model;

import lombok.Getter;

@Getter
public enum Categorie {
    LEGUMES("Légumes", "#28a745"),
    FRUITS("Fruits", "#fd7e14"),
    VIANDES("Viandes & Poissons", "#dc3545"),
    LAITIERS("Produits laitiers", "#17a2b8"),
    CONSERVES("Conserves", "#6c757d"),
    SURGELES("Surgelés", "#6610f2"),
    PLATS_PREPARES("Plats préparés", "#e83e8c"),
    FRIANDISES("Friandises", "#ff69b4"),
    BOISSONS("Boissons", "#20c997"),
    CONDIMENTS("Sauces & Condiments", "#ffc107"),
    PAIN_VIENNOISERIES("Pain & Viennoiseries", "#d4a574"),
    OEUFS("Œufs", "#f4e5c2"),
    AUTRES("Autres", "#6c757d");

    private final String label;
    private final String couleur;

    Categorie(String label, String couleur) {
        this.label = label;
        this.couleur = couleur;
    }

}
