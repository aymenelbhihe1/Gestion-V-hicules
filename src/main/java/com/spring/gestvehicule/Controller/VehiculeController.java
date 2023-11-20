package com.spring.gestvehicule.Controller;

import com.spring.gestvehicule.Model.Véhicule.Vehicule;
import com.spring.gestvehicule.Service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping()
    public String listVehicules(Model model) {
        List<Vehicule> vehicules = vehiculeService.getAllVehicules();
        model.addAttribute("vehicules", vehicules);
        model.addAttribute("newVehicule", new Vehicule());
        model.addAttribute("updateVehicule", new Vehicule());
        return "fragments/Vehicule/Vehicule-List";
    }

    // Save vehicule
    @PostMapping("/save")
    public String saveVehiculeForm(@ModelAttribute("vehicule") Vehicule vehicule) {
        try{
            vehicule.setDisponibilite(true);
            vehiculeService.saveVehicule(vehicule);
            return "redirect:/Vehicules";
        }
        catch (Exception e){
            return "redirect:/Vehicules";
        }
    }

    // Save the modified vehicule
    @PostMapping("/update/{id}")
    public String updateVehiculeForm(@ModelAttribute("updateVehicule") Vehicule updateVehicule) {
        try {
            vehiculeService.updateVehicule(updateVehicule);
            updateVehicule=null;
            return "redirect:/Vehicules";
        }
        catch (Exception e){
            return "redirect:/Vehicules";
        }
    }

    // Delete vehicule by id
    @GetMapping("/delete/{id}")
    public String deleteVehiculeForm(@PathVariable(value = "id") Long id) {
        try{
            vehiculeService.deleteVehiculeById(id);
            return "redirect:/Vehicules";
        }
        catch (Exception e){
            return "redirect:/Vehicules";
        }
    }

    // show vehicule details by id
    @GetMapping("/infos/{id}")
    public String viewVehiculeDetails(@PathVariable("id") Long id, Model model) {
       try {
           Vehicule vehicule = vehiculeService.getVehiculeById(id);
           model.addAttribute("vehicule", vehicule);
           return "fragments/Vehicule/infosVehicule::infosVehicule";
       }
         catch (Exception e){
              return "redirect:/Vehicules";
         }
    }
}
