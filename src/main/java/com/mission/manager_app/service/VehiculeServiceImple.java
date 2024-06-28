package com.mission.manager_app.service;

import com.mission.manager_app.repository.VehiculeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class VehiculeServiceImple implements VehiculeService{
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public Long nbreVehicule(){
        return vehiculeRepository.count();
    }
}
