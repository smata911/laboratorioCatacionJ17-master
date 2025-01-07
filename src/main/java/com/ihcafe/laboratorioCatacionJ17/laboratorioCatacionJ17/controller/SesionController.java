package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SesionDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.SampleRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.SesionRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SampleService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SesionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Sesion")
@RequiredArgsConstructor
public class SesionController {

    private  final SesionService sesionService;
    private  final SesionRepository sesionRepository;
    //private final SesionRepository sesionRepository;
    @PostMapping
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PreAuthorize("hasAuthority('WRITING_SESION')")
    public ResponseEntity<? extends Response<SesionDto>> saveSesion(

            @Valid @RequestBody SesionDto sesionDto) {
        SesionDto savedSesion = sesionService.saveSesion(sesionDto);
        BaseResponse<SesionDto> sesionBaseResponse = new BaseResponse<>();
        return sesionBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "sesion saved successfully", savedSesion);

    }


    @GetMapping(value = "/lista")
    @PreAuthorize("hasAuthority('READ_SESION')")
    public ResponseEntity<List<SesionDto>> findAllFarmId() {
        List<SesionDto> retrievedSample = sesionService.getAllSesion();

        return new ResponseEntity<>(retrievedSample, HttpStatus.OK);
    }


}
