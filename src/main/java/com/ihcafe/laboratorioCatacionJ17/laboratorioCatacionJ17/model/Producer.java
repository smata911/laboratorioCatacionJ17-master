package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.status.ModelStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;



@Entity
@Table(name = "tblProducer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producer {

    @Id
    @Column(name = "producer_id", nullable = false, length = 64)
    private String producerId;

    @Column(name = "producer_identidad", nullable = false)
    private String producerIdentidad;

    @Column(name = "producer_first_name", nullable = false)
    private String producerFirstName;

    @Column(name = "producer_last_name", nullable = false)
    private String producerLastName;

    @Column(name = "producer_gender", nullable = false)
    private int producerGender;


    @Column(name = "producer_fechaRegistro", nullable = false)
    private LocalDate producerFechaRegistro; // Usa LocalDate

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "producer_id")
    @JsonManagedReference // Esta anotación evita la serialización recursiva
    private List<Farm> producerFarm = new ArrayList<>();

    @Column(name = "student_status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ModelStatus producerStatus;



    public static Producer buildFromDto(Producer producer) {

        producer.setProducerId(UUID.randomUUID().toString());
        producer.setProducerStatus(ModelStatus.ACTIVE);
        producer.setProducerFechaRegistro(LocalDate.now());
        for (Farm farm : producer.getProducerFarm()) {
            farm.setFarmId(UUID.randomUUID().toString());  // Generar un ID único para cada finca
            farm.setProducer(producer);                    // Asociar la finca al productor
        }
        return producer;
    }

    public void setProducerStatus(ModelStatus modelStatus) {
        this.producerStatus = modelStatus;
    }
}
