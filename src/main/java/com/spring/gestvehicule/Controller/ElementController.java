package com.spring.gestvehicule.Controller;

import com.spring.gestvehicule.Model.Facture;
import com.spring.gestvehicule.Model.Reservation.Reservation;
import com.spring.gestvehicule.Service.AgenceService;
import com.spring.gestvehicule.Service.FactureService;
import com.spring.gestvehicule.Service.MissionService;
import com.spring.gestvehicule.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Elements")
public class ElementController {

    @Autowired
    MissionService missionService;
    @Autowired
    AgenceService agenceService;
    @Autowired
    FactureService factureService;
    @Autowired
    ReservationService reservationService;

    @GetMapping("/ListMissions")
    public String listElements(Model model) {
        model.addAttribute("missions", missionService.getAllMissions());
        return "./fragments/Mission/Mission-List";
    }
    @GetMapping("/ListAgences")
    public String listAgences(Model model) {
        model.addAttribute("agences", agenceService.getAllAgences());
        return "./fragments/Agence/Agence-List";
    }
    @GetMapping("/ListFactures")
    public String listFactures(Model model) {
        try{
            model.addAttribute("factures", factureService.getAllFactures());
            return "./fragments/Facture/Facture-List";
        }
        catch (Exception e){
            return "redirect:/Reservations";
        }
    }
    @GetMapping("/deleteFacture/{id}")
    public String deleteFacture(@PathVariable(value = "id") Long id) {
        try {
            factureService.deleteFactureById(id);
            return "redirect:/Elements/ListFactures";
        } catch (Exception e) {
            return "redirect:/Elements/ListMissions";
        }
    }

}
