package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tblMunicipio")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Municipio {

    @Id
    @Column(name = "municipio_id", nullable = false, length = 64)
    private  String municipioId;

    @Column(name = "municipio_nombre",nullable = false,length = 70)
    private  String municipioNombre;

    @Column(name = "municpio_departamento",nullable = false,length = 3)
    private String municpioDepartamento;

    @Column(name = "municipio_CodAgencia",nullable = false,length = 3)
    private  String municipioCodAgencia;
}
