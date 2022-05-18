package vehiclereport.controller;

import lombok.RequiredArgsConstructor;
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
    public Vehicle createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.createVehicle(new Vehicle(
                0,
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getColor(),
                vehicleDTO.getProductionYear(),
                vehicleDTO.getFuelType()
        ));
    }

    @PutMapping("/vehicles/{id}")
    public Vehicle editVehicleById(@PathVariable int id, @RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.editVehicle(new Vehicle(
                id,
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getColor(),
                vehicleDTO.getProductionYear(),
                vehicleDTO.getFuelType()
        ));
    }

    @DeleteMapping("/vehicles/{id}")
    public void deleteVehicleById(@PathVariable int id) {
        vehicleService.deleteVehicleById(id);
    }
}
