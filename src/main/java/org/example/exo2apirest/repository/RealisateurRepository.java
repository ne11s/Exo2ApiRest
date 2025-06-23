package org.example.exo2apirest.repository;

import org.example.exo2apirest.entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur,Long> {
}
