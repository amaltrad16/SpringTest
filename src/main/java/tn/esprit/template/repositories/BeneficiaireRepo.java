package tn.esprit.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.template.entities.Beneficiaire;

import java.util.List;


@Repository
public interface BeneficiaireRepo extends JpaRepository<Beneficiaire, Integer> {
    Beneficiaire findBeneficiaireByCin(int cin);

    List<Beneficiaire> findBeneficiaireByNomOrPrenom(String nom, String prenom);

    @Query("SELECT b FROM Beneficiaire b WHERE b.salaire > 1500 AND b.profession = 'teacher'")
    List<Beneficiaire> findRichProfessors();
}
