package com.spring.gestvehicule.Controller;

import com.spring.gestvehicule.Model.Staf.Client;
import com.spring.gestvehicule.Model.Staf.ROLE;
import com.spring.gestvehicule.Service.StafService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public String listClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        model.addAttribute("newClient", new Client());
        model.addAttribute("updateClient", new Client());
        return "fragments/Client/Client-List";
    }
    // save client
    @PostMapping("/save")
    public String saveClientForm(@ModelAttribute("client") Client client) {
        try {
            client.setRole(ROLE.CLIENT);
            clientService.saveClient(client);
            return "redirect:/Clients";
        } catch (Exception e) {
            return "redirect:/Clients";
        }
    }
    // Save the modified client
    @PostMapping("/update/{id}")
    public String updateClientForm(@ModelAttribute("updateClient") Client updateClient) {
        try{
            Client client = clientService.getClientById(updateClient.getId());
            updateClient.setRole(client.getRole());
            updateClient.setEmail(client.getEmail());
            updateClient.setPassword(client.getPassword());
            clientService.updateClient(updateClient);
            return "redirect:/Clients";
        }
        catch (Exception e){
            return "redirect:/Clients";
        }
    }
    // delete client by id
    @GetMapping("/delete/{id}")
    public String deleteClientForm(@PathVariable(value = "id") Long id) {
        // call delete client method
        try {
            clientService.deleteClientById(id);
            return "redirect:/Clients";
        } catch (Exception e) {
            return "redirect:/Clients";
        }
    }
    // show client details by id
    @GetMapping("/infos/{id}")
    public String viewClientDetails(@PathVariable("id") Long id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "fragments/Client/infosClient::infosClient";
    }

}
