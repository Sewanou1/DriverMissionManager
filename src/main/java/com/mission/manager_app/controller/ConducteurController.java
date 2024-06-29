package com.mission.manager_app.controller;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.service.ConducteurService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ConducteurController {
    @Autowired
    private ConducteurService conducteurService;

    @GetMapping("/conducteur")
    public String welcome(Model model, HttpServletRequest request){
        String title= "Liste des conducteurs";
        List<Conducteur> conducteurList= conducteurService.getAll();
        model.addAttribute("currentUrl", request.getRequestURI());
        model.addAttribute("title",title);
        model.addAttribute("conducteurs",conducteurList);
        return "pages/conducteurs/index";
    }

    @GetMapping("/conducteur/create")
    public String create(Model model) {
        String title= "Nouveau conducteur";
        model.addAttribute("title",title);
        return "pages/conducteurs/create";
    }

    /*@GetMapping("/edit/{id}")
    public String editConducteur(@PathVariable Long id, Model model) {
        Conducteur driver = conducteurService.getDriverById(id);
        model.addAttribute("driver", driver);
        return "conducteurs/edit";
    }

    @PostMapping("/update/{id}")
    public String updateConducteur(@PathVariable Long id, @ModelAttribute Conducteur driver) {
        conducteurService.updateDriver(id, driver);
        return "redirect:/conducteurs";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteConducteur(@PathVariable Long id) {
        conducteurService.deleteDriver(id);
        return "redirect:/conducteurs";
    }*/
}
