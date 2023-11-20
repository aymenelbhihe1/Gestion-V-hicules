package com.spring.gestvehicule.Service;

import com.spring.gestvehicule.Model.Facture;
import com.spring.gestvehicule.Model.Mission;
import com.spring.gestvehicule.Model.Reservation.ETAT;
import com.spring.gestvehicule.Model.Reservation.Reservation;
import com.spring.gestvehicule.Model.Staf.Client;
import com.spring.gestvehicule.Model.Staf.ROLE;
import com.spring.gestvehicule.Model.Véhicule.Vehicule;
import com.spring.gestvehicule.Service.StafService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DataCreationService {
    @Autowired
    private VehiculeService vehiculeService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private MissionService missionService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private FactureService factureService;

    public void createData(Client c, Long vehiculeId, Long missionId, Reservation r,String nbKm,String duree) {
        // Créer un client
            // Créer une voiture
            Vehicule vehicule=vehiculeService.getVehiculeById(vehiculeId);
            vehicule.setDisponibilite(false);

            // Créer une mission
            Mission mission= missionService.getMissionById(missionId);

            // Créer un client
            c.setRole(ROLE.CLIENT);

            // Créer une réservation
            Reservation reservation = new Reservation();
            reservation.setDateReservation(LocalDate.now());
            reservation.setEtat(ETAT.En_Attente);
            reservation.setVehicule(vehicule);
            reservation.setClient(c);
            reservation.setMission(mission);
            reservation.setNbKm(nbKm);
            reservation.setDuree(duree);
            reservation.setClient(c);
            c.getReservations().add(reservation);
            clientService.saveClient(c);

            //calculer facture
            double prixKm = Double.parseDouble(reservation.getMission().getPrixKm());
            double nbKms = Double.parseDouble(reservation.getNbKm());
            double nbJour = Double.parseDouble(reservation.getDuree());
            double prixTotal = (prixKm*nbKms)+(nbJour*10);
            double prixTotalArrondi = Math.round(prixTotal * 100.0) / 100.0;
            Facture facture = new Facture();
            facture.setDateFacture(LocalDate.now());
            facture.setMontantTotal(prixTotalArrondi);
            reservation.setFacture(facture);
            facture.setReservation(reservation);
            c.getReservations().add(reservation);
            System.out.println("1");
            factureService.saveFacture(facture);
            System.out.println("3");
            reservationService.saveReservation(reservation);
            System.out.println("4");

    }


    public void createDataClient(Client c, Long vehiculeId, Long missionId, Reservation r,String nbKm,String duree)
    {
            // Créer une voiture
            Vehicule vehicule=vehiculeService.getVehiculeById(vehiculeId);
            vehicule.setDisponibilite(false);

            // Créer une mission
            Mission mission= missionService.getMissionById(missionId);

            // Créer un client
            Client client = clientService.getClientById(c.getId());

            // Créer une réservation
            Reservation reservation = new Reservation();
            reservation.setDateReservation(LocalDate.now());
            reservation.setEtat(ETAT.En_Attente);
            reservation.setVehicule(vehicule);
            reservation.setClient(c);
            reservation.setMission(mission);
            reservation.setNbKm(nbKm);
            reservation.setDuree(duree);
            reservation.setClient(c);
            reservationService.saveReservation(reservation);
            //calculer facture
            double prixKm = Double.parseDouble(reservation.getMission().getPrixKm());
            double nbKms = Double.parseDouble(reservation.getNbKm());
            double nbJour = Double.parseDouble(reservation.getDuree());
            double prixTotal = (prixKm*nbKms)+(nbJour*10);
            double prixTotalArrondi = Math.round(prixTotal * 100.0) / 100.0;
            Facture facture = new Facture();
            facture.setDateFacture(LocalDate.now());
            facture.setMontantTotal(prixTotalArrondi);
            factureService.saveFacture(facture);
            facture.setReservation(reservation);
            reservation.setFacture(facture);
            c.getReservations().add(reservation);
            factureService.updateFacture(facture);
            reservationService.updateReservation(reservation);
            clientService.saveClient(c);
            System.out.println("1");
            System.out.println("4");
    }
}
