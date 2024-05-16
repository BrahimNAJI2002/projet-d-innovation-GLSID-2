package ma.enset.projetdinnovationglsid.services;

import ma.enset.projetdinnovationglsid.dtos.*;
import ma.enset.projetdinnovationglsid.exceptions.PatientNotFoundException;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);
    PatientDto getPatientById(Long id) throws PatientNotFoundException;
    PatientDto updatePatient(Long id, PatientDto patientDto) throws PatientNotFoundException;
    void deletePatient(Long id);
    List<PatientDto> getAllPatients();
    List<PatientDto> searchPatients(String searchTerm);

    DossierMedicalDto getDossierMedicalByPatient(Long patientId) throws PatientNotFoundException;
    List<ConsultationDto> getConsultationsByPatient(Long patientId) throws PatientNotFoundException;
    List<RendezVousDto> getRendezVousByPatient(Long patientId) throws PatientNotFoundException;
}
