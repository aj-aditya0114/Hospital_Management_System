package in.ac.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ac.main.entities.ContactUsForm;

@Controller
public class ContactController {

	@GetMapping("/contactUs")
	public String openContactUsPage(Model model) {
		 model.addAttribute("contactForm", new ContactUsForm());
		return "contactUs";
	}
	
	
    @PostMapping("/contact/submit")
    public String submitContactForm(@ModelAttribute ContactUsForm contactForm, Model model) {
        // For now: just print the details
        System.out.println(" Message Body:");
        System.out.println("Name: " + contactForm.getName());
        System.out.println("Email: " + contactForm.getEmail());
        System.out.println("Phone: " + contactForm.getPhone());
        System.out.println("Message: " + contactForm.getMessage());

        // You can save to DB or send an email here
        model.addAttribute("successMsg", "Your message has been sent successfully! ✅");
        model.addAttribute("contactForm", new ContactUsForm()); // reset form
        return "contactUs";
    }
}

