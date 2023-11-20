package com.spring.gestvehicule.Repository.StafRepository;

import com.spring.gestvehicule.Model.Facture;
import com.spring.gestvehicule.Model.Staf.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findClientByEmailAndPassword(String email, String password);
    public Client findClientByEmail(String email);
}
