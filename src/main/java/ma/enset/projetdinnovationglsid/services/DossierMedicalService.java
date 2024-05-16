package ma.enset.projetdinnovationglsid.services;

import ma.enset.projetdinnovationglsid.dtos.DossierMedicalDto;
import ma.enset.projetdinnovationglsid.exceptions.DossierMedicalNotFoundException;

import java.util.List;

public interface DossierMedicalService {
    DossierMedicalDto createDossierMedical(DossierMedicalDto dossierMedicalDto);
    DossierMedicalDto getDossierMedicalById(Long id) throws DossierMedicalNotFoundException;
    DossierMedicalDto updateDossierMedical(Long id, DossierMedicalDto dossierMedicalDto) throws DossierMedicalNotFoundException;
    void deleteDossierMedical(Long id);
    List<DossierMedicalDto> getAllDossiersMedical();
    List<DossierMedicalDto> searchDossiersMedical(String searchTerm);
}
