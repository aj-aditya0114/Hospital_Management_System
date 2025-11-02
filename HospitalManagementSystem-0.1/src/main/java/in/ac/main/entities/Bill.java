package in.ac.main.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Bill {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToOne
	    @JoinColumn(name = "appointment_id", nullable = false, unique = true)
	    private Appointment appointment;

	    @Column(nullable = false)
	    private Double amount;

	    @Column(name = "billing_date", nullable = false)
	    private LocalDate billingDate;

	    @Column(name = "payment_status", nullable = false)
	    private String paymentStatus; 								// "PAID" , "UNPAID"

	    @Column
	    private String transactionId;
	    

	    
	    
	    public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Appointment getAppointment() {
	        return appointment;
	    }

	    public void setAppointment(Appointment appointment) {
	        this.appointment = appointment;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public void setAmount(Double amount) {
	        this.amount = amount;
	    }

	    public LocalDate getBillingDate() {
	        return billingDate;
	    }

	    public void setBillingDate(LocalDate billingDate) {
	        this.billingDate = billingDate;
	    }

	    public String getPaymentStatus() {
	        return paymentStatus;
	    }

	    public void setPaymentStatus(String paymentStatus) {
	        this.paymentStatus = paymentStatus;
	    }
}
