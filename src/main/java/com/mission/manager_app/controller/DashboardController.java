package com.mission.manager_app.controller;

import com.mission.manager_app.model.Conducteur;
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
public class DashboardController {

    @Autowired
    private ConducteurService conducteurService;
    @Autowired
    private VehiculeService vehiculeService;
    @Autowired
    private MissionService missionService;

    @GetMapping("/")
    public String welcome(Model model, HttpServletRequest request){
        Long nbreC = conducteurService.nbreConducteur();
        Long nbreV = vehiculeService.nbreVehicule();
        Long nbreM = missionService.nbreMission();
        model.addAttribute("currentUrl", request.getRequestURI());
        model.addAttribute("nbreConducteur", nbreC != null ? nbreC : 0L);
        model.addAttribute("nbreVehicule", nbreV !=null ? nbreV : 0L);
        model.addAttribute("nbreMission", nbreM !=null ? nbreM : 0L);
        return "layouts/dashboard";
    }
}
