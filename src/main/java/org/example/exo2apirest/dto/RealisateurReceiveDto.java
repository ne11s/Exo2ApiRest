package org.example.exo2apirest.dto;

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
    private String first_name;
    private String last_name;
    private String birthDateStr;



    public Realisateur dtoToEntity (){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Realisateur.builder()
                .first_name(getFirst_name())
                .last_name(getFirst_name())
                .birthDate(LocalDate.parse(getBirthDateStr(),dateTimeFormatter))

                .build();
    }
}
