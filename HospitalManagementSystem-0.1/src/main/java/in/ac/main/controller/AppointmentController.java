package in.ac.main.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import in.ac.main.entities.Appointment;
import in.ac.main.entities.Doctor;
import in.ac.main.entities.Patient;
import in.ac.main.repositories.DoctorRepository;
import in.ac.main.repositories.PatientRepository;
import in.ac.main.services.ApoointmentService;
import in.ac.main.services.DoctorService;
import jakarta.servlet.http.HttpSession;

@Controller
public class AppointmentController {

	@Autowired
	private ApoointmentService appointmentService;
	
	@Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private DoctorService doctorService;
    
    
    
    // Show booking form (GET)
    @GetMapping("/book-appointment")
    public String showBookingForm(Model model, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("loggedInPatient");
        if (patient == null) {
            return "redirect:/Patient/loginPatient";
        }

        model.addAttribute("doctor", doctorRepository.findAll()); // findAll() is default method of JpaRepository
        List<Doctor> doctorList = doctorService.getAllDoctors();
        model.addAttribute("patient", patient);
        return "Patient/bookAppointment";
    }

    
    
    
    // Handle booking submission (POST)
    @PostMapping("/appointments/book")
    public String bookAppointment(@RequestParam Long doctorId,
            						@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate,
            						@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime appointmentTime,
            						@RequestParam(required = false) String reason,
            						HttpSession session,
            						Model model) {

    	Patient patient = (Patient) session.getAttribute("loggedInPatient");
        if (patient == null) {
            return "redirect:/Patient/loginPatient";
        }

        Doctor doctor = doctorService.getDoctorById(doctorId); // fetch from DB

        Appointment appointment = new Appointment();
        
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);
        appointment.setReason(reason);
        appointment.setStatus("PENDING");

        appointmentService.saveAppointment(appointment); // save to DB
        session.setAttribute("Namee", patient.getName());
        
        model.addAttribute("successMsg", "Appointment booked successfully!");
        return "Patient/patientProfile";
    }

    
    
    // Show patient's appointments
    @GetMapping("/appointments/mine")
    public String showPatientAppointments(Model model, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("loggedInPatient");
        if (patient == null) {
            return "redirect:/Patient/login";
        }

        List<Appointment> appointments = appointmentService.getAppointmentsByPatient(patient);
        
        LocalDate today = LocalDate.now();
        for (Appointment appt : appointments) {
            if (appt.getAppointmentDate().isBefore(today) && appt.getStatus().equals("PENDING")) {
                appt.setStatus("REJECTED");
                appointmentService.saveAppointment(appt);  // save updated status
            }
        }
        model.addAttribute("appointments", appointments);
        return "Patient/patientAppointments";
    }
    
    
    
    // Show appointments of a specific doctor
    @GetMapping("/doctor/appointments")
    public String viewDoctorAppointments(HttpSession session, Model model) {
        Doctor doctor = (Doctor) session.getAttribute("loggedInDoctor");
        if (doctor == null) {
            return "redirect:/Doctor/loginDoctor";
        }

        List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(doctor);
        model.addAttribute("appointments", appointments);
        return "Doctor/doctorAppointments"; // Thymeleaf page
    }
    
    
    
    
    //approve and reject appointment by a doctor
    @PostMapping("/appointments/updateStatus")
    public String updateAppointmentStatus(@RequestParam("appointmentId") Long appointmentId,
    										@RequestParam("status") String status,
    										HttpSession session) {
    	Doctor doctor = (Doctor) session.getAttribute("loggedInDoctor");
    	if (doctor == null) {
    		return "redirect:/Doctor/loginDoctor";
    	}

    	Appointment appointment = appointmentService.getAppointmentById(appointmentId);

    	// Check that appointment belongs to this doctor
    	if (appointment != null && appointment.getDoctor().getId().equals(doctor.getId())) {
    		appointment.setStatus(status); // "APPROVED" or "REJECTED"
    		appointmentService.saveAppointment(appointment);
    	}

    	return "redirect:/doctor/appointments";
    }
    
    
    
    
    
}
