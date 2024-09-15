package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SampleService;
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
    private  final String MSJ_NO_FOUND_PRODUCTOR="PRODUCTOR NO EXISTE";
    private  final String  MSJ_SAVE_SUCCES_SAMPLE="Sample saved successfully";

    @PostMapping("/{producerId}")//FALTA PEDIR POR PARAMETRO POR MEDIO DE SANPLE-ID DONDE lo tomaremos que no se guarde repetidos.
    public ResponseEntity<? extends Response<SampleDto>> saveRoast(
            @PathVariable("producerId")String producerId,
            @Validated
            @RequestBody  SampleDto sampleDto) {

        BaseResponse<SampleDto> producerBaseResponse = new BaseResponse<>();
        Optional<Producer> existingProducer = producerRepository.findByProducerIdentidad(producerId);
        SampleDto savedSample = sampleService.saveSample(producerId,sampleDto);
        ResponseEntity responseJSON=null;
        //aqui solo deben ir las validaciones de los dto y en el service si existe o no existe tal valor
        if (existingProducer.isEmpty()) {
            responseJSON=producerBaseResponse.
                    buildResponseEntity(HttpStatus.NOT_FOUND,MSJ_NO_FOUND_PRODUCTOR,savedSample);

        }else {

            responseJSON= producerBaseResponse
                    .buildResponseEntity(HttpStatus.CREATED, MSJ_SAVE_SUCCES_SAMPLE, savedSample);

        }

        return responseJSON;
    }
}
