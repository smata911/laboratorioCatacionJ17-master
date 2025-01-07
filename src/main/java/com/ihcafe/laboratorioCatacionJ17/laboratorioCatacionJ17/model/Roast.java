package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "tblRoast")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Roast {

    @Id
    @Column(name = "roast_id",nullable = false,length = 64)
    private String roastId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sample_id")
    //@JsonBackReference // Maneja la relación para evitar recursión infinita en la serialización
    private Sample sample;

    @Column(name ="roast_date" ,nullable = false,length = 20)
    private String roastDate;

    @Column(name = "roast_test",nullable = false,length = 10)
    private String roastTest;

    @Column(name = "roast_weight",nullable = false,length = 30)
    private double roastWeight;

    @Column(name = "roast_afterWeight",nullable = false,length = 30)
    private double roastAfterWeight;

    @Column(name = "roast_status",nullable = false,length = 10)
    private  String  roastStatus;

    //creo que se quita y solo quedaria en temperaturas
    @OneToMany(mappedBy = "roast", cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST })
    @JsonManagedReference
    @Builder.Default
    private List<Temperature> roastTemperature = new ArrayList<>();


    @OneToMany(mappedBy = "roast", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    //@JsonManagedReference // o @JsonIgnore si no necesitas serializar la relación
    @JsonIgnore
    @Builder.Default
    private List<Cupping> roastCupping = new ArrayList<>();

    public static Roast buildFromDto(Roast roast,Sample sample){
        roast.setRoastId(UUID.randomUUID().toString());
        roast.setSample(sample);

        roast.setRoastTemperature(roast.getRoastTemperature());

        //producer.stProducerStatus(ModelStatus.ACTIVE);
        return roast;
    }

}
