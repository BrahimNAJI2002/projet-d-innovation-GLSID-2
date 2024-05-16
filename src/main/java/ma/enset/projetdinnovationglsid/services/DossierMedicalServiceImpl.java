package ma.enset.projetdinnovationglsid.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.projetdinnovationglsid.dtos.DossierMedicalDto;
import ma.enset.projetdinnovationglsid.entities.DossierMedical;
import ma.enset.projetdinnovationglsid.exceptions.DossierMedicalNotFoundException;
import ma.enset.projetdinnovationglsid.mappers.Mapper;
import ma.enset.projetdinnovationglsid.repositories.DossierMedicalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class DossierMedicalServiceImpl implements DossierMedicalService {
    private final DossierMedicalRepository dossierMedicalRepository;
    private final Mapper mapper;

    @Override
    public DossierMedicalDto createDossierMedical(DossierMedicalDto dossierMedicalDto) {
        DossierMedical dossierMedical = mapper.convertToEntity(dossierMedicalDto);
        DossierMedical savedDossierMedical = dossierMedicalRepository.save(dossierMedical);
        return mapper.convertToDto(savedDossierMedical);
    }

    @Override
    public DossierMedicalDto getDossierMedicalById(Long id) throws DossierMedicalNotFoundException {
        DossierMedical dossierMedical = dossierMedicalRepository.findById(id)
                .orElseThrow(() -> new DossierMedicalNotFoundException("Dossier médical non trouvé avec l'ID : " + id));
        return mapper.convertToDto(dossierMedical);
    }

    @Override
    public DossierMedicalDto updateDossierMedical(Long id, DossierMedicalDto dossierMedicalDto) throws DossierMedicalNotFoundException {
        log.info("Updating DossierMedical with ID: {}", id);
        DossierMedical existingDossierMedical = dossierMedicalRepository.findById(id).orElseThrow(() -> new DossierMedicalNotFoundException("DossierMedical not found"));
        DossierMedical updatedDossierMedical = mapper.convertToEntity(dossierMedicalDto);
        updatedDossierMedical.setId(id);
        DossierMedical savedDossierMedical = dossierMedicalRepository.save(updatedDossierMedical);
        return mapper.convertToDto(savedDossierMedical);
    }

    @Override
    public void deleteDossierMedical(Long id) {
        dossierMedicalRepository.deleteById(id);
    }

    @Override
    public List<DossierMedicalDto> getAllDossiersMedical() {
        List<DossierMedical> dossiersMedical = dossierMedicalRepository.findAll();
        return dossiersMedical.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DossierMedicalDto> searchDossiersMedical(String searchTerm) {
        List<DossierMedical> dossiersMedical = dossierMedicalRepository.searchDossierMedical(searchTerm);
        return dossiersMedical.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }
}
