package ma.enset.projetdinnovationglsid.repositories;

import ma.enset.projetdinnovationglsid.entities.DossierMedical;
import ma.enset.projetdinnovationglsid.entities.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    Page<Medecin> findByNomContains(String nom, Pageable pageable);
    @Query("select m from Medecin m where m.nom like :kw")
    List<Medecin> searchMedecin(@Param("kw") String keyword);

}
