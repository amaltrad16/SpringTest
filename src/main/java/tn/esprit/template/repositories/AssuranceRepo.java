package tn.esprit.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.template.entities.Assurance;
import tn.esprit.template.entities.Contrat;

import java.util.List;

@Repository
public interface AssuranceRepo extends JpaRepository<Assurance, Integer> {

    List<Assurance> findAssuranceByContrat (Contrat contrat);
}
