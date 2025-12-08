package tn.esprit.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.template.entities.Assurance;
import tn.esprit.template.entities.Beneficiaire;
import tn.esprit.template.entities.Contrat;

import tn.esprit.template.repositories.BeneficiaireRepo;
import tn.esprit.template.repositories.ContratRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service

public class ContratImpl implements IContratService {
    @Autowired
    private ContratRepo contratRepo;
    @Autowired
    private BeneficiaireRepo beneficiaireRepo;

    public ContratImpl(ContratRepo contratRepo) {
        this.contratRepo = contratRepo;
    }

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepo.save(contrat);
    }

    @Override
    public Contrat modifierContrat(Contrat contratModif) {
        return contratRepo.save(contratModif);
    }

    @Override
    public void deleteContrat(int idContrat) {
        contratRepo.deleteById(idContrat);
    }

    @Override
    public List<Contrat> findContratByEffetDateBetween(Date from, Date to) {
        return contratRepo.findContratByEffetDateBetween(from, to);
    }

    @Override
    public Contrat getContratBf(int idBf) {
        Beneficiaire beneficiaire = beneficiaireRepo.findById(idBf).get();
        Set<Assurance> allAssurances = beneficiaire.getAssurances();
        List<Contrat> allContrats = new ArrayList<Contrat>();

        for(Assurance assurance : allAssurances) {
            allContrats.add(assurance.getContrat());
        }

        Contrat oldContract = allContrats.get(0);
        for(Contrat contrat : allContrats) {
            if (contrat.getEffetDate().before(oldContract.getEffetDate())) {
                oldContract = contrat;
            }
        }
        return oldContract;
    }

    @Override
    public List<Contrat> findAllContrat() {
        return contratRepo.findAll();
    }


}

