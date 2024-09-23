package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.*;

import jakarta.validation.constraints.*;
import lombok.*;


//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Positive;
//import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SampleDto {

    @JsonProperty("sample_id")
    private String sampleId;


    @Min(value = 50, message = "La humedad de la muestra debe ser mayor a 9")
    @Max(value = 250,message = "tiene que ser menor a 13")
    private double sampleWeight;

    @Min(value = 10, message = "La humedad de la muestra debe ser mayor a 9")
    @Max(value = 13,message = "tiene que ser menor a 13")
    private double samplePercentageHumidity;

    // @NotBlank(message = "El campo typeSample no puede ser vacio")
    @JsonProperty(required = true)
    private TypeSample typeSample;

    @JsonProperty(required = true)
    private TypeProcess typeProcess;

    @JsonProperty(required = true)
    private TypeMarket typeMarket;

    @NotBlank(message = "La fecha de la muestra es obligatoria")
    @Size(min = 2, max = 64, message = "La fecha de la muestra debe tener entre 2 y 64 caracteres")
    private String sampleDate;

    @NotBlank(message = "El estado de la muestra es obligatorio")
    @Size(min = 2, max = 64, message = "El estado de la muestra debe tener entre 2 y 64 caracteres")
    private String sampleStatus;

    @Builder.Default
    private List<Varieties> sampleVarieties = new ArrayList<>();
}
