package in.ac.main.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	
	@GetMapping("/medicines")
	public String openMedicineSection() {
		return "Medicines/medicinesHp";
	}
}
