package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tblVarieties")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Varieties {

    @Id
    @Column(name ="varieties_id",nullable = false,length = 64)
    private String varietiesId;

    @Column(name = "varieties_name",nullable = false,length = 35)
    private String varietiesName;

    @Column(name = "varieties_scientific",nullable = false,length = 40)
    private String varietiesScientific;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "tblHvarietiesSample",
            joinColumns = @JoinColumn(name = "varieties_id"),
            inverseJoinColumns = @JoinColumn(name = "sample_id")
    )
    @Builder.Default
    private List<Sample> varietiesSample=new ArrayList<>();
}
