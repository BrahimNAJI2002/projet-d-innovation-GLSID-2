package ma.enset.projetdinnovationglsid.repositories;


import ma.enset.projetdinnovationglsid.entities.Medecin;
import ma.enset.projetdinnovationglsid.entities.Patient;
import ma.enset.projetdinnovationglsid.entities.RendezVous;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    List<RendezVous> findByDate(Date date);

    List<RendezVous> findRendezVousByMedecin(Medecin medecin);

    @Query("SELECT r FROM RendezVous r WHERE r.medecin = :medecin AND (r.patient.nom   LIKE %:kw%)")
    List<RendezVous> searchRendezVousByMedecin(@Param("medecin") Medecin medecin, @Param("kw") String keyword);

    @Query("select m from Medecin m where m.nom like :kw")
    List<Medecin> searchMedecin(@Param("kw") String keyword);
}

