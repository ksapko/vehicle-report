package vehiclereport.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vehiclereport.model.Vehicle;
import vehiclereport.repository.VehicleRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(int id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono pojazdu o takim id"));
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle editVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicleById(int id) {
        vehicleRepository.deleteById(id);
    }
}
