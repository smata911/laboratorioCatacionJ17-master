package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.FarmDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.FarmService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SampleService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.MessageKey;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/Farm")
@RequiredArgsConstructor
public class FarmController {

    private  final FarmService farmService;
    private  final ProducerRepository producerRepository;

    private final Messages messages;
    @PostMapping("/{producerId}")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PreAuthorize("hasAuthority('WRITING_FARM')")
    public ResponseEntity<? extends Response<FarmDto>> saveFarm(
            @PathVariable("producerId")String producerId,
            @Valid @RequestBody FarmDto farmDto) {
        FarmDto savedFarm = farmService.saveFarm(producerId,farmDto);
        BaseResponse<FarmDto> farmBaseResponse = new BaseResponse<>();
        return farmBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "Rast saved successfully", savedFarm);




    }
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('READ_FARM')")
    public ResponseEntity<List<FarmDto>> findAll() {
        List<FarmDto> retrievedFarm = farmService.getAllFarm();

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedFarm, HttpStatus.OK);
    }

    @GetMapping("/list/{producerId}")
    @PreAuthorize("hasAuthority('READ_FARM')")
    public ResponseEntity<List<FarmDto>> findAllFarmProducer(
            @PathVariable("producerId")String producerId
    ) {
        List<FarmDto> retrievedFarm = farmService.getAllFarmProducer(producerId);

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedFarm, HttpStatus.OK);
    }

    @PutMapping("/{producerId}")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PreAuthorize("hasAuthority('UPDATE_FARM')")
    public ResponseEntity<? extends Response<FarmDto>> updateFarm(
            @PathVariable("producerId") String producerId,
            @RequestBody @Valid FarmDto farmDto) {

        FarmDto updatedFarm = farmService.updateFarm(producerId,farmDto);
        // Construir la respuesta
        BaseResponse<FarmDto> farmBaseResponse = new BaseResponse<>();
        return farmBaseResponse
                .buildResponseEntity(HttpStatus.OK, "farm " +
                        "updated successfully"+messages.getMessage(MessageKey.ENTITY_UPDATE.getKey()), updatedFarm);
    }



}
