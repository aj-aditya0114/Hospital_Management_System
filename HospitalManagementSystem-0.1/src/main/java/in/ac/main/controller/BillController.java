package in.ac.main.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.ac.main.entities.Appointment;
import in.ac.main.entities.Bill;
import in.ac.main.services.ApoointmentService;
import in.ac.main.services.BillService;

@Controller
public class BillController {

	@Autowired
	private BillService billService;
	
	@Autowired
	private ApoointmentService appointmentService;
	
	
	@GetMapping("/doctor/generate-bill/{appointmentId}")
	public String generateBill(@PathVariable Long appointmentId, Model model) {
	    Appointment appointment = appointmentService.getAppointmentById(appointmentId);

	    if (appointment == null) {
	        return "redirect:/doctor/appointments";
	    }

	    // Check if bill already exists
	    Bill existingBill = billService.getBillByAppointmentId(appointmentId);
	    if (existingBill != null) {
	        model.addAttribute("bill", existingBill);
	    } else {
	        Bill bill = new Bill();
	        bill.setAppointment(appointment);
	        bill.setAmount(1500.0); 
	        bill.setBillingDate(LocalDate.now());
	        bill.setPaymentStatus("UNPAID");
	        billService.saveBill(bill);
	        model.addAttribute("bill", bill);
	    }

	    return "Patient/bill";
	}
}
