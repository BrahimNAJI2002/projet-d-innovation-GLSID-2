package ma.enset.projetdinnovationglsid.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.projetdinnovationglsid.dtos.*;
import ma.enset.projetdinnovationglsid.entities.Patient;
import ma.enset.projetdinnovationglsid.exceptions.PatientNotFoundException;
import ma.enset.projetdinnovationglsid.mappers.Mapper;
import ma.enset.projetdinnovationglsid.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final DossierMedicalRepository dossierMedicalRepository;
    private final ConsultationRepository consultationRepository;
    private final RendezVousRepository rendezVousRepository;
    private final Mapper mapper;

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = mapper.convertToEntity(patientDto);
        Patient savedPatient = patientRepository.save(patient);
        return mapper.convertToDto(savedPatient);
    }

    @Override
    public PatientDto getPatientById(Long id) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        return mapper.convertToDto(patient);
    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) throws PatientNotFoundException {
        Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        Patient updatedPatient = mapper.convertToEntity(patientDto);
        updatedPatient.setId(id); // Ensure the ID remains the same
        Patient savedPatient = patientRepository.save(updatedPatient);
        return mapper.convertToDto(savedPatient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDto> searchPatients(String searchTerm) {
        List<Patient> patients = patientRepository.searchPatient(searchTerm);
        return patients.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DossierMedicalDto getDossierMedicalByPatient(Long patientId) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        if(patient.getDossierMedical() != null)
        return mapper.convertToDto(patient.getDossierMedical());
        else return new DossierMedicalDto() ;
    }

    @Override
    public List<ConsultationDto> getConsultationsByPatient(Long patientId) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        return patient.getDossierMedical().getConsultations().stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RendezVousDto> getRendezVousByPatient(Long patientId) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        return patient.getRendezVous().stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }
}
