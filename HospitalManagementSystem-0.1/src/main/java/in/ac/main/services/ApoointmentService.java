package in.ac.main.services;

import java.util.List;
import java.util.Optional;

import in.ac.main.entities.Appointment;
import in.ac.main.entities.Doctor;
import in.ac.main.entities.Patient;

public interface ApoointmentService {

	public void saveAppointment(Appointment appointment);
	public List<Appointment> getAppointmentsByDoctor(Doctor doctor);
	public List<Appointment> getAppointmentsByPatient(Patient patient);
	
	
	public void cancelAppointment(int id);
	public Appointment getAppointmentById(Long id);
	 
}
