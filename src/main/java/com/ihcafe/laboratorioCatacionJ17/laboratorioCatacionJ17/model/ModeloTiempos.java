package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tblModelosTiempo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModeloTiempos {

    @Id
    @Column(name = "modeloTiempo_id")
    private String modeloTiempoTiempoId;

    @Column(name = "modeloTiempo_valueX", nullable = false)
    private double modeloTiempoValue;

    @Column(name = "modeloTiempo_valueY", nullable = false)
    private double modeloTiempoTemperatura;

    @Column(name = "modeloTiempo_observacion", nullable = false, length = 100)
    private String modeloTiempoObservacion;

//    @ManyToOne
//    @JoinColumn(name = "modelo_id", referencedColumnName = "modelo_id")
//    @JsonIgnore
//    private ModelosTueste modelosTueste;


//    @ManyToOne
//    @JoinColumn(name = "modelo_id", referencedColumnName = "modelo_id")
//    @JsonIgnore
//    private ModelosTueste modelosTueste;

    @ManyToOne
    @JoinColumn(name = "modelo_id", referencedColumnName = "modelo_id")
    @JsonBackReference // Esta anotación está bien aquí
    private ModelosTueste modelosTueste;
}