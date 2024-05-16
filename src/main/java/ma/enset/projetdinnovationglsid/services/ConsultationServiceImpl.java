package ma.enset.projetdinnovationglsid.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.projetdinnovationglsid.dtos.ConsultationDto;
import ma.enset.projetdinnovationglsid.entities.Consultation;
import ma.enset.projetdinnovationglsid.exceptions.ConsultationNotFoundException;
import ma.enset.projetdinnovationglsid.mappers.Mapper;
import ma.enset.projetdinnovationglsid.repositories.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final Mapper mapper;

    @Override
    public ConsultationDto createConsultation(ConsultationDto consultationDto) {
        Consultation consultation = mapper.convertToEntity(consultationDto);
        Consultation savedConsultation = consultationRepository.save(consultation);
        return mapper.convertToDto(savedConsultation);
    }

    @Override
    public ConsultationDto getConsultationById(Long id) throws ConsultationNotFoundException {
        Consultation consultation = consultationRepository.findById(id).orElseThrow(() -> new ConsultationNotFoundException("Consultation not found"));
        return mapper.convertToDto(consultation);
    }

    @Override
    public ConsultationDto updateConsultation(Long id, ConsultationDto consultationDto) throws ConsultationNotFoundException {
        log.info("Updating Consultation with ID: {}", id);
        Consultation existingConsultation = consultationRepository.findById(id).orElseThrow(() -> new ConsultationNotFoundException("Consultation not found"));
        Consultation updatedConsultation = mapper.convertToEntity(consultationDto);
        updatedConsultation.setId(id); // Ensure the ID remains the same
        Consultation savedConsultation = consultationRepository.save(updatedConsultation);
        return mapper.convertToDto(savedConsultation);
    }


    @Override
    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }

    @Override
    public List<ConsultationDto> getAllConsultations() {
        List<Consultation> consultations = consultationRepository.findAll();
        return consultations.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<ConsultationDto> searchConsultations(String searchTerm) {
        List<Consultation> consultations = consultationRepository.searchConsultation(searchTerm);
        return consultations.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }
}
