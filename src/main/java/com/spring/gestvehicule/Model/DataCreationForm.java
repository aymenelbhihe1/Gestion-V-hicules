package com.spring.gestvehicule.Model;

import com.spring.gestvehicule.Model.Reservation.Reservation;
import com.spring.gestvehicule.Model.Staf.Client;
import com.spring.gestvehicule.Model.Véhicule.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class DataCreationForm {
    private int id;
    private Client client;
    private Long vehiculeId;
    private Long missionId;
    private String nbKm;
    private String duree;
    private Reservation reservation;
}