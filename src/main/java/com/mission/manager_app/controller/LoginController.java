package com.mission.manager_app.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private static final String ADMIN_EMAIL = "admin@gmail.com";
    private static final String ADMIN_PASSWORD = "admin";


    @RequestMapping("/login")
    public String loginPage(){
        return "pages/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes) {
        if (ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {
            session.setAttribute("user", "admin");
            redirectAttributes.addFlashAttribute("successMessage", "Welcome");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Email ou mot de passe incorrect");
            return "redirect:/login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.invalidate();
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        return "redirect:/login";
    }
}
