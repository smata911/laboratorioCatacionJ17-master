package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblSample")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sample {

    @Id
    @Column(name = "sample_id",nullable = false,length = 64)
    private String sampleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producer_id")
    private Producer producerId;

    @Column(name = "sample_weight",nullable = false)
    private int sampleWeight;

    @Column(name = "sample_porcentage_humidity",nullable = false)
    private  int samplePorcentageHumidity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeSample_id")
    private TypeSample typeSample;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeProcess_id")
    private TypeProcess typeProcess;

    @Column(name = "sample_date",nullable = false)
    private  String sampleDate;

    @Column(name = "sample_status")
    private String sampleStatus;

    /*relacion de quien lo inserto*/

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "typeMarket_id")
    private String  typeMarket;

    @ManyToMany(mappedBy = "varietiesSample",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @Builder.Default
    private List<Varieties> sampleVarieties=new ArrayList<>();


    @OneToMany(mappedBy = "sampleId",
            cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
    @Builder.Default
   private List<Roast> sampleRoast=new ArrayList<>();

}
