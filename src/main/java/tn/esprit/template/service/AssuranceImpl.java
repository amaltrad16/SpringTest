package tn.esprit.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.template.entities.Assurance;

import tn.esprit.template.entities.Beneficiaire;
import tn.esprit.template.entities.Contrat;
import tn.esprit.template.repositories.AssuranceRepo;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.template.repositories.BeneficiaireRepo;
import tn.esprit.template.repositories.ContratRepo;

@Service
public class AssuranceImpl implements IAssuranceService {

    @Autowired
    private AssuranceRepo assuranceRepo;
    @Autowired
    private BeneficiaireRepo beneficiaireRepo;
    @Autowired
    private ContratRepo contratRepo;

    public AssuranceImpl(AssuranceRepo assuranceRepo) {
        this.assuranceRepo = assuranceRepo;
    }

    @Override
    public Assurance ajouterAssurance(Assurance assurance) {

        return assuranceRepo.save(assurance);
    }

    @Override
    public Assurance modifierAssurance(Assurance assuranceModif) {
        return assuranceRepo.save(assuranceModif);
    }

    @Override
    public Assurance ajouterAssurance(Assurance assurance, int cinBf) {
        Beneficiaire beneficiaire = beneficiaireRepo.findBeneficiaireByCin(cinBf);
        assurance.setBeneficiaire(beneficiaire);
        Contrat contrat = contratRepo.save(assurance.getContrat());
        assurance.setContrat(contrat);
        return assuranceRepo.save(assurance);
    }
}
