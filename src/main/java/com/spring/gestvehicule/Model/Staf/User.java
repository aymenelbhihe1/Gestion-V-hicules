package com.spring.gestvehicule.Model.Staf;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
    @TableGenerator(name = "table-generator", table = "your_sequence_table", pkColumnName = "sequence_name", valueColumnName = "next_val", allocationSize = 1)
    private Long id;
    @Column(name="Nom",length = 30,nullable = true)
    private String nom;
    @Column(name="Prénom",length = 30,nullable = true)
    private String prenom;
    @Column(name="Adresse",length = 100,nullable = true)
    private String adresse;
    @Column(name="DateNaissance",columnDefinition = "DATE",nullable = true)
    private Date dateNaissance;
    @Column(name="Téléphone",length = 12,nullable = true)
    private String telephone;
    @Column(name="Email",length = 50)
    private String email;
    @Column(name="Password",length = 50)
    private String password;
    @Enumerated(EnumType.STRING)
    private SEXE sexe;
    @Enumerated(EnumType.STRING)
    private ROLE role;


}
