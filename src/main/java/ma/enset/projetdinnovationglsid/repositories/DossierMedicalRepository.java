package ma.enset.projetdinnovationglsid.repositories;

import ma.enset.projetdinnovationglsid.entities.Consultation;
import ma.enset.projetdinnovationglsid.entities.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
    @Query("select d from DossierMedical d where d.description like :kw")
    List<DossierMedical> searchDossierMedical(@Param("kw") String keyword);
}
