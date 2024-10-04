package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.FarmDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.FarmService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SampleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/Farm")
@RequiredArgsConstructor
public class FarmController {

    private  final FarmService farmService;
    private  final ProducerRepository producerRepository;

    @PostMapping("/{producerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<? extends Response<FarmDto>> saveFarm(
            @PathVariable("producerId")String producerId,
            @Valid @RequestBody FarmDto farmDto) {
        FarmDto savedFarm = farmService.saveFarm(producerId,farmDto);
        BaseResponse<FarmDto> farmBaseResponse = new BaseResponse<>();
        return farmBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "Rast saved successfully", savedFarm);




    }


}
