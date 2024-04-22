package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Temperature;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RoastDto {

    @JsonProperty("roast_id")
    private String roastId;

    @JsonProperty("sampleId")
    private String sampleId;


    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    private  String roastDate;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    private String roastTest;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    private String roastWeight;


    @JsonProperty("roastTemperature")
    @Builder.Default
    private List<Temperature> roastTemperature = new ArrayList<>();


}
