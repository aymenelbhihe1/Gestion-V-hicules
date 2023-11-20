package com.spring.gestvehicule.Service;

import com.spring.gestvehicule.Model.Agence;
import com.spring.gestvehicule.Repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    @Autowired
    private final AgenceRepository agenceRepository;


    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    // Create (sauvegarder une agence)
    public Agence saveAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    // Read (récupérer une agence par son ID)
    public Agence getAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    // Update (mettre à jour les informations d'une agence)
    public Agence updateAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    // Delete (supprimer une agence par son ID)
    public void deleteAgenceById(Long id) {
        agenceRepository.deleteById(id);
    }

    // Lire toutes les agences
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

}
