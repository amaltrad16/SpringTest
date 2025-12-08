package tn.esprit.template.service;

import tn.esprit.template.entities.Beneficiaire;
import tn.esprit.template.entities.Contrat;
import tn.esprit.template.entities.TypeContrat;

import java.util.List;
import java.util.Set;

public interface IBeneficiaireService {
    Beneficiaire ajouterBeneficiaire(Beneficiaire bf);
    Beneficiaire modifierBeneficiaire(Beneficiaire beneficiaireModif);
    Beneficiaire trouveParCin(int cin);
    List<Beneficiaire> trouverParNomOuPrenom (String input);
    List<Beneficiaire> findRichProfessors();
    float getMontantBf (int cinBf);
    Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat);

}
