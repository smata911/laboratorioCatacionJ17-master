package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="sample_id")
    private Sample sampleId;

    @Column(name ="roast_date" ,nullable = false,length = 20)
    private String roastDate;

    @Column(name = "roast_test",nullable = false,length = 10)
    private String roastTest;

    @Column(name = "roast_weight",nullable = false,length = 30)
    private String roastWeight;

    @OneToMany(mappedBy = "roast", cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST })
    @JsonManagedReference
    @Builder.Default
    private List<Temperature> roastTemperature = new ArrayList<>();

    public static Roast buildFromDto(Roast roast,Sample sample){
        roast.setRoastId(UUID.randomUUID().toString());
        roast.setSampleId(sample);

        //producer.stProducerStatus(ModelStatus.ACTIVE);
        return roast;
    }

}
