package vehiclereport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.createClient(new Client(
                0,
                clientDTO.getFirstName(),
                clientDTO.getLastName(),
                clientDTO.getEmail()
        ));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(client);
    }


    @PutMapping("/client/{id}")
    public ResponseEntity<Object> editClientById(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        clientService.editClientById(new Client(
                id,
                clientDTO.getFirstName(),
                clientDTO.getLastName(),
                clientDTO.getEmail()
        ));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Object> deleteClientById(@PathVariable int id) {
        clientService.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }

}