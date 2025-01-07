package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tblFragenceAffective")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FraganceAffective {

    @Id
    @Column(name = "fragance_id",nullable = false,length = 65)
    private String fraganceId;

    @Column(name = "fragance_name",nullable = false,length = 50)
    private int fraganceName;




}
