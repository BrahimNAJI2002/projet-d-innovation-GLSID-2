package ma.enset.projetdinnovationglsid.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String specialite;
    @OneToMany(mappedBy = "medecin")
    private List<Consultation> consultations;
    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;
}
