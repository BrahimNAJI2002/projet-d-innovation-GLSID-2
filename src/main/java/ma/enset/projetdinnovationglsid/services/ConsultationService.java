package ma.enset.projetdinnovationglsid.services;

import ma.enset.projetdinnovationglsid.dtos.ConsultationDto;
import ma.enset.projetdinnovationglsid.exceptions.ConsultationNotFoundException;

import java.util.List;

public interface ConsultationService {
    ConsultationDto createConsultation(ConsultationDto consultationDto);
    ConsultationDto getConsultationById(Long id) throws ConsultationNotFoundException;
    ConsultationDto updateConsultation(Long id, ConsultationDto consultationDto) throws ConsultationNotFoundException;
    void deleteConsultation(Long id);
    List<ConsultationDto> getAllConsultations();
    List<ConsultationDto> searchConsultations(String searchTerm);
}
