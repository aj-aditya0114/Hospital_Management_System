package in.ac.main.services;

import java.io.InputStream;
import java.util.*;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


//@Service
//public class MedicineService {
//
//	private static final String RXNORM_API = "https://rxnav.nlm.nih.gov/REST/drugs.json?name=";
//	private final RestTemplate restTemplate  = new RestTemplate();
//	private final Map<String, Double> indianPrices = new HashMap<>();
//	
//	public MedicineService() {
//		loadIndianPrices();
//	}
//	
//	// Load Indian prices from JSON file
//	private void loadIndianPrices() {
//		try {
//			InputStream inputStream = new ClassPathResource("indian-medicines.json").getInputStream();
//			ObjectMapper mapper = new ObjectMapper();
//			List<Map<String, Object>>medicines = mapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>(){});
//			
//			for(Map<String, Object> med:medicines) {
//				indianPrices.put(((String)med.get("name")).toLowerCase(), (Double)med.get("price"));
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	//Search drug info + Indian price
//	public List<MedicineDTO> serachMedicines(String query){
//		List<MedicineDTO> result = new ArrayList<>();
//		
//		String url = RXNORM_API + query;
//		ResponseEntity<String>response = restTemplate.getForEntity(url,  String.class);
//		
//		try {
//			
//			JSONObject json = new JSONObject(response.getBody());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
