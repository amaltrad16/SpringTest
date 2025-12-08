package tn.esprit.template.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbenef;
    private int cin;
    private String nom;
    private String prenom;
    private String profession;
    private Float salaire;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiaire", fetch = FetchType.EAGER)
    private Set<Assurance> assurances;
}
