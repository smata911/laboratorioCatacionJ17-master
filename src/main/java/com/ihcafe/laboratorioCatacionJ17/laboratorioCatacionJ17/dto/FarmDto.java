package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Municipio;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import jakarta.validation.constraints.Min;
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


    private String farmId;

    @Size(min = 2, max = 64, message = "La fecha de la muestra debe tener entre 2 y 64 caracteres")
    private String farmName;

    private  String  farmClave;

    @Size(min=2,message = "la observacion debe ser min 2")
    private String farmObservacion;

    @Min(value = 500,message = "minimo altura 500")
    private  double farmAltitud;

    @Size(min=2,max = 70,message = "la sitio debe ser min 2")
    private String farmSitio;

    private Producer producer;

    private Municipio municipio;







}
