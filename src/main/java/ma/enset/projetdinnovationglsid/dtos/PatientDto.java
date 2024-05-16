package ma.enset.projetdinnovationglsid.dtos;


import lombok.Data;
import java.util.Date;

@Data
public class PatientDto {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private String CNI;
}
