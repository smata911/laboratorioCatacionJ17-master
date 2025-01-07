package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTiempoDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTuesteDto;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ModeloTuesteRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ModeloTuesteService;
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
@RequestMapping(path = "/api/v1/ModeloTueste")
@RequiredArgsConstructor
public class ModeloTuesteController {
    private final ModeloTuesteService modeloTuesteService;

    private final Messages messages;
    @PostMapping
// @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PreAuthorize("hasAuthority('WRITING_MODELO')")
    public ResponseEntity<? extends Response<ModeloTuesteDto>> saveRoast(

            @Valid @RequestBody ModeloTuesteDto modeloTueste) {

        // Cambiamos el tipo de retorno a una lista de ModeloTuesteDto
        ModeloTuesteDto savedSamples = modeloTuesteService.saveModeloTueste( modeloTueste);
        BaseResponse<ModeloTuesteDto> sampleBaseResponse = new BaseResponse<>();
        // Construimos la respuesta con la lista de modelos guardados
        return sampleBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "Models saved successfully", savedSamples);
    }

   @GetMapping("/{typeProcessId}/{modeloVariedad}/{modeloStatus}")
   @PreAuthorize("hasAuthority('READ_MODELO')")
   public ResponseEntity<ModeloTuesteDto> getModelosByTypeProcess(
            @PathVariable int typeProcessId,
           @PathVariable String modeloVariedad,
           @PathVariable int modeloStatus) {
        ModeloTuesteDto modelos = modeloTuesteService.findByModeloTypeProces(typeProcessId,modeloVariedad,modeloStatus);
       return ResponseEntity.ok(modelos);
    }

    @GetMapping(value = "/lista")
    @PreAuthorize("hasAuthority('READ_MODELO')")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<ModeloTuesteDto>> findAll() {
        List<ModeloTuesteDto> retrievedVarieties = modeloTuesteService.getAllModelos();

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedVarieties, HttpStatus.OK);
    }




}