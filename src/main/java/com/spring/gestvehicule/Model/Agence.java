package com.spring.gestvehicule.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table
public class Agence {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name="Nom D'agence",length = 30)
    private String nom;
    @Column(name="Adresse",length = 100)
    private String adresse;
    @Column(name="Téléphone",length = 12)
    private String telephone;
    @Column(name="Email",length = 50)
    private String email;
    @Column(name="Heure D'ouverture",length = 50)
    private String HeureOuverture;
    @Column(name="Heure De Fermeture",length = 50)
    private String HeureFermeture;
}
