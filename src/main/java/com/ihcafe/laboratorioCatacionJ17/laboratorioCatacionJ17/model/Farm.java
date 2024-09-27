package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tblFarm")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Farm {

    @Id
    @Column(name = "farm_id",nullable = false,length = 64)
    private String farmId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producer_id")
    @JsonBackReference // Evita el bucle recursivo
    private Producer producer;

    @Column(name = "farm_name",nullable = false)
    private  String farmName;


    @OneToMany(mappedBy = "farm", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference // Maneja la relación
    private List<Sample> farmSample = new ArrayList<>();


    public static Farm buildFromDto(Farm farm, Producer producer) {
        farm.setFarmId(UUID.randomUUID().toString());
        farm.setProducer(producer);


        return farm;
    }

}
