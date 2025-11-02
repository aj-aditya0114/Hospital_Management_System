package in.ac.main.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DiagnosisBook {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column
	    private Long id;

	 @Column
	    private String testName;

	 @Column
	    private String patientName;

	 @Column
	    private String patientEmail;

	 
	    private LocalDateTime bookingTime;

	    public DiagnosisBook() {}

	    public DiagnosisBook(String testName, String patientName, String patientEmail) {
	        this.testName = testName;
	        this.patientName = patientName;
	        this.patientEmail = patientEmail;
	        this.bookingTime = LocalDateTime.now();
	    }

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getTestName() { return testName; }
	    public void setTestName(String testName) { this.testName = testName; }

	    public String getPatientName() { return patientName; }
	    public void setPatientName(String patientName) { this.patientName = patientName; }

	    public String getPatientEmail() { return patientEmail; }
	    public void setPatientEmail(String patientEmail) { this.patientEmail = patientEmail; }

	    public LocalDateTime getBookingTime() { return bookingTime; }
	    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }
}
