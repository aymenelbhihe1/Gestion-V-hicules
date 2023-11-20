package com.spring.gestvehicule.Model;

import com.spring.gestvehicule.Model.Reservation.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Nom de la Mission")
    private String nomMission;
    @Column(name="Prix par km")
    private String prixKm;
    @OneToMany(mappedBy = "mission")
    private Collection<Reservation> reservations;
}
