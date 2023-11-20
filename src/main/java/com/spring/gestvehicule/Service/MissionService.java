package com.spring.gestvehicule.Service;

import com.spring.gestvehicule.Model.Mission;
import com.spring.gestvehicule.Repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {

    @Autowired
    private final MissionRepository missionRepository;


    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    // Create (sauvegarder une mission)
    public Mission saveMission(Mission mission) {
        return missionRepository.save(mission);
    }

    // Read (récupérer une mission par son ID)
    public Mission getMissionById(Long id) {
        return missionRepository.findById(id).orElse(null);
    }

    // Update (mettre à jour les informations d'une mission)
    public Mission updateMission(Mission mission) {
        return missionRepository.save(mission);
    }

    // Delete (supprimer une mission par son ID)
    public void deleteMissionById(Long id) {
        missionRepository.deleteById(id);
    }

    // Lire toutes les missions
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

}

