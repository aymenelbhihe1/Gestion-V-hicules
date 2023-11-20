package com.spring.gestvehicule.Repository;

import com.spring.gestvehicule.Model.Disponibilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Long> {
}
