package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblTypeMarket")
@Builder
public class TypeMarket {

    @Id
    @Column(name = "typeMarket_id",nullable = false,length = 64)
    private String typeMarketId;

    @Column(name = "typeMarket_name",nullable = false,length = 35)
    private String typeMarketName;

    @OneToMany(mappedBy ="typeMarket" ,
            cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
    @Builder.Default
    private List<Sample> typeMarketSample=new ArrayList<>();


}
