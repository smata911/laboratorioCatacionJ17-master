package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblCupping")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cupping {

    @Id
    @Column(name = "cupping_id",nullable = false,length = 65)
    private String cuppingId;

    @Column(name = "cupping_date",nullable = false,length = 30)
    private String cuppingDate;

    @Column(name = "cupping")
    private String cuppingObservation;

    @Column(name = "cupping_status")
    private String cuppingStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roast_id")
    @JsonBackReference // Maneja la relación para evitar recursión infinita en la serialización
    private Roast roast;

    @OneToMany(mappedBy = "cupping", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    //@JsonManagedReference // o @JsonIgnore si no necesitas serializar la relación
    //@JsonIgnore
    @Builder.Default
    private List<EvaluationAffective> cuppingEvaluationAfective = new ArrayList<>();

    @OneToMany(mappedBy = "cupping", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    //@JsonManagedReference // o @JsonIgnore si no necesitas serializar la relación
    //@JsonIgnore
    @Builder.Default
    private List<EvaluationDescriptive> cuppingEvaluationDescriptive = new ArrayList<>();



}
