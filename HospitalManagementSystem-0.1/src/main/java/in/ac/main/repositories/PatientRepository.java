package in.ac.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.main.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Patient findByEmail(String email);
}
