package com.mission.manager_app.service;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.model.Vehicule;
import com.mission.manager_app.repository.MissionRepository;
import com.mission.manager_app.repository.VehiculeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class VehiculeServiceImple implements VehiculeService{
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private MissionRepository missionRepository;

    @Override
    public Long nbreVehicule(){
        return vehiculeRepository.count();
    }

    @Override
    public List<Vehicule> getAll(){
        return vehiculeRepository.findAll();
    }

    @Override
    public void saveVehicule(Vehicule vehicule){
        vehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteVehicule(Long id){
        if (vehiculeEnMission(id)) {
            throw new IllegalStateException("Le véhicule ne peut pas être supprimé car il est utilisé dans une mission.");
        }
        vehiculeRepository.deleteById(id);
    }

    public boolean vehiculeEnMission(Long id) {
        return missionRepository.existsByVehiculeId(id);
    }

   /* @Override
    public boolean  vehiculeEnMission(Long id) {
        return missionRepository.findByVehicule(id);
    }*/

}
