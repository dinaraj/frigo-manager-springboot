package com.frigo.frigomanager.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categorie categorie = Categorie.AUTRES;

    @Column(nullable = false)
    private Integer quantite = 1;

    @Column(name = "date_achat", nullable = false)
    private LocalDate dateAchat = LocalDate.now();

    @Column(name = "date_expiration", nullable = false)
    private LocalDate dateExpiration;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "photo_path")
    private String photoPath;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Methodes métiers

    public int getJoursRestants() {
        return (int) ChronoUnit.DAYS.between(LocalDate.now(), dateExpiration);
    }

    public StatutExpiration getStatutExpiration() {
        int jours = getJoursRestants();

        if (jours < 0) {
            return StatutExpiration.EXPIRE;
        } else if (jours <= 3) {
            return StatutExpiration.URGENT;
        } else if (jours <= 7) {
            return StatutExpiration.ATTENTION;
        }
        return StatutExpiration.OK;
    }

    public String getCategorieCouleur() {
        return categorie.getCouleur();
    }

    public String getCategorieLabel() {
        return categorie.getLabel();
    }
}
