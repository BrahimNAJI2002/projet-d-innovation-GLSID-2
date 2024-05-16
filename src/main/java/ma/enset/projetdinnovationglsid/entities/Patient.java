package ma.enset.projetdinnovationglsid.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private String adresse;
    private String CNI;
    @OneToOne(mappedBy = "patient")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private DossierMedical dossierMedical;
    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVous;
}
