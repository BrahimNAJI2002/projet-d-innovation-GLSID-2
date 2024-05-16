package ma.enset.projetdinnovationglsid.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.projetdinnovationglsid.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Patient patient;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Medecin medecin;
    @Enumerated(EnumType.STRING)
    private Status status;
}
