package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ProducerService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.MessageKey;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/produce")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;
    private final Messages messages;
    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<? extends Response<ProducerDto>> saveProducer(@RequestBody @Valid ProducerDto producerDto) {
        ProducerDto savedProducer = producerService.saveProducer(producerDto);
        BaseResponse<ProducerDto> producerBaseResponse = new BaseResponse<>();
        return producerBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "Producer saved successfully"+ messages.getMessage(MessageKey.ENTITY_SAVE.getKey()), savedProducer);
    }

    @GetMapping(value = "/{producerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<? extends ProducerDto> findByProducerId(@PathVariable final String producerId) {
        ProducerDto retrievedStudent = producerService.findProducertById(producerId);
        return new ResponseEntity<>(retrievedStudent, HttpStatus.OK);
    }

    @PutMapping("/{producerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<? extends Response<ProducerDto>> updateProducer(
            @PathVariable("producerId") String producerId,
            @RequestBody @Valid ProducerDto producerDto) {

        ProducerDto updatedProducer = producerService.updateProducer(producerId,producerDto);
        // Construir la respuesta
        BaseResponse<ProducerDto> producerBaseResponse = new BaseResponse<>();
        return producerBaseResponse
                .buildResponseEntity(HttpStatus.OK, "Producer updated successfully"+messages.getMessage(MessageKey.ENTITY_UPDATE.getKey()), updatedProducer);
    }





}
