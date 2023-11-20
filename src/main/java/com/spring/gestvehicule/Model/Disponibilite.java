package com.spring.gestvehicule.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table
public class Disponibilite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
