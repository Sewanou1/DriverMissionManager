package com.mission.manager_app.service;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.repository.ConducteurRepository;
import com.mission.manager_app.repository.MissionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ConducteurServiceImple implements ConducteurService{
    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private MissionRepository missionRepository;

    @Override
    public Conducteur getById(Long idConducteur) {
        return conducteurRepository.findById(idConducteur).get();
    }

    @Override

    public List<Conducteur> getAll(){
        return conducteurRepository.findAll();
    }

    @Override
    public Long nbreConducteur(){
        return conducteurRepository.count();
    }

    @Override
    public void saveConducteur(Conducteur conducteur){
        conducteurRepository.save(conducteur);
    }

    @Override
    public void deleteConducteur(Long idConducteur){

        if (conducteurEnMission(idConducteur)) {
            throw new IllegalStateException("Le conducteur ne peut pas être supprimé car il a participé à un ou plusieurs missions");
        }
        conducteurRepository.deleteById(idConducteur);

    }

    @Override
    public boolean conducteurEnMission(Long idConducteur){
        return missionRepository.existsByConducteurIdConducteur(idConducteur);
    }
}
