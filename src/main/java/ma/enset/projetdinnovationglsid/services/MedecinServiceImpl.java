package ma.enset.projetdinnovationglsid.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.projetdinnovationglsid.dtos.MedecinDto;
import ma.enset.projetdinnovationglsid.entities.Medecin;
import ma.enset.projetdinnovationglsid.exceptions.MedecinNotFoundException;
import ma.enset.projetdinnovationglsid.mappers.Mapper;
import ma.enset.projetdinnovationglsid.repositories.MedecinRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class MedecinServiceImpl implements MedecinService {
    private final MedecinRepository medecinRepository;
    private final Mapper mapper;

    @Override
    public MedecinDto createMedecin(MedecinDto medecinDto) {
        Medecin medecin = mapper.convertToEntity(medecinDto);
        Medecin savedMedecin = medecinRepository.save(medecin);
        return mapper.convertToDto(savedMedecin);
    }

    @Override
    public MedecinDto getMedecinById(Long id) throws MedecinNotFoundException {
        Medecin medecin = medecinRepository.findById(id)
                .orElseThrow(() -> new MedecinNotFoundException("Médecin non trouvé avec l'ID : " + id));
        return mapper.convertToDto(medecin);
    }

    @Override
    public MedecinDto updateMedecin(Long id, MedecinDto medecinDto) throws MedecinNotFoundException {
        log.info("Updating Medecin with ID: {}", id);
        Medecin existingMedecin = medecinRepository.findById(id).orElseThrow(() -> new MedecinNotFoundException("Medecin not found"));
        Medecin updatedMedecin = mapper.convertToEntity(medecinDto);
        updatedMedecin.setId(id);
        Medecin savedMedecin = medecinRepository.save(updatedMedecin);
        return mapper.convertToDto(savedMedecin);
    }

    @Override
    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }

    @Override
    public List<MedecinDto> getAllMedecins() {
        List<Medecin> medecins = medecinRepository.findAll();
        return medecins.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MedecinDto> searchMedecins(String searchTerm) {
        List<Medecin> medecins = medecinRepository.searchMedecin(searchTerm);
        return medecins.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }
}
