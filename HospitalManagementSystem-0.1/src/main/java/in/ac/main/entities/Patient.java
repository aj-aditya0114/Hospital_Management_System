package in.ac.main.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Patient 
{

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
		private String gender;
		
		@Column
		private int age;
		
		

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

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		
		
//		@ElementCollection(fetch = FetchType.EAGER)
//		private List<String>roleList = new ArrayList<>();
//
//		@Override
//		public Collection<? extends GrantedAuthority> getAuthorities() {
//			
//			//list of roles[USER, ADMIN]
//			// Collection of SimpleGrantedAuthority[roles{ADMIN, USER}]
//			
//			Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
//			
//			return roles;
//		}
//
//		
//		@Override
//		public String getUsername() {
//			
//			return this.email;
//		}
//		
//		
//		
//		@Override
//		public boolean isAccountNonExpired() {
//			return true;
//		}
//		
//		@Override
//		public boolean isAccountNonLocked() {
//			return true;
//		}
//		
//		@Override
//		public boolean isCredentialsNonExpired() {
//			return true;
//		}
//
//		
//		@Override
//		public boolean isEnabled(){
//			return true;
//		}
//		
//		
	}


