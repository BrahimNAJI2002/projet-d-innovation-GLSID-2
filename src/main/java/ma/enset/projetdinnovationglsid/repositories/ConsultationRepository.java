package ma.enset.projetdinnovationglsid.repositories;

import ma.enset.projetdinnovationglsid.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query("select c from Consultation c where c.ordonnance like :kw or c.traitement like :kw")
    List<Consultation> searchConsultation(@Param("kw") String keyword);
}

