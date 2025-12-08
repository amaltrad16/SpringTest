package tn.esprit.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.template.entities.Contrat;
import tn.esprit.template.entities.TypeContrat;

import java.util.Date;
import java.util.List;

public interface ContratRepo extends JpaRepository <Contrat, Integer>{

    List<Contrat> findContratByEffetDateBetween(Date from, Date to);
    List<Contrat> findContratByType(TypeContrat type);

}
