package ma.enset.projetdinnovationglsid.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.projetdinnovationglsid.dtos.RendezVousDto;
import ma.enset.projetdinnovationglsid.entities.RendezVous;
import ma.enset.projetdinnovationglsid.exceptions.RendezVousNotFoundException;
import ma.enset.projetdinnovationglsid.mappers.Mapper;
import ma.enset.projetdinnovationglsid.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class RendezVousServiceImpl implements RendezVousService {
    private final RendezVousRepository rendezVousRepository;
    private final Mapper mapper;

    @Override
    public RendezVousDto createRendezVous(RendezVousDto rendezVousDto) {
        RendezVous rendezVous = mapper.convertToEntity(rendezVousDto);
        RendezVous savedRendezVous = rendezVousRepository.save(rendezVous);
        return mapper.convertToDto(savedRendezVous);
    }

    @Override
    public RendezVousDto getRendezVousById(Long id) throws RendezVousNotFoundException {
        RendezVous rendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new RendezVousNotFoundException("Rendez-vous non trouvé avec l'ID : " + id));
        return mapper.convertToDto(rendezVous);
    }

    @Override
    public RendezVousDto updateRendezVous(Long id, RendezVousDto rendezVousDto) throws RendezVousNotFoundException {
        RendezVous existingRendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new RendezVousNotFoundException("Rendez-vous non trouvé avec l'ID : " + id));
        // Update existing rendezVous entity with data from DTO
        // Then save the updated rendezVous entity
        RendezVous updatedRendezVous = rendezVousRepository.save(existingRendezVous);
        return mapper.convertToDto(updatedRendezVous);
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public List<RendezVousDto> getAllRendezVous() {
        List<RendezVous> rendezVousList = rendezVousRepository.findAll();
        return rendezVousList.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RendezVousDto> searchRendezVous( Date date) {
        List<RendezVous> rendezVousList = rendezVousRepository.findByDate(date);
        return rendezVousList.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }
}
