package in.ac.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ac.main.entities.LabBooking;
import in.ac.main.repositories.LabRepo;



@Controller
public class LabController {
	
	@Autowired
	 private LabRepo labRepo;

	@GetMapping("/lab")
	public String openLabPage(Model model) {
		model.addAttribute("labBooking", new LabBooking());
		return "Lab/laboratory";
	}


	    @PostMapping("/lab/bookTest")
	    public String bookLab(@ModelAttribute LabBooking labBooking, Model model) {
	        
	        // Example: price logic based on test
	        if("Blood Test".equalsIgnoreCase(labBooking.getTestName())) {
	            labBooking.setPrice(500);
	        } else if("X-Ray".equalsIgnoreCase(labBooking.getTestName())) {
	            labBooking.setPrice(800);
	        } else if("MRI-scan".equalsIgnoreCase(labBooking.getTestName())){
	            labBooking.setPrice(300);
	        }else {
	        	labBooking.setPrice(700);
	        }

	        LabBooking savedBooking = labRepo.save(labBooking);

	        // Pass booking details to confirmation page
	        model.addAttribute("booking", savedBooking);

	        return "Lab/bookingConfirmation";
	    }
	

}
