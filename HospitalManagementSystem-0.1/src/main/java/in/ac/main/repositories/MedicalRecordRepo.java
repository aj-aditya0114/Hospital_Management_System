package in.ac.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ac.main.entities.MedicalRecord;

@Repository
public interface MedicalRecordRepo extends JpaRepository<MedicalRecord, Long>{

	// Fetch all records for a patient
    List<MedicalRecord> findByPatientId(Long patientId);

    // Optional: Search by doctor name
    List<MedicalRecord> findByPatientIdAndDoctorNameContainingIgnoreCase(Long patientId, String doctorName);

    // Optional: Search by date
    List<MedicalRecord> findByPatientIdAndDate(Long patientId, String date);
}
