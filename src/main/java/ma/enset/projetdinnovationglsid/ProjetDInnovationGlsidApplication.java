package ma.enset.projetdinnovationglsid;

import ma.enset.projetdinnovationglsid.entities.*;
import ma.enset.projetdinnovationglsid.enums.Status;
import ma.enset.projetdinnovationglsid.repositories.*;
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
            PatientRepository patientRepository,
            RendezVousRepository rendezVousRepository,
            MedecinRepository medecinRepository,
            DossierMedicalRepository dossierMedicalRepository,
            ConsultationRepository consultationRepository
    ) {
        return args -> {
            System.out.println("Testing...");

            // Création des patients et de leurs dossiers médicaux
            Stream.of("Brahim", "Mohammed", "abdelilah").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom("Nom de " + name);
                patient.setPrenom(name);
                patient.setDateNaissance(new Date());
                patient.setAdresse("Adresse de " + name);
                patient.setCNI("CNI de " + name);
                patientRepository.save(patient);

                DossierMedical dossierMedical = new DossierMedical();
                dossierMedical.setPatient(patient);
                dossierMedical.setDescription("Description du dossier médical de " + name);
                dossierMedicalRepository.save(dossierMedical);
            });

            // Affichage des patients et de leurs dossiers médicaux
            List<Patient> patients = patientRepository.findAll();
            for (Patient p : patients) {
                System.out.println("Patient: " + p.getNom() + " " + p.getPrenom() + ", CNI: " + p.getCNI() + ", Adresse: " + p.getAdresse() + ", Dossier Médical: " + p.getDossierMedical().getDescription());
            }

            // Création des médecins
            Stream.of("Loubna", "Hayat", "Hamza").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite("Dentaire");
                medecinRepository.save(medecin);
            });

            // Affichage des médecins
            List<Medecin> medecins = medecinRepository.findAll();
            for (Medecin m : medecins) {
                System.out.println("Médecin: " + m.getNom() + ", Spécialité: " + m.getSpecialite());
            }

            // Création des rendez-vous
            Stream.of(Status.CONFIRMER, Status.ANNULER, Status.EN_ATTENTE)
                    .forEach(status -> {
                        RendezVous rendezVous = new RendezVous();
                        rendezVous.setDate(new Date());
                        rendezVous.setStatus(status);
                        rendezVous.setPatient(patients.get((int) (Math.random() * patients.size())));
                        rendezVous.setMedecin(medecins.get((int) (Math.random() * medecins.size())));
                        rendezVousRepository.save(rendezVous);
                    });

            // Création des consultations po
            List<RendezVous> rendezVousList = rendezVousRepository.findAll();
            for (RendezVous r : rendezVousList) {
                Consultation consultation = new Consultation();
                consultation.setDate(new Date());
                consultation.setDossierMedical(r.getPatient().getDossierMedical());
                consultation.setMedecin(r.getMedecin());
                consultation.setDiagnostic("Diagnostic de la consultation");
                consultation.setTraitement("Traitement de la consultation");
                consultationRepository.save(consultation);
            }

            // Affichage des consultations
            List<Consultation> consultations = consultationRepository.findAll();
            for (Consultation c : consultations) {
                System.out.println("Consultation: " + c.getId() + ", Médecin: " + c.getMedecin().getNom() + ", Diagnostic: " + c.getDiagnostic() + ", Traitement: " + c.getTraitement());
            }
        };
    }
}
