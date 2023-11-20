package com.spring.gestvehicule.Service;

import com.spring.gestvehicule.Model.Disponibilite;
import com.spring.gestvehicule.Repository.DisponibiliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibiliteService {

    @Autowired
    private final DisponibiliteRepository disponibiliteRepository;

    public DisponibiliteService(DisponibiliteRepository disponibiliteRepository) {
        this.disponibiliteRepository = disponibiliteRepository;
    }

    // Create (sauvegarder une disponibilité)
    public Disponibilite saveDisponibilite(Disponibilite disponibilite) {
        return disponibiliteRepository.save(disponibilite);
    }

    // Read (récupérer une disponibilité par son ID)
    public Disponibilite getDisponibiliteById(Long id) {
        return disponibiliteRepository.findById(id).orElse(null);
    }

    // Update (mettre à jour les informations d'une disponibilité)
    public Disponibilite updateDisponibilite(Disponibilite disponibilite) {
        return disponibiliteRepository.save(disponibilite);
    }

    // Delete (supprimer une disponibilité par son ID)
    public void deleteDisponibiliteById(Long id) {
        disponibiliteRepository.deleteById(id);
    }

    // Lire toutes les disponibilités
    public List<Disponibilite> getAllDisponibilites() {
        return disponibiliteRepository.findAll();
    }

}


