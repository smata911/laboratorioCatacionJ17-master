package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import javax.print.attribute.standard.MediaSize;
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
    @Column(name = "farm_id", nullable = false, length = 64)
    private String farmId;

    @Column(name = "farm_name", nullable = false)
    private String farmName;

    @Column(name = "farm_clave")
    private String farmClave;

    @Column(name = "farm_observacion")
    private String farmObservacion;

    @Column(name = "farm_sitio")
    private String farmSitio;

    @Column(name = "farm_altitud")
    private  double farmAltitud;


    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "producer_id")
    @JsonBackReference // Evita la referencia circular
    private Producer producer;


    @ManyToOne
    @JoinColumn(name = "municipio_id", referencedColumnName = "municipio_id")
    //@JsonBackReference // Evita la referencia circular
    private Municipio municipio;

    //@OneToMany(mappedBy = "farm", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
   // @JsonManagedReference // Maneja la relación con Sample
    //@JsonManagedReference // Esta anotación evita la serialización recursiva
   // private List<Sample> farmSample = new ArrayList<>();

    public static Farm buildFromDto(Farm farm, Producer producer) {
        farm.setFarmId(UUID.randomUUID().toString());
        farm.setProducer(producer);
        return farm;
    }
}

