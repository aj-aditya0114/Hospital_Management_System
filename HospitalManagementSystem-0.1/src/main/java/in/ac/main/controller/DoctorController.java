package in.ac.main.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ac.main.entities.Doctor;
import in.ac.main.entities.Patient;
import in.ac.main.services.DoctorService;
import in.ac.main.services.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/regPageD")
	public String openRegPage(Model model) {
		model.addAttribute("doctor", new Doctor());
		return "Doctor/RegisterDoctor";
	}
	
	

	
	
	@PostMapping("/regFormD")
	public String getDoctorDetails(@ModelAttribute("doctor") Doctor doctor, Model model) {
		boolean status = doctorService.registerDoctor(doctor);
		if(status) {
			model.addAttribute("successMsg","Your Account is Created. Login to explore your profile.");
		}else {
			model.addAttribute("errorMsg", "User not registered due to some error");
		}
		return "Doctor/RegisterDoctor";
	}
	
	
	
	@GetMapping("/loginPageD")
	public String openDoctorLogInPage(Model model) {
		
		model.addAttribute("doctor", new Doctor());
		return "Doctor/loginDoctor";
	}
	
	
	@PostMapping("/loginFormD")
	public String loginDoctor(@ModelAttribute("doctor") Doctor doctor, Model model, HttpSession session) {
		Doctor validUser = doctorService.loginDoctor(doctor.getEmail(), doctor.getPassword());
		if(validUser != null) {
			//Store the logged-in doctor in session
			session.setAttribute("loggedInDoctor", validUser);
			//show name in page
			model.addAttribute("Nammee", validUser.getName());
			
			doctorService.saveDoctor(validUser);
			return "Doctor/doctorProfile";
		}else {
			model.addAttribute("errorMsg", "Email id and Password didn't matched");
			return "Doctor/loginDoctor";
		}
		
	}
	
	
	@GetMapping("/logoutD")
	public String logout(HttpServletRequest req) {
		 
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/loginPageD";
	}
	
	@GetMapping("/doctor/profile")
	public String viewDoctorProfile(HttpSession session, Model model) {
	    Doctor ourDoctor = (Doctor) session.getAttribute("loggedInDoctor");
	    if (ourDoctor == null) {
	        return "redirect:/Doctor/loginDoctor";
	    }

	    model.addAttribute("doctor", ourDoctor);
	    return "Doctor/doctorProfile"; 	
	}
	
	
	@GetMapping("/search-doctor")
	public String searchDoctorBySpeciality(@RequestParam("speciality") String speciality, Model model) {
	    List<Doctor> matchingDoctors = doctorService.findDoctorsBySpeciality(speciality.trim());
	    model.addAttribute("doctors", matchingDoctors);
	    return "searchResult";  // Create this HTML page to show matching doctors
	}
	
	@GetMapping("/doctor/patients")
	public String getPatients(Model model) {
	    List<Patient> patients = patientService.getAllPatients();
	    model.addAttribute("patients", patients);
	    return "Doctor/patientss";
	}
}
