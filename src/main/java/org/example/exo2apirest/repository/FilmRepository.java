package org.example.exo2apirest.repository;

import org.example.exo2apirest.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
