package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import jakarta.validation.constraints.*;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Farm;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//import javax.validation.constraints.*;


@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class ProducerDto {

    @JsonProperty("producer_id")
    private String producerId;

    @JsonProperty(required = true)
    @NotBlank(message = "El campo 'producerIdentidad' no puede estar vacío o contener solo espacios.")
    @Size(min = 13, max = 13, message = "El campo 'producerIdentidad' debe tener entre 13 y 13 caracteres.")
    private String producerIdentidad;

    @JsonProperty(required = true)
    @NotBlank(message = "El campo 'producerFirstName' no puede estar vacío.")
    @Size(min = 2, max = 32, message = "El campo 'producerFirstName' debe tener entre 2 y 32 caracteres.")
    private String producerFirstName;

    @JsonProperty(required = true)
    @NotBlank(message = "El campo 'producerLastName' no puede estar vacío.")
    @Size(min = 2, max = 32, message = "El campo 'producerFirstName' debe tener entre 2 y 32 caracteres.")
    private String producerLastName;

    @JsonProperty()
    @Positive(message = "El campo 'producerGender' debe ser un número positivo.")
    @Max(value =2, message = "El maximo es 1")
    private Integer producerGender;


    @JsonProperty(required = false)

    private LocalDate producerFechaRegistro;

    // Otros campos opcionales
    @JsonProperty(required = true)
     @Builder.Default
     private List<Farm> producerFarm = new ArrayList<>();
}
