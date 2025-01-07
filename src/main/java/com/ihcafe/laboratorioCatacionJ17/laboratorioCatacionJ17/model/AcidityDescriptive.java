package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tblAcidityDescriptive")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AcidityDescriptive {

    @Id
    @Column(name = "acidity_id",nullable = false,length = 65)
    private String acidityId;

    @Column(name = "acidity_name",nullable = false,length = 50)
    private int acidityName;
}
