package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;



import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.RoastDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.error.ErrorResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.RoastService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/roast")
@RequiredArgsConstructor
public class RoastController {
    private  final RoastService roastService;
    @PostMapping("/{sampleId}")// VERIFICAR EL SAMPLE WEIGHT LA CANTIDAD DISPONIBLE. ESTO DEBE IR EN EL IMPLEMENT
    public ResponseEntity<? extends Response<RoastDto>> saveRoast(
            @PathVariable("sampleId")String sampleId,
            @RequestBody @Valid RoastDto RoastDto) {
        RoastDto savedRoast = roastService.saveRoast(sampleId,RoastDto);
        BaseResponse<RoastDto> RoastBaseResponse = new BaseResponse<>();
        return RoastBaseResponse
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
