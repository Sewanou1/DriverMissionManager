package com.mission.manager_app.service;

import com.mission.manager_app.model.Conducteur;

import java.util.List;

public interface ConducteurService {
    Conducteur getById(Long idConducteur);
    List<Conducteur> getAll();
    Long nbreConducteur();
    void saveConducteur(Conducteur conducteur);
    void deleteConducteur(Long idConducteur);
    boolean conducteurEnMission(Long idConducteur);

}
