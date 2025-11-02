package in.ac.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ac.main.entities.DiagnosisBook;
import in.ac.main.services.DiagnosisService;

@Controller
public class DiagnosticController {

	@Autowired
	private DiagnosisService diaService;
	
	@GetMapping("/diagnostic")
	public String openDiagnosticPage(Model model) {
		return "Daignostic/diagnostic";
	}
	
	
	 // Open booking form with test name prefilled....
    @GetMapping("/bookLab")
    public String showBookingForm(@RequestParam("testName") String testName, Model model) {
        DiagnosisBook booking = new DiagnosisBook();
        booking.setTestName(testName);
        model.addAttribute("booking", booking);
        return "Daignostic/DiaBookForm"; 
    }
    
    
 // Handle form submission
    @PostMapping("/submitBooking")
    public String submitBooking(@ModelAttribute("booking")DiagnosisBook booking, Model model) {
    	diaService.saveBooking(booking);
        model.addAttribute("booking", booking);
        return "Daignostic/DiaBookConfirm"; 
    }
}
