package com.mission.manager_app.service;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.repository.ConducteurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ConducteurServiceImple implements ConducteurService{
    @Autowired
    private ConducteurRepository conducteurRepository;

    @Override
    public Conducteur getById(Long idConducteur) {
        return conducteurRepository.findById(idConducteur).get();
    }
}
