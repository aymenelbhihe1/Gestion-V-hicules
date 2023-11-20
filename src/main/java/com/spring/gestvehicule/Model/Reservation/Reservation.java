package com.spring.gestvehicule.Model.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.gestvehicule.Model.Facture;
import com.spring.gestvehicule.Model.Mission;
import com.spring.gestvehicule.Model.Staf.Client;
import com.spring.gestvehicule.Model.Véhicule.Vehicule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Date de Réservation",columnDefinition = "DATE")
    private LocalDate dateReservation;
    @Enumerated(EnumType.STRING)
    private ETAT etat;
    @ManyToOne()
    @JsonIgnore
    private Vehicule vehicule;
    @ManyToOne()
    @JsonIgnore
    private Client client;
    @ManyToOne()
    @JsonIgnore
    private Mission mission;
    private String nbKm;
    private String duree;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Facture facture;
}
