package ma.enset.projetdinnovationglsid.dtos;


import lombok.Data;
import ma.enset.projetdinnovationglsid.entities.Patient;

@Data
public class DossierMedicalDto {
    private Long id;
    private PatientDto patient;
    private String description;
}
