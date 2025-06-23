package org.example.exo2apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RealisateurResponseDto {
    private long id;
    private String first_name;
    private String last_name;
    private LocalDate birthDate;
}
