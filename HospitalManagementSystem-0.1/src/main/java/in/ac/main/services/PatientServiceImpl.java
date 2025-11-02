package in.ac.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.main.entities.Patient;

import in.ac.main.repositories.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	
	
	@Override
	public boolean registerPatient(Patient patient) {
		
		 try {
	            patientRepository.save(patient); 
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
		
	}
	
	
	@Override
	public Patient loginPatient(String email, String password) {
		Patient validUser = patientRepository.findByEmail(email);
		if(validUser != null && validUser.getPassword().equals(password)) {
			
			return validUser;
		}
		return null;
	}
	
	 public List<Patient> getAllPatients() {
	        return patientRepository.findAll();
	    }
}
