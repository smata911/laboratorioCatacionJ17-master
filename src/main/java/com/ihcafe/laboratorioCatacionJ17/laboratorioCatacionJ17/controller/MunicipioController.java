package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.FarmDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.MunicipioDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.FarmService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.MunicipioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/Municipio")
@RequiredArgsConstructor
public class MunicipioController {
    private  final MunicipioService municipioService;


    @GetMapping("/list")
    @PreAuthorize("hasAuthority('READ_MUNICIPIO')")
    public ResponseEntity<List<MunicipioDto>> findAll() {
        List<MunicipioDto> retrievedMunicipio = municipioService.getAllMunicipio();

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedMunicipio, HttpStatus.OK);
    }


}
