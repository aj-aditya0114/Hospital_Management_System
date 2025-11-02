package in.ac.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.main.entities.DiagnosisBook;

import in.ac.main.repositories.DiagnosisRepo;

@Service
public class DiagnosisServiceImpl implements DiagnosisService{

	
	@Autowired
	private DiagnosisRepo diaRepo;

	@Override
	public DiagnosisBook saveBooking(DiagnosisBook booking) {
		
		return diaRepo.save(booking); 	
}
}
