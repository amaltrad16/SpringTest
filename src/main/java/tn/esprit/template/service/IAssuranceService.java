package tn.esprit.template.service;

import tn.esprit.template.entities.Assurance;
import tn.esprit.template.entities.Beneficiaire;


public interface IAssuranceService {
    Assurance ajouterAssurance(Assurance assurance);

    Assurance modifierAssurance(Assurance assuranceModif);

    Assurance ajouterAssurance(Assurance a, int cinBf);

}
