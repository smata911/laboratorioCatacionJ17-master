package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tblGeneralAffective")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GeneralAffective {

    @Id
    @Column(name = "general_id",nullable = false,length = 65)
    private String generalId;

    @Column(name = "general_name",nullable = false,length = 50)
    private int generalName;
}
