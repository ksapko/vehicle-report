package vehiclereport.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vehiclereport.model.Client;
import vehiclereport.repository.ClientRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;


    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono klienta o danych id"));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client editClientById(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClientById(int id) {
        clientRepository.deleteById(id);
    }

}
