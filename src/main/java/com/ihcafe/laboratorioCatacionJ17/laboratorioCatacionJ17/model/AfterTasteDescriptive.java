package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tblAfterTasteDescriptive")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AfterTasteDescriptive {

    @Id
    @Column(name = "afterTaste_id",nullable = false,length = 65)
    private String afterTasteId;

    @Column(name = "afterTaste_name",nullable = false,length = 50)
    private int afterTasteName;
}
