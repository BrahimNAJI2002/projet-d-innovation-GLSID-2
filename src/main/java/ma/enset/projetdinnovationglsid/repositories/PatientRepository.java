package ma.enset.projetdinnovationglsid.repositories;



import ma.enset.projetdinnovationglsid.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Page<Patient> findByNomContains(String nom, Pageable pageable);
    @Query("select p from Patient p where p.nom like :kw")
    List<Patient> searchPatient(@Param("kw") String keyword);

}
