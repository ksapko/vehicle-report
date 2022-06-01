package vehiclereport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vehiclereport.model.Client;
import vehiclereport.service.ClientService;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/clients",
                produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientService clientService;

//    @GetMapping("/")
//    public List<Client> getAllClient() {
//        return clientService.getAllClient();
//    }

    @GetMapping("{id}")
    public Client getClientById(@PathVariable int id) {
        return clientService.getClientById(id);
    }

    @PostMapping("")
    public Client createClient(@RequestBody Client client) {
       return clientService.createClient(client);
    }

    @PutMapping("{id}")
    public Client editClientById(@PathVariable int id, @RequestBody Client client) {
        return clientService.editClientById(client);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteClientById(@PathVariable int id) {
        clientService.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }

}