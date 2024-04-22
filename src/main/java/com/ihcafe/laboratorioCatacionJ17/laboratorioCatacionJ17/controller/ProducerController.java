package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.openapi.ResponseProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.error.ErrorResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/produce")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;


    @PostMapping
    public ResponseEntity<? extends Response<ProducerDto>> saveProducer(@RequestBody @Valid ProducerDto producerDto) {
        ProducerDto savedProducer = producerService.saveProducer(producerDto);
        BaseResponse<ProducerDto> producerBaseResponse = new BaseResponse<>();
        return producerBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "Producer saved successfully", savedProducer);
    }




    @GetMapping(value = "/{producerId}")
    public ResponseEntity<? extends ProducerDto> findByProducerId(@PathVariable final String producerId) {
        ProducerDto retrievedStudent = producerService.findProducertById(producerId);
        return new ResponseEntity<>(retrievedStudent, HttpStatus.OK);
    }
}
