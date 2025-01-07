package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Temperature;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeSample;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;


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

    @JsonProperty(required = true)
    @NotBlank(message = "El campo roastDate no puede estar vacío.")
    private  String roastDate;

    @JsonProperty(required = true)
    @NotBlank(message = "El campo roastTest no puede estar vacío.")
    private String roastTest;//debe ser una relacion

    @JsonProperty(required = true)
    @Min(value = 90,message = "el peso de muestra minimo es de 90g")//TODO AQUI EL VALUE DEBE SER DINAMICO, PRIMERO SE DEBE CONSULTAR EN BASE DE DATO EL VALOR DE LA MUESTRA Y HACER UNA RESTA CON EL JSON Y QUE ESE SEA EL MINIMO
    private double roastWeight;


    @JsonProperty(value = "roastTemperature",required = true)
    @Builder.Default
    private List<Temperature> roastTemperature = new ArrayList<>();

    @JsonProperty(required = true)
    @Min(value = 20,message = "peso tueste mayor a 20")
    private Double roastAfterWeight;

    @JsonProperty(required = false)
    private String roastStatus;



    @JsonProperty(required = true)
    private  Sample sample;





}
