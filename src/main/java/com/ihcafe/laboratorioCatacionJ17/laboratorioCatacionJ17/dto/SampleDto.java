package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeProcess;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeSample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import lombok.Builder;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Builder
public class SampleDto {

    @JsonProperty("sample_id")
    private String sampleId;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 64)
    private Producer producerId;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 64)
    private String sampleWeight;

    @JsonProperty(required = true)
    @Positive
    @Size(min = 2, max = 64)
    private int samplePorcentageHumidity;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 64)
    private String typeSample;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 64)
    private TypeProcess typeProcess;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 64)
    private  String sampleDate;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 64)
    private String sampleStatus;

    @JsonProperty("varietiesSample")
    @Builder.Default
    private List<Varieties> sampleVarieties=new ArrayList<>();


}
