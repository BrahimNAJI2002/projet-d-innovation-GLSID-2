package ma.enset.projetdinnovationglsid.web;

import ma.enset.projetdinnovationglsid.dtos.*;
import ma.enset.projetdinnovationglsid.exceptions.*;
import ma.enset.projetdinnovationglsid.services.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ConsultationRestAPI {
    private ConsultationService consultationService;

    public ConsultationRestAPI(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("/consultations/{consultationId}")
    public ConsultationDto getConsultation(@PathVariable Long consultationId) throws ConsultationNotFoundException {
        return consultationService.getConsultationById(consultationId);
    }

    @GetMapping("/consultations")
    public List<ConsultationDto> listConsultations(){
        return consultationService.getAllConsultations();
    }

    @PostMapping("/consultations")
    public ConsultationDto createConsultation(@RequestBody ConsultationDto consultationDto){
        return consultationService.createConsultation(consultationDto);
    }

    @PutMapping("/consultations/{consultationId}")
    public ConsultationDto updateConsultation(@PathVariable Long consultationId, @RequestBody ConsultationDto consultationDto) throws ConsultationNotFoundException {
        return consultationService.updateConsultation(consultationId, consultationDto);
    }

    @DeleteMapping("/consultations/{consultationId}")
    public void deleteConsultation(@PathVariable Long consultationId){
        consultationService.deleteConsultation(consultationId);
    }

    @GetMapping("/consultations/search")
    public List<ConsultationDto> searchConsultations(@RequestParam String searchTerm) {
        return consultationService.searchConsultations(searchTerm);
    }
}
