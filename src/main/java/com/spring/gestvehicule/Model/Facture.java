package com.spring.gestvehicule.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.gestvehicule.Model.Reservation.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Facture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateFacture;
    private double montantTotal;
    @OneToOne(mappedBy = "facture",cascade = CascadeType.ALL)
    @JsonIgnore
    private Reservation reservation;
    @Override
    //hashcode and equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facture )) return false;
        return id != null && id.equals(((Facture) o).getId());
    }
    @Override
    public int hashCode() {
        return 0;
    }
}
