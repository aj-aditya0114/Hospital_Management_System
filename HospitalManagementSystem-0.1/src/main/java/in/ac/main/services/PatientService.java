package in.ac.main.services;

import java.util.List;

import in.ac.main.entities.Patient;


public interface PatientService {

	public boolean registerPatient(Patient patient);
	public List<Patient> getAllPatients();
	public Patient loginPatient(String email, String Password);
}
