package com.mission.manager_app.controller;

import com.mission.manager_app.model.Mission;
import com.mission.manager_app.repository.MissionRepository;
import com.mission.manager_app.service.ConducteurService;
import com.mission.manager_app.service.MissionService;
import com.mission.manager_app.service.VehiculeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class fontController {
    @Autowired
    private MissionRepository missionRepository;


    @Autowired
    private ConducteurService conducteurService;
    @Autowired
    private VehiculeService vehiculeService;
    @Autowired
    private MissionService missionService;

    @GetMapping("/accueil")
    public String welcome(Model model, HttpServletRequest request){
        List<Mission> missions = missionRepository.findTop6ByOrderByDateDepartDesc();
        model.addAttribute("missions", missions);

        Long nbreC = conducteurService.nbreConducteur();
        Long nbreV = vehiculeService.nbreVehicule();
        Long nbreM = missionService.nbreMission();
        model.addAttribute("currentUrl", request.getRequestURI());
        model.addAttribute("nbreConducteur", nbreC != null ? nbreC : 0L);
        model.addAttribute("nbreVehicule", nbreV !=null ? nbreV : 0L);
        model.addAttribute("nbreMission", nbreM !=null ? nbreM : 0L);
        return "font/index";
    }

}
