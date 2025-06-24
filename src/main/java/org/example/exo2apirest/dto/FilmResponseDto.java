package org.example.exo2apirest.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2apirest.entity.Realisateur;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FilmResponseDto {
    private long id;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private int duration;
    private String genre;
    private Realisateur realisateur;
}
