package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.SesionesTueste;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SesionDto {

    //@JsonProperty("sesion_id")
    private String sesionesId;
    private String sessionesNumeroSesion;
    private int sesionesNumeroMesa;
    private String sesionesFechaRegistro;
    private  String sesionesStatus;

    // Lista de `SesionesTuesteDto` para manejar los datos relacionados
    private List<SesionesTueste> sesionesTueste;



}


