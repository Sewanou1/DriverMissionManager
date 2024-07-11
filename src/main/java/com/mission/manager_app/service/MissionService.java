package com.mission.manager_app.service;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.model.Mission;
import com.mission.manager_app.model.Vehicule;

import java.util.List;

public interface MissionService {
    Long nbreMission();
    List<Mission> getAll();
    List<Conducteur> getConducteurAll();
    List<Vehicule> getVehiculeAll();
    Mission saveMission(Mission mission);
    void deleteMission(Long id);
    //Boolean isConducteurEnMission;

    boolean hasConducteurMissionEnCours(Long idConducteur);
    Mission getMissionById(Long id);
    boolean existsById(Long id);
}
