package com.spring.gestvehicule.Service;

import com.spring.gestvehicule.Model.Véhicule.Vehicule;
import com.spring.gestvehicule.Repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehiculeService {

    @Autowired
    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    // Create (sauvegarder un véhicule)
    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    // Read (récupérer un véhicule par son ID)
    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    // Update (mettre à jour les informations d'un véhicule)
    public Vehicule updateVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    // Delete (supprimer un véhicule par son ID)
    public void deleteVehiculeById(Long id) {
        vehiculeRepository.deleteById(id);
    }

    // Lire tous les véhicules
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }
    // Lire tous les véhicules par marque

}
