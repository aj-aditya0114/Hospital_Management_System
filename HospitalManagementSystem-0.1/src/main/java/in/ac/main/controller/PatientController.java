package in.ac.main.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ac.main.entities.Doctor;
import in.ac.main.entities.MedicalRecord;
import in.ac.main.entities.Patient;
//import in.ac.main.entities.User;
//import in.ac.main.repositories.UserRepository;
import in.ac.main.services.DoctorService;
import in.ac.main.services.MedicalRecordService;
import in.ac.main.services.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller

public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private MedicalRecordService medicalServices;
	
	
//	@Autowired
//    private UserRepository userRepository;

//    @GetMapping("/profile")
//    public String viewProfile(Model model, Principal principal) {
//        String username = principal.getName(); // Logged-in user
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        model.addAttribute("user", user);
//        return "patient_profile";
//    }

	
	@GetMapping("/regPageP")
	public String openRegPage(Model model) {
		
		model.addAttribute("patient", new Patient());
		return "Patient/RegisterPatient";
	}
	

	
	@PostMapping("/regFormP")
	public String getUserDetails(@ModelAttribute("patient") Patient patient, Model model) {
		
		boolean status = patientService.registerPatient(patient);
		
		if(status) {
			model.addAttribute("successMsg", "Your Account is Created. Login to explore your profile.");
		}else {
			model.addAttribute("errorMsg", "User not registered due to some error");
		}
		
		return "Patient/RegisterPatient";
	}
	
	
	@GetMapping("/loginPageP")
	public String openPatientLogInPage(Model model) {
		
		model.addAttribute("patient", new Patient());
		return "Patient/loginPatient";
	}
	
	
	@PostMapping("/loginFormP")
	public String loginPatient(@ModelAttribute("patient") Patient patient, Model model, HttpSession session) {
		Patient validUser = patientService.loginPatient(patient.getEmail(), patient.getPassword());
		
		if(validUser != null) {
		   //Store the logged-in patient in session
			session.setAttribute("loggedInPatient", validUser);
			//show name in page
			model.addAttribute("Namee", validUser.getName());
			return "Patient/patientProfile";
		}else {
			model.addAttribute("errorMsg", "Email id and Password didn't matched");
			return "Patient/loginPatient";
		}
		
	}
	
	
	@GetMapping("/logoutP")
	public String logout(HttpServletRequest req) {
		 
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/Patient/loginPatient";
	}
	
	@GetMapping("/doctor/generate-bill")
	public String openBillingPage() {
		return "Patient/bill";
	}
	
	
	
	@GetMapping("/appointments/book_form")
	public String bookAppointmentDirectly(Model model) {
		return "Patient/loginPatient";
	}
	
	
	@GetMapping("/appointments/book")
	public String openBookPage() {
		return "Patient/bookAppointment";
	}
	
	@GetMapping("/medical-records")
	public String openMedicalReports(@RequestParam(name = "doctor", required = false)String doctorName,
													 @RequestParam(name = "date", required = false) String date,
													 Model model, HttpSession session) {

		Long patientId = (Long) session.getAttribute("patientId");
		List<MedicalRecord> records;
		
		if(doctorName != null && !doctorName.isEmpty()) {
			records = medicalServices.searchByDoctor(patientId, doctorName);
		}else if(date != null && !date.isEmpty()) {
			records = medicalServices.searchByDate(patientId, date);
		}else {
			records = medicalServices.getRecordsForPatient(patientId);
		}
		
		model.addAttribute("records", records);
		
		return "Patient/medicalReports";
	}
	
//	public String profileSettings(Model model) {
//	    Patient patient = patientService.getLoggedInPatient(); // however you fetch
//	    model.addAttribute("patient", patient);
//	    return "profileSettings";
//	}
	
}
