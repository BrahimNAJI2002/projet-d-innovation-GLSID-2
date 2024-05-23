package ma.enset.projetdinnovationglsid.services;

import ma.enset.projetdinnovationglsid.dtos.RendezVousDto;
import ma.enset.projetdinnovationglsid.exceptions.RendezVousNotFoundException;

import java.util.Date;
import java.util.List;

public interface RendezVousService {
    RendezVousDto createRendezVous(RendezVousDto rendezVousDto);
    RendezVousDto getRendezVousById(Long id) throws RendezVousNotFoundException;
    RendezVousDto updateRendezVous(Long id, RendezVousDto rendezVousDto) throws RendezVousNotFoundException;
    void deleteRendezVous(Long id);
    List<RendezVousDto> getAllRendezVous();
    List<RendezVousDto> searchRendezVous(Date date);

    List<RendezVousDto> getAllRendezVousByMedecin(Long medecinId);
}
