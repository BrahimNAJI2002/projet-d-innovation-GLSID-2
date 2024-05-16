package ma.enset.projetdinnovationglsid.repositories;

import ma.enset.projetdinnovationglsid.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
