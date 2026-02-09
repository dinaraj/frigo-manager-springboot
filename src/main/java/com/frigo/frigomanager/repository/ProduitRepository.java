package com.frigo.frigomanager.repository;

import com.frigo.frigomanager.model.Categorie;
import com.frigo.frigomanager.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    // Trouver les produits qui expirent avant une certaine date
    @Query("SELECT p FROM Produit p WHERE p.dateExpiration <= :date ORDER BY p.dateExpiration ASC")
    List<Produit> findExpirantAvant(@Param("date") LocalDate date);

    // Par catégorie
    List<Produit> findByCategorie(Categorie categorie);

    // Produits expirés
    List<Produit> findByDateExpirationBefore(LocalDate date);

    // Recherche par nom
    List<Produit> findByNomContainingIgnoreCase(String nom);
}
