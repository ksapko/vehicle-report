package vehiclereport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vehiclereport.model.Vehicle;
import vehiclereport.model.dto.VehicleDTO;
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
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleService.createVehicle(new Vehicle(
                0,
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getColor(),
                vehicleDTO.getProductionYear(),
                vehicleDTO.getFuelType()
        ));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicle);
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Object> editVehicleById(@PathVariable int id, @RequestBody VehicleDTO vehicleDTO) {
        vehicleService.editVehicle(new Vehicle(
                id,
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getColor(),
                vehicleDTO.getProductionYear(),
                vehicleDTO.getFuelType()
        ));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Object> deleteVehicleById(@PathVariable int id) {
        vehicleService.deleteVehicleById(id);
        return ResponseEntity.noContent().build();
    }
}
