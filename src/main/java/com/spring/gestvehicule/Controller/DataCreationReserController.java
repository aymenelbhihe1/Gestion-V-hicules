package com.spring.gestvehicule.Controller;
import com.spring.gestvehicule.Model.DataCreationForm;
import com.spring.gestvehicule.Model.Véhicule.Vehicule;
import com.spring.gestvehicule.Service.DataCreationService;
import com.spring.gestvehicule.Service.MissionService;
import com.spring.gestvehicule.Service.ReservationService;
import com.spring.gestvehicule.Service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("CreationReserv")
public class DataCreationReserController {
    @Autowired
    private DataCreationService dataCreationService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private VehiculeService vehiculeService;
    @Autowired
    private MissionService missionService;

    @GetMapping()
    public String showCreateDataPage(Model model) {
        return "Reservation-List";
    }

    @GetMapping("/addReserv")
    public String addReservation(Model model) {
        model.addAttribute("vehicules", vehiculeService.getAllVehicules());
        model.addAttribute("missions", missionService.getAllMissions());
        model.addAttribute("data", new DataCreationForm());
        return "fragments/Reservation/addReservation";
    }
    @PostMapping("/createData")
    public String createData(@ModelAttribute DataCreationForm data, Model model) {
        try {
            dataCreationService.createData(data.getClient(), data.getVehiculeId(), data.getMissionId(), data.getReservation(), data.getNbKm(), data.getDuree());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/CreationReserv/addReserv";
        }
    }
    // listData


//    @GetMapping("/edit-data/{id}")
//    public String showEditDataPage(@PathVariable int id, Model model) {
//        // Appelez le service pour obtenir les données à modifier
//        DataCreationForm dataCreationForm = dataCreationService.getDataById(id);
//        model.addAttribute("dataCreationForm", dataCreationForm);
//        return "editData";
//    }
//
//    @PostMapping("/edit-data/{id}")
//    public String updateData(@PathVariable int id, @ModelAttribute DataCreationForm dataCreationForm) {
//        // Appelez le service pour mettre à jour les données
//        dataCreationService.updateData(id, dataCreationForm.getClient(), dataCreationForm.getVoiture(), dataCreationForm.getMission(), dataCreationForm.getReservation());
//        return "redirect:/create-data";
//    }
}
