package in.ac.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ac.main.entities.LabBooking;

@Repository
public interface LabRepo extends JpaRepository<LabBooking, Long>{

}
