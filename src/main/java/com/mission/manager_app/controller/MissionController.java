package com.mission.manager_app.controller;

import com.mission.manager_app.model.Conducteur;
import com.mission.manager_app.model.Mission;
import com.mission.manager_app.model.Vehicule;
import com.mission.manager_app.service.ConducteurService;
import com.mission.manager_app.service.MissionService;
import com.mission.manager_app.service.VehiculeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/missions")
public class MissionController {
    @Autowired
    private MissionService missionService;

    @Autowired
    private VehiculeService vehiculeService;

    @Autowired
    private ConducteurService conducteurService;

    @GetMapping("/missions")
    public String welcome(Model model, HttpServletRequest request){
        List<Mission> missionList= missionService.getAll();
        String title= "Liste des missions";
        model.addAttribute("currentUrl", request.getRequestURI());
        model.addAttribute("index", "Welcome");
        model.addAttribute("missions",missionList);
        model.addAttribute("title",title);
        return "pages/missions/index";
    }


    @GetMapping("/missions/create")
    public String create(Model model) {
        Mission mission= new Mission();
        model.addAttribute("mission",mission);
        List<Conducteur> conducteursList= conducteurService.getAll();
        List<Vehicule> vehiculesList= vehiculeService.getAll();
        String title= "Nouvelle Mission";
        model.addAttribute("title",title);
        model.addAttribute("conducteurs",conducteursList);
        model.addAttribute("vehicules",vehiculesList);
        return "pages/missions/create";
    }



    @PostMapping("/missions/save")
    public String saveMission(@ModelAttribute Mission mission, RedirectAttributes redirectAttributes) {
        if (mission.getDateDepart().isAfter(mission.getDateArrivee())) {
            redirectAttributes.addFlashAttribute("errorMessage", "La date de départ ne peut pas être après la date d'arrivée !");
            //return "redirect:/missions/create";
            //.setAttribute("missionTemp", mission);
            return "redirect:/missions/create";
        }

        if (missionService.hasConducteurMissionEnCours(mission.getConducteur().getIdConducteur())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ce conducteur a déjà une mission en cours !");
            return "redirect:/missions/create";
        }

        missionService.saveMission(mission);
        redirectAttributes.addFlashAttribute("successMessage", "La mission a été enregistrée avec succès !");
        return "redirect:/missions";
    }


    @DeleteMapping("/missions/delete/{id}")
    public String deleteMission(@PathVariable("id") Long id, @RequestParam(value = "_method", required = false) String method, RedirectAttributes redirectAttributes) {
        if ("delete".equalsIgnoreCase(method)) {
            missionService.deleteMission(id);
            redirectAttributes.addFlashAttribute("successMessage", "Mission supprimée avec succès!");
        }
        return "redirect:/missions";
    }
}
