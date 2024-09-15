package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;



import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.RoastDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.error.ErrorResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.RoastService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/roast")
@RequiredArgsConstructor
public class RoastController {

    private  final RoastService roastService;
    private final ProducerRepository producerRepository;

    @PostMapping("/{sampleId}")//FALTA PEDIR POR PARAMETRO POR MEDIO DE SANPLE-ID DONDE lo tomaremos que no se guarde repetidos mediante esa regla de negocio
    public ResponseEntity<? extends Response<RoastDto>> saveRoast(
            @PathVariable("sampleId")String sampleId,
            @RequestBody @Valid RoastDto RoastDto) {

        RoastDto savedRoast = roastService.saveRoast(sampleId,RoastDto);
        BaseResponse<RoastDto> producerBaseResponse = new BaseResponse<>();
        return producerBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "Rast saved successfully", savedRoast);


    }



    @PutMapping("/{RoastId}")
    public ResponseEntity<? extends Response<RoastDto>> updateRoast(
            @PathVariable("RoastId") String roastId,
            @RequestBody @Valid RoastDto roastDto) {

        RoastDto updatedRoast = roastService.updateRoast(roastId, roastDto);
        BaseResponse<RoastDto> response = new BaseResponse<>();
        return response
                .buildResponseEntity(HttpStatus.OK, "Roast updated successfully", updatedRoast);
    }

}
