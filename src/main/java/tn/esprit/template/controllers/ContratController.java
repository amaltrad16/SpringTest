package tn.esprit.template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.template.entities.Beneficiaire;
import tn.esprit.template.entities.Contrat;
import tn.esprit.template.service.IBeneficiaireService;
import tn.esprit.template.service.IContratService;

import java.util.Date;
import java.util.List;

@RequestMapping("api/contrat")
@RestController
public class ContratController {
    @Autowired
    private IContratService iContratService;

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return iContratService.ajouterContrat(contrat);
    }

    @PutMapping("/update")
    public Contrat updateContrat(@RequestBody Contrat contratModif) {
        return iContratService.modifierContrat(contratModif);
    }

    @DeleteMapping("/{idContrat}")
    public void deleteContrat(@PathVariable int idContrat) {
        iContratService.deleteContrat(idContrat);
    }

    @GetMapping("/all")
    public List<Contrat> getAllCours() {
        return iContratService.findAllContrat();
    }

    @GetMapping("/between")
    public List<Contrat> between(@RequestParam Date d1, @RequestParam Date d2) {
        return iContratService.findContratByEffetDateBetween(d1, d2);
    }

    @GetMapping("oldest-contract-by-ben-id")
    public Contrat getOldestContractByBenId(@RequestParam int benId) {
        return iContratService.getContratBf(benId);
    }
}
