package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.RoastDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.RoastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/roast")
@RequiredArgsConstructor
public class RoastController {

    private  final RoastService roastService;

    @PostMapping("/{sampleId}")//FALTA PEDIR POR PARAMETRO POR MEDIO DE SANPLE-ID DONDE lo tomaremos que no se guarde repetidos mediante esa regla de negocio
    public ResponseEntity<? extends Response<RoastDto>> saveRoast(
            @PathVariable("sampleId")String sampleId,
            @RequestBody @Valid RoastDto RoastDto) {
        RoastDto savedRoast = roastService.saveRoast(sampleId,RoastDto);
        BaseResponse<RoastDto> producerBaseResponse = new BaseResponse<>();
        return producerBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "raost saved successfully", savedRoast);
    }
}
