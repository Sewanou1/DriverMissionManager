package com.mission.manager_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(){
        return "pages/login";
    }

    @RequestMapping("/home")
    public String loginSubmit(){
        return "layout/dashboard";
    }
}
