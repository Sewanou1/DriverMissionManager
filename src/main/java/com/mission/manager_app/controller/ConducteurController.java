package com.mission.manager_app.controller;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.service.ConducteurService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConducteurController {
    @Autowired
    private ConducteurService conducteurService;

    @GetMapping("/conducteur")
    public String welcome(Model model, HttpServletRequest request){
        String title= "Liste des conducteurs";
        model.addAttribute("currentUrl", request.getRequestURI());
        model.addAttribute("title",title);
        return "pages/conducteurs/index";
    }
}
