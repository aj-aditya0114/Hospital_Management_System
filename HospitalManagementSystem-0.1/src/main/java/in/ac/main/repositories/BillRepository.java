package in.ac.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.main.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{

	Bill findByAppointmentId(Long appointmentId);
}
