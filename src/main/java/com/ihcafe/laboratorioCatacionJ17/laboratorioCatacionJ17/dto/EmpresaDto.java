package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
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
public class EmpresaDto {

    @JsonProperty("empresa_id")
    private String EmpresaId;


    private String EmpresaNombre;
}
