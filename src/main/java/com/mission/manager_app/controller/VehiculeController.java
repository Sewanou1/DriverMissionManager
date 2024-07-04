package com.mission.manager_app.controller;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.model.Vehicule;
import com.mission.manager_app.service.ConducteurService;
import com.mission.manager_app.service.VehiculeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        Vehicule vehicule=new Vehicule();
        String title= "Nouvel véhicule";
        model.addAttribute("vehicule",vehicule);
        model.addAttribute("title",title);
        return "pages/vehicules/create";
    }

    @PostMapping("/vehicules/save")
    public String saveConducteur(@ModelAttribute Vehicule vehicule, RedirectAttributes redirectAttributes) {
        vehiculeService.saveVehicule(vehicule);
        redirectAttributes.addFlashAttribute("successMessage", "Le véhicule a été enregistré avec succès !");
        return "redirect:/vehicules";
    }


    @DeleteMapping("/vehicules/delete/{id}")
    public String deleteVehicule(@PathVariable("id") Long id, @RequestParam(value = "_method", required = false) String method, RedirectAttributes redirectAttributes) {
        if ("delete".equalsIgnoreCase(method)) {
            try {
                vehiculeService.deleteVehicule(id);
                redirectAttributes.addFlashAttribute("successMessage", "Véhicule supprimé avec succès!");
            } catch (IllegalStateException e) {
                redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            }
        }
        return "redirect:/vehicules";
    }



}
