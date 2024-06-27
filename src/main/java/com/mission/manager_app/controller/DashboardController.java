package com.mission.manager_app.controller;

import com.mission.manager_app.model.Conducteur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String welcome(Model model){
        return "layouts/dashboard";
    }
}
