package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureDto {

    @JsonProperty("temperature_id")
    private String temeperatureId;


    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 64)
    private String temperatureHeat;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 64)
    private  String temperature_minute;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 64)
    private String temperatureTemperature;

    @JsonProperty("roast")
    private Roast roast;





}
