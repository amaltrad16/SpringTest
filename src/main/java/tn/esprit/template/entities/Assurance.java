package tn.esprit.template.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idAssurance;
    public String designation;
    public Float montant;

    @ManyToOne
    private Beneficiaire beneficiaire;
    @ManyToOne
    private Contrat contrat;
}

