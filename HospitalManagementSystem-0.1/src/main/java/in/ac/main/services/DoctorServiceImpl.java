package in.ac.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.main.entities.Doctor;

import in.ac.main.repositories.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public boolean registerDoctor(Doctor doctor) {
		try {
			doctorRepository.save(doctor);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Doctor loginDoctor(String email, String password) {
		Doctor validUser = doctorRepository.findByEmail(email);
		if(validUser != null && validUser.getPassword().equals(password)) {
			
			return validUser;
		}
		return null;
	}
	
	@Override
	 public List<Doctor> getAllDoctors() {
	        return doctorRepository.findAll();
	        
	    }
	
	@Override
	public Doctor getDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        return optionalDoctor.orElse(null); // or throw custom exception if preferred
    }
	
	
	@Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

	@Override
	public List<Doctor> findDoctorsBySpeciality(String speciality) {
	    return doctorRepository.findBySpecialityContainingIgnoreCase(speciality);
	}

   
}
