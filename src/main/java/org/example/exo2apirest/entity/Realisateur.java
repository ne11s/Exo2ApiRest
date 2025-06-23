package org.example.exo2apirest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2apirest.dto.RealisateurResponseDto;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Realisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String first_name;
    private String last_name;
    private LocalDate birthDate;



    public RealisateurResponseDto entityToDto (){
        return RealisateurResponseDto.builder()
                .id(getId())
                .first_name(getFirst_name())
                .last_name(getLast_name())
                .birthDate(getBirthDate())
                .build();
    }
}
