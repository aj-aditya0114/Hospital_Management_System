package in.ac.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ac.main.entities.DiagnosisBook;

@Repository
public interface DiagnosisRepo extends JpaRepository<DiagnosisBook, Long>{

}
