package ma.enset.projetdinnovationglsid;

import ma.enset.projetdinnovationglsid.dtos.*;
import ma.enset.projetdinnovationglsid.enums.Status;
import ma.enset.projetdinnovationglsid.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjetDInnovationGlsidApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetDInnovationGlsidApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            PatientService patientService,
            DossierMedicalService dossierMedicalService,
            MedecinService medecinService,
            RendezVousService rendezVousService,
            ConsultationService consultationService
    ) {
        return args -> {
            // Création de patients
            Stream.of("Brahim", "Mohammed", "Aicha").forEach(name -> {
                PatientDto patientDto = new PatientDto();
                patientDto.setNom("Nom de " + name);
                patientDto.setPrenom(name);
                patientDto.setDateNaissance(new Date());
                patientDto.setAdresse("Adresse de " + name);
                patientDto.setCNI("CNI de " + name);
                patientService.createPatient(patientDto);
            });

            // Récupération de tous les patients
            List<PatientDto> patients = patientService.getAllPatients();
            patients.forEach(patient -> System.out.println("Patient: " + patient.getNom() + " " + patient.getPrenom() + ", CNI: " + patient.getCNI() + ", Adresse: " + patient.getAdresse()));

            // Création de dossiers médicaux pour les patients
            patients.forEach(patient -> {
                DossierMedicalDto dossierMedicalDto = new DossierMedicalDto();
                dossierMedicalDto.setPatient(patient);
                dossierMedicalDto.setDescription("Description du dossier médical de " + patient.getNom());
                dossierMedicalService.createDossierMedical(dossierMedicalDto);
            });

            // Récupération de tous les dossiers médicaux
            List<DossierMedicalDto> dossiersMedical = dossierMedicalService.getAllDossiersMedical();
            dossiersMedical.forEach(dossierMedical -> System.out.println("Dossier médical: " + dossierMedical.getDescription()));

            // Création de médecins
            Stream.of("Samir", "Abdelilah", "Hamza").forEach(name -> {
                MedecinDto medecinDto = new MedecinDto();
                medecinDto.setNom(name);
                medecinDto.setSpecialite("Dentaire");
                medecinService.createMedecin(medecinDto);
            });

            // Récupération de tous les médecins
            List<MedecinDto> medecins = medecinService.getAllMedecins();
            medecins.forEach(medecin -> System.out.println("Médecin: " + medecin.getNom() + ", Spécialité: " + medecin.getSpecialite()));

            };
    }

}
