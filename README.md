# Projet Innovation - Gestion de Patients et de Consultations

## Introduction

Ce projet vise à créer un système de gestion de patients et de consultations pour les professionnels de la santé. Il permet de stocker et de gérer les informations sur les patients, les médecins, les rendez-vous et les consultations médicales.

## Couches de l'Application

### DAO (Data Access Object)

La couche DAO est responsable de l'accès aux données de la base de données. Elle comprend les entités Java qui représentent les données et les interfaces Repository qui fournissent un accès aux données à travers Spring Data JPA.

#### Entités

- **Patient**: Représente les informations sur un patient.
- **Medecin**: Représente les informations sur un médecin.
- **DossierMedical**: Contient les informations sur le dossier médical d'un patient.
- **RendezVous**: Représente un rendez-vous entre un patient et un médecin.
- **Consultation**: Représente une consultation effectuée par un médecin pour un patient.

#### Repositories

- **PatientRepository**: Pour accéder aux données des patients.
- **MedecinRepository**: Pour accéder aux données des médecins.
- **DossierMedicalRepository**: Pour accéder aux données des dossiers médicaux.
- **RendezVousRepository**: Pour accéder aux données des rendez-vous.
- **ConsultationRepository**: Pour accéder aux données des consultations.

### Services

La couche Services permet de manipuler les données à travers des DTOs (Data Transfer Objects). Elle encapsule la logique métier et fournit des opérations CRUD pour chaque entité.

#### Fonctionnalités ajoutées

- **PatientService**: Opérations pour créer, récupérer, mettre à jour et supprimer un patient. Permet également de rechercher des patients.
- **MedecinService**: Opérations pour gérer les médecins, y compris la recherche par terme.
- **DossierMedicalService**: Opérations pour gérer les dossiers médicaux des patients.
- **RendezVousService**: Opérations pour gérer les rendez-vous entre les patients et les médecins.
- **ConsultationService**: Opérations pour gérer les consultations médicales.

### Test

La classe `ProjetDInnovationGlsidApplication` contient une méthode `main` qui initialise quelques données de test pour les patients, les médecins, les rendez-vous et les consultations. Ces données de test sont utilisées pour vérifier le bon fonctionnement de l'application.


![img.png](img.png)

![img_1.png](img_1.png)
