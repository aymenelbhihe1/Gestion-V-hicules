package com.spring.gestvehicule.Service;


import com.spring.gestvehicule.Model.Facture;
import com.spring.gestvehicule.Model.Reservation.Reservation;
import com.spring.gestvehicule.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {

    @Autowired
    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    // Create (sauvegarder une facture)
    public Facture saveFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    // Read (récupérer une facture par son ID)
    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    // Update (mettre à jour les informations d'une facture)
    public Facture updateFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    // Delete (supprimer une facture par son ID)
    public void deleteFactureById(Long id) {
        factureRepository.deleteById(id);
    }

    // Lire toutes les factures
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }
    // Lire toutes les factures par réservation
    public List<Facture> getAllFacturesByReservation(Reservation reservation) {
        return factureRepository.findFacturesByReservation(reservation);
    }
}
