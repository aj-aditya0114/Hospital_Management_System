package in.ac.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.main.entities.MedicalRecord;
import in.ac.main.repositories.MedicalRecordRepo;

@Service
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepo repository;

	public List<MedicalRecord> getRecordsForPatient(Long patientId) {
		return repository.findByPatientId(patientId);
	}

	public List<MedicalRecord> searchByDoctor(Long patientId, String doctorName) {
		return repository.findByPatientIdAndDoctorNameContainingIgnoreCase(patientId, doctorName);
	}

	public List<MedicalRecord> searchByDate(Long patientId, String date) {
		return repository.findByPatientIdAndDate(patientId, date);
	}
}
