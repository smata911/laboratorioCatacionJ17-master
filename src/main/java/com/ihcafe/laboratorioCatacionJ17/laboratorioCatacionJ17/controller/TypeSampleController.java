package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeSampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.TypeSampleService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.VarietiesService;
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
@RequestMapping(path = "/api/v1/TypeSample")
@RequiredArgsConstructor
public class TypeSampleController {

    private  final TypeSampleService typeSampleService;


    @GetMapping(value = "/lista")
    @PreAuthorize("hasAuthority('READ_TYPESAMPLE')")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<TypeSampleDto>> findAll() {
        List<TypeSampleDto> retrievedTypeSample = typeSampleService.getAllTypeSample();

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedTypeSample, HttpStatus.OK);
    }

}
