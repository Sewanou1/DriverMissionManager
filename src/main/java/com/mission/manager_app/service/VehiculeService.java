package com.mission.manager_app.service;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.model.Vehicule;

import java.util.List;

public interface VehiculeService {
    Long nbreVehicule();
    List<Vehicule> getAll();
}
