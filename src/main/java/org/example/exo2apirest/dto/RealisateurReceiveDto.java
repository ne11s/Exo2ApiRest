package org.example.exo2apirest.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2apirest.entity.Realisateur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RealisateurReceiveDto {
    @Size(min = 2, max = 25)
    private String first_name;
    @Size(min = 2, max = 25)
    private String last_name;
    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}" , message = "La date dois etre au format dd-MM-yyyy")
    private String birthDateStr;
    @Size(min = 2)
    private String nationality;


    public Realisateur dtoToEntity (){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Realisateur.builder()
                .first_name(getFirst_name())
                .last_name(getLast_name())
                .birthDate(LocalDate.parse(getBirthDateStr(),dateTimeFormatter))
                .nationality(getNationality())
                .build();
    }
}
