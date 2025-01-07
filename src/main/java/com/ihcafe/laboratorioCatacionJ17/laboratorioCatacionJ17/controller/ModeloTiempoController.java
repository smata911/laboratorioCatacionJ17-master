package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTiempoDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ModeloTiempoRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ModeloTuesteRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ModeloTiempoService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ModeloTuesteService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.MessageKey;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/modeloTiempo")
@RequiredArgsConstructor
public class ModeloTiempoController {

    private final ModeloTiempoService modeloTuesteService;
    private final Messages messages;

    @PutMapping("/{modeloTiempoId}")
    @PreAuthorize("hasAuthority('UPDATE_MODELO')")
    public ResponseEntity<? extends Response<ModeloTiempoDto>> updateModeloTiempo(
            @PathVariable("modeloTiempoId") String modeloTiempoId,
            @RequestBody @Valid ModeloTiempoDto ModeloTiempoDto) {
        System.out.println(modeloTiempoId+"desde controller");
        ModeloTiempoDto updatedModeloTiempo = modeloTuesteService.updateModeloTiempo(modeloTiempoId,ModeloTiempoDto);
        // Construir la respuesta
        BaseResponse<ModeloTiempoDto> producerBaseResponse = new BaseResponse<>();
        return producerBaseResponse
                .buildResponseEntity(HttpStatus.OK, "Producer " +
                        "updated successfully"+messages.getMessage(MessageKey.ENTITY_UPDATE.getKey()), updatedModeloTiempo);
    }
}
