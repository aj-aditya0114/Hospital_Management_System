package in.ac.main.services;

import in.ac.main.entities.Bill;

public interface BillService {

	 Bill saveBill(Bill bill);
	 Bill getBillById(Long id);
	 Bill getBillByAppointmentId(Long appointmentId);
	 }
