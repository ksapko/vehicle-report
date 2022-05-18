package vehiclereport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vehiclereport.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
