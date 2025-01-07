package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.EstudiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.EstudiesService;
import lombok.*;
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
@RequestMapping(path = "/api/v1/Estudies")
@RequiredArgsConstructor
public class EstudiesController {
    private  final EstudiesService estudiesService;


    @GetMapping(value = "/lista")
    @PreAuthorize("hasAuthority('READ_ESTUDIES')")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<EstudiesDto>> findAll() {
        List<EstudiesDto> retrievedEstudies = estudiesService.getAllEstudies();

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedEstudies, HttpStatus.OK);
    }


}
