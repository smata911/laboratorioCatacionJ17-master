package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TemperatureDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity


@Table(name = "tblTemperature")

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Temperature {

    @Id
    @Column(name = "temperature_id",nullable = false,length = 64)
    private String temperatureId;

    @Column(name = "temperature_heat",nullable = false,length = 30)
    private double temperatureHeat;

    @Column(name = "temperature_minute",nullable = false,length = 40)
    private double temperature_minute;

    @Column(name = "temperature_temperature",nullable = false,length = 30)
    private double temperatureTemperature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roast_id")
    @JsonBackReference
    private Roast roast;


    public static Temperature buildFromDto(Temperature temperature){
        temperature.setTemperatureId(UUID.randomUUID().toString());
        //producer.setProducerStatus(ModelStatus.ACTIVE);
        return temperature;
    }

    public static List<String> DtototemperatureIds(List<Temperature> temperatureDtoList) {
        return temperatureDtoList.stream()
                .map(Temperature::getTemperatureId) // Extrae los ids
                .collect(Collectors.toList()); // Los convierte en una lista de Strings
    }


}
