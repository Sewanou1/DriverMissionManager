package com.mission.manager_app.controller;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConducteurController {
    @Autowired
    private ConducteurService conducteurService;

    @GetMapping("/conducteur")
    public String welcome(Model model){
        Conducteur conducteur= new Conducteur();
        conducteur= conducteurService.getById(3L);
        model.addAttribute("driver", conducteur);
        return "layouts/dashboard";
    }
}
