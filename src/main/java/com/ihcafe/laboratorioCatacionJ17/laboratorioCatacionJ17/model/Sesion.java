package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SesionDto;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.RoastRepository;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "tblSesiones")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sesion {

    @Id
    @Column(name = "sesiones_id")
    private String sesionesId;

    @Column(name = "sesiones_numeroSesion")
    private String sessionesNumeroSesion;

    @Column(name = "numero_Mesa")
    private int sesionesNumeroMesa;

    @Column(name = "sesiones_fechaRegistro")
    private String sesionesFechaRegistro;

    @Column(name = "sesiones_status")
    private  String sesionesStatus;

    @OneToMany(mappedBy = "sesiones", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Esta anotación controla la serialización de la colección
    private List<SesionesTueste> sesionesTueste = new ArrayList<>();

    public static Sesion buildFromDto(SesionDto sesionDto) {
        Sesion sesion = new Sesion();
        sesion.setSesionesId(UUID.randomUUID().toString());
        sesion.setSessionesNumeroSesion(sesionDto.getSessionesNumeroSesion());
        sesion.setSesionesNumeroMesa(sesionDto.getSesionesNumeroMesa());
        sesion.setSesionesFechaRegistro(sesionDto.getSesionesFechaRegistro());



        return sesion;
    }




}
