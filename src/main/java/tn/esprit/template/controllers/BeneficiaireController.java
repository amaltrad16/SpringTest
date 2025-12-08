package tn.esprit.template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.template.entities.Beneficiaire;

import tn.esprit.template.entities.TypeContrat;
import tn.esprit.template.service.IBeneficiaireService;

import java.util.List;
import java.util.Set;

@RequestMapping("api/beneficiaire")
@RestController
public class BeneficiaireController {

    @Autowired
    private IBeneficiaireService iBeneficiaireService;

    @PostMapping("/add")
    public Beneficiaire addBeneficiaire(@RequestBody Beneficiaire bf) {
        return iBeneficiaireService.ajouterBeneficiaire(bf);
    }

    @PutMapping("/update")
    public Beneficiaire updateBeneficiaire(@RequestBody Beneficiaire beneficiaireModif) {
        return iBeneficiaireService.modifierBeneficiaire(beneficiaireModif);
    }

    @GetMapping("/find-by-cin")
    public Beneficiaire findByCin(@RequestParam int cin) {
        return iBeneficiaireService.trouveParCin(cin);
    }

    @GetMapping("/find-by-input")
    public List<Beneficiaire> findByInput(@RequestParam String input) {
        return iBeneficiaireService.trouverParNomOuPrenom(input);
    }

    @GetMapping("/find-rich")
    public List<Beneficiaire> findRich() {
        return iBeneficiaireService.findRichProfessors();
    }

    @GetMapping("/somme")
    public float sum(@RequestParam int cin) {
        return iBeneficiaireService.getMontantBf(cin);
    }

    @GetMapping("/benf-by-type-contract")
    public Set<Beneficiaire> getBenByContractType(@RequestParam TypeContrat typeContrat) {
        return iBeneficiaireService.getBeneficairesAsType(typeContrat);
    }
}

