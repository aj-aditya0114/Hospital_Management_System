package in.ac.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.main.entities.Appointment;
import in.ac.main.entities.Doctor;
import in.ac.main.entities.Patient;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	// Find all appointments for a specific doctor
	List<Appointment> findByDoctor(Doctor doctor);

    // Find all appointments for a specific patient
    List<Appointment> findByPatient(Patient patient);

    // Optional: Find by status
    List<Appointment> findByStatus(String status);
    
    
    Optional<Appointment> findById(Long id);
}
