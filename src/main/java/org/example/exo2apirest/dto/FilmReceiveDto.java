package org.example.exo2apirest.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2apirest.entity.Film;
import org.example.exo2apirest.entity.Realisateur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmReceiveDto {
    @Size(min = 2, max = 25)
    private String name;
    @Size(min = 50, max = 500)
    private String description;
    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}" , message = "La date dois etre au format dd-MM-yyyy")
    private String releaseDate;
    private int duration;
    private String genre;
    private Realisateur realisateur;


    public Film dtoToEntity (){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Film.builder()
                .name(getName())
                .description(getDescription())
                .releaseDate(LocalDate.parse(getReleaseDate(),dateTimeFormatter))
                .duration(getDuration())
                .genre(getGenre())
                .realisateur(getRealisateur())
                .build();
    }
}
