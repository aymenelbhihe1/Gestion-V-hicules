package com.spring.gestvehicule.Repository.StafRepository;

import com.spring.gestvehicule.Model.Facture;
import com.spring.gestvehicule.Model.Reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
public Reservation findReservationByFacture(Facture facture);
}
