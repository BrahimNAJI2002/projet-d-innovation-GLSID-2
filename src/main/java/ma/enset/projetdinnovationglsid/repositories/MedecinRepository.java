package ma.enset.projetdinnovationglsid.repositories;

import ma.enset.projetdinnovationglsid.entities.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    Page<Medecin> findByNomContains(String nom, Pageable pageable);

}
