package com.spring.gestvehicule.Service;

import com.spring.gestvehicule.Model.Facture;
import com.spring.gestvehicule.Model.Reservation.Reservation;
import com.spring.gestvehicule.Repository.StafRepository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    // Create (sauvegarder une réservation)
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Read (récupérer une réservation par son ID)
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    // Update (mettre à jour les informations d'une réservation)
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Delete (supprimer une réservation par son ID)
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    // Lire toutes les réservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);

    }
    public Reservation getReservationByFacture(Facture facture) {
        return reservationRepository.findReservationByFacture(facture);
    }
}
