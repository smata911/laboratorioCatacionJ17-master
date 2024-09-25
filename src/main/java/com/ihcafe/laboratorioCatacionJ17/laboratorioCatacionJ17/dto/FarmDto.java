package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class FarmDto {



    @Size(min = 2, max = 64, message = "La fecha de la muestra debe tener entre 2 y 64 caracteres")
    private String farmName;


}
