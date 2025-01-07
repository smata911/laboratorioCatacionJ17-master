package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tblSweetNessAffective")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SweetNessAffective {

    @Id
    @Column(name = "sweetNess_id",nullable = false,length = 65)
    private String sweetNessId;

    @Column(name = "sweetNess_name",nullable = false,length = 50)
    private int sweetNessName;

}
