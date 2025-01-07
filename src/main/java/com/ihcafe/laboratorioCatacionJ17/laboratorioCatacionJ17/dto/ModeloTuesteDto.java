package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller.ModeloTuesteController;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModeloTiempos;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModelosTueste;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeProcess;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ModeloTuesteDto {


    private String modeloId;
    private String modeloVariedad;
    private int modeloStatus;

    // Utiliza un DTO en lugar de la entidad TypeProcess
    private TypeProcess typeProcess;

    @JsonProperty(value = "modeloTiempos", required = true)
    @Builder.Default
    private List<ModeloTiempos> modeloTiempos = new ArrayList<>();
}
