package com.mission.manager_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/missions")
public class MissionController {

    @GetMapping("/index")
    public String welcome(Model model){
        model.addAttribute("index", "Welcome");
        return "index";
    }
}
