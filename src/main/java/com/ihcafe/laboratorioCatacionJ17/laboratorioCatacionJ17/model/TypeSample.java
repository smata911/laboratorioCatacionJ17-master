package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblTypeSample")
@Builder

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeSample {

    @Id
    @Column(name = "typeSample_id",nullable = false,length = 2)
    private int typeSampleId;

    @Column(name = "typeSample_name",nullable = false,length = 25)
    private int typeSampleName;

    @OneToMany(mappedBy ="typeSample",
            cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
    @Builder.Default
    private List<Sample> typeSampleSample= new ArrayList<>();


}
