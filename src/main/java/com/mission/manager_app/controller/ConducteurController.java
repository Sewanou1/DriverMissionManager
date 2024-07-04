package com.mission.manager_app.controller;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.model.Mission;
import com.mission.manager_app.service.ConducteurService;
import com.mission.manager_app.service.MissionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ConducteurController {
    @Autowired
    private ConducteurService conducteurService;

    @Autowired
    private MissionService missionService;

    @GetMapping("/conducteur")
    public String welcome(Model model, HttpServletRequest request){
        String title= "Liste des conducteurs";
        List<Conducteur> conducteurList= conducteurService.getAll();
        model.addAttribute("currentUrl", request.getRequestURI());
        model.addAttribute("title",title);
        model.addAttribute("conducteurs",conducteurList);
        return "pages/conducteurs/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Conducteur conducteur= new Conducteur();
        model.addAttribute("conducteur",conducteur);
        String title= "Nouveau conducteur";
        model.addAttribute("title",title);
        return "pages/conducteurs/create";
    }


    @PostMapping("/conducteur/save")
    public String saveConducteur(@ModelAttribute Conducteur conducteur, RedirectAttributes redirectAttributes) {
        conducteurService.saveConducteur(conducteur);
        redirectAttributes.addFlashAttribute("successMessage", "Le conducteur a été enregistré avec succès !");
        return "redirect:/conducteur";
    }


    @DeleteMapping("/conducteur/delete/{id}")
    public String deleteConducteur(@PathVariable("id") Long id, @RequestParam(value = "_method", required = false) String method, RedirectAttributes redirectAttributes) {
        if ("delete".equalsIgnoreCase(method)) {
            try {
                conducteurService.deleteConducteur(id);
                redirectAttributes.addFlashAttribute("successMessage", "Mission supprimée avec succès!");
            } catch (IllegalStateException e) {
                redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            }


        }
        return "redirect:/conducteur";
    }


}
