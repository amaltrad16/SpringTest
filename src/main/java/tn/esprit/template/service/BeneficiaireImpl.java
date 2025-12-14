package tn.esprit.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.template.entities.Assurance;
import tn.esprit.template.entities.Beneficiaire;
import tn.esprit.template.entities.Contrat;
import tn.esprit.template.entities.TypeContrat;
import tn.esprit.template.repositories.AssuranceRepo;
import tn.esprit.template.repositories.BeneficiaireRepo;
import tn.esprit.template.repositories.ContratRepo;

import java.util.*;

@Service
public class BeneficiaireImpl implements IBeneficiaireService {

    @Autowired
    private BeneficiaireRepo beneficiaireRepo;
    @Autowired
    private ContratRepo contratRepo;
    @Autowired
    private AssuranceRepo assuranceRepo;

    public BeneficiaireImpl(BeneficiaireRepo beneficiaireRepo) {
        this.beneficiaireRepo = beneficiaireRepo;
    }

    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return beneficiaireRepo.save(bf);
    }

    @Override
    public Beneficiaire modifierBeneficiaire(Beneficiaire beneficiaireModif) {
        return beneficiaireRepo.save(beneficiaireModif);
    }

   
    @Override
    public Beneficiaire trouveParCin(int cin) {
        return beneficiaireRepo.findBeneficiaireByCin(cin);
    }

   
    @Override
    public List<Beneficiaire> trouverParNomOuPrenom(String input) {
        return beneficiaireRepo.findBeneficiaireByNomOrPrenom(input, input);
    }

    @Override
    public List<Beneficiaire> findRichProfessors() {
        return beneficiaireRepo.findRichProfessors();
    }

    @Override
    public float getMontantBf(int cinBf) {
        Beneficiaire beneficiaire = beneficiaireRepo.findBeneficiaireByCin(cinBf);
        Set<Assurance> assurances = beneficiaire.getAssurances();
        float sum = 0;
        for (Assurance assurance : assurances) {
            float montant = assurance.getMontant();
            TypeContrat type = assurance.getContrat().getType();
            if (type.equals(TypeContrat.Annuel)) {
                sum += montant;
            } else if (type.equals(TypeContrat.Semestriel)) {
                sum += montant * 2;
            } else {
                sum += montant * 12;
            }
         
        }
        return sum;
    }

    @Override
    public Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat) {
        List<Contrat> contrats = contratRepo.findContratByType(typeContrat);
        Set<Beneficiaire> beneficiaires = new HashSet<>();
        for(Contrat contrat : contrats) {
            List<Assurance> assurances = assuranceRepo.findAssuranceByContrat(contrat);
            for(Assurance assurance : assurances) {
                beneficiaires.add(assurance.getBeneficiaire());
            }
        }
        return beneficiaires;
    }

    @Scheduled(fixedRate = 60000)
    public void statistiques () {
        List<Beneficiaire> beneficiaires = beneficiaireRepo.findAll();
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(Beneficiaire beneficiaire : beneficiaires) {
            Set<Assurance> assurances = beneficiaire.getAssurances();
            map.put(assurances.size(), beneficiaire.getCin());
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(" Nombre d'assurances :" + entry.getKey() + " -- CIN : " + entry.getValue());
        }
    }
}
