package vehiclereport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vehiclereport.model.Client;
import vehiclereport.model.dto.ClientDTO;
import vehiclereport.service.ClientService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/clients")
    public Client createClient(@RequestBody ClientDTO clientDTO) {
        return clientService.createClient(new Client(
                0,
                clientDTO.getFirstName(),
                clientDTO.getLastName(),
                clientDTO.getEmail()
        ));
    }

    @PutMapping("/client/{id}")
    public Client editClientById(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        return clientService.editClientById(new Client(
                id,
                clientDTO.getFirstName(),
                clientDTO.getLastName(),
                clientDTO.getEmail()
        ));
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClientById(@PathVariable int id) {
        clientService.deleteClientById(id);
    }

}