package com.frigo.frigomanager.service;


import com.frigo.frigomanager.model.Produit;
import com.frigo.frigomanager.model.StatutExpiration;
import com.frigo.frigomanager.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;

    public Produit creerProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> listerTous() {
        return produitRepository.findAll(Sort.by("dateExpiration"));
    }

    public List<Produit> getProduitsExpirantBientot(int nbJours) {
        LocalDate dateLimit = LocalDate.now().plusDays(nbJours);
        return produitRepository.findExpirantAvant(dateLimit);
    }

    public List<Produit> getProduitsExpires() {
        return produitRepository.findByDateExpirationBefore(LocalDate.now());
    }

    public Map<StatutExpiration, List<Produit>> getProduitsParStatut() {
        List<Produit> tous = produitRepository.findAll();
        return tous.stream()
                .collect(Collectors.groupingBy(Produit::getStatutExpiration));
    }

    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }

    public Produit getProduit(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'ID " + id));
    }
}
