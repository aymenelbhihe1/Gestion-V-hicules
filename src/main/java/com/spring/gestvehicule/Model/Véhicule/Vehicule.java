package com.spring.gestvehicule.Model.Véhicule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.gestvehicule.Model.Disponibilite;
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
public class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MARQUE marque;
    @Enumerated(EnumType.STRING)
    private TYPE_VEHICULE typeVehicule;
    @Column(name="Modèle",length = 30)
    private String modele;
    @Column(name="Matricule",length = 30)
    private String matricule;
    @Column(name="Couleur",length = 30)
    private String couleur;
    @Column(name="Carburant",length = 30)
    private String carburant;
    @Column(name="Disponibilité")
    private Boolean disponibilite;
    @OneToMany(mappedBy = "vehicule")
    @JsonIgnore
    private Collection<Reservation> reservations;
    @Override
    //hashcode and equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicule )) return false;
        return id != null && id.equals(((Vehicule) o).getId());
    }
    @Override
    public int hashCode() {
        return 0;
    }
}
