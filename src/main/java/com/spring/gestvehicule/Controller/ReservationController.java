package com.spring.gestvehicule.Controller;

import com.spring.gestvehicule.Model.Facture;
import com.spring.gestvehicule.Model.Reservation.Reservation;
import com.spring.gestvehicule.Model.Staf.Client;
import com.spring.gestvehicule.Service.FactureService;
import com.spring.gestvehicule.Service.ReservationService;
import com.spring.gestvehicule.Service.StafService.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("Reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private FactureService factureService;
    @GetMapping()
    public String listReservations( Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        Reservation updateReservation = new Reservation();
        model.addAttribute("reservations", reservations);
        model.addAttribute("updateReservation", updateReservation);
        return "fragments/Reservation/Reservation-List";
    }
    @GetMapping("/delete/{id}")
    public String deleteReservationForm(@PathVariable(value = "id") Long id) {
        try{
            Reservation reservation = reservationService.getReservationById(id);
            reservation.getVehicule().setDisponibilite(true);
            Facture facture =reservation.getFacture();
            factureService.deleteFactureById(facture.getId());
            reservationService.deleteReservation(reservation);
            return "redirect:/Reservations";
        }
        catch (Exception e){
            return "redirect:/Reservations";
        }
    }
    @PostMapping("/update/{id}")
    public String updateReservationForm(@PathVariable(value = "id") Long id, Reservation updateReservation) {
        try{
            Reservation reservation = reservationService.getReservationById(id);
            reservation.setEtat(updateReservation.getEtat());
            reservationService.updateReservation(reservation);
            return "redirect:/Reservations";
        }
        catch (Exception e){
            return "redirect:/Reservations";
        }
    }
}
