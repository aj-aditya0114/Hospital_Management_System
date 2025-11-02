package in.ac.main.services;

import java.util.List;
import java.util.Optional;

import in.ac.main.entities.Doctor;
import in.ac.main.entities.Patient;

public interface DoctorService {
	public boolean registerDoctor(Doctor doctor);
	public Doctor loginDoctor(String email, String Password);
	public List<Doctor> getAllDoctors();
	public  Doctor getDoctorById(Long id);
	
	
	void saveDoctor(Doctor doctor);
    
    
   // List<Doctor> getLoggedInDoctors();
    
    public List<Doctor> findDoctorsBySpeciality(String speciality);

}
