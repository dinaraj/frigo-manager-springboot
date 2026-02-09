package com.frigo.frigomanager.controller;

import com.frigo.frigomanager.model.Produit;
import com.frigo.frigomanager.model.StatutExpiration;
import com.frigo.frigomanager.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProduitController {

    private final ProduitService produitService;

    @GetMapping
    public ResponseEntity<List<Produit>> listerTous() {
        List<Produit> produits = produitService.listerTous();
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduit(@PathVariable Long id) {
        Produit produit = produitService.getProduit(id);
        return ResponseEntity.ok(produit);
    }

    @GetMapping("/expirant-bientot")
    public ResponseEntity<List<Produit>> getExpirantBientot(@RequestParam(defaultValue = "7") int jours) {
        List<Produit> produits = produitService.getProduitsExpirantBientot(jours);
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/expires")
    public ResponseEntity<List<Produit>> getExpires() {
        List<Produit> produits = produitService.getProduitsExpires();
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/par-statut")
    public ResponseEntity<Map<StatutExpiration, List<Produit>>> getParStatut() {
        Map<StatutExpiration, List<Produit>> parStatut = produitService.getProduitsParStatut();
        return ResponseEntity.ok(parStatut);
    }

    @PostMapping
    public ResponseEntity<Produit> creer(@RequestBody Produit produit) {
        Produit created = produitService.creerProduit(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        produitService.supprimerProduit(id);
        return ResponseEntity.noContent().build();
    }
}
