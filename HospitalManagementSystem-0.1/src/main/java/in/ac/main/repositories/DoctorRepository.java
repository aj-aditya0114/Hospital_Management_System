package in.ac.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.main.entities.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	Doctor findByEmail(String email);
	Optional<Doctor> findById(Long id);
	List<Doctor> findByLoggedInTrue();
	
	List<Doctor> findBySpecialityContainingIgnoreCase(String speciality);
	
	
}
