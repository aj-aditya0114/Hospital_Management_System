package in.ac.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.main.entities.Bill;
import in.ac.main.repositories.BillRepository;

@Service
public class BillServiceImpl implements BillService{

	
	@Autowired
	private BillRepository billRepository;
	
	@Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public Bill getBillByAppointmentId(Long appointmentId) {
        return billRepository.findByAppointmentId(appointmentId);
    }
}
