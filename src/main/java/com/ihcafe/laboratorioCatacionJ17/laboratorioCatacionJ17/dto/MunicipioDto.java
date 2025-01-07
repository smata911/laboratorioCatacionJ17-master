package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class MunicipioDto {

   // @JsonProperty("municipio_id")
    private String municipioId;

    private String municipioNombre;

    private  String municpioDepartamento;

    private  String municipioCodAgencia;
}
