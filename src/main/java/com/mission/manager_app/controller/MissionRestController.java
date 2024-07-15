package com.mission.manager_app.controller;

import com.mission.manager_app.model.Mission;
import com.mission.manager_app.model.MissionList;
import com.mission.manager_app.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;



@RestController
@RequestMapping("/api/missions")
public class MissionRestController {

    @Autowired
    private MissionService missionService;


    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public MissionList getAllMissions() {
        List<Mission> missions = missionService.getAll();
        MissionList missionList = new MissionList(missions);

        if (missions == null || missions.isEmpty()) {
            missionList.setMessage("Aucune mission trouvée");
        } else {
            missionList.setMessage("Liste des missions trouvées");
            System.out.println("Missions found: " + missions.size());
        }

        return missionList;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<MissionList> getMission(@PathVariable Long id) {
        Mission mission = missionService.getMissionById(id);
        MissionList missionList = new MissionList();

        if (mission != null) {
            missionList.setMissions(Collections.singletonList(mission));
            missionList.setMessage("Mission ayant l'ID : " + id +" trouvée avec succès !!!");
            return ResponseEntity.ok(missionList);
        } else {
            missionList.setMessage("Mission non trouvée pour l'ID : " + id);
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createMission(@RequestBody Mission mission) {
        if (mission.getDateDepart().isAfter(mission.getDateArrivee())) {
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.APPLICATION_XML)
                    .body("<error>La date de départ ne peut pas être après la date d'arrivée !</error>");
        }

        if (missionService.hasConducteurMissionEnCours(mission.getConducteur().getIdConducteur())) {
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.APPLICATION_XML)
                    .body("<error>Ce conducteur a déjà une mission en cours !</error>");
        }

        Mission savedMission = missionService.saveMission(mission);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMission);
    }
}
