package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.status.ModelStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    @Column(name = "producer_id",nullable = false,length = 64)
    private String producerId;

    @Column(name = "producer_identidad",nullable = false)
    private  String producerIdentidad;

    @Column(name = "producer_first_name",nullable = false)
    private String producerFirstName;

    @Column(name = "producer_last_name",nullable = false)
    private String producerLastName;

    @Column(name = "producer_gender",nullable = false)
    private int producerGender;

//    @OneToMany(mappedBy = "producer",
//            cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
//    @Builder.Default
//    private List<Sample> producerSample=new ArrayList<>();



    @Column(name = "student_status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ModelStatus producerStatus;
    /**falta agencia* la relacion*/



    public static Producer buildFromDto(Producer producer){
        producer.setProducerId(UUID.randomUUID().toString());
        producer.setProducerStatus(ModelStatus.ACTIVE);
        return producer;
    }

    private void setProducerId(final String producerId){
        this.producerId = producerId;
    }

    public void setProducerStatus(ModelStatus modelStatus){
        this.producerStatus = modelStatus;
    }
}
