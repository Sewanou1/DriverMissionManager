package com.mission.manager_app.service;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.model.Vehicule;
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

    @Override
    public Long nbreVehicule(){
        return vehiculeRepository.count();
    }

    public List<Vehicule> getAll(){
        return vehiculeRepository.findAll();
    }

}
