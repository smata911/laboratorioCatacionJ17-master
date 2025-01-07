package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tblFlavorAffective")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlavorAffective {

    @Id
    @Column(name = "flavor_id",nullable = false,length = 65)
    private String flavorId;

    @Column(name = "flavor_name",nullable = false,length = 50)
    private int flavorName;


}
