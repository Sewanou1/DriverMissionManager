package com.mission.manager_app.controller;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.model.Vehicule;
import com.mission.manager_app.service.ConducteurService;
import com.mission.manager_app.service.VehiculeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VehiculeController {
    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping("/vehicules")
    public String welcome(Model model, HttpServletRequest request){
        String title= "Liste des véhicules";
        List<Vehicule> vehiculesList= vehiculeService.getAll();
        model.addAttribute("currentUrl", request.getRequestURI());
        model.addAttribute("title",title);
        model.addAttribute("vehicules",vehiculesList);
        return "pages/vehicules/index";
    }

    @GetMapping("vehicules/create")
    public String create(Model model) {
        String title= "Nouvel véhicule";
        model.addAttribute("title",title);
        return "pages/vehicules/create";
    }
}
