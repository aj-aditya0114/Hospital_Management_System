package in.ac.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ac.main.entities.Bill;
import in.ac.main.services.BillService;

@Controller
@RequestMapping("/payment")
public class PaymentController {

	
	@Autowired
	private BillService billService;
	
	@GetMapping("/pay/{billId}")
	public String payBill(@PathVariable Long billId, Model model) {
		Bill bill = billService.getBillById(billId);
		if(bill == null || "PAID".equals(bill.getPaymentStatus())) {
			return "redirect:/patient/bills";
		}
		
		model.addAttribute("bill", bill);
		return "Patient/paymentPage";
	}
	
	
	@PostMapping("/success")
	public String paymentSuccess(@RequestParam Long billId, @RequestParam String transactionId) {
		Bill bill = billService.getBillById(billId);
		bill.setPaymentStatus("PAID");
		bill.setTransactionId(transactionId);
		billService.saveBill(bill);
		
		return "redirect:/patient/bills";
	}
	
}
