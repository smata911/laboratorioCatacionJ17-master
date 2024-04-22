package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    private String temperatureHeat;

    @Column(name = "temperature_minute",nullable = false,length = 40)
    private String temperature_minute;

    @Column(name = "temperature_temperature",nullable = false,length = 30)
    private String temperatureTemperature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roast_id")
    @JsonBackReference
    private Roast roast;


    public static Temperature buildFromDto(Temperature temperature){
        temperature.setTemperatureId(UUID.randomUUID().toString());
        //producer.setProducerStatus(ModelStatus.ACTIVE);
        return temperature;
    }

}
