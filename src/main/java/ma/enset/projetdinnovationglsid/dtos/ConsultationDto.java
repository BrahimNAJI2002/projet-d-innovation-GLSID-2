package ma.enset.projetdinnovationglsid.dtos;


import lombok.Data;
import java.util.Date;

@Data
public class ConsultationDto {
    private Long id;
    private MedecinDto medecin;
    private DossierMedicalDto dossierMedical;
    private Date date;
    private String diagnostic;
    private String traitement;
    private String ordonnance;
    private String certificatMedical;
}
