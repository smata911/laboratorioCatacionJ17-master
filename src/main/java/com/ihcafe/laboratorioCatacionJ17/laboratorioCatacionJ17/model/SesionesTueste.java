package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tblSesionesTueste")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SesionesTueste {

    @Id
    @Column(name = "sesionesTueste_id", nullable = false, length = 64)
    private String sesionesTuesteId;

    @ManyToOne
    @JoinColumn(name = "sesiones_id", referencedColumnName = "sesiones_id", nullable = false)
    @JsonBackReference // Esta anotación controla la referencia inversa
    private Sesion sesiones;

    @ManyToOne(fetch = FetchType.EAGER) // Cambia de LAZY a EAGER
    @JoinColumn(name = "roast_id", referencedColumnName = "roast_id", nullable = false, unique = true)
    private Roast roast;


    public static SesionesTueste buildFromDto(SesionesTueste sesionesTueste){
        sesionesTueste.setSesionesTuesteId(UUID.randomUUID().toString());
        //producer.setProducerStatus(ModelStatus.ACTIVE);
        return sesionesTueste;
    }

}
