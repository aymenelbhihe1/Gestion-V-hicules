package com.spring.gestvehicule.Service.StafService;

import com.spring.gestvehicule.Model.Staf.Client;
import com.spring.gestvehicule.Repository.StafRepository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Read (récupérer tous les clients)
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    // Create (sauvegarder un client)
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    // Read (récupérer un client par son ID)
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    // Update (mettre à jour les informations d'un client)
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    // Delete (supprimer un client par son ID)
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    // Read (récupérer un client par son email et son mot de passe)
    public Client login(String email, String password) {
        return clientRepository.findClientByEmailAndPassword(email, password);
    }
    public Client getClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }
}

