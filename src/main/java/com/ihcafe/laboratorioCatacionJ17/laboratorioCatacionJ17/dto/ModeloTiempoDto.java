package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModelosTueste;
import lombok.*;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ModeloTiempoDto {
    private String modeloTiempoTiempoId;
    private double modeloTiempoValue;
    private double modeloTiempoTemperatura;
    private String modeloTiempoObservacion;


    private ModelosTueste modelosTueste;
}
