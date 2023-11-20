package com.spring.gestvehicule.Controller;

import com.spring.gestvehicule.Model.DataCreationForm;
import com.spring.gestvehicule.Model.Facture;
import com.spring.gestvehicule.Model.Reservation.ETAT;
import com.spring.gestvehicule.Model.Reservation.Reservation;
import com.spring.gestvehicule.Model.Staf.Client;
import com.spring.gestvehicule.Model.Staf.ROLE;
import com.spring.gestvehicule.Service.*;
import com.spring.gestvehicule.Service.StafService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class AccueilController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    FactureService factureService;
    @Autowired
    ClientService clientService;
    @Autowired
    VehiculeService vehiculeService;
    @Autowired
    MissionService missionService;
    @Autowired
    DataCreationService dataCreationService;
    private Client user;

    @RequestMapping()
    public String accueil(Model model) {
        return "index";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("client", new Client());
        return "loginPage";
    }
    @PostMapping("/connecter")
    public String loginForm(Model model, Client client) {
        Client c =clientService.login(client.getEmail(), client.getPassword());
        if (c == null) {
            return "redirect:/login";
        }
        else {
           return switch (c.getRole()) {
                case ADMIN -> {
                    user = c;
                    yield "redirect:/Reservations";
                }
                case CLIENT -> {
                    user = c;
                    yield "redirect:/dashClient/Reservations";
                }
            };
        }
    }
    //Dashboard Client
    @GetMapping("/dashClient/Reservations")
    public String listReservationsClient(Model model) {
        try{
            Client client =clientService.getClientById(user.getId());
            Collection<Reservation> reservations = client.getReservations();
            if (client == null) {
                return "redirect:/dashClient/Reservations";
            }
            else {
                model.addAttribute("reservations", reservations);
                model.addAttribute("client", user);
                return "fragments/dashboardClient/ReservationClient/Reservation-List-Client";
            }
        }
        catch (Exception e){
            return "redirect:/dashClient/Reservations";
        }
    }
    @GetMapping("/dashClient/Factures")
    public String listFacturesClient(Model model) {
       try{
           Client client =clientService.getClientById(user.getId());
           Collection<Reservation> reservations = client.getReservations();
           List<Facture> factures = new ArrayList<>();
           for (Reservation r:reservations) {
               if (r.getFacture() != null) {
                   factures.add(r.getFacture());
               }
           }
           if (client == null) {
               return "redirect:/dashClient/Reservations";
           }
           else {
               model.addAttribute("factures", factures);
               model.addAttribute("client", user);
               return "fragments/dashboardClient/FactureClient/Facture-List-Client";
           }
       }
         catch (Exception e){
              return "redirect:/dashClient/Reservations";
         }
    }

    @GetMapping("/dashClient/addReservation")
    public String addReservation(Model model) {
        model.addAttribute("vehicules", vehiculeService.getAllVehicules());
        model.addAttribute("missions", missionService.getAllMissions());
        model.addAttribute("data", new DataCreationForm());
        model.addAttribute("client", user);
        return "fragments/dashboardClient/ReservationClient/Reservation-Add-Client";
    }
    @PostMapping("/dashClient/saveReservation")
    public String saveReservation(@ModelAttribute DataCreationForm data, Model model) {
            Client client =clientService.getClientById(user.getId());
            dataCreationService.createDataClient(client, data.getVehiculeId(), data.getMissionId(), data.getReservation(), data.getNbKm(), data.getDuree());
            return "redirect:/dashClient/Reservations";
    }
    @GetMapping("/dashClient/contact")
    public String contact() {
        return "Msg";
    }
    @GetMapping("/dashClient/infos")
    public String infos(Model model) {
        model.addAttribute("client", user);
        return "UserProfil";
    }
    //Dashboard Client
    @GetMapping("/dashClient/Statistiques")
    public String Statistiques(Model model) {
        Client client =clientService.getClientById(user.getId());
        Collection<Reservation> reservations = client.getReservations();
        // somme des Nbre de Km
        int sommeKm = 0;
        for (Reservation r:reservations) {
            sommeKm += Double.parseDouble(r.getNbKm());
        }
        model.addAttribute("sommeKm", sommeKm);
        // Somme des MontantTotal
        double sommeMontantTotal = 0;
        for (Reservation r:reservations) {
            if (r.getFacture() != null) {
                sommeMontantTotal += r.getFacture().getMontantTotal();
            }
        }
        model.addAttribute("sommePrix", sommeMontantTotal);
        //somme des durées
        int sommeDuree = 0;
        for (Reservation r:reservations) {
            sommeDuree += Double.parseDouble(r.getDuree());
        }
        model.addAttribute("sommeDuree", sommeDuree);
        model.addAttribute("client", user);
        return "fragments/dashboardClient/Statistiques";
    }

    //Dashboard Admin
    @GetMapping("/dashAdmin/Statisques")
    public String StatistiquesAdmin(Model model) {
        Collection<Reservation> reservations = reservationService.getAllReservations();
        // somme des Clients
        int sommeClients = clientService.getAllClients().stream().filter(c -> c.getRole() == ROLE.CLIENT).toList().size();
        model.addAttribute("sommeClients", sommeClients);
        // Total des Reservations
        int sommeReservations = reservations.size();
        model.addAttribute("sommeReservations", sommeReservations);
        //somme des prix
        double sommePrix = 0;
        for (Reservation r:reservations) {
            if (r.getFacture() != null) {
                sommePrix += r.getFacture().getMontantTotal();
            }
        }
        model.addAttribute("sommePrix", sommePrix);
        return "StatistiqueAdmin";
    }
}
