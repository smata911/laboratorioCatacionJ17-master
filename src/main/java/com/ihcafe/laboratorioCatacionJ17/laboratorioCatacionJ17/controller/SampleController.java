package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SampleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Sample")
@RequiredArgsConstructor
public class SampleController {
    private  final SampleService sampleService;
    private  final ProducerRepository producerRepository;

    @PostMapping("/{producerId}")
    public ResponseEntity<? extends Response<SampleDto>> saveRoast(
            @PathVariable("producerId")String producerId,
            @Valid @RequestBody  SampleDto sampleDto) {
        SampleDto savedSample = sampleService.saveSample(producerId,sampleDto);
        BaseResponse<SampleDto> sampleBaseResponse = new BaseResponse<>();
        return sampleBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "Rast saved successfully", savedSample);




    }
}
