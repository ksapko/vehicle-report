package vehiclereport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vehiclereport.model.Vehicle;
import vehiclereport.service.VehicleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable int id) {
        return vehicleService.getVehicleById(id);
    }

    @PostMapping("/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @PutMapping("/vehicles/{id}")
    public Vehicle editVehicleById(@PathVariable int id, @RequestBody Vehicle vehicle1) {
        return vehicleService.editVehicle(vehicle1);
    }

    @DeleteMapping("/vehicles/{id}")
    public void deleteVehicleById(@PathVariable int id) {
        vehicleService.deleteVehicleById(id);
    }
}
