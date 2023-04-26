package org.moha.miniproject.Repositories;

import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long>, CrudRepository<Conducteur, Long> {

    @Query("SELECT c FROM Conducteur c " +
            "WHERE NOT EXISTS (SELECT vo.conducteur FROM Voyage vo WHERE vo.conducteur = c) " +
            "OR EXISTS (SELECT vo.conducteur FROM Voyage vo WHERE vo.conducteur = c AND (:dateD >= vo.dateArrivee OR :dateA <= vo.dateDepart))")
    public List<Conducteur> getDisponibleConducteur(LocalDate dateD, LocalDate dateA);
}