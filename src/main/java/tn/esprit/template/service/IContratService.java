package tn.esprit.template.service;


import tn.esprit.template.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {
    Contrat ajouterContrat(Contrat contrat);
    Contrat modifierContrat(Contrat contratModif);
    public void deleteContrat (int idContrat);
    public List<Contrat> findAllContrat();
    public List<Contrat> findContratByEffetDateBetween(Date from, Date to);
    Contrat getContratBf (int idBf);
}
