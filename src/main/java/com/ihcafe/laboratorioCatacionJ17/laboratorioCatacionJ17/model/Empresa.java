package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblEmpresa")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Empresa {

    @Id
    private int id;

    private String nombre;
}
