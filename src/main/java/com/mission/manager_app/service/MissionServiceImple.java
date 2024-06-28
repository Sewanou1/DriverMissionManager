package com.mission.manager_app.service;

import com.mission.manager_app.repository.MissionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class MissionServiceImple implements MissionService{

    @Autowired
    private MissionRepository missionRepository;

    @Override
    public Long nbreMission(){
        return missionRepository.count();
    }
}
