# Projet Innovation - Gestion de Patients et de Consultations

La couche DAO

### Entités

Les entités Java ont été créées pour représenter les données de l'application. Les annotations Lombok sont utilisées pour générer automatiquement les getters, setters, et les constructeurs. Voici les principales entités utilisées dans le projet :

- Patient : Représente les informations sur un patient.
- Medecin : Représente les informations sur un médecin.
- DossierMedical : Contient les informations sur le dossier médical d'un patient.
- RendezVous : Représente un rendez-vous entre un patient et un médecin.
- Consultation : Représente une consultation effectuée par un médecin pour un patient.

### Repository

Des interfaces Repository ont été créées pour chaque entité afin de fournir un accès aux données de la base de données. Ces interfaces étendent JpaRepository de Spring Data JPA, ce qui permet de bénéficier de méthodes de base pour les opérations CRUD. Voici les principaux repositories utilisés dans le projet :

- PatientRepository : Pour accéder aux données des patients.
- MedecinRepository : Pour accéder aux données des médecins.
- DossierMedicalRepository : Pour accéder aux données des dossiers médicaux.
- RendezVousRepository : Pour accéder aux données des rendez-vous.
- ConsultationRepository : Pour accéder aux données des consultations.

### Test

![img.png](img.png)

![img_1.png](img_1.png)
