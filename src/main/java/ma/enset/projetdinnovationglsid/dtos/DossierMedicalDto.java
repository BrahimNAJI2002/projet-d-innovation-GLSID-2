package ma.enset.projetdinnovationglsid.dtos;


import lombok.Data;

@Data
public class DossierMedicalDto {
    private Long id;
    private PatientDto patient;
    private String description;
}
