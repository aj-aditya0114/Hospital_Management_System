package in.ac.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.main.entities.Appointment;
import in.ac.main.entities.Doctor;
import in.ac.main.entities.Patient;
import in.ac.main.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements ApoointmentService{

	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	
	// Book a new appointment for patient
	@Override
	public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

	
    // Get appointments for a specific doctor
	@Override
	public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {
	    return appointmentRepository.findByDoctor(doctor);
	}

	
    // Get appointments for a patient in my appointment page
	@Override
    public List<Appointment> getAppointmentsByPatient(Patient patient) {
        return appointmentRepository.findByPatient(patient);
    }

    
    // Update appointment status (APPROVED or REJECTED) for doctor
	@Override
	public Appointment getAppointmentById(Long id) {
	    return appointmentRepository.findById(id).orElse(null);
	}

    // Cancel/Delete appointment
	@Override
    public void cancelAppointment(int id) {
        appointmentRepository.deleteById(id);
    }
}
