package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;



import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.RoastDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.error.ErrorResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.RoastService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
//@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/roast")
@RequiredArgsConstructor
public class RoastController {
    private  final RoastService roastService;
    @PostMapping("/{sampleId}")// VERIFICAR EL SAMPLE WEIGHT LA CANTIDAD DISPONIBLE. ESTO DEBE IR EN EL IMPLEMENT
   // @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PreAuthorize("hasAuthority('WRITING_ROAST')")

    public ResponseEntity<? extends Response<RoastDto>> saveRoast(
            @PathVariable("sampleId")String sampleId,
            @RequestBody @Valid RoastDto RoastDto) {
        RoastDto savedRoast = roastService.saveRoast(sampleId,RoastDto);
        BaseResponse<RoastDto> RoastBaseResponse = new BaseResponse<>();
        return RoastBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "Rast saved successfully", savedRoast);
    }
    @PutMapping("/{RoastId}")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PreAuthorize("hasAuthority('UPDATE_ROAST')")
    public ResponseEntity<? extends Response<RoastDto>> updateRoast(
            @PathVariable("RoastId") String roastId,
            @RequestBody @Valid RoastDto roastDto) {
        RoastDto updatedRoast = roastService.updateRoast(roastId, roastDto);
        BaseResponse<RoastDto> response = new BaseResponse<>();
        return response
                .buildResponseEntity(HttpStatus.OK, "Roast updated successfully", updatedRoast);
    }

    @GetMapping(value = "/lista")
    @PreAuthorize("hasAuthority('READ_SAMPLE')")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Page<RoastDto>> findAll(
            @RequestParam(required = false) String sampleNumeroMuestra,
            Pageable pageable)  {
        Page<RoastDto> retrievedRoast = roastService.getRoastsBySampleNumeroMuestra(sampleNumeroMuestra,pageable);

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedRoast, HttpStatus.OK);
    }

    @GetMapping(value = "/listaAll")
    @PreAuthorize("hasAuthority('READ_SAMPLE')")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Page<RoastDto>> findAllTueste(
            @RequestParam(required = false) String sampleNumeroMuestra,
            Pageable pageable)  {
        Page<RoastDto> retrievedRoast = roastService.getRoastsBySampleNumeroMuestraAll(sampleNumeroMuestra,pageable);

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedRoast, HttpStatus.OK);
    }





}
