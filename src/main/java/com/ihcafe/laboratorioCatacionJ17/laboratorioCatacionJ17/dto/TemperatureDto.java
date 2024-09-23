package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureDto {

    @JsonProperty("temperature_id")
    private String temeperatureId;


   // @JsonProperty(required = true)
    @Min(value = 0,message = "calor  minimo 0")
    @Max(value = 250,message = "calor maximo 250")
    private double temperatureHeat;

    @JsonProperty(required = true)
    @Size(min = 3, max = 64)
    private  String temperature_minute;

    @JsonProperty(required = true)
    private double temperatureTemperature;

    @JsonProperty("roast")
    private Roast roast;





}
