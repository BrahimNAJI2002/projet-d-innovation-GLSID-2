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
        if (dossierMedical.getPatient() != null) {
            dossierMedicalDto.setPatient(convertToDto(dossierMedical.getPatient())); // Mapper également le patient
        }
        return dossierMedicalDto;
    }

    public DossierMedical convertToEntity(DossierMedicalDto dossierMedicalDto) {
        DossierMedical dossierMedical = new DossierMedical();
        BeanUtils.copyProperties(dossierMedicalDto, dossierMedical);
        if (dossierMedicalDto.getPatient() != null) {
            dossierMedical.setPatient(convertToEntity(dossierMedicalDto.getPatient())); // Mapper également le patient
        }
        return dossierMedical;
    }

    public RendezVousDto convertToDto(RendezVous rendezVous) {
        RendezVousDto rendezVousDto = new RendezVousDto();
        BeanUtils.copyProperties(rendezVous, rendezVousDto);
        rendezVousDto.setMedecin(convertToDto(rendezVous.getMedecin()));
        rendezVousDto.setPatient(convertToDto(rendezVous.getPatient()));
        return rendezVousDto;
    }

    public RendezVous convertToEntity(RendezVousDto rendezVousDto) {
        RendezVous rendezVous = new RendezVous();
        BeanUtils.copyProperties(rendezVousDto, rendezVous);
        rendezVous.setMedecin(convertToEntity(rendezVousDto.getMedecin()));
        rendezVous.setPatient(convertToEntity(rendezVousDto.getPatient()));
        return rendezVous;
    }


    public ConsultationDto convertToDto(Consultation consultation) {
        ConsultationDto consultationDto = new ConsultationDto();
        BeanUtils.copyProperties(consultation, consultationDto);
        consultationDto.setDossierMedical(convertToDto(consultation.getDossierMedical()));
        consultationDto.setMedecin(convertToDto(consultation.getMedecin()));
        return consultationDto;
    }

    public Consultation convertToEntity(ConsultationDto consultationDto) {
        Consultation consultation = new Consultation();
        BeanUtils.copyProperties(consultationDto, consultation);
        consultation.setDossierMedical(convertToEntity(consultationDto.getDossierMedical()));
        consultation.setMedecin(convertToEntity(consultationDto.getMedecin()));
        return consultation;
    }

}
