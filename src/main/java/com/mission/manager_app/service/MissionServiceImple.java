package com.mission.manager_app.service;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.model.Mission;
import com.mission.manager_app.model.Vehicule;
import com.mission.manager_app.repository.ConducteurRepository;
import com.mission.manager_app.repository.MissionRepository;
import com.mission.manager_app.repository.VehiculeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class MissionServiceImple implements MissionService{

    @Autowired
    private MissionRepository missionRepository;


    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public Long nbreMission(){
        return missionRepository.count();
    }

    @Override
    public List<Mission> getAll(){
        return missionRepository.findAll();
    }
    @Override
    public List<Vehicule> getVehiculeAll(){
        return vehiculeRepository.findAll();
    }

    @Override
    public List<Conducteur> getConducteurAll(){
        return conducteurRepository.findAll();
    }

    public void saveMission(Mission mission) {
        missionRepository.save(mission);
    }

    public void deleteMission(Long id){
        missionRepository.deleteById(id);
    }


    public boolean hasConducteurMissionEnCours(Long idConducteur) {
        List<Mission> missions = missionRepository.findByConducteurIdConducteur(idConducteur);
        LocalDate now = LocalDate.now();
        return missions.stream()
                .anyMatch(mission ->
                        (mission.getDateArrivee().isAfter(now) || mission.getDateArrivee().isEqual(now))
                );
    }
}
