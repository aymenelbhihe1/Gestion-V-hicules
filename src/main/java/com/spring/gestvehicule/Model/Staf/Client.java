package com.spring.gestvehicule.Model.Staf;

import com.spring.gestvehicule.Model.Reservation.Reservation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@Data
public class Client extends User{
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private Collection<Reservation> reservations= new ArrayList<>();
}