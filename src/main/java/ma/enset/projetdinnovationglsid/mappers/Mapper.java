package ma.enset.projetdinnovationglsid.mappers;


import ma.enset.projetdinnovationglsid.dtos.*;
import ma.enset.projetdinnovationglsid.entities.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
@Component
public class Mapper {
    public PatientDto convertToDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        BeanUtils.copyProperties(patient, patientDto);
        return patientDto;
    }

    public Patient convertToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        BeanUtils.copyProperties(patientDto, patient);
        return patient;
    }

    public MedecinDto convertToDto(Medecin medecin) {
        MedecinDto medecinDto = new MedecinDto();
        BeanUtils.copyProperties(medecin, medecinDto);
        return medecinDto;
    }

    public Medecin convertToEntity(MedecinDto medecinDto) {
        Medecin medecin = new Medecin();
        BeanUtils.copyProperties(medecinDto, medecin);
        return medecin;
    }

    public DossierMedicalDto convertToDto(DossierMedical dossierMedical) {
        DossierMedicalDto dossierMedicalDto = new DossierMedicalDto();
        BeanUtils.copyProperties(dossierMedical, dossierMedicalDto);
        return dossierMedicalDto;
    }

    public DossierMedical convertToEntity(DossierMedicalDto dossierMedicalDto) {
        DossierMedical dossierMedical = new DossierMedical();
        BeanUtils.copyProperties(dossierMedicalDto, dossierMedical);
        return dossierMedical;
    }

    public RendezVousDto convertToDto(RendezVous rendezVous) {
        RendezVousDto rendezVousDto = new RendezVousDto();
        BeanUtils.copyProperties(rendezVous, rendezVousDto);
        return rendezVousDto;
    }

    public RendezVous convertToEntity(RendezVousDto rendezVousDto) {
        RendezVous rendezVous = new RendezVous();
        BeanUtils.copyProperties(rendezVousDto, rendezVous);
        return rendezVous;
    }

    public ConsultationDto convertToDto(Consultation consultation) {
        ConsultationDto consultationDto = new ConsultationDto();
        BeanUtils.copyProperties(consultation, consultationDto);
        return consultationDto;
    }

    public Consultation convertToEntity(ConsultationDto consultationDto) {
        Consultation consultation = new Consultation();
        BeanUtils.copyProperties(consultationDto, consultation);
        return consultation;
    }
}
