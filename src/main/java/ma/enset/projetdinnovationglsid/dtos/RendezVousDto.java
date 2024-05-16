package ma.enset.projetdinnovationglsid.dtos;


import lombok.Data;
import java.util.Date;

@Data
public class RendezVousDto {
    private Long id;
    private PatientDto patient;
    private MedecinDto medecin;
    private Date date;
}
