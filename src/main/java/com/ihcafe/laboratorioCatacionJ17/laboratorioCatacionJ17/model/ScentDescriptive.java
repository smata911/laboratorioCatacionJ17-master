package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tblScentDescriptive")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScentDescriptive {

    @Id
    @Column(name = "scent_id",nullable = false,length = 65)
    private String scentId;

    @Column(name = "scent_name",nullable = false,length = 50)
    private int scentName;

}
