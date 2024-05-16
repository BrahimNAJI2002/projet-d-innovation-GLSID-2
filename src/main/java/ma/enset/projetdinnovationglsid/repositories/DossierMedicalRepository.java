package ma.enset.projetdinnovationglsid.repositories;

import ma.enset.projetdinnovationglsid.entities.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
}
