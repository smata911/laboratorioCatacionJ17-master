package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Producer producerId;

    @Column(name = "farm_name",nullable = false)
    private  String farmName;



    public static Farm buildFromDto(Farm farm, Producer producer) {
        farm.setFarmId(UUID.randomUUID().toString());
        farm.setProducerId(producer);


        return farm;
    }

}
