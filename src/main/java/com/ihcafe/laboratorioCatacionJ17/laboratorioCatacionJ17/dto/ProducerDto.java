package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import lombok.*;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;


@JsonSerialize
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProducerDto {
    @JsonProperty("producerId")
    private String producerId;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min=13,max=13)
    private String producerIdentidad;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min=2,max=32)
    private String producerFirstName;

    @JsonProperty(required = true)
    @NotNull
    @NotEmpty
    private String producerLastName;

    @JsonProperty(required = true)
    @Positive
    @NotNull
    private Integer producerGender;

   // @JsonProperty("producerSample")
    //@Builder.Default
   //private List<Sample> producerSample=new ArrayList<>();


}
