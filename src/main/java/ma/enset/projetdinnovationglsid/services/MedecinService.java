package ma.enset.projetdinnovationglsid.services;

import ma.enset.projetdinnovationglsid.dtos.MedecinDto;
import ma.enset.projetdinnovationglsid.exceptions.MedecinNotFoundException;

import java.util.List;

public interface MedecinService {
    MedecinDto createMedecin(MedecinDto medecinDto);
    MedecinDto getMedecinById(Long id) throws MedecinNotFoundException;
    MedecinDto updateMedecin(Long id, MedecinDto medecinDto) throws MedecinNotFoundException;
    void deleteMedecin(Long id);
    List<MedecinDto> getAllMedecins();
    List<MedecinDto> searchMedecins(String searchTerm);
}
