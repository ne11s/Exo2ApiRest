package org.example.exo2apirest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2apirest.dto.FilmResponseDto;
import org.example.exo2apirest.dto.RealisateurResponseDto;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private int duration;
    private String genre;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;


    public FilmResponseDto entityToDto (){
        return FilmResponseDto.builder()
                .id(getId())
                .name(getName())
                .description(getDescription())
                .releaseDate(getReleaseDate())
                .duration(getDuration())
                .genre(getGenre())
                .realisateur(getRealisateur())
                .build();
    }
}
