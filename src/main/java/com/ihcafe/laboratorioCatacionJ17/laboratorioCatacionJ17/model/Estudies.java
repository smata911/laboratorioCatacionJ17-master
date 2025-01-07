package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tblEstudiesw")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Estudies {

    @Id
    @Column(name = "estudies_id",length = 64)
    private  String estudiesId;

    @Column(name="estudies_name",length = 35)
    private  String estudiesName;

    //@ManyToOne
    //@JoinColumn(name = "sample_id")
    //@JsonBackReference
    //private Sample sample;

}
