package in.ac.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column 
	private String password;
	
	@Column
	private String speciality;
	
	@Column
	private String course; 

	@Column
	private String institution; 
	
	@Column
	private String gender;
	
	
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	private boolean loggedIn;

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	
	

	public Doctor(Long id, String name, String email, String password, String speciality, String course,
			String institution, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.speciality = speciality;
		this.course = course;
		this.institution = institution;
		this.gender = gender;
		
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}

