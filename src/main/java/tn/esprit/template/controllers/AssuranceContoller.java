package tn.esprit.template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.template.entities.Assurance;

import tn.esprit.template.entities.Beneficiaire;
import tn.esprit.template.service.IAssuranceService;


@RestController
@RequestMapping("api/assurance")

public class AssuranceContoller {
     @Autowired
    private IAssuranceService iAssuranceService;

    @PostMapping("/add")
    public Assurance addAssurance(@RequestBody Assurance assurance) {
        return iAssuranceService.ajouterAssurance(assurance);
    }

    @PutMapping("/update")
    public Assurance updateAssurance(@RequestBody Assurance assuranceModif) {
        return iAssuranceService.modifierAssurance(assuranceModif);
    }

    @PostMapping("/add-assurance-with-benef-cin")
    public Assurance addWithBenCin(@RequestBody Assurance assurance, @RequestParam int cin) {
        return iAssuranceService.ajouterAssurance(assurance, cin);
    }
}

